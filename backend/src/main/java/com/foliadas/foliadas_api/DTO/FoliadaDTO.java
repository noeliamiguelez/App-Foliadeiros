package com.foliadas.foliadas_api.DTO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class FoliadaDTO {

    private int id;
    private String nombre;
    private LocalDate fecha;
    private LocalTime hora;
    private String lugar;
    private String descripcion;
    private Double latitude;
    private Double lonxitude;
    private String imaxe;

    private ProvinciaDTO provincia;

    private Set<GrupoDTO> grupos= new HashSet<>();

    public FoliadaDTO() {
    }

    public FoliadaDTO(int id, String nombre, LocalTime hora, LocalDate fecha, String lugar, String descripcion, Double latitude, Double lonxitude, String imaxe, ProvinciaDTO provincia) {
        this.id = id;
        this.nombre = nombre;
        this.hora = hora;
        this.fecha = fecha;
        this.lugar = lugar;
        this.descripcion = descripcion;
        this.latitude = latitude;
        this.lonxitude = lonxitude;
        this.imaxe = imaxe;
        this.provincia = provincia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getLonxitude() {
        return lonxitude;
    }

    public void setLonxitude(Double lonxitude) {
        this.lonxitude = lonxitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getImaxe() {
        return imaxe;
    }

    public void setImaxe(String imaxe) {
        this.imaxe = imaxe;
    }

    public ProvinciaDTO getProvincia() {
        return provincia;
    }

    public void setProvincia(ProvinciaDTO provincia) {
        this.provincia = provincia;
    }

    public Set<GrupoDTO> getGrupos() {
        return grupos;
    }

    public void setGrupos(Set<GrupoDTO> grupos) {
        this.grupos = grupos;
    }
}
