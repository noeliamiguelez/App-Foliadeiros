package com.foliadas.foliadas_api.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "provincia")
public class Provincia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre", unique = true, nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "provincia")
    private List<Foliada> foliadas;

    public Provincia() {
    }

    public Provincia(int id, String nombre, List<Foliada> foliadas) {
        this.id = id;
        this.nombre = nombre;
        this.foliadas = foliadas;
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

    public List<Foliada> getFoliadas() {
        return foliadas;
    }

    public void setFoliadas(List<Foliada> foliadas) {
        this.foliadas = foliadas;
    }
}
