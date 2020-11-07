package com.examen.jugadores.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Jugador {
    @Id
    @Column(name = "id_jugador")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("idJugador")
    private int idJugador;

    @Column(name = "nombre_jugador")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("nombreJugador")
    @NotEmpty
    private String nombreJugador;


    @Column(name = "apellido_jugador")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("apellidoJugador")
    @NotNull
    private String apellidoJugador;

    @Column(name = "fecha_nacimiento_jugador")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("fechaNacimientoJugador")
    private Date fechaNacimientoJugador;

    @Column(name = "tarjeta_roja_jugador")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("tarjetaRojaJugador")
    private int tarjetaRojaJugador;

    @Column(name = "tarjeta_amarilla_jugador")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("tarjetaAmarillaJugador")
    private int tarjetaAmarillaJugador;

    @Column(name = "total_tantos_jugador")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("totalTantosJugador")
    private int totalTantosJugador;

    @ManyToOne
    @JsonProperty("tipoDocumento")
    private TipoDocumento tipoDocumento;

    @Column(name = "numero_documento_jugador")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("numeroDocumentoJugador")
    private String numeroDocumentoJugador;

    @ManyToOne
    @JsonProperty("equipo")
    private Equipo equipo;

}