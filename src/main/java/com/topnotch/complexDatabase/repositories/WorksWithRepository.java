package com.topnotch.complexDatabase.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.topnotch.complexDatabase.models.WorksWith;
import com.topnotch.complexDatabase.models.WorksWithKey;

//@RepositoryRestResource(collectionResourceRel = "workswith", path = "workswith", itemResourceRel = "workswith/{emp_id}_{client_id}")
public interface WorksWithRepository extends JpaRepository<WorksWith,WorksWithKey>{

	//public WorksWith findOne(WorksWith);
}
