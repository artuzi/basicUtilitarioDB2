package com.fiap.aoj.ms.basicSistema.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="sistema")
public class Sistema implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "sq_sistema")
    @SequenceGenerator(name = "sq_sistema", sequenceName = "SQ_SISTEMA", allocationSize = 1)
 	Long id;
	
    @Column(name = "nome")
	String nome;

    @Column(name = "host")
    String host;

    @Column(name = "versao")
    String versao;

    @Column(name = "ativo")
    String ativo;
	
	public Long getId() {
		return id;
	}
	public void set(Long id) {
		this.id = id;
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
}
