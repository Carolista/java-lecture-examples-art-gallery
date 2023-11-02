package org.launchcode.artgallery.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GalleryController {

    // Corresponds to http://localhost:8080
    @GetMapping("/")
    public String displayHomePage() {
        return "index";
    }

}
