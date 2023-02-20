package com.launchcode.artgallery.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/collection")
public class CollectionController {

    // TODO: Create an Artwork model to have the properties title, artist, nationality, and time period
    // TODO: Create a data layer class to store a map of Artwork objects and handle CRUD ops
    // TODO: Remove ArrayList below once no longer needed
    private static final List<String> artCollection = new ArrayList<>();

    // TODO: Use method of data layer class to retrieve art collection
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

    // TODO: Modify this to accommodate additional properties of object in Artwork model
    // TODO: Make use of data layer class method to add artwork to art collection
    // TODO: Later, modify again to use model binding
    @PostMapping("/add")
    public String processAddArtForm(@RequestParam String artwork) {
        System.out.println("\n*** POST request submitted to add " + artwork + " to collection");
        artCollection.add(artwork);
        Collections.sort(artCollection);
        return "redirect:/collection";
    }
}
