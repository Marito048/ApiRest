package com.example.portfolioapi.repos;

import com.example.portfolioapi.models.SkillModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepo extends CrudRepository<SkillModel, Integer>  {
    
}
