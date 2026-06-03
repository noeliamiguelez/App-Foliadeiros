package com.foliadas.foliadas_api.Service;

import com.foliadas.foliadas_api.DTO.FoliadaDTO;
import com.foliadas.foliadas_api.DTO.UsuarioDTO;
import com.foliadas.foliadas_api.Model.Foliada;
import com.foliadas.foliadas_api.Model.Usuario;

import java.util.List;
import java.util.Set;

public interface UsuarioService {

    List<UsuarioDTO> getAll();
    UsuarioDTO getById(int id);
    UsuarioDTO create(UsuarioDTO usuarioDTO);
    void delete(int id);
    Usuario update(int id, Usuario usuario);
    Usuario login(String email, String password);

    Set<FoliadaDTO> getFavoritas(int usuarioId);
    void addFavorita(int usuarioId, int foliadaId);
    void removeFavorita(int usuarioId, int foliadaId);

}
