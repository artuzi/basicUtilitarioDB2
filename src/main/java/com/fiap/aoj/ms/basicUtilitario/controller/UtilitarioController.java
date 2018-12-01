package com.fiap.aoj.ms.basicUtilitario.controller;

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

import com.fiap.aoj.ms.basicUtilitario.dao.ISistemaMicroservicoService;
import com.fiap.aoj.ms.basicUtilitario.entity.SistemaMicroservico;

@RestController
public class UtilitarioController {

	Logger logger = LoggerFactory.getLogger(UtilitarioController.class);	

	@Autowired
	private ISistemaMicroservicoService sistemaMicroservicoService;	
	
	/*
	 * @RequestMapping("/sistemaMicroservico")
	 * 
	 */
	
	
	@RequestMapping(method = RequestMethod.POST, value="/insert")
	public ResponseEntity<SistemaMicroservico> insertSistema(@RequestBody SistemaMicroservico sistemaMicroservico) {
		
		sistemaMicroservicoService.create(sistemaMicroservico);
		logger.info("Insert processado " + sistemaMicroservico.getIdSistema() + " " + sistemaMicroservico.getIdMicroservico());
		
		return new ResponseEntity<>(sistemaMicroservico,HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/update/{id}")
	public ResponseEntity<Void> updateSistema(@PathVariable Long id,@RequestBody SistemaMicroservico sistemaMicroservico) {
		
		SistemaMicroservico oldSistema = sistemaMicroservicoService.get(id);
		oldSistema.setIdSistema(sistemaMicroservico.getIdSistema());
		oldSistema.setIdMicroservico(sistemaMicroservico.getIdMicroservico());
		sistemaMicroservicoService.edit(oldSistema);
		
		logger.info("Update processado " + sistemaMicroservico.getIdSistema() + " " + sistemaMicroservico.getIdMicroservico());
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	
	@GetMapping("/get/{id}")
	public ResponseEntity<SistemaMicroservico> getSistema(@PathVariable Long id) {
		
		SistemaMicroservico sistemaMicroservico = null;
		
		try {
			sistemaMicroservico = sistemaMicroservicoService.get(id);
			logger.info("get processado " + sistemaMicroservico.getIdSistema() + " " + sistemaMicroservico.getIdMicroservico());
		} catch (Exception e) {
			logger.error("Nao encontrado " + id);
			return new ResponseEntity<>(sistemaMicroservico,HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(sistemaMicroservico,HttpStatus.OK);
	}
	
	@GetMapping("/delete/{id}")
	public ResponseEntity<Void> deleteSistema(@PathVariable Long id) {
		
		sistemaMicroservicoService.deleteById(id);

		logger.info("delete processado " + id);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public List<SistemaMicroservico> getAll() {
		logger.info("retornando todos os sistemas_x_microservicos");
		return sistemaMicroservicoService.getAll();
	}
}
