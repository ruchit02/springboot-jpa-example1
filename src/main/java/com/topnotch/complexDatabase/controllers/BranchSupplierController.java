package com.topnotch.complexDatabase.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.topnotch.complexDatabase.models.BranchSupplier;
import com.topnotch.complexDatabase.models.BranchSupplierKey;
import com.topnotch.complexDatabase.repositories.BranchSupplierRepository;

@RestController
@RequestMapping("api/v1/branchsupplier")
@BasePathAwareController
public class BranchSupplierController {

	@Autowired
	private BranchSupplierRepository repository;
	
	public BranchSupplierController() {
		
	}
	
	@GetMapping
	public List<BranchSupplier> list(){
		return repository.findAll();
	}
	
	@PostMapping
	public BranchSupplier create(@RequestBody final BranchSupplier branchSupplier) {
		return repository.saveAndFlush(branchSupplier);
	}
	
	@GetMapping("{id1}_{id2}")
	public BranchSupplier getSpecificSupplier(@PathVariable String id1, @PathVariable String id2) {
		return repository.getById( new BranchSupplierKey( new Long(id1),id2) );
	}
	
	@PutMapping("{id}")
	public BranchSupplier update(@RequestBody BranchSupplier branchSupplier, @PathVariable BranchSupplierKey id) {
		
		BranchSupplier exsisting = repository.getById(id);
		BeanUtils.copyProperties(branchSupplier, exsisting);
		return repository.saveAndFlush(exsisting);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable BranchSupplierKey id) {
		repository.deleteById(id);
	}
}
