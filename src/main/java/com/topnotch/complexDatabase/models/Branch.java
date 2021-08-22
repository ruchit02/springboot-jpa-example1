package com.topnotch.complexDatabase.models;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="branch")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Branch {
	
	//the type of a FOREIGN KEY OBJECT in this table/entity
	//is the NAME of the TABLE/ENTITY in which it is a PRIMARY KEY OBJECT
	
	@Id
	@Column(name="branch_id")
	private Long branch_id;
	
	@Column(name="branch_name")
	private String branch_name;
	
	@Column(name="manager_startdate")
	private Date manager_startdate;
	
	
	
	//FOREIGN KEYS
	@OneToOne
	@JsonBackReference
	@JoinColumn(name="manager_id", referencedColumnName="emp_id")
	private Employee manager_id;
	
	
	
	
	//RELATIONS
	@JsonIgnore
	@OneToMany(mappedBy="branch_id")
	private List<Employee> employees;
	
	@JsonIgnore
	@OneToMany(mappedBy="branch_id")
	private List<Client> clients ;
	
	@JsonIgnore
	@OneToMany(mappedBy="branch_id")
	private List<BranchSupplier> suppliers;
	
	
	public Branch() {
		
	}

	
	
	
	
	

	public Long getBranch_id() {
		return branch_id;
	}


	public void setBranch_id(Long branch_id) {
		this.branch_id = branch_id;
	}


	public String getBranch_name() {
		return branch_name;
	}


	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}


	public Date getManager_startdate() {
		return manager_startdate;
	}


	public void setManager_startdate(Date manager_startdate) {
		this.manager_startdate = manager_startdate;
	}


	public Employee getManager_id() {
		return manager_id;
	}


	public void setManager_id(Employee manager_id) {
		this.manager_id = manager_id;
	}


	public List<Employee> getEmployees() {
		return employees;
	}


	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}


	public List<Client> getClients() {
		return clients;
	}


	public void setClients(List<Client> clients) {
		this.clients = clients;
	}


	public List<BranchSupplier> getSuppliers() {
		return suppliers;
	}


	public void setSuppliers(List<BranchSupplier> suppliers) {
		this.suppliers = suppliers;
	}
}
