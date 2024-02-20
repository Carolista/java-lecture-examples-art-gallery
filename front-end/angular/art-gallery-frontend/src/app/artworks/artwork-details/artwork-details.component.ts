import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Artist } from 'src/app/classes/artist';
import { Artwork } from 'src/app/classes/artwork';
import { ArtworkDetails } from 'src/app/classes/artwork-details';
import { Style } from 'src/app/classes/style';

@Component({
  selector: 'app-artwork-details',
  templateUrl: './artwork-details.component.html',
  styleUrls: ['./artwork-details.component.css']
})
export class ArtworkDetailsComponent implements OnInit {

  isLoading: boolean = true;

  id: string | null = "0";

  artwork: Artwork = new Artwork(0, "", new Artist(0, "", "", ""), [], new ArtworkDetails(0, "", "", "", 0, 0, 0, ""));

  constructor(private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get("id");
    this.fetchArtwork();
  }

  async fetchArtwork() {

    let response = await fetch('http://localhost:8080/api/artworks/' + this.id);
    
    let obj: Artwork = await response.json();

    let artist = new Artist(obj.artist.id, obj.artist.firstName, obj.artist.lastName, obj.artist.location);
    let styles: Style[] = [];
    obj.styles.forEach(style => {
      styles.push(new Style(style.id, style.name));
    })
    let details = new ArtworkDetails(obj.details.id, obj.details.media, obj.details.yearCreated, obj.details.description, obj.details.width, obj.details.height, obj.details.depth, obj.details.imageId)
    this.artwork = new Artwork(obj.id, obj.title, artist, styles, details);

    this.isLoading = false;

  }

}
