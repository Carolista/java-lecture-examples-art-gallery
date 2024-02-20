export default class ArtworkDetails {

  constructor(id, media, yearCreated, description, width, height, depth, imageId) {
    this.id  = id;
    this.media = media;
    this.yearCreated = yearCreated;
    this.description = description;
    this.width = width;
    this.height = height;
    this.depth = depth;
    this.imageId = imageId;
  }
  
  getDimensions() {
    let widthFormatted = this.width > 0 ? this.width + '"W' : "";
    let heightFormatted = this.height > 0 ? " x " + this.height + '"H' : "";
    let depthFormatted = this.depth > 0 ? " x " + this.depth + '"D' : "";
    return widthFormatted + heightFormatted + depthFormatted;
  }

  getImageURL() {
    return "https://drive.google.com/thumbnail?sz=w1000&id=" + this.imageId;
  }
}
