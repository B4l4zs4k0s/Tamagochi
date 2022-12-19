package com.example.foxclub.controllers;

import com.example.foxclub.services.FoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FoxController {

    FoxService foxService;

    @Autowired
    public FoxController(FoxService foxService) {
        this.foxService = foxService;
    }

    @GetMapping("/nutritionStore")
    public String showNutritionPage(@RequestParam(value = "name") String name, Model model) {
        model.addAttribute("name", foxService.loadFox(name));
        return "nutrition-store";
    }

    @PostMapping("/nutritionStore")
    public String changeNutrition(@RequestParam(value = "name") String name,
                                  @ModelAttribute(value = "food") String food,
                                  @ModelAttribute(value = "drink") String drink) {
        foxService.loadFox(name).setFood(food);
        foxService.loadFox(name).setDrink(drink);
        return "redirect:/?name=" + name;
    }

    @GetMapping("/trickCenter")
    public String showTrickCenter(@RequestParam(value = "name") String name, Model model) {
        model.addAttribute("name", foxService.loadFox(name));
        return "trick-center";
    }

    @PostMapping("/trickCenter")
    public String addTrick(@RequestParam(value = "name") String name,
                           @ModelAttribute(value = "trick") String trick) {
        foxService.addTrick(name, trick);
        return "redirect:/?name=" + name;
    }
}
