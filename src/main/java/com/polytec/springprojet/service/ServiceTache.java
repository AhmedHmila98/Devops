package com.polytec.springprojet.service;

import com.polytec.springprojet.entities.Employes;
import com.polytec.springprojet.entities.Taches;
import com.polytec.springprojet.repository.EmployesRepository;
import com.polytec.springprojet.repository.TachesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ServiceTache implements IServiceTache {

    private final TachesRepository tr;
    @Override
    public void addTache(Taches t) {
        tr.save(t);
    }

    @Override
    public List<Taches> getAllTaches() {
        return tr.findAll();
    }

    @Override
    public Taches getTacheByID(Long id) {
        Optional<Taches> tache = tr.findById(id);
        return tache.orElseThrow(() -> new RuntimeException("Tache not found with ID: " + id));
    }

    @Override
    public void updateTache(Taches t) {
        tr.save(t);

    }

    @Override
    public void deleteTache(Long id) {
        tr.deleteById(id);

    }
}
