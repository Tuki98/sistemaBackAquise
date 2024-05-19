package com.cibertec.sistemabackaquise.service.serviceImpl;

import com.cibertec.sistemabackaquise.model.Motor;
import com.cibertec.sistemabackaquise.dtos.MotorDTO.MotorCreateDTO;
import com.cibertec.sistemabackaquise.dtos.MotorDTO.MotorDTO;
import com.cibertec.sistemabackaquise.dtos.MotorDTO.MotorUpdateDTO;
import com.cibertec.sistemabackaquise.mappers.MotorMapper;
import com.cibertec.sistemabackaquise.repository.MotorRepository;
import com.cibertec.sistemabackaquise.service.MotorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MotorServiceImpl implements MotorService {

    private final MotorRepository motorRepository;

    @Autowired
    public MotorServiceImpl(MotorRepository motorRepository) {
        this.motorRepository = motorRepository;
    }


    @Override
    public List<MotorDTO> listarMotores() {
        List<Motor> motores = motorRepository.findAll();
        return MotorMapper.instancia.listaMotorAListaMotorDTO(motores);
    }

    @Override
    public MotorDTO obtenerMotorPorId(Integer id) {
        Optional<Motor> optionalMotor = motorRepository.findById(id);
        return optionalMotor.map(MotorMapper.instancia::motorToMotorDTO).orElse(null);
    }

    @Override
    public MotorDTO registrarMotor(MotorCreateDTO motorCreateDTO) {
        Motor motor = MotorMapper.instancia.motorCreateDTOToMotor(motorCreateDTO);
        Motor motorGuardado = motorRepository.save(motor);
        return MotorMapper.instancia.motorToMotorDTO(motorGuardado);
    }

    @Override
    public MotorDTO actualizarMotor(MotorUpdateDTO motorUpdateDTO) {
        Motor motor = MotorMapper.instancia.motorUpdateDTOToMotor(motorUpdateDTO);
        Motor motorActualizado = motorRepository.save(motor);
        return MotorMapper.instancia.motorToMotorDTO(motorActualizado);
    }

    @Override
    public void eliminarMotor(Integer id) {
        motorRepository.deleteById(id);
    }
}
