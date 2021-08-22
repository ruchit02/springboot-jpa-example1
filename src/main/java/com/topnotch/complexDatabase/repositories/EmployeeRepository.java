package com.topnotch.complexDatabase.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.topnotch.complexDatabase.models.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
