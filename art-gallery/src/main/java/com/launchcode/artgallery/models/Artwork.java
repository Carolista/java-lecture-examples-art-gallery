package com.launchcode.artgallery.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Artwork extends AbstractEntity {

    @NotBlank(message = "Title is required.")
    private String title;

    // TODO #1: Change this to associate the Artist class
    // TODO #1: Remove @Size and add @ManyToOne to establish the relationship
    // TODO #1: Truncate table in database before re-starting app in IntelliJ
    @Size(min = 2, max = 30, message = "Artist name must be 2-30 characters long.")
    private String artist;

    private String yearCreated;

    private String media;

    private Style style;

    private String imageId;

    public Artwork() {}

    // TODO #1: update constructor with change to artist field
    public Artwork(String title, String artist, String yearCreated, String media, Style style, String imageId) {
        this.title = title;
        this.artist = artist;
        this.yearCreated = yearCreated;
        this.media = media;
        this.style = style;
        this.imageId = imageId;
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

    // TODO #1: Update with Artist type
    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getYearCreated() {
        return yearCreated;
    }

    public void setYearCreated(String yearCreated) {
        this.yearCreated = yearCreated;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    @Override
    public String toString() {
        return title + " (" + artist + ", " + yearCreated + ")";
    }

}
