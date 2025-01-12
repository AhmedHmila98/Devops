package com.polytec.springprojet.controller;

import com.polytec.springprojet.entities.Employes;
import com.polytec.springprojet.service.IServiceEmploye;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/employees")
public class EmployeController {


    private final IServiceEmploye serviceEmploye;


    @GetMapping("/all")
    public String getAllEmployes(Model model) {
        model.addAttribute("employes", serviceEmploye.getAllEmployes());
        return "employes-list"; // Vue Thymeleaf pour afficher la liste des employés
    }


    @GetMapping("/{id}")
    public String getEmployeById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("employe", serviceEmploye.getEmployeByID(id));
        return "employe-details"; // Vue Thymeleaf pour afficher les détails d'un employé
    }

    // Formulaire pour ajouter un nouvel employé
    @GetMapping("/admin/form")
    public String goToAddForm(Model model) {
        model.addAttribute("employe", new Employes());
        return "addEmploye";
    }

    // Enregistrer un nouvel employé
    @PostMapping("/admin/save")
    public String saveEmploye(@ModelAttribute Employes employe) {
        serviceEmploye.addEmploye(employe);
        return "redirect:/employees/all"; // Redirection vers la liste des employés après l'enregistrement
    }


    @GetMapping("/admin/delete/{id}")
    public String deleteEmploye(@PathVariable("id") Long id) {
        serviceEmploye.deleteEmploye(id);
        return "redirect:/employees/all";
    }


    @GetMapping("/admin/edit/{id}")
    public String editEmploye(@PathVariable("id") Long id, Model model) {
        model.addAttribute("employe", serviceEmploye.getEmployeByID(id));
        return "addEmploye";
    }
}
