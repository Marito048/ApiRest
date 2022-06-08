package com.example.portfolioapi.services;

import java.util.List;
import java.util.Optional;

import com.example.portfolioapi.models.PersonaModel;
import com.example.portfolioapi.repos.PersonaRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PersonaService {
    @Autowired
    PersonaRepo personaRepo;

    public List<PersonaModel> getAll(){
        return (List<PersonaModel>) personaRepo.findAll();
    }

    public ResponseEntity<PersonaModel> getById(int id) {

        Optional<PersonaModel> persona = personaRepo.findById(id);

        if (persona.isPresent()) {
            return ResponseEntity.ok().body(persona.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public PersonaModel getByUsername(String username) {
        return personaRepo.findByUsername(username);
    }

    public PersonaModel save(PersonaModel persona) {
        return personaRepo.save(persona); // crear o actualizar
    }


    public boolean delete(int id) {
        try {
            personaRepo.deleteById(id);
            return true;
        } catch(Exception err){
            return false;
        }
    }

}
