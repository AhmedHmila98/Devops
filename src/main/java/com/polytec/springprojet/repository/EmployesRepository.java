package com.polytec.springprojet.repository;

import com.polytec.springprojet.entities.Employes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployesRepository extends JpaRepository<Employes, Long> {
}
