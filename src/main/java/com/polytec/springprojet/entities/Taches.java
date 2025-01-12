package com.polytec.springprojet.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Getter
@Setter
public class Taches {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private String statut;
    private String dateLimite;

    @ManyToOne
    @JoinColumn(name = "projet_id", nullable = false)
    private Projets projets;

    @ManyToOne
    @JoinColumn(name = "employe_id", nullable = false)
    private Employes employe;
}