import React, { useEffect, useState } from "react";
import { Routes, Route, Navigate } from "react-router-dom"
import { Artworks, Details, Header } from "./components/exports";
import { Artist, Artwork, ArtworkDetails, Style } from "./classes/exports";
import './App.css'
import Loading from "./components/Loading";

function App() {

  const [loading, setLoading] = useState(true);
  const [allArtworks, setAllArtworks] = useState({});

  const fetchArtworks = async () => {
    
    let artworks = {};
    
    let response = await fetch('http://localhost:8080/api/artworks');
    let data = await response.json();

    data.forEach(obj => {
      let artist = new Artist(obj.artist.id, obj.artist.firstName, obj.artist.lastName, obj.artist.location);
      let styles = [];
      obj.styles.forEach(style => {
        styles.push(new Style(style.id, style.name));
      })
      let details = new ArtworkDetails(obj.details.id, obj.details.media, obj.details.yearCreated, obj.details.description, obj.details.width, obj.details.height, obj.details.depth, obj.details.imageId)
      let artwork = new Artwork(obj.id, obj.title, artist, styles, details);
      artworks[artwork.id] = artwork;
    });

    setAllArtworks(artworks);
  };

  useEffect(() => {
    fetchArtworks();
  }, []);

  useEffect(() => {
    if (Object.values(allArtworks).length > 0) {
      setLoading(false);
    }
  }, [allArtworks]);
  
  return (
    <React.StrictMode>
      <Header />
      {loading && <Loading />}
      {!loading && <Routes>
        <Route path="/" element={ <Artworks artworks={allArtworks} /> } />
        <Route path="/artworks" element={ <Artworks artworks={allArtworks} /> } />
        <Route path="artworks/:id" element={ <Details artworks={allArtworks} /> } />
        <Route path="*" element={<Navigate to="/" />} />
      </Routes>}
    </React.StrictMode>
  )
}

export default App
