package com.launchcode.artgallery.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GalleryController {

    // Corresponds to http://localhost:8080
    @GetMapping("/")
    public String displayHomePage(Model model) {
        System.out.println("\n*** Home page content requested by browser");
        model.addAttribute("title", "Welcome");
        return "index";
    }

}
