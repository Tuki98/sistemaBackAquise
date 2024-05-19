package com.cibertec.sistemabackaquise.service;

import com.cibertec.sistemabackaquise.dtos.AutomovilDTO.AutomovilCreateDTO;
import com.cibertec.sistemabackaquise.dtos.AutomovilDTO.AutomovilDTO;
import com.cibertec.sistemabackaquise.dtos.AutomovilDTO.AutomovilUpdateDTO;

import java.util.List;

public interface AutomovilService {
    List<AutomovilDTO> listarAutomoviles();
    AutomovilDTO obtenerAutomovilPorId(Integer id);
    AutomovilDTO registrarAutomovil(AutomovilCreateDTO automovilCreateDTO);
    AutomovilDTO actualizarAutomovil(AutomovilUpdateDTO automovilUpdateDTO);
    void eliminarAutomovil(Integer id);
    String generarPdftoBase64();
}
