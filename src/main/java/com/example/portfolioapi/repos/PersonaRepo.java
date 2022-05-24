package com.example.portfolioapi.repos;

//import java.util.Optional;

import com.example.portfolioapi.models.PersonaModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepo extends CrudRepository<PersonaModel, Integer> {
    
    public abstract PersonaModel findByUsername(String username);
    
}