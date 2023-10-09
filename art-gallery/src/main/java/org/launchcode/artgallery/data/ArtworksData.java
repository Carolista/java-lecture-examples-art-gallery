package org.launchcode.artgallery.data;

import org.launchcode.artgallery.models.Artwork;

import java.util.*;

public class ArtworksData {

    private static final Map<Integer, Artwork> artCollection = new HashMap<>();

    public static void add(Artwork artwork) {
        artCollection.put(artwork.getId(), artwork);
    }

    public static Artwork findById(int id) {
        return artCollection.get(id);
    }

    public static Collection<Artwork> getAll() {
        return artCollection.values();
    }

    public static void remove(int id) {
        artCollection.remove(id);
    }

}
