package com.examen.jugadores.repo;

import java.util.List;

import com.examen.jugadores.model.Jugador;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IJugadorRepo extends JpaRepository<Jugador, Integer> {
    
    @Query(value = "SELECT * FROM jugador j LEFT JOIN equipo e ON j.equipo_id_equipo=e.id_equipo ORDER BY j.equipo_id_equipo DESC", 
    nativeQuery = true)
    public List<Jugador> findByEquiposOrdenados();

    @Query(value = "SELECT * FROM jugador j LEFT JOIN equipo e ON j.equipo_id_equipo=e.id_equipo WHERE j.equipo_id_equipo=?1 ORDER BY j.equipo_id_equipo DESC", 
    nativeQuery = true)
    public List<Jugador> findByEquipoId(int id);

    @Query(value = "SELECT * FROM  jugador WHERE tipo_documento_id_tipo_documento=?2 AND numero_documento_jugador=?1 AND equipo_id_equipo = ?3", 
    nativeQuery = true)
    public List<Jugador> updateEquipo(String numero, Integer id_tipo, Integer id_equipo);

    @Query(value = "UPDATE jugador SET equipo_id_equipo = 0 WHERE tipo_documento_id_tipo_documento=?2 AND numero_documento_jugador=?1 AND equipo_id_equipo = ?3", 
    nativeQuery = true)
    public void updateEquipo0(String numero, Integer id_tipo, Integer id_equipo);
}
