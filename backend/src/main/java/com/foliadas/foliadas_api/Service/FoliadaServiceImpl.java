package com.foliadas.foliadas_api.Service;

import com.foliadas.foliadas_api.DTO.FoliadaDTO;
import com.foliadas.foliadas_api.DTO.GrupoDTO;
import com.foliadas.foliadas_api.DTO.ProvinciaDTO;
import com.foliadas.foliadas_api.Model.Foliada;
import com.foliadas.foliadas_api.Model.Grupo;
import com.foliadas.foliadas_api.Model.Provincia;
import com.foliadas.foliadas_api.Repository.FoliadaRepository;
import com.foliadas.foliadas_api.Repository.GrupoRepository;
import com.foliadas.foliadas_api.Repository.ProvinciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FoliadaServiceImpl implements FoliadaService{

    @Autowired
    private final FoliadaRepository foliadaRepository;
     @Autowired
     private final ProvinciaRepository provinciaRepository;
     @Autowired
     private final GrupoRepository grupoRepository;

    public FoliadaServiceImpl(FoliadaRepository foliadaRepository, ProvinciaRepository provinciaRepository, GrupoRepository grupoRepository) {
        this.foliadaRepository = foliadaRepository;
        this.provinciaRepository = provinciaRepository;
        this.grupoRepository = grupoRepository;
    }

    @Override
    public List<FoliadaDTO> getAll() {
        return foliadaRepository.findAll().stream()
                .map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public FoliadaDTO getById(int id) {
        Foliada f= foliadaRepository.findById(id).orElseThrow(()-> new RuntimeException("Foliada no encontrada"));
        return toDTO(f);
    }

    @Override
    public FoliadaDTO create(FoliadaDTO foliadaDTO) {
        Foliada f= new Foliada();
        f.setNome(foliadaDTO.getNombre());
        f.setFecha(foliadaDTO.getFecha());
        f.setHora(foliadaDTO.getHora());
        f.setLugar(foliadaDTO.getLugar());
        f.setDescripcion(foliadaDTO.getDescripcion());
        f.setLatitude(foliadaDTO.getLatitude());
        f.setLonxitude(foliadaDTO.getLonxitude());
        f.setImaxe(foliadaDTO.getImaxe());

        Provincia p= provinciaRepository.findById(foliadaDTO.getProvincia().getId())
                .orElseThrow(()-> new RuntimeException("Provincia no encontrada"));
        f.setProvincia(p);

        Set<Grupo> grupos= foliadaDTO.getGrupos().stream().map(grupoDTO -> grupoRepository.findById(grupoDTO.getId())
                .orElseThrow(()-> new RuntimeException("Grupo no encontrado"))).collect(Collectors.toSet());
        f.setGrupos(grupos);

        Foliada saved= foliadaRepository.save(f);
        return toDTO(saved);
    }

    @Override
    public void delete(int id) {
        foliadaRepository.deleteById(id);
    }

    @Override
    public Foliada update(int id, Foliada foliada) {
        Foliada existente= foliadaRepository.findById(id).orElse(null);

        if (existente==null){
            return null;
        }
        existente.setNome(foliada.getNome());
        existente.setFecha(foliada.getFecha());
        existente.setHora(foliada.getHora());
        existente.setLugar(foliada.getLugar());
        existente.setDescripcion(foliada.getDescripcion());
        existente.setLatitude(foliada.getLatitude());
        existente.setLonxitude(foliada.getLonxitude());
        existente.setImaxe(foliada.getImaxe());

        if (foliada.getProvincia() != null){
            int provinciaId= foliada.getProvincia().getId();
            Provincia provincia= provinciaRepository.findById(provinciaId).orElse(null);
            existente.setProvincia(provincia);
        }

        if (foliada.getGrupos() != null){
            Set<Grupo> gruposActualizados = new HashSet<>();

            for (Grupo g: foliada.getGrupos()){
                Grupo grupo= grupoRepository.findById(g.getGrupo_id()).orElse(null);
                if (grupo!=null){
                    gruposActualizados.add(grupo);
                }
            }
            existente.setGrupos(gruposActualizados);
        }
        return foliadaRepository.save(existente);

    }

    @Override
    public List<FoliadaDTO> getByProvincia(int provinciaId) {
        return foliadaRepository.findByProvincia_Id(provinciaId)
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<FoliadaDTO> getByNome(String nome) {
        return foliadaRepository.findByNomeContainingIgnoreCase(nome)
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    private FoliadaDTO toDTO(Foliada f){
        FoliadaDTO dto= new FoliadaDTO();
        dto.setId(f.getId());
        dto.setNombre(f.getNome());
        dto.setFecha(f.getFecha());
        dto.setHora(f.getHora());
        dto.setLugar(f.getLugar());
        dto.setDescripcion(f.getDescripcion());
        dto.setLatitude(f.getLatitude());
        dto.setLonxitude(f.getLonxitude());
        dto.setImaxe(f.getImaxe());
        dto.setProvincia(new ProvinciaDTO(f.getProvincia().getId(), f.getProvincia().getNombre()));
        dto.setGrupos(f.getGrupos().stream()
                .map(grupo -> new GrupoDTO(grupo.getGrupo_id(), grupo.getNome(), grupo.getTipo(), grupo.getOrixen()))
                .collect(Collectors.toSet()));

        return dto;
    }


}
