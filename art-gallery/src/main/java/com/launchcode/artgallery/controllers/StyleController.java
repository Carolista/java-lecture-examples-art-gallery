package com.launchcode.artgallery.controllers;

import com.launchcode.artgallery.data.StyleRepository;
import com.launchcode.artgallery.models.Artist;
import com.launchcode.artgallery.models.Style;
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
    public String displayStylesPage(Model model) {
        model.addAttribute("styles", styleRepository.findAll());
        return "/styles/index";
    }

    // Corresponds to http://localhost:8080/styles/add
    @GetMapping("/add")
    public String displayAddStyleForm(Model model) {
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

//    // Corresponds to http://localhost:8080/styles/delete
//    @GetMapping("/delete")
//    public String displayDeleteStyleForm(Model model) {
//        model.addAttribute("styles", styleRepository.findAll());
//        return "styles/delete";
//    }
//
//    @PostMapping("/delete")
//    public String processDeleteStyleForm(@RequestParam(required = false) int[] styleIds) {
//        for (int id : styleIds) {
//            styleRepository.deleteById(id);
//        }
//        return "redirect:/styles";
//    }
}
