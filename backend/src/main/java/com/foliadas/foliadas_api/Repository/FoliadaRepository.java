package com.foliadas.foliadas_api.Repository;

import com.foliadas.foliadas_api.Model.Foliada;
import com.foliadas.foliadas_api.Model.Provincia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FoliadaRepository extends JpaRepository<Foliada, Integer> {
    List<Foliada> findByProvincia_Id(int  provinciaId);
    List<Foliada> findByNomeContainingIgnoreCase(String nome);
}
