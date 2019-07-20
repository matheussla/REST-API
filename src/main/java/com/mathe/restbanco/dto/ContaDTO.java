package com.mathe.restbanco.dto;

import java.io.Serializable;

import com.mathe.restbanco.domain.Conta;

public class ContaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String numero;
	private String agencia;
	private String cpf;
	private Boolean status;
	private Long dataCriacao;
	private Long dataAtualizacao;
	
	public ContaDTO() {
	}

	public ContaDTO(Conta obj) {
		id = obj.getId();
		numero = obj.getNumero();
		agencia = obj.getAgencia();
		cpf = obj.getCpf();
		status = obj.getStatus();
		dataCriacao = obj.getDataCriacao();
		dataAtualizacao = obj.getDataAtualizacao();	
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Long getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Long dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Long getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Long dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
	
}
