package com.mathe.restbanco.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mathe.restbanco.domain.Conta;

@RestController
@RequestMapping(value="/contas")
public class ContaResource {
	
	@GetMapping
	public ResponseEntity<List<Conta>> findAll(){
		
		Conta Mario = new Conta("1", "123456", "4289", "12345678910", true, "05/08/2018", "08/02/2019");
		Conta Juliana = new Conta("2", "123489", "4299", "12345678999", true, "07/10/2018", "05/01/2019");
		List<Conta> list = new ArrayList<>();
		list.addAll(Arrays.asList(Mario, Juliana));
		
		return ResponseEntity.ok().body(list);

	}

}
