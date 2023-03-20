package com.launchcode.artgallery.models;

import java.util.Comparator;

public class StyleComparator implements Comparator<Style> {

    @Override
    public int compare(Style s1, Style s2) {
        return s1.getName().compareTo(s2.getName());
    }
}
