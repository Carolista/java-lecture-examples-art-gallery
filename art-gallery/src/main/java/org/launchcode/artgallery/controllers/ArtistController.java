package org.launchcode.artgallery.controllers;

import org.launchcode.artgallery.data.ArtistRepository;
import org.launchcode.artgallery.models.Artist;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.launchcode.artgallery.models.ArtistComparator;
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
    public String displayArtistsPage(Model model, HttpSession session) {
        List<Artist> artists = (List<Artist>) artistRepository.findAll();
        artists.sort(new ArtistComparator());
        model.addAttribute("artists", artists);
        model.addAttribute("loggedIn", session.getAttribute("user") != null);
        return "/artists/index";
    }

    // Corresponds to http://localhost:8080/artists/add
    @GetMapping("/add")
    public String displayAddArtistForm(Model model, HttpSession session) {
        model.addAttribute("loggedIn", session.getAttribute("user") != null);
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

}
