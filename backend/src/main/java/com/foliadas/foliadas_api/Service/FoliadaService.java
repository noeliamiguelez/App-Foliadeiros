package com.foliadas.foliadas_api.Service;


import com.foliadas.foliadas_api.DTO.FoliadaDTO;
import com.foliadas.foliadas_api.Model.Foliada;

import java.util.List;

public interface FoliadaService {

    List<FoliadaDTO> getAll();
    FoliadaDTO getById(int id);
    FoliadaDTO create(FoliadaDTO foliadaDTO);
    void delete(int id);
    Foliada update(int id, Foliada foliada);

    List<FoliadaDTO> getByProvincia(int provinciaId);
    List<FoliadaDTO> getByNome(String nome);

}
