package com.cibertec.sistemabackaquise.mappers;

import com.cibertec.sistemabackaquise.dtos.MotorDTO.MotorCreateDTO;
import com.cibertec.sistemabackaquise.dtos.MotorDTO.MotorDTO;
import com.cibertec.sistemabackaquise.dtos.MotorDTO.MotorUpdateDTO;
import com.cibertec.sistemabackaquise.model.Motor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MotorMapper {
    MotorMapper instancia = Mappers.getMapper(MotorMapper.class);
    MotorDTO motorToMotorDTO(Motor motor);
    Motor motorDTOToMotor(MotorDTO motorDTO);
    Motor motorCreateDTOToMotor(MotorCreateDTO motorCreateDTO);
    Motor motorUpdateDTOToMotor(MotorUpdateDTO motorUpdateDTO);
    List<MotorDTO> listaMotorAListaMotorDTO(List<Motor> listaMotor);


}
