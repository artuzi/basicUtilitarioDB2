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


public class Microservico implements Serializable {
   
	private static final long serialVersionUID = 1L;
	
	Long id;	
	String nome;
	
    @JsonProperty("endpoint")
    String endPoint;
    
	String container;
	String versao;
	String banco;
	String ativo;
	
	
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getEndPoint() {
		return endPoint;
	}
	public String getContainer() {
		return container;
	}
	public String getVersao() {
		return versao;
	}
	public String getBanco() {
		return banco;
	}
	public String getAtivo() {
		return ativo;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}
	public void setContainer(String container) {
		this.container = container;
	}
	public void setVersao(String versao) {
		this.versao = versao;
	}
	public void setBanco(String banco) {
		this.banco = banco;
	}
	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}
	
	
}
