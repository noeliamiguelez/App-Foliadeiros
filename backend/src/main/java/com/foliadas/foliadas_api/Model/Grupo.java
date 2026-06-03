package com.foliadas.foliadas_api.Model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "grupo")
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int grupo_id;

    private String nome;

    private String tipo;

    private String orixen;

    @ManyToMany(mappedBy = "grupos")
    private Set<Foliada> foliadas;

    public Grupo() {}

    public Grupo(int grupo_id, String nome, String tipo, String orixen, Set<Foliada> foliadas) {
        this.grupo_id = grupo_id;
        this.nome = nome;
        this.tipo = tipo;
        this.orixen = orixen;
        this.foliadas = foliadas;
    }

    public int getGrupo_id() {
        return grupo_id;
    }

    public void setGrupo_id(int grupo_id) {
        this.grupo_id = grupo_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public Set<Foliada> getFoliadas() {
        return foliadas;
    }

    public void setFoliadas(Set<Foliada> foliadas) {
        this.foliadas = foliadas;
    }
}