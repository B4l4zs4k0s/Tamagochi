package com.example.foxclub.controllers;

import com.example.foxclub.services.FoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    FoxService foxService;

    @Autowired
    public MainController(FoxService foxService) {
        this.foxService = foxService;
    }

    @GetMapping("/")
    public String main(@RequestParam(value = "name", required = false) String name, Model model) {
        model.addAttribute("name", foxService.loadFox(name));
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String saveFox(@RequestParam(value = "name") String name, Model model) {
        model.addAttribute("name", name);
        foxService.loadFox(name);
        return "redirect:/?name=" + name;
    }
}
