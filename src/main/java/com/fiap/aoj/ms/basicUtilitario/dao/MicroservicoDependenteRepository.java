package com.fiap.aoj.ms.basicUtilitario.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fiap.aoj.ms.basicUtilitario.entity.MicroservicoDependente;
import com.fiap.aoj.ms.basicUtilitario.entity.SistemaMicroservico;


@Repository
public interface MicroservicoDependenteRepository extends CrudRepository<MicroservicoDependente, Long> { 

	List<MicroservicoDependente> findByIdMicroservico(Long id);
	
}
