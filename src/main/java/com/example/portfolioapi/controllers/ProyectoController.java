package com.example.portfolioapi.controllers;

import java.util.List;

import com.example.portfolioapi.models.ProyectoModel;
import com.example.portfolioapi.services.ProyectoService;

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
@RequestMapping("/api/proyectos")
public class ProyectoController {

    @Autowired
    private ProyectoService proyectoService;

    @GetMapping
    public List<ProyectoModel> getAll() {
        return proyectoService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProyectoModel> getById(@PathVariable(value = "id") int id) {
        return proyectoService.getById(id);
    }

    @PostMapping
    public ProyectoModel save(@Validated @RequestBody ProyectoModel proyecto) {
        return proyectoService.save(proyecto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProyectoModel> update(@PathVariable(value = "id") int id, @Validated @RequestBody ProyectoModel proyecto) {
        if (id == proyecto.idproyecto) {
            ProyectoModel taskNew = proyectoService.save(proyecto);
            return ResponseEntity.ok().body(taskNew);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ProyectoModel> delete(@PathVariable int id) {
        boolean ok = proyectoService.delete(id);
        if (ok) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.internalServerError().build();
        }
}

}

