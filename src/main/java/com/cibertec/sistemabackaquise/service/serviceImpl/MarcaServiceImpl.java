package com.cibertec.sistemabackaquise.service.serviceImpl;

import com.cibertec.sistemabackaquise.model.Marca;
import com.cibertec.sistemabackaquise.dtos.MarcaDTO.MarcaCreateDTO;
import com.cibertec.sistemabackaquise.dtos.MarcaDTO.MarcaDTO;
import com.cibertec.sistemabackaquise.dtos.MarcaDTO.MarcaUpdateDTO;
import com.cibertec.sistemabackaquise.mappers.MarcaMapper;
import com.cibertec.sistemabackaquise.repository.MarcaRepository;
import com.cibertec.sistemabackaquise.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarcaServiceImpl implements MarcaService {

    private final MarcaRepository marcaRepository;

    @Autowired
    public MarcaServiceImpl(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }

    @Override
    public List<MarcaDTO> listarMarcas() {
        List<Marca> marcas = marcaRepository.findAll();
        return MarcaMapper.instancia.listaMarcaAListaMarcaDTO(marcas);
    }

    @Override
    public MarcaDTO obtenerMarcaPorId(Integer id) {
        Optional<Marca> optionalMarca = marcaRepository.findById(id);
        return optionalMarca.map(MarcaMapper.instancia::marcaToMarcaDTO).orElse(null);
    }

    @Override
    public MarcaDTO registrarMarca(MarcaCreateDTO marcaCreateDTO) {
        Marca marca = MarcaMapper.instancia.marcaCreateDTOToMarca(marcaCreateDTO);
        Marca marcaGuardada = marcaRepository.save(marca);
        return MarcaMapper.instancia.marcaToMarcaDTO(marcaGuardada);
    }

    @Override
    public MarcaDTO actualizarMarca(MarcaUpdateDTO marcaUpdateDTO) {
        Marca marca = MarcaMapper.instancia.marcaUpdateDTOToMarca(marcaUpdateDTO);
        Marca marcaActualizada = marcaRepository.save(marca);
        return MarcaMapper.instancia.marcaToMarcaDTO(marcaActualizada);
    }

    @Override
    public void eliminarMarca(Integer id) {
        marcaRepository.deleteById(id);
    }
}
