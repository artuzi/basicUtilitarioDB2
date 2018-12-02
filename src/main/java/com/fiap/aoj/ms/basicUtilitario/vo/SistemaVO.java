package com.fiap.aoj.ms.basicUtilitario.vo;

import java.util.List;

import com.fiap.aoj.ms.basicUtilitario.entity.Microservico;
import com.fiap.aoj.ms.basicUtilitario.entity.Sistema;

public class SistemaVO extends Sistema {

	private static final long serialVersionUID = 1L;	
	

    List<Microservico> microservicos;

    
	public List<Microservico> getMicroservicos() {
		return microservicos;
	}
	public void setMicroservicos(List<Microservico> microservicos) {
		this.microservicos = microservicos;
	}
    
}
