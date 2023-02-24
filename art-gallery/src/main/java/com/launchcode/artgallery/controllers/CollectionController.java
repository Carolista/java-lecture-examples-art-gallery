package com.launchcode.artgallery.controllers;

import com.launchcode.artgallery.data.CollectionData;
import com.launchcode.artgallery.models.Artwork;
import com.launchcode.artgallery.models.Style;
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

    // Corresponds to http://localhost:8080/collection/add
    @GetMapping("/add")
    public String displayAddArtForm(Model model) {
        System.out.println("\n*** GET request submitted for add-art-form content");
        model.addAttribute("artwork", new Artwork());
        model.addAttribute("styles", Style.values());
        return "collection/add-art-form";
    }

    @PostMapping("/add")
    public String processAddArtForm(@ModelAttribute @Valid Artwork artwork, Errors errors, Model model) {
        System.out.println("\n*** POST request submitted to add " + artwork.getTitle() + " to collection");
        if (errors.hasErrors()) {
            model.addAttribute("styles", Style.values());
            return "collection/add-art-form";
        } else {
            CollectionData.add(artwork);
            return "redirect:/collection";
        }
    }

    // Corresponds to http://localhost:8080/collection/delete
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
