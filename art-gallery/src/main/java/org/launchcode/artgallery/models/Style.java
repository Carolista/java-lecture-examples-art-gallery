package org.launchcode.artgallery.models;

public enum Style {

    ABSTRACT_PHOTOGRAPHY("Abstract Photography"),
    ABSTRACT_REALISM("Abstract Realism"),
    ABSTRACT_SCULPTURE("Abstract Sculpture"),
    ASTROPHOTOGRAPHY("Astrophotography"),
    CARTOON("Cartoon"),
    DIGITAL_ILLUSTRATION("Digital Illustration"),
    FIGURE_PAINTING("Figure Painting"),
    FUTURISM("Futurism"),
    INK_ILLUSTRATION("Ink Illustration"),
    LANDSCAPE_PHOTOGRAPHY("Landscape Photography"),
    MAXIMALIST_PHOTOGRAPHY("Maximalist Photography"),
    PENCIL_ILLUSTRATION("Pencil Illustration"),
    PHOTOREALISM("Photorealism"),
    POETRY("Poetry"),
    REALISM("Realism"),
    STREET_PHOTOGRAPHY("Street Photography");

    private final String displayName;

    Style(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
