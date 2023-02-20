package com.launchcode.artgallery.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GalleryController {

    // TODO: Create and use a template called index.html
    // Remember to remove @ResponseBody
    // Corresponds to http://localhost:8080
    @GetMapping("/")
    @ResponseBody
    public String displayHomePage() {
        System.out.println("\n*** Home page content requested by browser");
        return "<h2>Midtown Art Gallery</h2>" +
                "<p>Welcome! View our <a href='/collection'>collection</a> of fine art.</p>";
    }

}
