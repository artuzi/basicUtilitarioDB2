package com.fiap.aoj.ms.basicSistema.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.aoj.ms.basicSistema.entity.Sistema;

@Service
public class SistemaService implements ISistemaService {

    @Autowired
    private SistemaRepository sistemaRepository;


    
	@Override
	public Sistema create(Sistema sistema) {
		return sistemaRepository.save(sistema);
	}

	@Override
	public Sistema get(Long id) {
		return sistemaRepository.findById(id).get();
	}

	@Override
	public Sistema edit(Sistema sistema) {
		return sistemaRepository.save(sistema);
	}

	@Override
	public void delete(Sistema sistema) {
		sistemaRepository.delete(sistema);
	}
	
	
    @Override
	public long count() {
		return sistemaRepository.count();
	}
	
	
	@Override
	public List getAll() {

		Iterable<Sistema> sistema = sistemaRepository.findAll();
		
		return (List) sistema;
		
	}

	@Override
	public void deleteById(Long id) {
		Sistema sistema = sistemaRepository.findById(id).get();
		sistemaRepository.delete(sistema);		
	}
    
 
}
