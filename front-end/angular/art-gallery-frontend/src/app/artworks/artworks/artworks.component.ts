import { Component, OnInit } from '@angular/core';
import { Artist } from 'src/app/classes/artist';
import { Artwork } from 'src/app/classes/artwork';
import { ArtworkDetails } from 'src/app/classes/artwork-details';
import { Style } from 'src/app/classes/style';

@Component({
  selector: 'app-artworks',
  templateUrl: './artworks.component.html',
  styleUrls: ['./artworks.component.css']
})
export class ArtworksComponent implements OnInit {

  isLoading: boolean = true;

  artworks: Artwork[] = [];

  constructor() { }

  ngOnInit(): void {
    this.fetchArtworks();
  }

  async fetchArtworks() {

    let response = await fetch('http://localhost:8080/api/artworks');
    
    let payload: Artwork[] = await response.json();

    payload.forEach(obj => {
      let artist = new Artist(obj.artist.id, obj.artist.firstName, obj.artist.lastName, obj.artist.location);
      let styles: Style[] = [];
      obj.styles.forEach(style => {
        styles.push(new Style(style.id, style.name));
      })
      let details = new ArtworkDetails(obj.details.id, obj.details.media, obj.details.yearCreated, obj.details.description, obj.details.width, obj.details.height, obj.details.depth, obj.details.imageId)
      let artwork = new Artwork(obj.id, obj.title, artist, styles, details);
      this.artworks.push(artwork);
    });

    this.artworks.sort(
      (a1, a2) => 
      (a1.title < a2.title) ? 1 : (a1.title > a2.title) ? -1 : 0);

    this.isLoading = false;

  }

}
