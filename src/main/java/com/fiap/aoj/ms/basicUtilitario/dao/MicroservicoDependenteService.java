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
import com.fiap.aoj.ms.basicUtilitario.entity.MicroservicoDependente;
import com.fiap.aoj.ms.basicUtilitario.entity.Sistema;
import com.fiap.aoj.ms.basicUtilitario.vo.MicroservicoVO;
import com.fiap.aoj.ms.basicUtilitario.vo.SistemaVO;



@Service
public class MicroservicoDependenteService implements IMicroservicoDependenteService {

	private final MicroservicoDependenteRepository microservicoDependenteRepository;

	MicroservicoDependenteService(MicroservicoDependenteRepository microservicoDependenteRepository) {
	    this.microservicoDependenteRepository = microservicoDependenteRepository;
	 }	  
	  
    
	Logger logger = LoggerFactory.getLogger(MicroservicoDependenteService.class);		
	
	private final String URL_SISTEMA = "http://localhost:8090/get/";
	private final String URL_MICROSERVICO = "http://localhost:8095/get/";
    
	@Override
	public MicroservicoDependente create(MicroservicoDependente sistema) {
		return microservicoDependenteRepository.save(sistema);
	}

	@Override
	public MicroservicoDependente get(Long id) {
		return microservicoDependenteRepository.findById(id).get();
	}

	@Override
	public MicroservicoDependente edit(MicroservicoDependente sistema) {
		return microservicoDependenteRepository.save(sistema);
	}

	@Override
	public void delete(MicroservicoDependente sistema) {
		microservicoDependenteRepository.delete(sistema);
	}
	
	
    @Override
	public long count() {
		return microservicoDependenteRepository.count();
	}
	
	
	@Override
	public List getAll() {
		Iterable<MicroservicoDependente> sistema = microservicoDependenteRepository.findAll();
		return (List) sistema;
	}

	@Override
	public void deleteById(Long id) {
		MicroservicoDependente sistema = microservicoDependenteRepository.findById(id).get();
		microservicoDependenteRepository.delete(sistema);		
	}
    
	@Override
	public List<MicroservicoDependente> findByIdMicroservico(Long id){
		List<MicroservicoDependente> microservicoDependentes = microservicoDependenteRepository.findByIdMicroservico(id);
		return microservicoDependentes;
	}
	
	
	public MicroservicoVO findMicroservicoVO(Long id) {
		
		MicroservicoVO microservicoVO = new MicroservicoVO();
		
		logger.info("Chamando MICROSERVICO");
		RestTemplate restTemplate = new RestTemplate();

		Microservico microservico = restTemplate.getForObject(URL_MICROSERVICO + id, Microservico.class);

		microservicoVO.setId(microservico.getId());
		microservicoVO.setNome(microservico.getNome());
		microservicoVO.setBanco(microservico.getBanco());
		microservicoVO.setContainer(microservico.getContainer());
		microservicoVO.setEndPoint(microservico.getEndPoint());
		microservicoVO.setVersao(microservico.getVersao());
		microservicoVO.setAtivo(microservico.getAtivo());
		
		List<MicroservicoDependente> microservicoDependentes = microservicoDependenteRepository.findByIdMicroservico(id);
		
		logger.info("Chamando servico MICROSISTEMA");
        List<Microservico> microservicos = new ArrayList<Microservico>();

		for (int i = 0; i < microservicoDependentes.size(); i++){
            try {
	        	Microservico microservicoDep = restTemplate.getForObject(URL_MICROSERVICO + microservicoDependentes.get(i).getIdDependente(), Microservico.class);
	            microservicos.add(microservicoDep);
            } catch (Exception e) {
            	logger.info("Nao foi possivel encontrar microservico " +  microservicoDependentes.get(i).getIdMicroservico() );
            	e.printStackTrace();
            }
        };		
		
        microservicoVO.setMicroservicos(microservicos);
		
		return microservicoVO;
	}

}
