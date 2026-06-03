package com.example.foliadeiros.Model;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class Foliada {

    private int id;
    private String nombre;
    private String fecha;
    private String hora;
    private String lugar;
    private String descripcion;
    private Double latitude;
    private Double lonxitude;

    @SerializedName("imaxe")
    private String imaxe;

    private Provincia provincia;

    private Set<Grupo> grupos= new HashSet<>();

    public Foliada() {
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
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

    public String getImaxe() {
        return imaxe;
    }

    public void setImaxe(String imaxe) {
        this.imaxe = imaxe;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public Set<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(Set<Grupo> grupos) {
        this.grupos = grupos;
    }
}
