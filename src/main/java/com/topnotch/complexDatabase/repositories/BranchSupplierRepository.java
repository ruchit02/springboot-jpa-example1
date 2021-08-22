package com.topnotch.complexDatabase.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.topnotch.complexDatabase.models.BranchSupplier;
import com.topnotch.complexDatabase.models.BranchSupplierKey;

@Repository
public interface BranchSupplierRepository extends JpaRepository<BranchSupplier,BranchSupplierKey>{

}
