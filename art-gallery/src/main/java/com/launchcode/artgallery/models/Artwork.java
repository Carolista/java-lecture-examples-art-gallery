package com.launchcode.artgallery.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Artwork extends AbstractEntity {

    @NotBlank(message = "Title is required.")
    private String title;

    @Size(min = 2, max = 30, message = "Artist name must be 2-30 characters long.")
    private String artist;

    private String yearCreated;

    private Style style;

    public Artwork() {}

    public Artwork(String title, String artist, String yearCreated, Style style) {
        this.title = title;
        this.artist = artist;
        this.yearCreated = yearCreated;
        this.style = style;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getYearCreated() {
        return yearCreated;
    }

    public void setYearCreated(String yearCreated) {
        this.yearCreated = yearCreated;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    @Override
    public String toString() {
        return title + " (" + artist + ", " + yearCreated + ")";
    }

}
