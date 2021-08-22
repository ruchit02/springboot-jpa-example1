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

import com.topnotch.complexDatabase.models.Branch;
import com.topnotch.complexDatabase.repositories.BranchRepository;

@RestController
@RequestMapping("api/v1/branch")
public class BranchController {

	@Autowired
	private BranchRepository repository;
	
	public BranchController() {
		
	}
	
	@GetMapping
	public List<Branch> list(){
		return repository.findAll();
	}
	
	@PostMapping
	public Branch create(@RequestBody final Branch branch) {
		return repository.saveAndFlush(branch);
	}
	
	@GetMapping("{id}")
	public Branch read(@PathVariable Long id) {
		return repository.getById(id) ;
	}
	
	@PutMapping("{id}")
	public Branch update(@RequestBody Branch branch, @PathVariable Long id) {
		
		Branch exsisting = repository.getById(id);
		BeanUtils.copyProperties(branch, exsisting);
		return repository.saveAndFlush(exsisting);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
