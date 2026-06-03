package com.foliadas.foliadas_api.Repository;

import com.foliadas.foliadas_api.Model.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Integer> {
    List<Grupo> findByNomeContainingIgnoreCase(String nome);
}