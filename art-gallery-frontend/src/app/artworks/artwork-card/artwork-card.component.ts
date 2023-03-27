import { Component, Input, OnInit } from '@angular/core';
import { Artist } from 'src/app/classes/artist';
import { Artwork } from 'src/app/classes/artwork';
import { ArtworkDetails } from 'src/app/classes/artwork-details';

@Component({
  selector: 'app-artwork-card',
  templateUrl: './artwork-card.component.html',
  styleUrls: ['./artwork-card.component.css']
})
export class ArtworkCardComponent implements OnInit {

  @Input() artwork: Artwork = new Artwork(0, "", new Artist(0, "", "", ""), [], new ArtworkDetails(0, "", "", "", 0, 0, 0, ""));

  constructor() { }

  ngOnInit(): void {
  }


}
