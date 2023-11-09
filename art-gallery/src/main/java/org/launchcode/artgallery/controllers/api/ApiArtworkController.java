package org.launchcode.artgallery.controllers.api;

import org.launchcode.artgallery.data.ArtworkRepository;
import org.launchcode.artgallery.models.Artwork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/artworks")
public class ApiArtworkController {

    @Autowired
    private ArtworkRepository artworkRepository;

    @GetMapping
    public ResponseEntity<?> getAllArtworks() {

        List<Artwork> artworks = (List<Artwork>) artworkRepository.findAll();
        return new ResponseEntity<>(artworks, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getArtworkById(@PathVariable Integer id) {

        Optional<Artwork> artworkOptional = artworkRepository.findById(id);
        if (artworkOptional.isPresent()) {
            return new ResponseEntity<>(artworkOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
