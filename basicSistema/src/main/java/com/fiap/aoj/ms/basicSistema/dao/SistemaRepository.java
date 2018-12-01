package com.fiap.aoj.ms.basicSistema.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fiap.aoj.ms.basicSistema.entity.Sistema;


@Repository
public interface SistemaRepository extends CrudRepository<Sistema, Long> { 
    
}
