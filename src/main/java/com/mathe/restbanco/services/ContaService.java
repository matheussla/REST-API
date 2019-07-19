package com.mathe.restbanco.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mathe.restbanco.domain.Conta;
import com.mathe.restbanco.repository.ContaRepository;
import com.mathe.restbanco.services.exception.ObjectNotFoundException;

@Service
public class ContaService {
	
	@Autowired
	private ContaRepository repo;
	
	
	public List<Conta> findAll(){
		return repo.findAll();
		
	}

	public Conta findById(String id) {
		Optional<Conta> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
}
