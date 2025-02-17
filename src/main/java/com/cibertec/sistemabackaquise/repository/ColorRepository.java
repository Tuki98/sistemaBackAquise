package com.cibertec.sistemabackaquise.repository;


import com.cibertec.sistemabackaquise.model.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepository extends JpaRepository<Color, Integer> {
}