package com.cibertec.sistemabackaquise.service;

import com.cibertec.sistemabackaquise.dtos.MarcaDTO.MarcaCreateDTO;
import com.cibertec.sistemabackaquise.dtos.MarcaDTO.MarcaDTO;
import com.cibertec.sistemabackaquise.dtos.MarcaDTO.MarcaUpdateDTO;

import java.util.HashMap;
import java.util.List;

public interface MarcaService {
    List<MarcaDTO> listarMarcas();
    MarcaDTO obtenerMarcaPorId(Integer id);
    MarcaDTO registrarMarca(MarcaCreateDTO marcaCreateDTO);
    MarcaDTO actualizarMarca(MarcaUpdateDTO marcaUpdateDTO);
    void eliminarMarca(Integer id);
}
