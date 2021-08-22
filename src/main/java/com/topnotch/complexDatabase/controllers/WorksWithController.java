package com.topnotch.complexDatabase.controllers;

import java.util.List;

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

import com.topnotch.complexDatabase.models.WorksWith;
import com.topnotch.complexDatabase.models.WorksWithKey;
import com.topnotch.complexDatabase.repositories.WorksWithRepository;

@RestController
@RequestMapping("api/v1/workswith")
@BasePathAwareController
public class WorksWithController {

	@Autowired
	private WorksWithRepository repository;
	
	public WorksWithController() {
		
	}
	
	@GetMapping
	public List<WorksWith> list(){
		return repository.findAll();
	}
	
	@PostMapping
	public WorksWith create(@RequestBody final WorksWith workswith) {
		return repository.saveAndFlush(workswith);
	}
	
	@GetMapping("{id1}_{id2}")
	public WorksWith read(@PathVariable String id1, @PathVariable String id2) {
		return repository.getById( new WorksWithKey( new Long(id1), new Long(id2) ) ) ;
	}
	
	/*@GetMapping("{id}")
	public WorksWith read(@PathVariable WorksWithKey id) {
		return repository.getById( id ) ;
	}*/
	
	@PutMapping("{id}")
	public WorksWith update(@RequestBody WorksWith workswith, @PathVariable WorksWithKey id) {
		
		WorksWith exsisting = repository.getById(id);
		BeanUtils.copyProperties(workswith, exsisting);
		return repository.saveAndFlush(exsisting);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable WorksWithKey id) {
		repository.deleteById(id);
	}
}
