package com.cibertec.sistemabackaquise.model;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@Entity
@Table(name ="tb_Motor")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Motor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codMotor")
    private Integer codMotor;

    @Column(name = "desMotor", length = 200)
    private String desMotor;

    @OneToMany(mappedBy = "motor")
    private Set<Automovil> automoviles;
}