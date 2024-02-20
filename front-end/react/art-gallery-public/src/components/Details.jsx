import { useParams } from "react-router-dom";

const Details = ({ artworks }) => {

  const { id } = useParams();

  const artwork = artworks[id];

  return (
    <main>
      <p><a href="/artworks">&larr; Back to Artworks Gallery View</a></p>
      <h2>ARTWORK DETAILS</h2>
      <div className="container">
        <div className="row">
          <div className="col-6">
            <img className="card-image" src={artwork.details.getImageURL()} /> 
          </div>
          <div className="col-6">
            <h4 className="mb-4 mt-2 font-bold">{artwork.title + " (" + artwork.details.yearCreated + ")"}</h4>
            <>
              <h5>Artist</h5>
              <p>{artwork.artist.getFullName()} &mdash; {artwork.artist.location}</p>       
            </>
            {artwork.details.description != '' && <>
              <h5>Description</h5>
              <p>{artwork.details.description}</p> 
            </>}
            <>
              <h5>{artwork.styles.length === 1 ? 'Style' : 'Styles'}</h5>
              <p>{artwork.getFormattedStyles()}</p> 
            </>
            {artwork.details.media != '' && <>
              <h5>Media</h5>
              <p>{artwork.details.media}</p> 
            </>}
            {artwork.details.getDimensions() != '' && <>
              <h5>Dimensions</h5>
              <p>{artwork.details.getDimensions()}</p> 
            </>}
          </div>
        </div>
      </div>
    </main>
  )
};

export default Details;