package com.polytec.springprojet.service;

import com.polytec.springprojet.entities.Projets;

import java.util.List;

public interface IServiceProjet {

    public void addProjet(Projets p);
    public List<Projets> getAllProjets();
    public Projets getProjetByID(Long id);
    public void updateProjet(Projets p);
    public void deleteProjet(Long id);
}
