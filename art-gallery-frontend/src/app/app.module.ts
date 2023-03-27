import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ArtworksComponent } from './artworks/artworks/artworks.component';
import { HeaderComponent } from './header/header.component';
import { ArtworkDetailsComponent } from './artworks/artwork-details/artwork-details.component';
import { ArtworkCardComponent } from './artworks/artwork-card/artwork-card.component';

@NgModule({
  declarations: [
    AppComponent,
    ArtworksComponent,
    HeaderComponent,
    ArtworkDetailsComponent,
    ArtworkCardComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
