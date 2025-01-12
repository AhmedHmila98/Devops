package com.polytec.springprojet.controller;

import com.polytec.springprojet.entities.Employes;
import com.polytec.springprojet.entities.Taches;
import com.polytec.springprojet.service.ServiceEmploye;
import com.polytec.springprojet.service.ServiceTache;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class TacheRestAPI {
    @Autowired
    private final ServiceTache serviceTache;

    @PostMapping("/taches")
    public void addTache(@RequestBody Taches tache) throws IOException {
        serviceTache.addTache(tache);
    }

    @GetMapping("/taches")
    public List<Taches> getTaches() {
        return serviceTache.getAllTaches();
    }

    @GetMapping("/taches/{id}")
    public Taches getTacheByID(@PathVariable Long id) {
        return serviceTache.getTacheByID(id);
    }

    @PutMapping("/taches/{id}")
    public void updateTache(@PathVariable Long id, @RequestBody Taches updatedTache) throws IOException {
        updatedTache.setId(id);
        serviceTache.updateTache(updatedTache);
    }

    @DeleteMapping("/taches/{id}")
    public void deleteTache(@PathVariable Long id) {
        serviceTache.deleteTache(id);
    }

}
