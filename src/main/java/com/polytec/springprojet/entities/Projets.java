package com.polytec.springprojet.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Getter
@Setter
public class Projets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String description;

    @ManyToMany
    @JoinTable(
            name = "projet_employe",
            joinColumns = @JoinColumn(name = "projet_id"),
            inverseJoinColumns = @JoinColumn(name = "employe_id")
    )
    private List<Employes> employes;

    @OneToMany(mappedBy = "projets", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Taches> taches;
}
