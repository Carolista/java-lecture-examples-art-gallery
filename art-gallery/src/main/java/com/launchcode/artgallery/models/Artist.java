package com.launchcode.artgallery.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Artist extends AbstractEntity {

    @NotBlank(message="First name is required.")
    private String firstName;

    @NotBlank(message="Last name is required.")
    private String lastName;

    private String location;

    @OneToMany(mappedBy="artist")
    @JsonBackReference
    private final List<Artwork> artworks = new ArrayList<>();

    public Artist() {}

    public Artist(String firstName, String lastName, String location) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.location = location;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Artwork> getArtworks() {
        return artworks;
    }

    @Override
    public String toString() {
        return firstName + ' ' + lastName;
    }
}
