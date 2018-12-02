package com.fiap.aoj.ms.basicUtilitario.dao;

import java.util.List;

import com.fiap.aoj.ms.basicUtilitario.entity.SistemaMicroservico;
import com.fiap.aoj.ms.basicUtilitario.vo.SistemaVO;

public interface ISistemaMicroservicoService {

    SistemaMicroservico create(SistemaMicroservico sistemaMicroservico);
    SistemaMicroservico get(Long id);
    SistemaMicroservico edit(SistemaMicroservico sistemaMicroservico);
    void delete(SistemaMicroservico sistemaMicroservico);
    void deleteById(Long id);
    List getAll();
    long count();
	List<SistemaMicroservico> findByIdSistema(Long id);
	SistemaVO findSistemaVO(Long id);

}
