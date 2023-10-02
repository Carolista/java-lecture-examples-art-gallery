package com.launchcode.artgallery.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GalleryController {

    // Corresponds to http://localhost:8080
    @GetMapping("/")
    public String displayHomePage(Model model) {
        model.addAttribute("title", "Welcome");
        return "index";
    }

}
