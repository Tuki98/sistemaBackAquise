package com.cibertec.sistemabackaquise.service;

import com.cibertec.sistemabackaquise.dtos.ColorDTO.ColorCreateDTO;
import com.cibertec.sistemabackaquise.dtos.ColorDTO.ColorDTO;
import com.cibertec.sistemabackaquise.dtos.ColorDTO.ColorUpdateDTO;

import java.util.List;

public interface ColorService {
    List<ColorDTO> listarColores();
    ColorDTO obtenerColorPorId(Integer id);
    ColorDTO registrarColor(ColorCreateDTO colorCreateDTO);
    ColorDTO actualizarColor(ColorUpdateDTO colorUpdateDTO);
    void eliminarColor(Integer id);
}
