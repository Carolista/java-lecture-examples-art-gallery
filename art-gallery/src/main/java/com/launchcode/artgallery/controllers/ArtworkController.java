package com.launchcode.artgallery.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/artworks")
public class ArtworkController {

    private static int nextId = 6;

    private static final Map<Integer, String> artworks = new HashMap<>() {{
        put(1, "Girl with a Pearl Earring");
        put(2, "Mona Lisa");
        put(3, "The Birth of Venus");
        put(4, "The Persistence of Memory");
        put(5, "The Starry Night");
    }};

    // Corresponds to http://localhost:8080/artworks
    @GetMapping("")
    public String displayCollectionPage(Model model) {
        List<String> artworkList = new ArrayList<>(artworks.values());
        model.addAttribute("artworkList", artworkList);
        return "artworks/index";
    }

    // Corresponds to http://localhost:8080/artworks/add
    @GetMapping("/add")
    public String displayAddArtForm() {
        return "artworks/add";
    }

    // Corresponds to http://localhost:8080/artworks/add?artwork=someArtworkTitle
    @PostMapping("/add")
    public String processAddArtForm(@RequestParam String artwork) {
        artworks.put(nextId, artwork);
        nextId++;
        return "redirect:/artworks";
    }
}
