package org.launchcode.artgallery.models;

import java.util.Objects;

public class Artwork {

    private static int nextId = 1;

    private int id;

    // TODO: Add rules to title and artist
    // Use the message parameter to give the user meaningful feedback
    // title should not be blank
    // artist should be 2-30 characters long
    private String title;
    private String artist;

    // TODO: Add an Enum class for style, with values for several styles of art
    // Add a rule to prevent form submission if value is null
    // Then add the style field to this class and update the constructor

    // TODO: For binding to th:field and th:errors, add a no-arg constructor
    // Move the id-related items from the other constructor
    // Then call this constructor from the other constructor with this()
    public Artwork(String title, String artist) {
        this.id = nextId;
        this.title = title;
        this.artist = artist;
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
