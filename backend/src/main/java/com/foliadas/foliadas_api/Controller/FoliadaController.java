package com.foliadas.foliadas_api.Controller;

import com.foliadas.foliadas_api.DTO.FoliadaDTO;
import com.foliadas.foliadas_api.FoliadasApiApplication;
import com.foliadas.foliadas_api.Model.Foliada;
import com.foliadas.foliadas_api.Service.FoliadaService;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("api/foliadas")
public class FoliadaController {

        private final FoliadaService foliadaService;

        public FoliadaController(FoliadaService foliadaService) {
            this.foliadaService = foliadaService;
        }

        // 🔹 GET todas las foliadas
        @GetMapping
        public ResponseEntity<List<FoliadaDTO>> getAll() {
            return ResponseEntity.ok(foliadaService.getAll());
        }

        // 🔹 GET foliada por ID
        @GetMapping("/{id}")
        public ResponseEntity<FoliadaDTO> getById(@PathVariable int id) {
            return ResponseEntity.ok(foliadaService.getById(id));
        }

        // 🔹 POST crear nueva foliada
        @PostMapping
        public ResponseEntity<FoliadaDTO> create(@RequestBody FoliadaDTO foliadaDTO) {
            return ResponseEntity.ok(foliadaService.create(foliadaDTO));
        }

        // 🔹 DELETE eliminar foliada
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> delete(@PathVariable int id) {
            foliadaService.delete(id);
            return ResponseEntity.noContent().build();
        }

        @PutMapping("/{id}")
         public Foliada update(@PathVariable int id, @RequestBody Foliada foliada){
            return foliadaService.update(id, foliada);
        }

        @GetMapping("/provincia/{provinciaId}")
        public List<FoliadaDTO> getByProvincia(@PathVariable int provinciaId){
            return foliadaService.getByProvincia(provinciaId);
        }

        @GetMapping("/buscar/{nome}")
        public List<FoliadaDTO> getByNome(@PathVariable String nome){
            return foliadaService.getByNome(nome);
        }
}