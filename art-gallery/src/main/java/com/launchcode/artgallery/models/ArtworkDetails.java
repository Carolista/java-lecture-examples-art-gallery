package com.launchcode.artgallery.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;

@Entity
public class ArtworkDetails extends AbstractEntity {

    private String description;

    private String yearCreated;

    private String media;

    @NotBlank(message = "Image ID is required.")
    private String imageId;

    private double width;

    private double height;

    private double depth;

    public ArtworkDetails() {}

    public ArtworkDetails(String description, String yearCreated, String media, String imageId, double width, double height, double depth) {
        this.description = description;
        this.yearCreated = yearCreated;
        this.media = media;
        this.imageId = imageId;
        this.width = width;
        this.height = height;
        this.depth = depth;
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
}
