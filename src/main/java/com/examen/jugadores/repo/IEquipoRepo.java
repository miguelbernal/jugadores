package com.examen.jugadores.repo;

import com.examen.jugadores.model.Equipo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IEquipoRepo extends JpaRepository<Equipo, Integer> {
    
}
