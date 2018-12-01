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
@Table(name="sistema_microservico")
public class SistemaMicroservico implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "sq_sistema_micro")
    @SequenceGenerator(name = "sq_sistema_micro", sequenceName = "SQ_SISTEMA_MICRO", allocationSize = 1)
 	Long id;

    @JsonProperty("idsistema")
    @Column(name = "idSistema")
	Long idSistema;

    @JsonProperty("idmicroservico")
    @Column(name = "idMicroservico")
    Long idMicroservico;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdSistema() {
		return idSistema;
	}

	public void setIdSistema(Long idSistema) {
		this.idSistema = idSistema;
	}

	public Long getIdMicroservico() {
		return idMicroservico;
	}

	public void setIdMicroservico(Long idMicroservico) {
		this.idMicroservico = idMicroservico;
	}

	
}
