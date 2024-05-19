package com.cibertec.sistemabackaquise.dtos.AutomovilDTO;

import com.cibertec.sistemabackaquise.dtos.ColorDTO.ColorDTO;
import com.cibertec.sistemabackaquise.dtos.MarcaDTO.MarcaDTO;
import com.cibertec.sistemabackaquise.dtos.MotorDTO.MotorDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AutomovilUpdateDTO {
    private Integer codAutomovil;
    private Integer codMarca;
    private Integer codMotor;
    private Integer codColor;
    private Integer anioFabricacion;
    private Double cilindrada;
    private Integer numPuertas;
    private Double precio;
    private MarcaDTO marcaDTO;
    private ColorDTO colorDTO;
    private MotorDTO motorDTO;
}
