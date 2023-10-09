package org.launchcode.artgallery.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;

public class Artwork {

    private static int nextId = 1;

    private int id;

    @NotBlank(message = "Title is required.")
    private String title;

    @Size(min = 2, max = 30, message = "Artist's name must be 2-30 characters long.")
    private String artist;

    @NotNull(message = "Style is required.")
    private Style style;

    public Artwork() {
        this.id = nextId;
        nextId++; // This means only even id numbers will show up in table
    }

    public Artwork(String title, String artist, Style style) {
        this(); // Call no-arg constructor to set id and increment nextId
        this.title = title;
        this.artist = artist;
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

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    @Override
    public String toString() {
        return title + " (" + artist + ")";
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
