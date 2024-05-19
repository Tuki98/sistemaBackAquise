package com.cibertec.sistemabackaquise.repository;

import com.cibertec.sistemabackaquise.model.Motor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotorRepository extends JpaRepository<Motor, Integer> {
}