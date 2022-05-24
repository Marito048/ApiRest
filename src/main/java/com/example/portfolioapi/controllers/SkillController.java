package com.example.portfolioapi.controllers;

import java.util.List;

import com.example.portfolioapi.models.SkillModel;
import com.example.portfolioapi.services.SkillServices;
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
@RequestMapping("/api/skills")
public class SkillController {
    
    @Autowired
    private SkillServices skillService;

    @GetMapping
    public List<SkillModel> getAll() {
        return skillService.getAll();
    }        

    @GetMapping("/{id}")
    public ResponseEntity<SkillModel> getById(@PathVariable(value = "id") int id) {
        return skillService.getById(id);
    } 
    
    @PostMapping
    public SkillModel save(@Validated @RequestBody SkillModel educacion) {
        return skillService.save(educacion);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<SkillModel> update(@PathVariable(value = "id") int id, @Validated @RequestBody SkillModel skill) {
        if (id == skill.getIdskill()) {
            SkillModel skillNew = skillService.save(skill);
            return ResponseEntity.ok().body(skillNew);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    /*@DeleteMapping("/{id}")
    public ResponseEntity eliminarPorId(@PathVariable(value = "id") int id) {
        ResponseEntity response = null;
        if(skillService.getById(id) == null) {
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        else{
            skillService.delete(id);
            response= ResponseEntity.ok("SE ELIMINÓ LA EDUCACIÓN CON ID " + id);
        }
        return response;
    }*/

    @DeleteMapping("/{id}")
    public ResponseEntity<SkillModel> delete(@PathVariable int id) {
        boolean ok = skillService.delete(id);
        if (ok) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.internalServerError().build();
        }
    }

}
