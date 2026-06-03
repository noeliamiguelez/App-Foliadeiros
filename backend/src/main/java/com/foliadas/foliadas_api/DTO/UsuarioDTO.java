package com.foliadas.foliadas_api.DTO;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class UsuarioDTO {

    private int id;
    private String nombre;
    private String email;
    private String password;

    private Set<FoliadaDTO> favoritas= new HashSet<>();

    public UsuarioDTO() {
    }

    public UsuarioDTO(int id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    public String getPassword() {
        return password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<FoliadaDTO> getFavoritas() {
        return favoritas;
    }

    public void setFavoritas(Set<FoliadaDTO> favoritas) {
        this.favoritas = favoritas;
    }


}
