package org.launchcode.artgallery.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
public class Artwork extends AbstractEntity {

    @NotBlank(message = "Title is required.")
    private String title;

    @ManyToOne
    @NotNull(message = "Artist is required.")
    @JsonManagedReference
    private Artist artist;

    @ManyToMany
    @JsonManagedReference
    private List<Style> styles;

    @OneToOne(cascade = CascadeType.ALL)
    @Valid
    private ArtworkDetails details;

    public Artwork() {}

    public Artwork(String title, Artist artist, List<Style> styles, ArtworkDetails details) {
        this.title = title;
        this.artist = artist;
        this.styles = styles;
        this.details = details;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public List<Style> getStyles() {
        return styles;
    }

    public void setStyles(List<Style> styles) {
        this.styles = styles;
    }

    public ArtworkDetails getDetails() {
        return details;
    }

    public void setDetails(ArtworkDetails details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return title + " (" + artist + ", " + details.getYearCreated() + ")";
    }

    @JsonIgnore
    public String getFormattedStyles() {
        StringBuilder styleNames = new StringBuilder("");
        for (int i=0; i < styles.size(); i++) {
            styleNames.append(styles.get(i).getName());
            if (i < styles.size() - 1) {
                styleNames.append(", ");
            }
        }
        return styleNames.toString();
    }

}
