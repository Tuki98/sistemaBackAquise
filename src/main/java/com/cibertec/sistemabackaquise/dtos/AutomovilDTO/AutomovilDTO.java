package com.cibertec.sistemabackaquise.dtos.AutomovilDTO;

import com.cibertec.sistemabackaquise.dtos.ColorDTO.ColorDTO;
import com.cibertec.sistemabackaquise.dtos.MarcaDTO.MarcaDTO;
import com.cibertec.sistemabackaquise.dtos.MotorDTO.MotorDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutomovilDTO {
    private Integer codAutomovil;
    private MarcaDTO marca;
    private MotorDTO motor;
    private ColorDTO color;
    private Integer anioFabricacion;
    private Double cilindrada;
    private Integer numPuertas;
    private Double precio;
    private MarcaDTO marcaDTO;
    private ColorDTO colorDTO;
    private MotorDTO motorDTO;
}
