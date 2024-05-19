package com.cibertec.sistemabackaquise.controller;

import com.cibertec.sistemabackaquise.dtos.ColorDTO.ColorCreateDTO;
import com.cibertec.sistemabackaquise.dtos.ColorDTO.ColorDTO;
import com.cibertec.sistemabackaquise.dtos.ColorDTO.ColorUpdateDTO;
import com.cibertec.sistemabackaquise.service.ColorService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ColorController {
    private final ColorService colorService;

    public ColorController(ColorService colorService) {
        this.colorService = colorService;
    }

    @Operation(summary = "Endpoint que permite listar los colores", description = "Endpoint que permite listar los colores")
    @GetMapping("/colores")
    public ResponseEntity<List<ColorDTO>> listarColores() {
        List<ColorDTO> colores = colorService.listarColores();
        return new ResponseEntity<>(colores, HttpStatus.OK);
    }

    @Operation(summary = "Endpoint que permite obtener un color por su ID", description = "Endpoint que permite obtener un color por su ID")
    @GetMapping("/colores/{colorId}")
    public ResponseEntity<ColorDTO> obtenerColorPorId(@PathVariable("colorId") Integer colorId) {
        ColorDTO color = colorService.obtenerColorPorId(colorId);
        if (color != null) {
            return new ResponseEntity<>(color, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Endpoint que permite registrar un nuevo color", description = "Endpoint que permite registrar un nuevo color")
    @PostMapping("/colores")
    public ResponseEntity<ColorDTO> registrarColor(@RequestBody ColorCreateDTO colorCreateDTO) {
        ColorDTO colorDTO = colorService.registrarColor(colorCreateDTO);
        return new ResponseEntity<>(colorDTO, HttpStatus.CREATED);
    }

    @Operation(summary = "Endpoint que permite actualizar un color existente", description = "Endpoint que permite actualizar un color existente")
    @PutMapping("/colores")
    public ResponseEntity<ColorDTO> actualizarColor(@RequestBody ColorUpdateDTO colorUpdateDTO) {
        ColorDTO colorDTO = colorService.actualizarColor(colorUpdateDTO);
        if (colorDTO != null) {
            return new ResponseEntity<>(colorDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Endpoint que permite eliminar un color por su ID", description = "Endpoint que permite eliminar un color por su ID")
    @DeleteMapping("/colores/{colorId}")
    public ResponseEntity<?> eliminarColor(@PathVariable("colorId") Integer colorId) {
        colorService.eliminarColor(colorId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
