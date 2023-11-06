package org.launchcode.artgallery.data;

import org.launchcode.artgallery.models.Style;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StyleRepository extends CrudRepository<Style, Integer> {
}
