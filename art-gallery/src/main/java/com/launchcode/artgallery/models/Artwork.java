package com.launchcode.artgallery.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

public class Artwork {

    private static int nextId = 1;

    private int id;

    @NotBlank(message = "Title is required.")
    private String title;

    @Size(min = 2, max = 30, message = "Artist name must be 2-30 characters long.")
    private String artist;

    private String period;

    private Style style;

    public Artwork() {
        this.id = nextId;
        nextId++;
    }

    public Artwork(String title, String artist, String period, Style style) {
        this(); // add id and increment nextId
        this.title = title;
        this.artist = artist;
        this.period = period;
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

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    @Override
    public String toString() {
        return title + " (" + artist + ", " + period + ")";
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
