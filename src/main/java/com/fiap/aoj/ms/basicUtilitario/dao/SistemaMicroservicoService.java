package com.fiap.aoj.ms.basicUtilitario.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fiap.aoj.ms.basicUtilitario.entity.Microservico;
import com.fiap.aoj.ms.basicUtilitario.entity.Sistema;
import com.fiap.aoj.ms.basicUtilitario.entity.SistemaMicroservico;
import com.fiap.aoj.ms.basicUtilitario.vo.SistemaVO;

//estava public abstract class

@Service
public class SistemaMicroservicoService implements ISistemaMicroservicoService {

    //@Autowired
    //private SistemaMicroservicoRepository sistemaMicroservicoRepository;
	
	private final SistemaMicroservicoRepository sistemaMicroservicoRepository;

	SistemaMicroservicoService(SistemaMicroservicoRepository sistemaMicroservicoRepository) {
	    this.sistemaMicroservicoRepository = sistemaMicroservicoRepository;
	 }	  
	  
    
	Logger logger = LoggerFactory.getLogger(SistemaMicroservicoService.class);		
	
	private final String URL_SISTEMA = "http://localhost:8090/get/";
	private final String URL_MICROSERVICO = "http://localhost:8095/get/";
    
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
    
	@Override
	public List<SistemaMicroservico> findByIdSistema(Long id){
		List<SistemaMicroservico> sistemaMicroservico = sistemaMicroservicoRepository.findByIdSistema(id);
		return sistemaMicroservico;
	}
	
	@Override
	public SistemaVO findSistemaVO(Long id) {
		
		logger.info("Chamando servico SISTEMA para id " + id);

		RestTemplate restTemplate = new RestTemplate();
        Sistema sistema = restTemplate.getForObject(URL_SISTEMA + id, Sistema.class);
        
		SistemaVO sistemaVO = new SistemaVO();
        sistemaVO.setIdSistema(sistema.getId());
        sistemaVO.setNome(sistema.getNome());
        sistemaVO.setHost(sistema.getHost());
        sistemaVO.setVersao(sistema.getVersao());
        sistemaVO.setAtivo(sistema.getAtivo());
 
        List<Microservico> microservicos = new ArrayList<Microservico>();
        
		logger.info("Obtendo servicos do sistema");

        List<SistemaMicroservico> SistemaMicroservicos = sistemaMicroservicoRepository.findByIdSistema(id);

        
		logger.info("Chamando servico MICROSISTEMA");
        for (int i = 0; i < SistemaMicroservicos.size(); i++){
            try {
	        	Microservico microservico = restTemplate.getForObject(URL_MICROSERVICO + SistemaMicroservicos.get(i).getIdMicroservico(), Microservico.class);
	            microservicos.add(microservico);
            } catch (Exception e) {
            	logger.info("Nao foi possivel encontrar microservico " +  SistemaMicroservicos.get(i).getIdMicroservico() );
            }
        };
        		
        sistemaVO.setMicroservicos(microservicos);
        
		return sistemaVO;
	}
}
