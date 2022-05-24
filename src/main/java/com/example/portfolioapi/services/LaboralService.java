
package com.example.portfolioapi.services;

import com.example.portfolioapi.models.LaboralModel;
import com.example.portfolioapi.repos.LaboralRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author JLG
 */
@Service
public class LaboralService {
    
    @Autowired
    LaboralRepo expeRepo;
    
    public List<LaboralModel> getAll() {
        return (List<LaboralModel>) expeRepo.findAll();
    }
    
    public ResponseEntity<LaboralModel> getById(int id) {

        Optional<LaboralModel> laboral = expeRepo.findById(id);

        if (laboral.isPresent()) {
            return ResponseEntity.ok().body(laboral.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    public LaboralModel save(LaboralModel laboral) {
        return expeRepo.save(laboral); // crea o actualiza
    }
    
    //public void delete(long id){
    //    expeRepo.deleteById(id);
    //}
    public boolean delete(int id) {
        try {
            expeRepo.deleteById(id); 
            return true;
        } catch(Exception err){
            return false;
        }
    } 

}
