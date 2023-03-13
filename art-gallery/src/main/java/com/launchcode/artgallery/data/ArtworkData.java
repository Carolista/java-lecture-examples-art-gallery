package com.launchcode.artgallery.data;

import com.launchcode.artgallery.models.Artwork;

import java.util.*;

public class ArtworkData {

    private static final Map<Integer, Artwork> artworks = new HashMap<>();

    public static void add(Artwork artwork) {
        artworks.put(artwork.getId(), artwork);
    }

    public static Artwork findById(int id) {
        return artworks.get(id);
    }

    public static Collection<Artwork> getAll() {
        return artworks.values();
    }

    public static void remove(int id) {
        artworks.remove(id);
    }

}
