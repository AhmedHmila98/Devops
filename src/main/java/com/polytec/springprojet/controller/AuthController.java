package com.polytec.springprojet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AuthController {

    @GetMapping("/")
    public String goToHomePage() {
        return "home";
    }

    @GetMapping("/erreur")
    public String goToErrorPage() {
        return "errorPage";
    }
}
