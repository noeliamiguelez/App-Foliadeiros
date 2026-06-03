package com.foliadas.foliadas_api.Controller;

import com.foliadas.foliadas_api.DTO.UsuarioDTO;
import com.foliadas.foliadas_api.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuarios")
public class UsuarioViewController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/nuevo")
    public String nuevoUsuario(Model model){
        model.addAttribute("usuario", new UsuarioDTO());
        return "usuario-form.html";
    }

    @PostMapping("/guardar")
    public String guardarUsuario(@ModelAttribute UsuarioDTO usuarioDTO){
        usuarioService.create(usuarioDTO);
        return "redirect:/usuarios/lista";
    }

    @GetMapping("/lista")
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioService.getAll());
        return "usuario-lista.html";
    }

    // 🔹 Mostrar formulario de editar
    @GetMapping("/editar/{id}")
    public String editarUsuario(@PathVariable int id, Model model) {
        UsuarioDTO usuario = usuarioService.getById(id);
        model.addAttribute("usuario", usuario);
        return "usuario-form.html";
    }

}
