package com.topnotch.complexDatabase.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.topnotch.complexDatabase.models.Client;
import com.topnotch.complexDatabase.repositories.ClientRepository;

@RestController
@RequestMapping("api/v1/client")
public class ClientController {

	@Autowired
	private ClientRepository repository;
	
	public ClientController() {
		
	}
	
	@GetMapping
	public List<Client> list(){
		return repository.findAll();
	}
	
	@PostMapping
	public Client create(@RequestBody final Client client) {
		return repository.saveAndFlush(client);
	}
	
	@GetMapping("{id}")
	public Client read(@PathVariable Long id) {
		return repository.getById(id) ;
	}
	
	@PutMapping("{id}")
	public Client update(@RequestBody Client client, @PathVariable Long id) {
		
		Client exsisting = repository.getById(id);
		BeanUtils.copyProperties(client, exsisting);
		return repository.saveAndFlush(exsisting);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
