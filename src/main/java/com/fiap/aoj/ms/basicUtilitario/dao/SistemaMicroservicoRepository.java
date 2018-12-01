package com.fiap.aoj.ms.basicUtilitario.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fiap.aoj.ms.basicUtilitario.entity.SistemaMicroservico;


@Repository
public interface SistemaMicroservicoRepository extends CrudRepository<SistemaMicroservico, Long> { 
    
}
