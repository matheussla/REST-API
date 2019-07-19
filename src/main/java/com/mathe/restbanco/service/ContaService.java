package com.mathe.restbanco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mathe.restbanco.domain.Conta;
import com.mathe.restbanco.repository.ContaRepository;

@Service
public class ContaService {
	
	@Autowired
	private ContaRepository repo;
	
	
	public List<Conta> findAll(){
		return repo.findAll();
		
	}

}
