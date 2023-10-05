package org.launchcode.artgallery.controllers;

import org.launchcode.artgallery.data.ArtworksData;
import org.launchcode.artgallery.models.Artwork;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/artworks")
public class ArtworkController {

    // Corresponds to http://localhost:8080/artworks
    @GetMapping("")
    public String renderArtworksPage(Model model) {
        model.addAttribute("artworkList", ArtworksData.getAll());
        return "artworks/index";
    }

    // Corresponds to http://localhost:8080/artworks/add
    @GetMapping("/add")
    public String renderAddArtForm() {
        return "artworks/add";
    }

    @PostMapping("/add")
    public String processAddArtForm(@ModelAttribute Artwork artwork) {
        ArtworksData.add(artwork);
        return "redirect:/artworks";
    }

    @GetMapping("/delete")
    public String displayDeleteArtForm(Model model) {
        model.addAttribute("artworkList", ArtworksData.getAll());
        return "artworks/delete";
    }

    @PostMapping("/delete")
    public String processDeleteArtForm(@RequestParam(required = false) int[] artworkIds) {
        for (int id : artworkIds) {
            ArtworksData.remove(id);
        }
        return "redirect:/artworks";
    }

}
