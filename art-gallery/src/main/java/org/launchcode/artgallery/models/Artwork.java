package org.launchcode.artgallery.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Artwork extends AbstractEntity {

    @NotBlank(message = "Title is required.")
    private String title;

    @ManyToOne
    private Artist artist;

    private String yearCreated;

    private String media;

    private Style style;

    private String imageId;

    public Artwork() {}

    public Artwork(String title, Artist artist, String yearCreated, String media, Style style, String imageId) {
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
