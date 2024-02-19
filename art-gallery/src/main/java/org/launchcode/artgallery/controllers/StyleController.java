package org.launchcode.artgallery.controllers;

import org.launchcode.artgallery.data.StyleRepository;
import org.launchcode.artgallery.models.Style;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.launchcode.artgallery.models.StyleComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/styles")
public class StyleController {

    @Autowired
    private StyleRepository styleRepository;

    // Corresponds to http://localhost:8080/styles
    @GetMapping
    public String renderStylesPage(Model model, HttpSession session) {
        List<Style> styles = (List<Style>) styleRepository.findAll();
        styles.sort(new StyleComparator());
        model.addAttribute("styles", styles);
        model.addAttribute("loggedIn", session.getAttribute("user") != null);
        return "/styles/index";
    }

    // Corresponds to http://localhost:8080/styles/add
    @GetMapping("/add")
    public String renderAddStyleForm(Model model, HttpSession session) {
        model.addAttribute("style", new Style());
        model.addAttribute("loggedIn", session.getAttribute("user") != null);
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
