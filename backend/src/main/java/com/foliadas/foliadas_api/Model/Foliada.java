package com.foliadas.foliadas_api.Model;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="foliada")
public class Foliada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome",nullable = false, length = 150)
    private String nome;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "hora")
    private LocalTime hora;

    @Column(name = "lugar", length = 150)
    private String lugar;

    @ManyToOne
    @JoinColumn(name = "provincia_id", nullable = false)
    private Provincia provincia;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    private String imaxe;

    private Double latitude;

    private Double lonxitude;

    @ManyToMany
    @JoinTable(
            name= "foliada_grupo",
            joinColumns = @JoinColumn(name = "foliada_id"),
            inverseJoinColumns = @JoinColumn(name = "grupo_id")
    )
    private Set<Grupo> grupos;

    @ManyToMany(mappedBy = "favoritas")
    private Set<Usuario> usarios= new HashSet<>();


    public Foliada() {}

    public Foliada(int id, String nome, LocalDate fecha, LocalTime hora, String lugar, Provincia provincia, String descripcion, String imaxe, Double latitude, Double lonxitude, Set<Grupo> grupos, Set<Usuario> usarios) {
        this.id = id;
        this.nome = nome;
        this.fecha = fecha;
        this.hora = hora;
        this.lugar = lugar;
        this.provincia = provincia;
        this.descripcion = descripcion;
        this.imaxe = imaxe;
        this.latitude = latitude;
        this.lonxitude = lonxitude;
        this.grupos = grupos;
        this.usarios = usarios;
    }

    public Set<Usuario> getUsarios() {
        return usarios;
    }

    public void setUsarios(Set<Usuario> usarios) {
        this.usarios = usarios;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImaxe() {
        return imaxe;
    }

    public void setImaxe(String imaxe) {
        this.imaxe = imaxe;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLonxitude() {
        return lonxitude;
    }

    public void setLonxitude(Double lonxitude) {
        this.lonxitude = lonxitude;
    }

    public Set<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(Set<Grupo> grupos) {
        this.grupos = grupos;
    }
}