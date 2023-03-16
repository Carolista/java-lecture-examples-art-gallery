package com.launchcode.artgallery.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Artwork extends AbstractEntity {

    @NotBlank(message = "Title is required.")
    private String title;

    // TODO #1: Truncate table in database before re-starting app in IntelliJ
    @ManyToOne
    private Artist artist;

    private String yearCreated;

    private String media;

    private Style style;

    private String imageURL;

    public Artwork() {}

    public Artwork(String title, Artist artist, String yearCreated, String media, Style style, String imageURL) {
        this.title = title;
        this.artist = artist;
        this.yearCreated = yearCreated;
        this.media = media;
        this.style = style;
        this.imageURL = imageURL;
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

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public String toString() {
        return title + " (" + artist + ", " + yearCreated + ")";
    }

}
