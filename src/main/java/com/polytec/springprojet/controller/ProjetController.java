package com.polytec.springprojet.controller;

import com.polytec.springprojet.entities.Projets;
import com.polytec.springprojet.service.IServiceProjet;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/projet")
public class ProjetController {

    private final IServiceProjet serviceProjet;

    // Afficher tous les projets
    @GetMapping("/all")
    public String getAllProjets(Model model) {
        model.addAttribute("projets", serviceProjet.getAllProjets());
        return "projets-list"; // Vue Thymeleaf pour afficher la liste des projets
    }

    // Afficher les détails d'un projet spécifique
    @GetMapping("/{id}")
    public String getProjetById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("projet", serviceProjet.getProjetByID(id));
        return "projet-details"; // Vue Thymeleaf pour afficher les détails d'un projet
    }

    // Formulaire pour ajouter un nouveau projet
    @GetMapping("/admin/form")
    public String goToAddForm(Model model) {
        model.addAttribute("projet", new Projets());
        return "projet-form"; // Vue Thymeleaf pour le formulaire d'ajout
    }

    // Enregistrer un nouveau projet
    @PostMapping("/admin/save")
    public String saveProjet(@ModelAttribute Projets projet) {
        serviceProjet.addProjet(projet);
        return "redirect:/projet/all"; // Redirection vers la liste des projets après l'enregistrement
    }

    // Supprimer un projet
    @GetMapping("/admin/delete/{id}")
    public String deleteProjet(@PathVariable("id") Long id) {
        serviceProjet.deleteProjet(id);
        return "redirect:/projet/all"; // Redirection vers la liste des projets après la suppression
    }

    // Formulaire pour modifier un projet existant
    @GetMapping("/admin/edit/{id}")
    public String editProjet(@PathVariable("id") Long id, Model model) {
        model.addAttribute("projet", serviceProjet.getProjetByID(id));
        return "projet-form"; //
    }
}

