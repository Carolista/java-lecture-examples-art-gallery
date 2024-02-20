export default class Artwork {

  constructor(id, title, artist, styles, details) {
    this.id = id;
    this.title = title;
    this.artist = artist; // Artist object
    this.styles = styles; // array of Style objects
    this.details = details; // ArtworkDetails object
  }

  getFormattedStyles() {
    let styleNames = "";
    for (let i=0; i < this.styles.length; i++) {
        styleNames += this.styles[i].name;
        if (i < this.styles.length - 1) {
            styleNames += ", ";
        }
    }
    return styleNames;
  }

}