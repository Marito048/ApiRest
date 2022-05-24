package com.example.portfolioapi.services;

import java.util.List;
import java.util.Optional;

import com.example.portfolioapi.models.RedesModel;
import com.example.portfolioapi.repos.RedesRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RedesService {
    @Autowired
    RedesRepo redesRepo;

    public List<RedesModel> getAll(){
        return (List<RedesModel>) redesRepo.findAll();
    }

    public ResponseEntity<RedesModel> getById(int id) {

        Optional<RedesModel> red = redesRepo.findById(id);

        if (red.isPresent()) {
            return ResponseEntity.ok().body(red.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public RedesModel save(RedesModel red) {
        return redesRepo.save(red);
    }

    public boolean delete(int id) {
        try {
            redesRepo.deleteById(id);
            return true;
        } catch(Exception err){
            return false;
        }
    }
    
}
