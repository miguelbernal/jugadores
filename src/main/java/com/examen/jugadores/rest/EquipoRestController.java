package com.examen.jugadores.rest;

import java.util.List;
import java.util.Optional;

import com.examen.jugadores.model.Equipo;
import com.examen.jugadores.repo.IEquipoRepo;

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
@RequestMapping("api/equipos")
public class EquipoRestController {
    @Autowired
    private IEquipoRepo repo;

    @GetMapping(value ="/{id}")
    public Optional<Equipo> findOne(@PathVariable("id") Integer id) {
        return repo.findById(id);
    }

    @GetMapping
    public List<Equipo> findAll() {
        return repo.findAll();
    }

    @PostMapping
    public Equipo insert(@RequestBody Equipo equipo) {
         return repo.save(equipo);
    }

    @PutMapping
    public Equipo update(@RequestBody Equipo equipo) {
         return repo.save(equipo);
    }

    @DeleteMapping(value="/{id}")
    public Optional<Equipo> delete(@PathVariable("id") Integer id) {
        Optional<Equipo> equipo = repo.findById(id);
        repo.deleteById(id);
        return equipo;
    }
}
