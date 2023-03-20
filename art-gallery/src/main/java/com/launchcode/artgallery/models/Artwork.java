package com.launchcode.artgallery.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Artwork extends AbstractEntity {

    @NotBlank(message = "Title is required.")
    private String title;

    @ManyToOne
    @NotNull(message = "Artist is required.")
    private Artist artist;

    @ManyToOne
    private Style style;

    private String media;

    @NotBlank(message = "Year is required.")
    private String yearCreated;
    private String description;
    private double width;
    private double height;
    private double depth;

    @NotBlank(message = "Image ID is required.")
    private String imageId;

    public Artwork() {}

    public Artwork(String title, Artist artist, Style style, String media, String yearCreated, String description, int width, int height, int depth, String imageId) {
        this.title = title;
        this.artist = artist;
        this.style = style;
        this.media = media;
        this.yearCreated = yearCreated;
        this.description = description;
        this.width = width;
        this.height = height;
        this.depth = depth;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    @Override
    public String toString() {
        return title + " (" + artist + ", " + yearCreated + ")";
    }

    public String getDimensions() {
        String widthFormatted = width + "\"W";
        String heightFormatted = " x " + height + "\"H";
        String depthFormatted = depth > 0 ? " x " + depth + "\"D" : "";
        return widthFormatted + heightFormatted + depthFormatted;
    }

}
