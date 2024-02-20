import Card from "./Card";

const Artworks = ({ artworks }) => {

  let artworksJSX = Object.values(artworks).map(artwork => {
      return (     
        <a href={'/artworks/' + artwork.id} key={artwork.id}>
          <Card artwork={artwork} />
        </a>
      );
    });

  return (
    <main>
      <h1>Artworks</h1>
      <div className="artwork-container" >
        {artworksJSX}
      </div>
      
    </main>
  );
}

export default Artworks;