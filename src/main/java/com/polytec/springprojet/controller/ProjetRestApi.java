package com.polytec.springprojet.controller;


import com.polytec.springprojet.entities.Employes;
import com.polytec.springprojet.entities.Projets;
import com.polytec.springprojet.service.ServiceProjet;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProjetRestApi {

    private final ServiceProjet serviceProjet;


    @PostMapping("/projets")
    public void addProjet(@RequestBody Projets p) throws IOException {
        serviceProjet.addProjet(p);
    }

    @GetMapping("/projets")
    public List<Projets> getProjets() {
        return serviceProjet.getAllProjets();
    }

    @GetMapping("/projets/{id}")
    public Projets getProjetByID(@PathVariable Long id) {
        return serviceProjet.getProjetByID(id);
    }

    @PutMapping("/projets/{id}")
    public void updateProjet(@PathVariable Long id, @RequestBody Projets updatedProjet) throws IOException {
        updatedProjet.setId(id);
        serviceProjet.updateProjet(updatedProjet);
    }

    @DeleteMapping("/projets/{id}")
    public void deleteProjet(@PathVariable Long id) {
        serviceProjet.deleteProjet(id);
    }
}
