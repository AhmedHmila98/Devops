package com.polytec.springprojet.controller;

import com.polytec.springprojet.entities.Employes;
import com.polytec.springprojet.service.ServiceEmploye;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor

public class EmployeRestApi {

    @Autowired
    private final ServiceEmploye serviceEmploye;

    @PostMapping("/employes")
    public void addEmploye(@RequestBody Employes employe) throws IOException {
        serviceEmploye.addEmploye(employe);
    }

    @GetMapping("/employes")
    public List<Employes> getEmployes() {
        return serviceEmploye.getAllEmployes();
    }

    @GetMapping("/employes/{id}")
    public Employes getEmployeByID(@PathVariable Long id) {
        return serviceEmploye.getEmployeByID(id);
    }

    @PutMapping("/employes/{id}")
    public void updateEmploye(@PathVariable Long id, @RequestBody Employes updatedEmploye) throws IOException {
        updatedEmploye.setId(id); // Définir l'ID depuis la variable de chemin
        serviceEmploye.updateEmploye(updatedEmploye); // Mettre à jour l'employé
    }

    @DeleteMapping("/employes/{id}")
    public void deleteEmploye(@PathVariable Long id) {
        serviceEmploye.deleteEmploye(id);
    }
}
