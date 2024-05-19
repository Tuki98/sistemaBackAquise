package com.cibertec.sistemabackaquise.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name ="tb_Color")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codColor")
    private Integer codColor;

    @Column(name = "desColor", length = 200)
    private String desColor;

    @OneToMany(mappedBy = "color")
    private Set<Automovil> automoviles;
}