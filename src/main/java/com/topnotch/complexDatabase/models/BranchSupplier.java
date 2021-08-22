package com.topnotch.complexDatabase.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="branch_supplier")
@IdClass(BranchSupplierKey.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class BranchSupplier implements Serializable{

	
	//the type of a FOREIGN KEY OBJECT in this table/entity
	//is the NAME of the TABLE/ENTITY in which it is a PRIMARY KEY OBJECT
	
	
	//FOREIGN KEY
	@Id
	@ManyToOne
	@JoinColumn(name="branch_id", referencedColumnName="branch_id")
	private Branch branch_id;
	
	@Id
	@Column(name="supplier_name")
	private String supplier_name;
	
	@Column(name="supplier_type")
	private String supplier_type;
	
	
	
	
	//RELATIONS
	
	
	public BranchSupplier() {
		
	}







	public String getSupplier_name() {
		return supplier_name;
	}

	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}







	public String getSupplier_type() {
		return supplier_type;
	}

	public void setSupplier_type(String supplier_type) {
		this.supplier_type = supplier_type;
	}







	public Branch getBranch_id() {
		return branch_id;
	}

	public void setBranch_id(Branch branch_id) {
		this.branch_id = branch_id;
	}
}
