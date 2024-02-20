import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ArtworkDetailsComponent } from './artworks/artwork-details/artwork-details.component';
import { ArtworksComponent } from './artworks/artworks/artworks.component';

const routes: Routes = [
  {path: 'artworks', component: ArtworksComponent},
  {path: 'artworks/:id', component: ArtworkDetailsComponent},
  {path: '', redirectTo: 'artworks', pathMatch: 'full'},
  {path: '**', redirectTo: 'artworks', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
