package com.example.portfolioapi.services;

import java.util.List;
import java.util.Optional;

import com.example.portfolioapi.models.ProyectoModel;
import com.example.portfolioapi.repos.ProyectoRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService {
    @Autowired
    ProyectoRepo proyectoRepo;

    public List<ProyectoModel> getAll(){
        return (List<ProyectoModel>) proyectoRepo.findAll();
    }

    public ResponseEntity<ProyectoModel> getById(int id) {

        Optional<ProyectoModel> proyecto = proyectoRepo.findById(id);

        if (proyecto.isPresent()) {
            return ResponseEntity.ok().body(proyecto.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ProyectoModel save(ProyectoModel proyecto) {
        return proyectoRepo.save(proyecto); // crear o actualizar
    }
    public boolean delete(int id) {
        try {
            proyectoRepo.deleteById(id);
            return true;
        } catch(Exception err){
            return false;
        }
    }
}