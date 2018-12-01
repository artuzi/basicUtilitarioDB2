package com.fiap.aoj.ms.basicSistema.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fiap.aoj.ms.basicSistema.entity.Sistema;

public interface ISistemaService {

    Sistema create(Sistema sistema);
    Sistema get(Long id);
    Sistema edit(Sistema sistema);
    void delete(Sistema sistema);
    void deleteById(Long id);
    List getAll();
    long count();
    
}
