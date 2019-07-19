package com.mathe.restbanco.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mathe.restbanco.domain.Conta;
import com.mathe.restbanco.dto.ContaDTO;
import com.mathe.restbanco.service.ContaService;

@RestController
@RequestMapping(value="/contas")
public class ContaResource {
	
	@Autowired
	private ContaService service;
	
	@GetMapping
	public ResponseEntity<List<ContaDTO>> findAll(){
		List<Conta> list = service.findAll();
		List<ContaDTO> listDto = list.stream().map(mapper -> new ContaDTO(mapper)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);

	}

}
