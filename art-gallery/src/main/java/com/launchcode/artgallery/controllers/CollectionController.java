package com.launchcode.artgallery.controllers;

import com.launchcode.artgallery.data.CollectionData;
import com.launchcode.artgallery.models.Artwork;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/collection")
public class CollectionController {

    // TODO: Create an Artwork model to have the properties title, artist, and time period
    // Then update the List below to hold Artwork objects instead of strings
    // TODO: Later, Create a data layer class to store a map of Artwork objects and handle CRUD ops
    // Then remove ArrayList below once no longer needed

    // TODO: Use method of data layer class to retrieve art collection
    // Corresponds to http://localhost:8080/collection
    @GetMapping("")
    public String displayCollectionPage(Model model) {
        System.out.println("\n*** Collection page content requested");
        model.addAttribute("collection", CollectionData.getAll());
        return "collection/index";
    }

    // Corresponds to http://localhost:8080/collection/add
    @GetMapping("/add")
    public String displayAddArtForm() {
        System.out.println("\n*** GET request submitted for add-art-form content");
        return "collection/add-art-form";
    }

    // TODO: Modify this to accommodate additional properties of object in Artwork model
    // TODO: Later, make use of data layer class method to add artwork to art collection
    // TODO: Last, modify again to use model binding
    @PostMapping("/add")
    public String processAddArtForm(@RequestParam String title, String artist, String period) {
        System.out.println("\n*** POST request submitted to add " + title + " to collection");
        CollectionData.add(new Artwork(title, artist, period));
        return "redirect:/collection";
    }

    // TODO: Create a GET handler for /delete
    // It should pass a list of Artwork objects to the delete-art-form template
    @GetMapping("/delete")
    public String displayDeleteArtForm(Model model) {
        System.out.println("\n*** GET request submitted for delete-art-form content");
        model.addAttribute("collection", CollectionData.getAll());
        return "collection/delete-art-form";
    }

    // TODO: Create a POST handler for /delete
    @PostMapping("/delete")
    public String processDeleteArtForm(@RequestParam(required = false) int[] artworkIds) {
        for (int id : artworkIds) {
            CollectionData.remove(id);
        }
        return "redirect:/collection";
    }

}
