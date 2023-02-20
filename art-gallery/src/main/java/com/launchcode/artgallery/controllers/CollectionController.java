package com.launchcode.artgallery.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody // TODO: Remove this once templates are being used
@RequestMapping("/collection")
public class CollectionController {

    // TODO: Convert this to use a template, collection.html
    // TODO: Pass list, artCollection, to template
    // Corresponds to http://localhost:8080/collection
    @GetMapping("")
    public String displayCollectionPage() {
        System.out.println("\n*** Collection page content requested");
        return "<p>We have an extensive collection of fine art.</p>" +
                "<ul>" +
                "<li>Girl with a Pearl Earring</li>" +
                "<li>Mona Lisa</li>" +
                "<li>The Birth of Venus</li>" +
                "<li>The Persistence of Memory</li>" +
                "<li>The Starry Night</li>" +
                "</ul>";
    }

    // TODO: Convert this to use a template, add-art-form.html
    // Corresponds to http://localhost:8080/collection/add
    @GetMapping("/add")
    public String displayAddArtForm() {
        System.out.println("\n*** GET request submitted for form content");
        return "<html>" +
                "<body>" +
                "<form action='/collection' method='POST'>" +
                "<p>Ooh! New art! What is it called?</p>" +
                "<input type='text' name='artwork' />" +
                "<button type='submit'>Add to Collection</button>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    // TODO: Create a POST handler for /add
    // Should add name of artwork to collection list
    // Then should redirect to /collection

}
