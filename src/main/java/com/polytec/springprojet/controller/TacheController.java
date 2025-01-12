package com.polytec.springprojet.controller;

import com.polytec.springprojet.entities.Taches;
import com.polytec.springprojet.service.IServiceTache;
import com.polytec.springprojet.service.IServiceProjet;
import com.polytec.springprojet.service.IServiceEmploye;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/tachees")
public class TacheController {

    private final IServiceTache serviceTache;
    private final IServiceProjet serviceProjet;
    private final IServiceEmploye serviceEmploye;

    @GetMapping("/all")
    public String getAllTaches(Model model) {
        model.addAttribute("taches", serviceTache.getAllTaches());
        return "taches-list";
    }

    @GetMapping("/{id}")
    public String getTacheById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("tache", serviceTache.getTacheByID(id));
        return "tache-details";
    }

    @GetMapping("/admin/form")
    public String goToAddForm(Model model) {
        model.addAttribute("tache", new Taches());
        model.addAttribute("projets", serviceProjet.getAllProjets());
        model.addAttribute("employes", serviceEmploye.getAllEmployes());
        return "tache-form";
    }

    @PostMapping("/admin/save")
    public String saveTache(@ModelAttribute Taches tache) {
        serviceTache.addTache(tache);
        return "redirect:/tachees/all";
    }

    @GetMapping("/admin/delete/{id}")
    public String deleteTache(@PathVariable("id") Long id) {
        serviceTache.deleteTache(id);
        return "redirect:/tachees/all";
    }

    @GetMapping("/admin/edit/{id}")
    public String editTache(@PathVariable("id") Long id, Model model) {
        model.addAttribute("tache", serviceTache.getTacheByID(id));
        model.addAttribute("projets", serviceProjet.getAllProjets());
        model.addAttribute("employes", serviceEmploye.getAllEmployes());
        return "tache-form";
    }
}
