package org.launchcode.artgallery.controllers;

import org.launchcode.artgallery.data.ArtistRepository;
import org.launchcode.artgallery.data.ArtworkRepository;
import org.launchcode.artgallery.data.StyleRepository;
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

    @Autowired
    private StyleRepository styleRepository;

    // Corresponds to http://localhost:8080/artworks
    @GetMapping("")
    public String renderArtworksPage(@RequestParam(required = false) Integer artistId,
                                      @RequestParam(required = false) Integer styleId,
                                      Model model) {
        if (artistId != null) {
            Optional<Artist> result = artistRepository.findById(artistId);
            if (result.isPresent()) {
                Artist artist = result.get();
                model.addAttribute("artworks", artist.getArtworks());
            }
        } else if (styleId != null) {
            Optional<Style> result = styleRepository.findById(styleId);
            if (result.isPresent()) {
                Style style = result.get();
                model.addAttribute("artworks", style.getArtworks());
            }
        } else {
            model.addAttribute("artworks", artworkRepository.findAll());
        }
        return "artworks/index";
    }

    // Corresponds to http://localhost:8080/artworks/details/1
    @GetMapping("/details/{artworkId}")
    public String renderArtworkDetailsPage(@PathVariable int artworkId, Model model) {
        Optional<Artwork> result = artworkRepository.findById(artworkId);
        if (result.isPresent()) {
            Artwork artwork = result.get();
            model.addAttribute("artwork", artwork);
            return "artworks/details";
        } else {
            return "artworks/index";
        }
    }

    // Corresponds to http://localhost:8080/artworks/add
    @GetMapping("/add")
    public String renderAddArtForm(Model model) {
        // TODO #3: Create comparator classes to sort artists and styles
        model.addAttribute("artwork", new Artwork());
        model.addAttribute("artists", artistRepository.findAll());
        model.addAttribute("styles", styleRepository.findAll());
        return "artworks/add";
    }

    // TODO #2: Add a query parameter, styleIds, to handle user selections on the /add form
    @PostMapping("/add")
    public String processAddArtForm(@ModelAttribute @Valid Artwork artwork, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("artists", artistRepository.findAll());
            model.addAttribute("styles", styleRepository.findAll());
            return "artworks/add";
        } else {
            // TODO #2: If styleIds were passed in:
            //  - look up the Style objects for those ids
            //  - set them into the artwork object that has been passed in through model binding
            artworkRepository.save(artwork);
            return "redirect:/artworks";
        }
    }

    // Corresponds to http://localhost:8080/artworks/delete
    @GetMapping("/delete")
    public String renderDeleteArtForm(Model model) {
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
