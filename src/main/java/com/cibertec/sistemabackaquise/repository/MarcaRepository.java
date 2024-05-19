package com.cibertec.sistemabackaquise.repository;

import com.cibertec.sistemabackaquise.model.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Integer> {
}