package org.launchcode.artgallery.controllers;

import org.launchcode.artgallery.data.ArtistRepository;
import org.launchcode.artgallery.data.ArtworkRepository;
import org.launchcode.artgallery.data.StyleRepository;
import org.launchcode.artgallery.models.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
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
        List<Artist> artists = (List<Artist>) artistRepository.findAll();
        Collections.sort(artists, new ArtistComparator());
        List<Style> styles = (List<Style>) styleRepository.findAll();
        Collections.sort(styles, new StyleComparator());
        model.addAttribute("artwork", new Artwork());
        model.addAttribute("artists", artists);
        model.addAttribute("styles", styles);
        return "artworks/add";
    }

    @PostMapping("/add")
    public String renderAddArtForm(@ModelAttribute @Valid Artwork artwork,
                                    Errors errors,
                                    @RequestParam(required = false) List<Integer> styleIds,
                                    Model model) {
        if (errors.hasErrors()) {
            System.out.println(errors.getAllErrors());
            List<Artist> artists = (List<Artist>) artistRepository.findAll();
            artists.sort(new ArtistComparator());
            List<Style> styles = (List<Style>) styleRepository.findAll();
            styles.sort(new StyleComparator());
            model.addAttribute("artists", artists);
            model.addAttribute("styles", styles);
            return "artworks/add";
        } else {
            if (styleIds != null) {
                List<Style> selectedStyles = (List<Style>) styleRepository.findAllById(styleIds);
                artwork.setStyles(selectedStyles);
            }
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
