package com.launchcode.artgallery.models;

import java.util.Objects;

public class Artwork {

    private static int nextId = 1;

    private final int id;
    private String title;
    private String artist;
    private String period;

    public Artwork(String title, String artist, String period) {
        this.id = nextId;
        this.title = title;
        this.artist = artist;
        this.period = period;
        nextId++;
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
