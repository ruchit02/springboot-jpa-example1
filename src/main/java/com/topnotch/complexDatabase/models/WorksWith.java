package com.topnotch.complexDatabase.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="works_with")
@IdClass(WorksWithKey.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class WorksWith implements Serializable{
	
	//the type of a FOREIGN KEY OBJECT in this table/entity
	//is the NAME of the TABLE/ENTITY in which it is a PRIMARY KEY OBJECT
	
	//FOREIGN KEYS
	@Id
	@ManyToOne
	@JoinColumn(name="emp_id", referencedColumnName="emp_id")
	private Employee emp_id;
	
	@Id
	@ManyToOne
	@JoinColumn(name="client_id", referencedColumnName="client_id")
	private Client client_id;
	
	@Column(name="total_sales")
	private Integer total_sales;
	
	//RELATIONS
	
	
	
	public WorksWith() {
		
	}




	public Integer getTotal_sales() {
		return total_sales;
	}

	public void setTotal_sales(Integer total_sales) {
		this.total_sales = total_sales;
	}




	public Employee getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Employee emp_id) {
		this.emp_id = emp_id;
	}




	public Client getClient_id() {
		return client_id;
	}

	public void setClient_id(Client client_id) {
		this.client_id = client_id;
	}
	
}
