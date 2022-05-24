package com.example.portfolioapi.services;

import java.util.List;
import java.util.Optional;

import com.example.portfolioapi.models.SkillModel;
import com.example.portfolioapi.repos.SkillRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SkillServices {
    @Autowired
    SkillRepo skillRepo;

    public List<SkillModel> getAll(){
        return (List<SkillModel>) skillRepo.findAll();
    }
    public ResponseEntity< SkillModel> getById(int id) {

        Optional<SkillModel> skill = skillRepo.findById(id);

        if (skill.isPresent()) {
            return ResponseEntity.ok().body(skill.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    public SkillModel save( SkillModel skill) {
        return skillRepo.save(skill); // crear o actualizar
    }

 //   public void delete(int id) {
 //       skillRepo.deleteById(id);
 //   }
 public boolean delete(int id) {
    try {
        skillRepo.deleteById(id);
        return true;
    } catch(Exception err){
        return false;
    }
}

}