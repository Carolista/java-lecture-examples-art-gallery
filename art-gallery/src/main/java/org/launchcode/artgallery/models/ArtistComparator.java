package org.launchcode.artgallery.models;

import java.util.Comparator;

public class ArtistComparator implements Comparator<Artist> {

    @Override
    public int compare(Artist a1, Artist a2) {
        return a1.getLastName().compareTo(a2.getLastName());
    }
}
