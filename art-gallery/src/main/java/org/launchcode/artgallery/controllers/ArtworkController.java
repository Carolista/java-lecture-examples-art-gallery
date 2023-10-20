package org.launchcode.artgallery.controllers;

import org.launchcode.artgallery.data.ArtworksData;
import org.launchcode.artgallery.models.Artwork;
import org.launchcode.artgallery.models.Style;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/artworks")
public class ArtworkController {

    // TODO: Replace data layer with repository and replace CRUD methods in handlers
    // TODO: Delete temporary data layer class, ArtworksData

    // Corresponds to http://localhost:8080/artworks
    @GetMapping("")
    public String renderArtworksPage(Model model) {
        model.addAttribute("artworkList", ArtworksData.getAll());
        return "artworks/index";
    }

    // Corresponds to http://localhost:8080/artworks/add
    @GetMapping("/add")
    public String renderAddArtForm(Model model) {
        model.addAttribute("artwork", new Artwork());
        model.addAttribute("styles", Style.values());
        return "artworks/add";
    }

    // Corresponds to http://localhost:8080/artworks/add?title=SomeTitle&artist=SomeArtist
    @PostMapping("/add")
    public String processAddArtForm(@ModelAttribute @Valid Artwork artwork, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("styles", Style.values());
            return "artworks/add";
        } else {
            ArtworksData.add(artwork);
            return "redirect:/artworks";
        }
    }

    // Corresponds to http://localhost:8080/artworks/delete
    @GetMapping("/delete")
    public String renderDeleteArtForm(Model model) {
        model.addAttribute("artworkList", ArtworksData.getAll());
        return "artworks/delete";
    }

    // Corresponds to http://localhost:8080/artworks/delete?artworkIds=1&artworkIds=2 (etc)
    @PostMapping("/delete")
    public String processDeleteArtForm(@RequestParam(required = false) int[] artworkIds) {
        for (int id : artworkIds) {
            ArtworksData.remove(id);
        }
        return "redirect:/artworks";
    }

}
