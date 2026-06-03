package com.foliadas.foliadas_api.Controller;

import com.foliadas.foliadas_api.DTO.FoliadaDTO;
import com.foliadas.foliadas_api.DTO.GrupoDTO;
import com.foliadas.foliadas_api.DTO.ProvinciaDTO;
import com.foliadas.foliadas_api.Service.FoliadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("foliadas")
public class FoliadaViewController {

    @Autowired
    private FoliadaService foliadaService;

    @GetMapping("/nuevo")
    public String nuevaFoliada(Model model){
        FoliadaDTO dto= new FoliadaDTO();
        dto.setProvincia(new ProvinciaDTO());
        model.addAttribute("foliada", dto);
        return "foliadas-form.html";
    }

    @PostMapping("/guardar")
    public String guardarFoliada(@ModelAttribute FoliadaDTO foliadaDTO, @RequestParam("imagen")MultipartFile file){
        if (!file.isEmpty()) {
            try {
                String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/images/";

                Path uploadPath = Paths.get(uploadDir);
                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }

                String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();

                Path filePath = uploadPath.resolve(fileName);
                Files.write(filePath, file.getBytes());

                foliadaDTO.setImaxe("/images/" + fileName);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        foliadaService.create(foliadaDTO);
        return "redirect:/foliadas/lista";
    }

    @GetMapping("/lista")
    public String listarFoliadas(Model model){
        model.addAttribute("foliadas", foliadaService.getAll());
        return "foliadas-lista.html";
    }

    @GetMapping("/editar/{id}")
    public String editarFoliada(@PathVariable int id, Model model){
        FoliadaDTO foliada= foliadaService.getById(id);
        model.addAttribute("foliada", foliada);
        return "foliadas-form.html";
    }
}
