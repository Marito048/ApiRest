package com.example.portfolioapi.controllers;

import java.util.List;

import com.example.portfolioapi.models.EducacionModel;
import com.example.portfolioapi.services.EducacionService;

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
@RequestMapping("/api/educacion")
public class EducacionController {

    @Autowired
    private EducacionService educacionService;

    @GetMapping
    public List<EducacionModel> getAll() {
        return educacionService.getAll();
    }        

    @GetMapping("/{id}")
    public ResponseEntity<EducacionModel> getById(@PathVariable(value = "id") int id) {
        return educacionService.getById(id);
    } 
    
    @PostMapping
    public EducacionModel save(@Validated @RequestBody EducacionModel educacion) {
        return educacionService.save(educacion);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<EducacionModel> update(@PathVariable(value = "id") int id, @Validated @RequestBody EducacionModel educacion) {
        if (id == educacion.getIdeducacion()) {
            EducacionModel taskNew = educacionService.save(educacion);
            return ResponseEntity.ok().body(taskNew);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    //@DeleteMapping("/{id}")
    //public ResponseEntity eliminarPorId(@PathVariable(value = "id") int id) {
    //    ResponseEntity response = null;
    //    if(educacionService.getById(id) == null) {
    //        response = new ResponseEntity(HttpStatus.NOT_FOUND);
    //    }
    //    else{
    //        educacionService.delete(id);
    //        response= ResponseEntity.ok("SE ELIMINÓ LA EDUCACIÓN CON ID " + id);
    //    }
    //    return response;
    //}
    @DeleteMapping("/{id}")
    public ResponseEntity<EducacionModel> delete(@PathVariable int id) {
        boolean ok = educacionService.delete(id);
        if (ok) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.internalServerError().build();
        }
    }


}