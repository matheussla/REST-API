package com.mathe.restbanco.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mathe.restbanco.domain.Conta;

@Repository
public interface ContaRepository extends MongoRepository<Conta, String> {
	
	

}
