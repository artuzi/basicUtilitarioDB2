package com.fiap.aoj.ms.basicUtilitario.vo;

import java.util.List;

import com.fiap.aoj.ms.basicUtilitario.entity.Microservico;

public class SistemaVO {

	Long idSistema;
	String nome;
    String host;
    String versao;
    String ativo;
    List<Microservico> microservicos;
    
 	public Long getIdSistema() {
		return idSistema;
	}
	public void setIdSistema(Long idSistema) {
		this.idSistema = idSistema;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getVersao() {
		return versao;
	}
	public void setVersao(String versao) {
		this.versao = versao;
	}
	public String getAtivo() {
		return ativo;
	}
	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}
	public List<Microservico> getMicroservicos() {
		return microservicos;
	}
	public void setMicroservicos(List<Microservico> microservicos) {
		this.microservicos = microservicos;
	}
    
}
