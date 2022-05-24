package com.example.portfolioapi.services;

import java.util.List;
import java.util.Optional;

import com.example.portfolioapi.models.EducacionModel;
import com.example.portfolioapi.repos.EducacionRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EducacionService {
    @Autowired
    EducacionRepo educacionRepo;
   

    public List<EducacionModel> getAll(){
        return (List<EducacionModel>) educacionRepo.findAll();
    }
    
    public ResponseEntity< EducacionModel> getById(int id) {

        Optional<EducacionModel> educacion = educacionRepo.findById(id);

        if (educacion.isPresent()) {
            return ResponseEntity.ok().body(educacion.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    public EducacionModel save( EducacionModel educacion) {
        return educacionRepo.save(educacion); // crear o actualizar
    }
 //   public void delete(int id) {
 //       educacionRepo.deleteById(id);
 //   }
 public boolean delete(int id) {
    try {
        educacionRepo.deleteById(id);
        return true;
    } catch(Exception err){
        return false;
    }
}


}
