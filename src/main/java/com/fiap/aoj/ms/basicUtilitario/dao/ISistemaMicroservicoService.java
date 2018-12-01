package com.fiap.aoj.ms.basicUtilitario.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fiap.aoj.ms.basicUtilitario.entity.SistemaMicroservico;

public interface ISistemaMicroservicoService {

    SistemaMicroservico create(SistemaMicroservico sistemaMicroservico);
    SistemaMicroservico get(Long id);
    SistemaMicroservico edit(SistemaMicroservico sistemaMicroservico);
    void delete(SistemaMicroservico sistemaMicroservico);
    void deleteById(Long id);
    List getAll();
    long count();
    
}
