package com.example.portfolioapi.repos;

import com.example.portfolioapi.models.EducacionModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducacionRepo extends CrudRepository<EducacionModel, Integer> {

}