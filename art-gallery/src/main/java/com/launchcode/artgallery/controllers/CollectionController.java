package com.launchcode.artgallery.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;

@Controller
@RequestMapping("/collection")
public class CollectionController {

    private static final ArrayList<String> artCollection = new ArrayList<>();

    // Corresponds to http://localhost:8080/collection
    @GetMapping("")
    public String displayCollectionPage(Model model) {
        System.out.println("\n*** Collection page content requested");
        model.addAttribute("collection", artCollection);
        return "collection/index";
    }

    // Corresponds to http://localhost:8080/collection/add
    @GetMapping("/add")
    public String displayAddArtForm() {
        System.out.println("\n*** GET request submitted for form content");
        return "collection/add-art-form";
    }

    @PostMapping("/add")
    public String processAddArtForm(@RequestParam String artwork) {
        System.out.println("\n*** POST request submitted to add " + artwork + " to collection");
        artCollection.add(artwork);
        Collections.sort(artCollection);
        return "redirect:/collection";
    }
}
