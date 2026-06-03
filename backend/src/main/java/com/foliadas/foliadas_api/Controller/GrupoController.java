package com.foliadas.foliadas_api.Controller;

import com.foliadas.foliadas_api.DTO.GrupoDTO;
import com.foliadas.foliadas_api.Model.Grupo;
import com.foliadas.foliadas_api.Repository.GrupoRepository;
import com.foliadas.foliadas_api.Service.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/grupos")
public class GrupoController {

    @Autowired
    private final GrupoService grupoService;

    public GrupoController(GrupoService grupoService) {
        this.grupoService = grupoService;
    }

    @GetMapping
    public ResponseEntity<List<GrupoDTO>> getAll() {
        return ResponseEntity.ok(grupoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GrupoDTO> getById(@PathVariable int id) {
        return ResponseEntity.ok(grupoService.getById(id));
    }

    @PostMapping
    public ResponseEntity<GrupoDTO> create(@RequestBody GrupoDTO grupoDTO) {
        return ResponseEntity.ok(grupoService.create(grupoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        grupoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public GrupoDTO update(@PathVariable int id, @RequestBody GrupoDTO grupoDTO){
        return grupoService.update(id, grupoDTO);
        }

}