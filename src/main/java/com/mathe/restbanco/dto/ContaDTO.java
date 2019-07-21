package com.mathe.restbanco.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mathe.restbanco.domain.Conta;

public class ContaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	@NotNull
	@Size(min = 6, max = 6, message = "numero must be 6 digits")
	private String numero;
	@NotNull
	@Size(min = 4, max = 4, message = "agencia must be 4 digits")
	private String agencia;
	@NotNull
	@Size(min = 11, max = 11, message = "cpf must be 11 digits")
	private String cpf;
	private Boolean status;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime dataCriacao;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime dataAtualizacao;
	
	public ContaDTO() {
	}

	public ContaDTO(Conta obj) {
		id = obj.getId();
		numero = obj.getNumero();
		agencia = obj.getAgencia();
		cpf = obj.getCpf();
		status = obj.getStatus();
		dataCriacao = startDate();
		dataAtualizacao = startDate();	
	}

	private LocalDateTime startDate() {
        return LocalDateTime.now();
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

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
	
}
