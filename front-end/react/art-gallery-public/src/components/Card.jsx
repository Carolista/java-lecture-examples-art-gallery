const Card = ({ artwork }) => {

  return (
    <div className="card artwork-card">
      <img className="card-image" src={artwork.details.getImageURL()} />
      <h5>{artwork.title}</h5>
      <p>{artwork.artist.getFullName()} ({artwork.details.yearCreated})</p> 
    </div>
  )
}

export default Card;