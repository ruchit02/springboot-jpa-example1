package com.topnotch.complexDatabase.models;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="employee")
//@SecondaryTable(name="WorksWith", pkJoinColumns= {@PrimaryKeyJoinColumn(name="emp_id", referencedColumnName="emp_id")})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Employee {

	
	//the type of a FOREIGN KEY OBJECT in this table/entity
	//is the NAME of the TABLE/ENTITY in which it is a PRIMARY KEY OBJECT
	
	@Id
	@Column(name="emp_id")
	private Long emp_id;
	
	@Column(name="first_name")
	private String first_name;
	
	@Column(name="last_name")
	private String last_name;
	
	@Column(name="birth_date")
	private Date birth_date;
	
	@Column(name="sex")
	private String sex;
	
	@Column(name="salary")
	private Double salary;
	
	
	//FOREIGN KEYS
	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name="supervisor_id", referencedColumnName="emp_id")
	private Employee supervisor_id;
	
	@ManyToOne
	@JoinColumn(name="branch_id", referencedColumnName="branch_id")
	private Branch branch_id;
	
	
	
	
	//RELATIONS
	@JsonIgnore
	@OneToMany(mappedBy="supervisor_id")
	private List<Employee> superviseeEmployees;
	
	@JsonIgnore
	@OneToOne(mappedBy="manager_id")
	private Branch someBranch;
	
	@JsonIgnore
	@OneToMany(mappedBy="emp_id")
	private List<WorksWith> workingWith;
	
	
	
	
	
	
	
	
	
	public Employee() {
	}
	
	
	
	
	
	
	
	
	
	

	public Long getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Long emp_id) {
		this.emp_id = emp_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Date getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Employee getSupervisor_id() {
		return supervisor_id;
	}

	public void setSupervisor_id(Employee supervisor_id) {
		this.supervisor_id = supervisor_id;
	}

	public Branch getBranch_id() {
		return branch_id;
	}

	public void setBranch_id(Branch branch_id) {
		this.branch_id = branch_id;
	}

	public List<Employee> getSuperviseeEmployees() {
		return superviseeEmployees;
	}

	public void setSuperviseeEmployees(List<Employee> superviseeEmployees) {
		this.superviseeEmployees = superviseeEmployees;
	}

	public Branch getSomeBranch() {
		return someBranch;
	}

	public void setSomeBranch(Branch someBranch) {
		this.someBranch = someBranch;
	}

	public List<WorksWith> getWorkingWith() {
		return workingWith;
	}

	public void setWorkingWith(List<WorksWith> workingWith) {
		this.workingWith = workingWith;
	}
}
