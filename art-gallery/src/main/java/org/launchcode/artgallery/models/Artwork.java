package org.launchcode.artgallery.models;

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

    // TODO #2: Change the relationship to many-to-many
    //  - Update the constructor, getter, and setter
    @ManyToOne
    private Style style;

    // TODO #1: Create an ArtworkDetails class
    //  - Move the 7 properties below into that class, as well as getters/setters, and refactor the constructor
    //  - Add a new field, details, of the ArtworkDetails type, update constructor, and add a getter and setter
    private String media;

    @NotBlank(message = "Year is required.")
    private String yearCreated;
    private String description;
    private double width;
    private double height;
    private double depth;

    @NotBlank(message = "Image ID is required.")
    private String imageId;

    public Artwork() {
    }

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

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public String getDescription() {
        return description;
    }

    public String getYearCreated() {
        return yearCreated;
    }

    public void setYearCreated(String yearCreated) {
        this.yearCreated = yearCreated;
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

    // TODO #1: Update with new reference to details.getYearCreated()
    @Override
    public String toString() {
        return title + " (" + artist + ", " + yearCreated + ")";
    }

    // TODO #1: Move to ArtworkDetails
    public String getDimensions() {
        String widthFormatted = width + "\"W";
        String heightFormatted = " x " + height + "\"H";
        String depthFormatted = depth > 0 ? " x " + depth + "\"D" : "";
        return widthFormatted + heightFormatted + depthFormatted;
    }

    // TODO #2: Add getFormattedStyles() after the many-to-many relationship has been set

}
