package org.launchcode.artgallery.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@ResponseBody // TODO: Remove this once templates are being used
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

    // TODO: Convert this to use a template, index.html
    // TODO: Pass list of values from map, artworkList, to template using Model class
    // Corresponds to http://localhost:8080/artworks
    @GetMapping("")
    public String renderArtworksHomePage() {
        StringBuilder artworksList = new StringBuilder();
        for (int artworkId : artworks.keySet()) {
            String artwork = artworks.get(artworkId);
            artworksList.append("<li><a href='/artworks/details/").append(artworkId).append("'>").append(artwork).append("</a></li>");
        }
        return "<html>" +
                "<body>" +
                "<h2>ARTWORKS</h2>" +
                "<ul>" +
                artworksList +
                "</ul>" +
                "<p>Click <a href='/artworks/add'>here</a> to add another artwork.</p>" +
                "</body>" +
                "</html>";
    }

    // TODO: Convert this to use a template, add.html
    // Corresponds to http://localhost:8080/artworks/add
    @GetMapping("/add")
    public String renderAddArtworkForm() {
        return "<html>" +
                "<body>" +
                "<form action='/artworks/add' method='POST'>" +
                "<p>Enter the name of a new work of art:</p>" +
                "<input type='text' name='artwork' />" +
                "<button type='submit'>Submit</button>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    // TODO: Convert this to redirect to /artworks route
    // Corresponds to http://localhost:8080/artworks/add?artwork=someArtworkTitle
    @PostMapping("/add")
    public String processAddArtworkForm(@RequestParam String artwork) {
        artworks.put(nextId, artwork);
        nextId++;
        return "<html>" +
                "<body>" +
                "<h3>ARTWORK ADDED</h3>" +
                "<p>You have successfully added " + artwork + " to the collection.</p>" +
                "<p><a href='/artworks/add'>Add another artwork</a> or <a href='/artworks'>view the updated list</a> of artworks.</p>" +
                "</body>" +
                "</html>";
    }

}
