package org.launchcode.artgallery.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GalleryController {

    // TODO: Create and use a template called index.html
    // Remember to remove @ResponseBody
    // Pass in Model attribute for title

    // Corresponds to http://localhost:8080
    @GetMapping("/")
    @ResponseBody
    public String renderHomePage() {
        return "<h1>Welcome</h1>" +
                "<p>This portal will allow you to help manage our <a href='/artworks'>collection</a> of fine art.</p>" +
                "<img th:src='@{/images/gallery2.png}' width='100%' />";
    }

}
