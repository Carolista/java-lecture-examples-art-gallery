package org.launchcode.artgallery.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/artworks")
public class ArtworkController {

    // TODO: Create an Artwork model to have the fields id, title, and artist
    // Then update the Map below to hold Artwork objects instead of strings
    private static int nextId = 6;

    private static final Map<Integer, String> artworks = new HashMap<>() {{
        put(1, "Girl with a Pearl Earring");
        put(2, "Mona Lisa");
        put(3, "The Birth of Venus");
        put(4, "The Persistence of Memory");
        put(5, "The Starry Night");
    }};

    // TODO: Later, Create a data layer class to store a map of Artwork objects and handle CRUD ops
    // Then remove map above

    // TODO: Use method of data layer class to retrieve art collection
    // Corresponds to http://localhost:8080/artworks
    @GetMapping("")
    public String renderArtworksPage(Model model) {
        List<String> artworkList = new ArrayList<>(artworks.values());
        model.addAttribute("artworkList", artworkList);
        return "artworks/index";
    }

    // Corresponds to http://localhost:8080/artworks/add
    @GetMapping("/add")
    public String renderAddArtForm() {
        return "artworks/add";
    }

    // TODO: Modify this to accommodate additional properties of object in Artwork model
    // TODO: Later, make use of data layer class method to add artwork to art collection
    // TODO: Last, modify again to use model binding
    // Corresponds to http://localhost:8080/artworks/add?artwork=someArtworkTitle
    @PostMapping("/add")
    public String processAddArtForm(@RequestParam String artwork) {
        artworks.put(nextId, artwork);
        nextId++;
        return "redirect:/artworks";
    }

    // TODO: Add GET and POST handlers for /delete

}
