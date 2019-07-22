package com.mathe.restbanco.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mathe.restbanco.domain.Conta;
import com.mathe.restbanco.dto.ContaDTO;
import com.mathe.restbanco.repository.ContaRepository;
import com.mathe.restbanco.services.exception.ObjectNotFoundException;

@Service
public class ContaService {
	
	@Autowired
	private ContaRepository repo;
	
	
	public List<Conta> findAll() {
		return repo.findAll();
		
	}

	public Conta findById(String id) {
		Optional<Conta> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public Conta insert(Conta obj) {
		return repo.insert(obj);
	}
	//Delete by Id
	//public void delete(String id) {
		//findById(id);
		//repo.deleteById(id);
	//}
	public Conta delete(Conta obj) {
		Conta newObj = findById(obj.getId());
		statusUpdate(newObj, obj);
		return repo.save(newObj);
	}
	
	public Conta update(Conta obj) {
		Conta newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void updateData(Conta newObj, Conta obj) {
		newObj.setNumero(obj.getNumero());
		newObj.setAgencia(obj.getAgencia());
		newObj.setCpf(obj.getCpf());
		newObj.setStatus(obj.getStatus());
		newObj.setDataAtualizacao(obj.getDataAtualizacao());
	}
	
	public void statusUpdate(Conta newObj, Conta obj) {
		newObj.setStatus(obj.getStatus());
		newObj.setDataAtualizacao(obj.getDataAtualizacao());
	}
	
	public Conta fromDTO(ContaDTO objDto) {
		boolean status = true;
		return new Conta(objDto.getId(), objDto.getNumero(), objDto.getAgencia(), objDto.getCpf(), status,objDto.getDataCriacao(), objDto.getDataAtualizacao());
	}
	
	public Conta deleteFromDTO(ContaDTO objDto) {
		boolean status = false;
		return new Conta(objDto.getId(), objDto.getNumero(), objDto.getAgencia(), objDto.getCpf(), status,objDto.getDataCriacao(), objDto.getDataAtualizacao());
	}
}
