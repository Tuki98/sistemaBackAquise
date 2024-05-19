package com.cibertec.sistemabackaquise.service;
import com.cibertec.sistemabackaquise.dtos.MotorDTO.MotorCreateDTO;
import com.cibertec.sistemabackaquise.dtos.MotorDTO.MotorDTO;
import com.cibertec.sistemabackaquise.dtos.MotorDTO.MotorUpdateDTO;

import java.util.List;
public interface MotorService {
    List<MotorDTO> listarMotores();
    MotorDTO obtenerMotorPorId(Integer id);
    MotorDTO registrarMotor(MotorCreateDTO motorCreateDTO);
    MotorDTO actualizarMotor(MotorUpdateDTO motorUpdateDTO);
    void eliminarMotor(Integer id);
}
