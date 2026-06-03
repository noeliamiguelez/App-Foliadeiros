package com.foliadas.foliadas_api.DTO;

public class GrupoDTO {

    private int id;
    private String nombre;
    private String tipo;
    private String orixen;

    public GrupoDTO() {
    }

    public GrupoDTO(int id, String nombre, String tipo, String orixen) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.orixen = orixen;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getOrixen() {
        return orixen;
    }

    public void setOrixen(String orixen) {
        this.orixen = orixen;
    }
}
