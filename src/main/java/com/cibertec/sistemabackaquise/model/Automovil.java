package com.cibertec.sistemabackaquise.model;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@Entity
@Table(name ="tb_Automovil")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Automovil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codAutomovil")
    private Integer codAutomovil;

    @ManyToOne
    @JoinColumn(name = "codMarca")
    private Marca marca;

    @ManyToOne
    @JoinColumn(name = "codMotor")
    private Motor motor;

    @ManyToOne
    @JoinColumn(name = "codColor")
    private Color color;

    @Column(name = "anioFabricacion")
    private Integer anioFabricacion;

    @Column(name = "cilindrada")
    private Double cilindrada;

    @Column(name = "numPuertas")
    private Integer numPuertas;

    @Column(name = "precio")
    private Double precio;
}