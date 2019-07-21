package com.mathe.restbanco.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mathe.restbanco.domain.Conta;
import com.mathe.restbanco.dto.ContaDTO;
import com.mathe.restbanco.services.ContaService;

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
	
	@GetMapping(value="/{id}")
	public ResponseEntity<ContaDTO> findById(@PathVariable String id){
		Conta obj = service.findById(id);
		return ResponseEntity.ok().body(new ContaDTO(obj));
	}
	
	@PostMapping
	public ResponseEntity<ContaDTO> insert(@RequestBody @Valid ContaDTO objDto){
		Conta obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
    //Delete by Id
	//@DeleteMapping(value="/{id}")
	//public ResponseEntity<Void> delete(@PathVariable String id){
		//service.delete(id);
		//return ResponseEntity.noContent().build();
	//}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@RequestBody @Valid ContaDTO objDto, @PathVariable String id){
		Conta conta = service.findById(id);
		Conta obj = service.deleteFromDTO(objDto);
		obj.setId(id);
		obj.setNumero(conta.getNumero());
		obj.setAgencia(conta.getAgencia());
		obj.setCpf(conta.getCpf());
		obj.setDataCriacao(conta.getDataCriacao());
		obj = service.delete(obj);
		return ResponseEntity.noContent().build();
	}
	
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Void> update(@RequestBody @Valid ContaDTO objDto, @PathVariable String id){
		Conta obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
}
