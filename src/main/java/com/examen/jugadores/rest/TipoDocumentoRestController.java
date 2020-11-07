package com.examen.jugadores.rest;

import java.util.List;
import java.util.Optional;

import com.examen.jugadores.model.TipoDocumento;
import com.examen.jugadores.repo.ITipoDocumentoRepo;

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
@RequestMapping("api/tiposdocumentos")
public class TipoDocumentoRestController {
    @Autowired
    private ITipoDocumentoRepo repo;

    @GetMapping(value ="/{id}")
    public Optional<TipoDocumento> findOne(@PathVariable("id") Integer id) {
        return repo.findById(id);
    }

    @GetMapping
    public List<TipoDocumento> findAll() {
        return repo.findAll();
    }

    @PostMapping
    public TipoDocumento insert(@RequestBody TipoDocumento tipoDocumento) {
         return repo.save(tipoDocumento);
    }

    @PutMapping
    public TipoDocumento update(@RequestBody TipoDocumento tipoDocumento) {
         return repo.save(tipoDocumento);
    }

    @DeleteMapping(value="/{id}")
    public Optional<TipoDocumento> delete(@PathVariable("id") Integer id) {
        Optional<TipoDocumento> tipoDocumento = repo.findById(id);
        repo.deleteById(id);
        return tipoDocumento;
    }
}
