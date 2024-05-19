package com.cibertec.sistemabackaquise.controller;

import com.cibertec.sistemabackaquise.dtos.AutomovilDTO.AutomovilCreateDTO;
import com.cibertec.sistemabackaquise.dtos.AutomovilDTO.AutomovilDTO;
import com.cibertec.sistemabackaquise.dtos.AutomovilDTO.AutomovilUpdateDTO;
import com.cibertec.sistemabackaquise.service.AutomovilService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AutomovilController {
    private final AutomovilService automovilService;

    public AutomovilController(AutomovilService automovilService) {
        this.automovilService = automovilService;
    }

    @Operation(summary = "Endpoint que permite listar los automóviles", description = "Endpoint que permite listar los automóviles")
    @GetMapping("/automoviles")
    public ResponseEntity<List<AutomovilDTO>> listarAutomoviles() {
        List<AutomovilDTO> automoviles = automovilService.listarAutomoviles();
        return new ResponseEntity<>(automoviles, HttpStatus.OK);
    }

    @Operation(summary = "Endpoint que permite obtener un automóvil por su ID", description = "Endpoint que permite obtener un automóvil por su ID")
    @GetMapping("/automoviles/{automovilId}")
    public ResponseEntity<AutomovilDTO> obtenerAutomovilPorId(@PathVariable("automovilId") Integer automovilId) {
        AutomovilDTO automovil = automovilService.obtenerAutomovilPorId(automovilId);
        if (automovil != null) {
            return new ResponseEntity<>(automovil, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Endpoint que permite registrar un nuevo automóvil", description = "Endpoint que permite registrar un nuevo automóvil")
    @PostMapping("/automoviles")
    public ResponseEntity<AutomovilDTO> registrarAutomovil(@RequestBody AutomovilCreateDTO automovilCreateDTO) {
        AutomovilDTO automovilDTO = automovilService.registrarAutomovil(automovilCreateDTO);
        return new ResponseEntity<>(automovilDTO, HttpStatus.CREATED);
    }

    @Operation(summary = "Endpoint que permite actualizar un automóvil existente", description = "Endpoint que permite actualizar un automóvil existente")
    @PutMapping("/automoviles")
    public ResponseEntity<AutomovilDTO> actualizarAutomovil(@RequestBody AutomovilUpdateDTO automovilUpdateDTO) {
        AutomovilDTO automovilDTO = automovilService.actualizarAutomovil(automovilUpdateDTO);
        if (automovilDTO != null) {
            return new ResponseEntity<>(automovilDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Endpoint que permite eliminar un automóvil por su ID", description = "Endpoint que permite eliminar un automóvil por su ID")
    @DeleteMapping("/automoviles/{automovilId}")
    public ResponseEntity<?> eliminarAutomovil(@PathVariable("automovilId") Integer automovilId) {
        automovilService.eliminarAutomovil(automovilId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Endpoint que permite generar reporte de automoviles", description = "Endpoint que permite generar reporte de automoviles")
    @GetMapping("/automoviles/reporte")
    public ResponseEntity<String> generateReportBase64()throws Exception{
        return new ResponseEntity<>(automovilService.generarPdftoBase64(),HttpStatus.OK);
    }
}
