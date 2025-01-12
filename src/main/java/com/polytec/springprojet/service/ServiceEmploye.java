package com.polytec.springprojet.service;

import com.polytec.springprojet.entities.Employes;
import com.polytec.springprojet.repository.EmployesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ServiceEmploye implements IServiceEmploye {

    private final EmployesRepository er;


    @Override
    public void addEmploye(Employes p) {
        er.save(p);
    }

    @Override
    public List<Employes> getAllEmployes() {
        return er.findAll();
    }

    @Override
    public Employes getEmployeByID(Long id) {
        Optional<Employes> employe = er.findById(id);
        return employe.orElseThrow(() -> new RuntimeException("Employe not found with ID: " + id));
    }

    @Override
    public void updateEmploye(Employes p) {
        er.save(p);
    }

    @Override
    public void deleteEmploye(Long id) {
        er.deleteById(id);

    }


}
