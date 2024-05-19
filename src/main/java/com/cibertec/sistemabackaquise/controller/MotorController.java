package com.cibertec.sistemabackaquise.controller;

import com.cibertec.sistemabackaquise.dtos.MotorDTO.MotorCreateDTO;
import com.cibertec.sistemabackaquise.dtos.MotorDTO.MotorDTO;
import com.cibertec.sistemabackaquise.dtos.MotorDTO.MotorUpdateDTO;
import com.cibertec.sistemabackaquise.service.MotorService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class MotorController {
    private final MotorService motorService;

    public MotorController(MotorService motorService) {
        this.motorService = motorService;
    }

    @Operation(summary = "Endpoint que permite listar los motores", description = "Endpoint que permite listar los motores")
    @GetMapping("/motores")
    public ResponseEntity<List<MotorDTO>> listarMotores() {
        List<MotorDTO> motores = motorService.listarMotores();
        return new ResponseEntity<>(motores, HttpStatus.OK);
    }

    @Operation(summary = "Endpoint que permite obtener un motor por su ID", description = "Endpoint que permite obtener un motor por su ID")
    @GetMapping("/motores/{motorId}")
    public ResponseEntity<MotorDTO> obtenerMotorPorId(@PathVariable("motorId") Integer motorId) {
        MotorDTO motor = motorService.obtenerMotorPorId(motorId);
        if (motor != null) {
            return new ResponseEntity<>(motor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Endpoint que permite registrar un nuevo motor", description = "Endpoint que permite registrar un nuevo motor")
    @PostMapping("/motores")
    public ResponseEntity<MotorDTO> registrarMotor(@RequestBody MotorCreateDTO motorCreateDTO) {
        MotorDTO motorDTO = motorService.registrarMotor(motorCreateDTO);
        return new ResponseEntity<>(motorDTO, HttpStatus.CREATED);
    }

    @Operation(summary = "Endpoint que permite actualizar un motor existente", description = "Endpoint que permite actualizar un motor existente")
    @PutMapping("/motores")
    public ResponseEntity<MotorDTO> actualizarMotor(@RequestBody MotorUpdateDTO motorUpdateDTO) {
        MotorDTO motorDTO = motorService.actualizarMotor(motorUpdateDTO);
        if (motorDTO != null) {
            return new ResponseEntity<>(motorDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Endpoint que permite eliminar un motor por su ID", description = "Endpoint que permite eliminar un motor por su ID")
    @DeleteMapping("/motores/{motorId}")
    public ResponseEntity<?> eliminarMotor(@PathVariable("motorId") Integer motorId) {
        motorService.eliminarMotor(motorId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
