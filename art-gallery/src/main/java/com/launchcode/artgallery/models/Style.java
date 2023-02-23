package com.launchcode.artgallery.models;

public enum Style {

    ART_NOUVEAU("Art Nouveau"),
    BAROQUE("Baroque"),
    IMPRESSIONISM("Impressionism"),
    POINTILLISM("Pointillism"),
    RENAISSANCE("Renaissance");

    private final String displayName;

    Style(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
