package com.polytec.springprojet.service;

import com.polytec.springprojet.entities.Taches;

import java.util.List;

public interface IServiceTache {

    public void addTache(Taches t);
    public List<Taches> getAllTaches();
    public Taches getTacheByID(Long id);
    public void updateTache(Taches t);
    public void deleteTache(Long id);
}
