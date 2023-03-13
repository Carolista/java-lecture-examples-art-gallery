package com.launchcode.artgallery.models;

public enum Style {

    ARCHITECTURAL_SCULPTURE("Architectural Sculpture"),
    ABSTRACT("Abstract Photography"),
    ASTROPHOTOGRAPHY("Astrophotography"),
    DIGITAL_ILLUSTRATION("Digital Illustration"),
    INK_ILLUSTRATION("Ink Illustration"),
    LANDSCAPE_PHOTOGRAPHY("Landscape Photography"),
    MAXIMALIST_PHOTOGRAPHY("Maximalist Photography"),
    REALISM("Realism");

    private final String displayName;

    Style(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
