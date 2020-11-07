package com.examen.jugadores.repo;

import com.examen.jugadores.model.TipoDocumento;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ITipoDocumentoRepo extends JpaRepository<TipoDocumento, Integer> {
    
}
