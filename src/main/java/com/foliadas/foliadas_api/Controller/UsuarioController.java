package com.foliadas.foliadas_api.Controller;

import com.foliadas.foliadas_api.DTO.FoliadaDTO;
import com.foliadas.foliadas_api.DTO.LoginDTO;
import com.foliadas.foliadas_api.DTO.UsuarioDTO;
import com.foliadas.foliadas_api.Model.Foliada;
import com.foliadas.foliadas_api.Model.Usuario;
import com.foliadas.foliadas_api.Repository.UsuarioRepository;
import com.foliadas.foliadas_api.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("api/usuarios")
public class UsuarioController {

    @Autowired
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> getAll(){
        return ResponseEntity.ok(usuarioService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> getById(@PathVariable int id){
        return ResponseEntity.ok(usuarioService.getById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<UsuarioDTO> create(@RequestBody UsuarioDTO usuarioDTO) {
        try {
            UsuarioDTO usuario = usuarioService.create(usuarioDTO);
            return ResponseEntity.ok(usuario);

        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public Usuario update (@PathVariable int id, @RequestBody Usuario usuario){
        return usuarioService.update(id, usuario);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO){
        Usuario usuario= usuarioService.login(loginDTO.getEmail(), loginDTO.getPassword());
        if (usuario==null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email o contraseña incorrectos");
        }
        return ResponseEntity.ok(usuario);
    }

    /*------------------------------------------
                      FAVORITAS
     ------------------------------------------*/

    @GetMapping("/{id}/favoritas")
    public Set<FoliadaDTO> getFavoritas(@PathVariable int id){
        return usuarioService.getFavoritas(id);
    }

    @PostMapping("/{id}/favoritas/{foliadaId}")
    public void addFavorita(@PathVariable int id, @PathVariable int foliadaId){
        usuarioService.addFavorita(id, foliadaId);
    }

    @DeleteMapping("/{id}/favoritas/{foliadaId}")
    public void removeFavorita(@PathVariable int id, @PathVariable int foliadaId){
        usuarioService.removeFavorita(id, foliadaId);
    }

}