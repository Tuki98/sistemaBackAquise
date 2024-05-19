package com.cibertec.sistemabackaquise.service.serviceImpl;
import com.cibertec.sistemabackaquise.model.Automovil;
import com.cibertec.sistemabackaquise.dtos.AutomovilDTO.AutomovilCreateDTO;
import com.cibertec.sistemabackaquise.dtos.AutomovilDTO.AutomovilDTO;
import com.cibertec.sistemabackaquise.dtos.AutomovilDTO.AutomovilUpdateDTO;
import com.cibertec.sistemabackaquise.mappers.AutomovilMapper;
import com.cibertec.sistemabackaquise.repository.AutomovilRepository;
import com.cibertec.sistemabackaquise.service.AutomovilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import java.io.ByteArrayOutputStream;
import java.util.Base64;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class AutomovilServiceImpl implements AutomovilService {

    private final AutomovilRepository automovilRepository;
    private final TemplateEngine templateEngine;

    @Autowired
    public AutomovilServiceImpl(AutomovilRepository automovilRepository, TemplateEngine templateEngine) {
        this.automovilRepository = automovilRepository;
        this.templateEngine=templateEngine;
    }
    @Override
    public List<AutomovilDTO> listarAutomoviles() {
        List<Automovil> automoviles = automovilRepository.findAll();
        return AutomovilMapper.instancia.listaAutomovilAListaAutomovilDTO(automoviles);
    }

    @Override
    public AutomovilDTO obtenerAutomovilPorId(Integer id) {
        Optional<Automovil> optionalAutomovil = automovilRepository.findById(id);
        return optionalAutomovil.map(AutomovilMapper.instancia::automovilToAutomovilDTO).orElse(null);
    }

    @Override
    public AutomovilDTO registrarAutomovil(AutomovilCreateDTO automovilCreateDTO) {
        Automovil automovil = AutomovilMapper.instancia.automovilCreateDTOToAutomovil(automovilCreateDTO);
        Automovil automovilGuardado = automovilRepository.save(automovil);
        return AutomovilMapper.instancia.automovilToAutomovilDTO(automovilGuardado);
    }

    @Override
    public AutomovilDTO actualizarAutomovil(AutomovilUpdateDTO automovilUpdateDTO) {
        Automovil automovil = AutomovilMapper.instancia.automovilUpdateDTOToAutomovil(automovilUpdateDTO);
        Automovil automovilActualizado = automovilRepository.save(automovil);
        return AutomovilMapper.instancia.automovilToAutomovilDTO(automovilActualizado);
    }

    @Override
    public void eliminarAutomovil(Integer id) {
        automovilRepository.deleteById(id);
    }

    @Override
    public String generarPdftoBase64() {
        List<AutomovilDTO> listaAutomovil=listarAutomoviles();

        Context context=new Context();
        context.setVariable("listaAutomovil", listaAutomovil);

        String htmlContent = templateEngine.process("report-template",context);

        ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
        ConverterProperties converterProperties=new ConverterProperties();
        HtmlConverter.convertToPdf(htmlContent,outputStream,converterProperties);

        byte[] pdfBytes=outputStream.toByteArray();
        String base64Content= Base64.getEncoder().encodeToString(pdfBytes);
        return base64Content;
    }
}
