package org.launchcode.artgallery.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;

@Entity
public class ArtworkDetails extends AbstractEntity {

    private String media;

    @NotBlank(message = "Year is required.")
    private String yearCreated;
    private String description;

    private double width;
    private double height;
    private double depth;

    @NotBlank(message = "Image ID is required.")
    private String imageId;

    public ArtworkDetails() {}

    public ArtworkDetails(String media, String yearCreated, String description, double width, double height, double depth, String imageId) {
        this.media = media;
        this.yearCreated = yearCreated;
        this.description = description;
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.imageId = imageId;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public String getYearCreated() {
        return yearCreated;
    }

    public void setYearCreated(String yearCreated) {
        this.yearCreated = yearCreated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getDimensions() {
        String widthFormatted = width + "\"W";
        String heightFormatted = " x " + height + "\"H";
        String depthFormatted = depth > 0 ? " x " + depth + "\"D" : "";
        return widthFormatted + heightFormatted + depthFormatted;
    }
}
