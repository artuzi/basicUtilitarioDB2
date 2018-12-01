package com.fiap.aoj.ms.basicUtilitario.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.aoj.ms.basicUtilitario.entity.SistemaMicroservico;

@Service
public class SistemaMicroservicoService implements ISistemaMicroservicoService {

    @Autowired
    private SistemaMicroservicoRepository sistemaMicroservicoRepository;


    
	@Override
	public SistemaMicroservico create(SistemaMicroservico sistema) {
		return sistemaMicroservicoRepository.save(sistema);
	}

	@Override
	public SistemaMicroservico get(Long id) {
		return sistemaMicroservicoRepository.findById(id).get();
	}

	@Override
	public SistemaMicroservico edit(SistemaMicroservico sistema) {
		return sistemaMicroservicoRepository.save(sistema);
	}

	@Override
	public void delete(SistemaMicroservico sistema) {
		sistemaMicroservicoRepository.delete(sistema);
	}
	
	
    @Override
	public long count() {
		return sistemaMicroservicoRepository.count();
	}
	
	
	@Override
	public List getAll() {

		Iterable<SistemaMicroservico> sistema = sistemaMicroservicoRepository.findAll();
		
		return (List) sistema;
		
	}

	@Override
	public void deleteById(Long id) {
		SistemaMicroservico sistema = sistemaMicroservicoRepository.findById(id).get();
		sistemaMicroservicoRepository.delete(sistema);		
	}
    
 
}
