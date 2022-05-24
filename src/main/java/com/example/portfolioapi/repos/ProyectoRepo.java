package com.example.portfolioapi.repos;

import com.example.portfolioapi.models.ProyectoModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoRepo extends CrudRepository<ProyectoModel, Integer> {
    
    
}