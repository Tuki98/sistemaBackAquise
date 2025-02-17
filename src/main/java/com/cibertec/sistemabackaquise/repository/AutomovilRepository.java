package com.cibertec.sistemabackaquise.repository;

import com.cibertec.sistemabackaquise.model.Automovil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutomovilRepository extends JpaRepository<Automovil, Integer> {
}