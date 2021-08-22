package com.topnotch.complexDatabase.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="client_tb")
//@SecondaryTable(name="WorksWith", pkJoinColumns= {@PrimaryKeyJoinColumn(name="client_id", referencedColumnName="client_id")})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Client {

	
	//the type of a FOREIGN KEY OBJECT in this table/entity
	//is the NAME of the TABLE/ENTITY in which it is a PRIMARY KEY OBJECT
	
	
	@Id
	@Column(name="client_id")
	private Long client_id;
	
	@Column(name="client_name")
	private String client_name;
	
	
	//FOREIGN KEYS
	@ManyToOne
	@JoinColumn(name="branch_id", referencedColumnName="branch_id")
	private Branch branch_id;
	
	
	
	
	
	//RELATIONS
	@JsonIgnore
	@OneToMany(mappedBy="client_id")
	private List<WorksWith> workingWith;
	
	
	
	
	
	public Client() {
		
	}

	
	
	
	
	public Long getClient_id() {
		return client_id;
	}

	public void setClient_id(Long client_id) {
		this.client_id = client_id;
	}

	public String getClient_name() {
		return client_name;
	}

	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}

	public Branch getBranch_id() {
		return branch_id;
	}

	public void setBranch_id(Branch branch_id) {
		this.branch_id = branch_id;
	}

	public List<WorksWith> getWorkingWith() {
		return workingWith;
	}

	public void setWorkingWith(List<WorksWith> workingWith) {
		this.workingWith = workingWith;
	}
}
