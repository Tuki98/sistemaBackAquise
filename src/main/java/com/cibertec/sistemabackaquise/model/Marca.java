package com.cibertec.sistemabackaquise.model;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name ="tb_Marca")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codMarca")
    private Integer codMarca;

    @Column(name = "desMarca", length = 200)
    private String desMarca;

    @OneToMany(mappedBy = "marca")
    private Set<Automovil> automoviles;
}