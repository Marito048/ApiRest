package com.example.portfolioapi.controllers;

import java.util.List;

import com.example.portfolioapi.models.PersonaModel;
import com.example.portfolioapi.services.PersonaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping
    public List<PersonaModel> getAll() {
        return personaService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonaModel> getById(@PathVariable(value = "id") int id) {
        return personaService.getById(id);
    }

    @PostMapping
    public PersonaModel save(@Validated @RequestBody PersonaModel persona) {
        return personaService.save(persona);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonaModel> update(@PathVariable(value = "id") int id,
            @Validated @RequestBody PersonaModel persona) {
        if (id == persona.getIdpersona()) {
            PersonaModel personaNew = personaService.save(persona);
            return ResponseEntity.ok().body(personaNew);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    //@DeleteMapping("/{id}")
    //public void delete(@PathVariable int id) {
    //    PersonaService.delete(id);
    //}
    @DeleteMapping("/{id}")
    public ResponseEntity<PersonaModel> delete(@PathVariable int id) {
        boolean ok = personaService.delete(id);
        if (ok) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.internalServerError().build();
        }
    }

}
