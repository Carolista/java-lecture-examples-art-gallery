import { Artist } from "./artist";
import { ArtworkDetails } from "./artwork-details";
import { Style } from "./style";

export class Artwork {

  id: number;
  title: string;
  artist: Artist;
  styles: Style[];
  details: ArtworkDetails;

  constructor(id: number, title: string, artist: Artist, styles: Style[], details: ArtworkDetails) {
    this.id = id;
    this.title = title;
    this.artist = artist; 
    this.styles = styles;
    this.details = details;
  }

  getFormattedStyles(): string {
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
