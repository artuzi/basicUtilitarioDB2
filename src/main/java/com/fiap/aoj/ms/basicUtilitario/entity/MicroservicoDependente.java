package com.fiap.aoj.ms.basicUtilitario.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name="microservico_dependente")
public class MicroservicoDependente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "sq_micro_dependente")
    @SequenceGenerator(name = "sq_micro_dependente", sequenceName = "SQ_MICRO_DEPENDENTE", allocationSize = 1)
 	Long id;

    @JsonProperty("idmicroservico")
    @Column(name = "idMicroservico")
	Long idMicroservico;

    @JsonProperty("iddependente")
    @Column(name = "idDependente")
    Long idDependente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdMicroservico() {
		return idMicroservico;
	}

	public void setIdMicroservico(Long idMicroservico) {
		this.idMicroservico = idMicroservico;
	}

	public Long getIdDependente() {
		return idDependente;
	}

	public void setIdDependente(Long idDependente) {
		this.idDependente = idDependente;
	}

	
}
