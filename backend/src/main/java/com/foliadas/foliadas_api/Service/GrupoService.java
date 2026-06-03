package com.foliadas.foliadas_api.Service;


import com.foliadas.foliadas_api.DTO.GrupoDTO;
import com.foliadas.foliadas_api.Model.Grupo;

import java.util.List;

public interface GrupoService {

    List<GrupoDTO> getAll();
    GrupoDTO getById(int id);
    GrupoDTO create(GrupoDTO grupoDTO);
    void delete(int id);
    GrupoDTO update(int id, GrupoDTO grupoDTO);

}
