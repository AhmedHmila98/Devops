package com.polytec.springprojet.service;

import com.polytec.springprojet.entities.Employes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IServiceEmploye {

    public void addEmploye(Employes p);
    public List<Employes> getAllEmployes();
    public Employes getEmployeByID(Long id);
    public void updateEmploye(Employes p);
    public void deleteEmploye(Long id);
}
