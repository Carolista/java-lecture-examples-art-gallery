package org.launchcode.artgallery.controllers;

import org.launchcode.artgallery.data.ArtistRepository;
import org.launchcode.artgallery.data.ArtworkRepository;
import org.launchcode.artgallery.models.Artist;
import org.launchcode.artgallery.models.Artwork;
import org.launchcode.artgallery.models.Style;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/artworks")
public class ArtworkController {

    @Autowired
    private ArtworkRepository artworkRepository;

    @Autowired
    private ArtistRepository artistRepository;

    // Corresponds to http://localhost:8080/artworks
    // or http://localhost:8080/artworks?artistId=1 (for example) if artistId is present
    @GetMapping("")
    public String displayArtworksPage(@RequestParam(required = false) Integer artistId, Model model) {
        if (artistId != null) {
            Optional<Artist> result = artistRepository.findById(artistId);
            if (result.isPresent()) {
                Artist artist = result.get();
                model.addAttribute("artist", artist);
                model.addAttribute("artworks", artist.getArtworks());
            }
        } else {
            model.addAttribute("artworks", artworkRepository.findAll());
        }
        return "artworks/index";
    }

    // Corresponds to http://localhost:8080/artworks/add
    @GetMapping("/add")
    public String displayAddArtForm(Model model) {
        model.addAttribute("artwork", new Artwork());
        model.addAttribute("artists", artistRepository.findAll());
        model.addAttribute("styles", Style.values());
        return "artworks/add";
    }

    @PostMapping("/add")
    public String processAddArtForm(@ModelAttribute @Valid Artwork artwork, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("styles", Style.values());
            return "artworks/add";
        } else {
            artworkRepository.save(artwork);
            return "redirect:/artworks";
        }
    }

    // Corresponds to http://localhost:8080/artworks/delete
    @GetMapping("/delete")
    public String displayDeleteArtForm(Model model) {
        model.addAttribute("artworks", artworkRepository.findAll());
        return "artworks/delete";
    }

    @PostMapping("/delete")
    public String processDeleteArtForm(@RequestParam(required = false) int[] artworkIds) {
        for (int id : artworkIds) {
            artworkRepository.deleteById(id);
        }
        return "redirect:/artworks";
    }

}
