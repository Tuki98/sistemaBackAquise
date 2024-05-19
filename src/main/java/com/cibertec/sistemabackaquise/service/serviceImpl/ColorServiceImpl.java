package com.cibertec.sistemabackaquise.service.serviceImpl;
import com.cibertec.sistemabackaquise.model.Color;
import com.cibertec.sistemabackaquise.dtos.ColorDTO.ColorCreateDTO;
import com.cibertec.sistemabackaquise.dtos.ColorDTO.ColorDTO;
import com.cibertec.sistemabackaquise.dtos.ColorDTO.ColorUpdateDTO;
import com.cibertec.sistemabackaquise.mappers.ColorMapper;
import com.cibertec.sistemabackaquise.repository.ColorRepository;
import com.cibertec.sistemabackaquise.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import java.util.List;

@Service
public class ColorServiceImpl implements ColorService {


    private final ColorRepository colorRepository;

    @Autowired
    public ColorServiceImpl(ColorRepository colorRepository) {
        this.colorRepository = colorRepository;
    }
    @Override
    public List<ColorDTO> listarColores() {
        List<Color> colores = colorRepository.findAll();
        return ColorMapper.instancia.listaColorAListaColorDTO(colores);
    }

    @Override
    public ColorDTO obtenerColorPorId(Integer id) {
        Optional<Color> optionalColor = colorRepository.findById(id);
        return optionalColor.map(ColorMapper.instancia::colorToColorDTO).orElse(null);
    }

    @Override
    public ColorDTO registrarColor(ColorCreateDTO colorCreateDTO) {
        Color color = ColorMapper.instancia.colorCreateDTOToColor(colorCreateDTO);
        Color colorGuardado = colorRepository.save(color);
        return ColorMapper.instancia.colorToColorDTO(colorGuardado);
    }

    @Override
    public ColorDTO actualizarColor(ColorUpdateDTO colorUpdateDTO) {
        Color color = ColorMapper.instancia.colorUpdateDTOToColor(colorUpdateDTO);
        Color colorActualizado = colorRepository.save(color);
        return ColorMapper.instancia.colorToColorDTO(colorActualizado);
    }

    @Override
    public void eliminarColor(Integer id) {
        colorRepository.deleteById(id);
    }
}
