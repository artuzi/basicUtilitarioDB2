package com.fiap.aoj.ms.basicUtilitario.dao;

import java.util.List;

import org.jboss.logging.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fiap.aoj.ms.basicUtilitario.entity.SistemaMicroservico;


@Repository
public interface SistemaMicroservicoRepository extends CrudRepository<SistemaMicroservico, Long> { 

	//public static final String QUERY_MICROSERVICOS_POR_SISTEMA = "SELECT s FROM sistema_microservico s WHERE s.id_sistema = ?1";

	//@Query(value = QUERY_MICROSERVICOS_POR_SISTEMA)
	List<SistemaMicroservico> findByIdSistema(Long id);

	
}
