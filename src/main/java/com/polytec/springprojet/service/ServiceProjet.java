package com.polytec.springprojet.service;
import com.polytec.springprojet.entities.Employes;
import com.polytec.springprojet.entities.Projets;
import com.polytec.springprojet.repository.ProjetsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ServiceProjet implements IServiceProjet{

    private final ProjetsRepository pr;

    @Override
    public void addProjet(Projets p) {
        pr.save(p);
    }

    @Override
    public List<Projets> getAllProjets() {
        return pr.findAll();
    }

    @Override
    public Projets getProjetByID(Long id) {
        Optional<Projets> projet = pr.findById(id);
        return projet.orElseThrow(() -> new RuntimeException("Projet not found with ID: " + id));
    }

    @Override
    public void updateProjet(Projets p) {
        pr.save(p);

    }

    @Override
    public void deleteProjet(Long id) {
        pr.deleteById(id);
    }
}
