package org.launchcode.artgallery.controllers;

import org.launchcode.artgallery.data.StyleRepository;
import org.launchcode.artgallery.models.Style;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/styles")
public class StyleController {

    @Autowired
    private StyleRepository styleRepository;

    // Corresponds to http://localhost:8080/styles
    @GetMapping
    public String renderStylesPage(Model model) {
        // TODO #3: Sort styles using a comparator class
        model.addAttribute("styles", styleRepository.findAll());
        return "/styles/index";
    }

    // Corresponds to http://localhost:8080/styles/add
    @GetMapping("/add")
    public String renderAddStyleForm(Model model) {
        model.addAttribute("style", new Style());
        return "styles/add";
    }

    @PostMapping("/add")
    public String processAddStyleForm(@ModelAttribute @Valid Style style, Errors errors) {
        if (errors.hasErrors()) {
            return "styles/add";
        } else {
            styleRepository.save(style);
            return "redirect:/styles";
        }
    }

}
