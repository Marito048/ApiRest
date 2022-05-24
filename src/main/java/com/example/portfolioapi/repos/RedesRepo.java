package com.example.portfolioapi.repos;

import com.example.portfolioapi.models.RedesModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedesRepo extends CrudRepository<RedesModel, Integer> {
    
}