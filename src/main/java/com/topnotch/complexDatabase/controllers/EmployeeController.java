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

import com.topnotch.complexDatabase.models.Employee;
import com.topnotch.complexDatabase.repositories.EmployeeRepository;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {

	@Autowired
	private EmployeeRepository repository;
	
	public EmployeeController() {
		
	}
	
	@GetMapping
	public List<Employee> list(){
		return repository.findAll();
	}
	
	@PostMapping
	public Employee create(@RequestBody final Employee employee) {
		return repository.saveAndFlush(employee);
	}
	
	@GetMapping("{id}")
	public Employee read(@PathVariable Long id) {
		return repository.getById(id) ;
	}
	
	@PutMapping("{id}")
	public Employee update(@RequestBody Employee employee, @PathVariable Long id) {
		
		Employee exsisting = repository.getById(id);
		BeanUtils.copyProperties(employee, exsisting);
		return repository.saveAndFlush(exsisting);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
