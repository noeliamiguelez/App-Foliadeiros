package com.foliadas.foliadas_api.Service;

import com.foliadas.foliadas_api.DTO.GrupoDTO;
import com.foliadas.foliadas_api.Model.Grupo;
import com.foliadas.foliadas_api.Repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GrupoServiceImpl implements GrupoService{

    @Autowired
    private final GrupoRepository grupoRepository;

    public GrupoServiceImpl(GrupoRepository grupoRepository) {
        this.grupoRepository = grupoRepository;
    }

    @Override
    public List<GrupoDTO> getAll() {
        return grupoRepository.findAll().stream()
                .map(grupo -> new GrupoDTO(grupo.getGrupo_id(), grupo.getNome(), grupo.getTipo(), grupo.getOrixen()))
                .collect(Collectors.toList());
    }

    @Override
    public GrupoDTO getById(int id) {
        Grupo g= grupoRepository.findById(id).orElseThrow(()-> new RuntimeException("Grupo no encontrado"));
        return new GrupoDTO(g.getGrupo_id(), g.getNome(), g.getTipo(), g.getOrixen());
    }

    @Override
    public GrupoDTO create(GrupoDTO grupoDTO) {
        Grupo g= new Grupo();
        g.setNome(grupoDTO.getNombre());
        g.setTipo(grupoDTO.getTipo());
        g.setOrixen(grupoDTO.getOrixen());
        Grupo saved= grupoRepository.save(g);
        return new GrupoDTO(saved.getGrupo_id(),saved.getNome(), saved.getTipo(), saved.getOrixen());
    }

    @Override
    public void delete(int id) {
        grupoRepository.deleteById(id);
    }


    @Override
    public GrupoDTO update(int id, GrupoDTO grupoDTO) {
        Grupo existente = grupoRepository.findById(id).orElseThrow(() -> new RuntimeException("Grupo no encontrado"));
        existente.setNome(grupoDTO.getNombre());
        existente.setTipo(grupoDTO.getTipo());
        existente.setOrixen(grupoDTO.getOrixen());
        Grupo actualizado = grupoRepository.save(existente);
        return new GrupoDTO(actualizado.getGrupo_id(), actualizado.getNome(), actualizado.getTipo(), actualizado.getOrixen());
    }
}
