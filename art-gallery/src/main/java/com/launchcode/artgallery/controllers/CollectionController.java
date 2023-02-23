package com.launchcode.artgallery.controllers;

import com.launchcode.artgallery.data.CollectionData;
import com.launchcode.artgallery.models.Artwork;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/collection")
public class CollectionController {

    // Corresponds to http://localhost:8080/collection
    @GetMapping("")
    public String displayCollectionPage(Model model) {
        System.out.println("\n*** Collection page content requested");
        model.addAttribute("collection", CollectionData.getAll());
        return "collection/index";
    }

    // TODO: Pass an empty artwork object to the template for binding with th:field and th:errors
    // Corresponds to http://localhost:8080/collection/add
    @GetMapping("/add")
    public String displayAddArtForm() {
        System.out.println("\n*** GET request submitted for add-art-form content");
        return "collection/add-art-form";
    }

    // TODO: Enable validation and handle validation errors
    @PostMapping("/add")
    public String processAddArtForm(@ModelAttribute Artwork artwork) {
        System.out.println("\n*** POST request submitted to add " + artwork.getTitle() + " to collection");
        CollectionData.add(artwork);
        return "redirect:/collection";
    }

    @GetMapping("/delete")
    public String displayDeleteArtForm(Model model) {
        System.out.println("\n*** GET request submitted for delete-art-form content");
        model.addAttribute("collection", CollectionData.getAll());
        return "collection/delete-art-form";
    }

    @PostMapping("/delete")
    public String processDeleteArtForm(@RequestParam(required = false) int[] artworkIds) {
        for (int id : artworkIds) {
            CollectionData.remove(id);
        }
        return "redirect:/collection";
    }

}
