package com.topnotch.complexDatabase.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.topnotch.complexDatabase.models.Branch;

@Repository
public interface BranchRepository extends JpaRepository<Branch,Long> {

}
