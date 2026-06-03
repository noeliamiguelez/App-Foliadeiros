package com.foliadas.foliadas_api.Service;

import com.foliadas.foliadas_api.DTO.ProvinciaDTO;

import java.util.List;

public interface ProvinciaService {

    List<ProvinciaDTO> getAll();
    ProvinciaDTO getById(int id);

}
