package com.examen.jugadores.rest;

import java.util.List;
import java.util.Optional;

import com.examen.jugadores.model.Jugador;
import com.examen.jugadores.repo.IJugadorRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/jugadores")
public class JugadorRestController {
    @Autowired
    private IJugadorRepo repo;

    @GetMapping(value ="/{id}")
    public Optional<Jugador> findOne(@PathVariable("id") Integer id) {
        return repo.findById(id);
    }

    @GetMapping
    public List<Jugador> findAll() {
        return repo.findAll();
    }

    @PostMapping
    public Jugador insert(@RequestBody Jugador jugador) {
         return repo.save(jugador);
    }

    @PutMapping
    public Jugador update(@RequestBody Jugador jugador) {
        return repo.save(jugador);        
    }

    @DeleteMapping(value="/{id}")
    public Optional<Jugador> delete(@PathVariable("id") Integer id) {
        Optional<Jugador> jugador = repo.findById(id);
        repo.deleteById(id);
        return jugador;
    }

    @GetMapping(value = "/equipo")
    public List<Jugador> findEquiposOrdenados() {
        return repo.findByEquiposOrdenados();
    }

    @GetMapping(value = "/equipo/id/{id}")
    public List<Jugador> findEquiposId(@PathVariable("id") int id) {
        return repo.findByEquipoId(id);
    }

    
    @PutMapping(value="/jugadordeunequipo/{numero_documento}/{tipo_documento}/{id_equipo}")
    public Jugador updateEquipo(@PathVariable("numero_documento") String numero, @PathVariable("tipo_documento") Integer id_tipo, @PathVariable("id_equipo") Integer id_equipo ) {
        List<Jugador> lista = repo.updateEquipo(numero,id_tipo,id_equipo);
        Jugador jugador = lista.get(0);
        try {
            repo.updateEquipo0(numero, id_tipo, id_equipo);    
        } catch (Exception e) {
            //TODO: handle exception
        }
        return jugador;    
    }
    
}
