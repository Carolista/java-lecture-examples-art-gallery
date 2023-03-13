package com.launchcode.artgallery.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

// TODO: Convert model to an Entity (persistent class)
public class Artwork {

    // TODO: Add annotations so Hibernate knows to generate id as a primary key
    private int id;
    private static int nextId;

    @NotBlank(message = "Title is required.")
    private String title;

    @Size(min = 2, max = 30, message = "Artist name must be 2-30 characters long.")
    private String artist;

    private String yearCreated;

    private Style style;

    // TODO: Remove nextId & id related code from constructors
    public Artwork() {
        this.id = nextId;
        nextId++;
    }

    public Artwork(String title, String artist, String yearCreated, Style style) {
        this();
        this.title = title;
        this.artist = artist;
        this.yearCreated = yearCreated;
        this.style = style;
    }

    public int getId() {
        return id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Artwork artwork = (Artwork) o;
        return id == artwork.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
