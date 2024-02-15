package org.launchcode.artgallery.controllers;

import org.launchcode.artgallery.data.ArtistRepository;
import org.launchcode.artgallery.models.Artist;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/artists")
public class ArtistController {

    @Autowired
    private ArtistRepository artistRepository;

    // Corresponds to http://localhost:8080/artists
    @GetMapping
    public String renderArtistsPage(Model model) {
        // TODO #3: Sort artists using a comparator class
        model.addAttribute("artists", artistRepository.findAll());
        return "/artists/index";
    }

    // Corresponds to http://localhost:8080/artists/add
    @GetMapping("/add")
    public String renderAddArtistForm(Model model) {
        model.addAttribute("artist", new Artist());
        return "artists/add";
    }

    @PostMapping("/add")
    public String processAddArtistForm(@ModelAttribute @Valid Artist artist, Errors errors) {
        if (errors.hasErrors()) {
            return "artists/add";
        } else {
            artistRepository.save(artist);
            return "redirect:/artists";
        }
    }

    // Corresponds to http://localhost:8080/artists/delete
    @GetMapping("/delete")
    public String displayDeleteArtistForm(Model model) {
        model.addAttribute("artists", artistRepository.findAll());
        return "artists/delete";
    }

    @PostMapping("/delete")
    public String processDeleteArtistForm(@RequestParam(required = false) int[] artistIds) {
        for (int id : artistIds) {
            artistRepository.deleteById(id);
        }
        return "redirect:/artists";
    }

}
