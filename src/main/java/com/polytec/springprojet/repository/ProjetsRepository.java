package com.polytec.springprojet.repository;

import com.polytec.springprojet.entities.Projets;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetsRepository extends JpaRepository<Projets, Long> {
}
