package com.cibertec.sistemabackaquise.controller;

import com.cibertec.sistemabackaquise.dtos.MarcaDTO.MarcaCreateDTO;
import com.cibertec.sistemabackaquise.dtos.MarcaDTO.MarcaDTO;
import com.cibertec.sistemabackaquise.dtos.MarcaDTO.MarcaUpdateDTO;
import com.cibertec.sistemabackaquise.service.MarcaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api")
public class MarcaController {
    private final MarcaService marcaService;

    public MarcaController(MarcaService marcaService) {
        this.marcaService = marcaService;
    }

    @Operation(summary = "Endpoint que permite listar las marcas", description = "Endpoint que permite listar las marcas")
    @GetMapping("/marcas")
    public ResponseEntity<List<MarcaDTO>> listarMarcas(){
        return new ResponseEntity<>(marcaService.listarMarcas(), HttpStatus.OK);
    }

    @Operation(summary = "Endpoint que permite obtener una marca por su ID", description = "Endpoint que permite obtener una marca por su ID")
    @GetMapping("/marcas/{marcaId}")
    public ResponseEntity<MarcaDTO> obtenerMarcaPorId(@PathVariable("marcaId") Integer marcaId){
        return new ResponseEntity<>(marcaService.obtenerMarcaPorId(marcaId), HttpStatus.OK);
    }

    @Operation(summary = "Endpoint que permite registrar una nueva marca", description = "Endpoint que permite registrar una nueva marca")
    @PostMapping("/marcas")
    public ResponseEntity<MarcaDTO> registrarMarca(@RequestBody MarcaCreateDTO marcaCreateDTO){
        return new ResponseEntity<>(marcaService.registrarMarca(marcaCreateDTO), HttpStatus.OK);
    }

    @Operation(summary = "Endpoint que permite actualizar una marca existente", description = "Endpoint que permite actualizar una marca existente")
    @PutMapping("/marcas")
    public ResponseEntity<MarcaDTO> actualizarMarca(@RequestBody MarcaUpdateDTO marcaUpdateDTO){
        return new ResponseEntity<>(marcaService.actualizarMarca(marcaUpdateDTO), HttpStatus.OK);
    }

    @Operation(summary = "Endpoint que permite eliminar una marca por su ID", description = "Endpoint que permite eliminar una marca por su ID")
    @DeleteMapping("/marcas/{marcaId}")
    public ResponseEntity<?> eliminarMarca(@PathVariable("marcaId") Integer marcaId){
        marcaService.eliminarMarca(marcaId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
