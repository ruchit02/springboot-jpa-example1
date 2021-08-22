package com.topnotch.complexDatabase.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.topnotch.complexDatabase.models.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long>{

}
