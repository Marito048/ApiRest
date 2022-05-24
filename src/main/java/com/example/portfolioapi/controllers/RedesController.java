package com.example.portfolioapi.controllers;

import java.util.List;

import com.example.portfolioapi.models.RedesModel;
import com.example.portfolioapi.services.RedesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/redes")
public class RedesController {

    @Autowired
    private RedesService redService;

    @GetMapping
    public List<RedesModel> getAll() {
        return redService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RedesModel> getById(@PathVariable(value = "id") int id) {
        return redService.getById(id);
    }

    @PostMapping
    public RedesModel save(@Validated @RequestBody RedesModel red) {
        return redService.save(red);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RedesModel> update(@PathVariable(value = "id") int id, @Validated @RequestBody RedesModel red) {
        if (id == red.getIdred()) {
            RedesModel redNew = redService.save(red);
            return ResponseEntity.ok().body(redNew);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RedesModel> delete(@PathVariable int id) {
        boolean ok = redService.delete(id);
        if (ok) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.internalServerError().build();
        }
    
    }


}






