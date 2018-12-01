package com.fiap.aoj.ms.basicSistema.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.aoj.ms.basicSistema.dao.ISistemaService;
import com.fiap.aoj.ms.basicSistema.entity.Sistema;

@RestController
public class SistemaController {

	Logger logger = LoggerFactory.getLogger(SistemaController.class);	

	@Autowired
	private ISistemaService sistemaService;	
	
	/*
	 * @RequestMapping("/sistema")
	 * 
	 */
	
	
	@RequestMapping(method = RequestMethod.POST, value="/insert")
	public ResponseEntity<Sistema> insertSistema(@RequestBody Sistema sistema) {
		
		sistemaService.create(sistema);
		logger.info("Insert processado " + sistema.getNome());
		
		return new ResponseEntity<>(sistema,HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/update/{id}")
	public ResponseEntity<Void> updateSistema(@PathVariable Long id,@RequestBody Sistema sistema) {
		
		Sistema oldSistema = sistemaService.get(id);
		oldSistema.setNome(sistema.getNome() );
		oldSistema.setHost(sistema.getHost() );
		oldSistema.setVersao(sistema.getVersao());
		oldSistema.setAtivo(sistema.getAtivo());
		sistemaService.edit(oldSistema);
		
		logger.info("Update processado " + sistema.getNome());
		//MUDOU
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	
	@GetMapping("/get/{id}")
	public ResponseEntity<Sistema> getSistema(@PathVariable Long id) {
		
		Sistema sistema = null;
		
		try {
			sistema = sistemaService.get(id);
			logger.info("get processado " + sistema.getNome());
		} catch (Exception e) {
			logger.error("Nao encontrato " + id);
			return new ResponseEntity<>(sistema,HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(sistema,HttpStatus.OK);
	}
	
	@GetMapping("/delete/{id}")
	public ResponseEntity<Void> deleteSistema(@PathVariable Long id) {
		
		sistemaService.deleteById(id);
		logger.info("delete processado " + id);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public List<Sistema> getAll() {
		logger.info("retornando todos os sistemas");
		return sistemaService.getAll();
	}
}
