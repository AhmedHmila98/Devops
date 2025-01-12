package com.polytec.springprojet.repository;

import com.polytec.springprojet.entities.Taches;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TachesRepository extends JpaRepository<Taches, Long> {
}
