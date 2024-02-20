package org.launchcode.artgallery.data;

import org.launchcode.artgallery.models.Artwork;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtworkRepository extends CrudRepository<Artwork, Integer> {
}
