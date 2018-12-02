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

import com.fiap.aoj.ms.basicUtilitario.dao.IMicroservicoDependenteService;
import com.fiap.aoj.ms.basicUtilitario.dao.ISistemaMicroservicoService;
import com.fiap.aoj.ms.basicUtilitario.entity.MicroservicoDependente;
import com.fiap.aoj.ms.basicUtilitario.vo.MicroservicoVO;
import com.fiap.aoj.ms.basicUtilitario.vo.SistemaVO;

@RestController
@RequestMapping("/microservico")
public class MicroservicoUtilController {

	Logger logger = LoggerFactory.getLogger(MicroservicoUtilController.class);	

	
	@Autowired
	private IMicroservicoDependenteService microservicoDependenteService;	
	
	
	@RequestMapping(method = RequestMethod.POST, value="/insert")
	public ResponseEntity<MicroservicoDependente> insertSistema(@RequestBody MicroservicoDependente microservicoDependente) {
		
		microservicoDependenteService.create(microservicoDependente);
		logger.info("Insert processado " + microservicoDependente.getIdMicroservico() + " " + microservicoDependente.getIdDependente());
		
		return new ResponseEntity<>(microservicoDependente,HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/update/{id}")
	public ResponseEntity<Void> updateSistema(@PathVariable Long id,@RequestBody MicroservicoDependente microservicoDependente) {
		
		MicroservicoDependente oldSistema = microservicoDependenteService.get(id);
		oldSistema.setIdMicroservico(microservicoDependente.getIdMicroservico());
		oldSistema.setIdDependente(microservicoDependente.getIdDependente());
		microservicoDependenteService.edit(oldSistema);
		
		logger.info("Update processado " + microservicoDependente.getIdMicroservico() + " " + microservicoDependente.getIdDependente());
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	
	@GetMapping("/get/{id}")
	public ResponseEntity<MicroservicoDependente> getSistema(@PathVariable Long id) {
		
		MicroservicoDependente microservicoDependente = null;
		
		try {
			microservicoDependente = microservicoDependenteService.get(id);
			logger.info("get processado " + microservicoDependente.getIdMicroservico() + " " + microservicoDependente.getIdDependente());
		} catch (Exception e) {
			logger.error("Nao encontrado " + id);
			return new ResponseEntity<>(microservicoDependente,HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(microservicoDependente,HttpStatus.OK);
	}
	
	@GetMapping("/delete/{id}")
	public ResponseEntity<Void> deleteSistema(@PathVariable Long id) {
		
		microservicoDependenteService.deleteById(id);

		logger.info("delete processado " + id);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public List<MicroservicoDependente> getAll() {
		logger.info("retornando todos os microservicos_x_dependentes");
		return microservicoDependenteService.getAll();
	}
	
	
	@GetMapping("/getMicroservicosByMicroservico/{id}")
	public ResponseEntity<MicroservicoVO> getMicroservicosByMicroMicroservico(@PathVariable Long id) {
		
		MicroservicoVO microservicoVO = new MicroservicoVO();
		
		try {
			microservicoVO = microservicoDependenteService.findMicroservicoVO(id);
			
			logger.info("getMicroservicosByMicroservico processado " +  microservicoVO.getId() + " " + microservicoVO.getNome());
			
		} catch (Exception e) {
			logger.error("Nao encontrado " + id);
			e.printStackTrace();
			return new ResponseEntity<>(microservicoVO,HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(microservicoVO,HttpStatus.OK);
	}	
	
	
}
