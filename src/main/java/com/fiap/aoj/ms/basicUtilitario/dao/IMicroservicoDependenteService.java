package com.fiap.aoj.ms.basicUtilitario.dao;

import java.util.List;

import com.fiap.aoj.ms.basicUtilitario.entity.MicroservicoDependente;
import com.fiap.aoj.ms.basicUtilitario.vo.MicroservicoVO;

public interface IMicroservicoDependenteService {

    MicroservicoDependente create(MicroservicoDependente microservicoDependente);
    MicroservicoDependente get(Long id);
    MicroservicoDependente edit(MicroservicoDependente microservicoDependente);
    void delete(MicroservicoDependente microservicoDependente);
    void deleteById(Long id);
    List getAll();
    long count();
	List<MicroservicoDependente> findByIdMicroservico(Long id);
	MicroservicoVO findMicroservicoVO(Long id);

}
