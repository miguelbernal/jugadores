package com.examen.jugadores.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TipoDocumento {
    @Id
    @Column(name = "id_tipo_documento")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("idTipoDocumento")
    private int idTipoDocumento;

    @Column(name = "descripcion_tipo_documento", length = 128)
    @JsonProperty("descripcionTipoDocumento")
    private String descripcionTipoDocumento;
}