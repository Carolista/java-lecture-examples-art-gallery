package org.launchcode.artgallery.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GalleryController {

    // Corresponds to http://localhost:8080
    @GetMapping("/")
    @ResponseBody
    public String renderHomePage() {
        return "<h2>Midtown Art Gallery</h2>" +
                "<p>Welcome! View our <a href='/artworks'>collection</a> of fine art.</p>";
    }

    /* All handlers initially coded below were moved to the ArtworkController class */
}
