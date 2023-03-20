package com.launchcode.artgallery.data;

import com.launchcode.artgallery.models.Style;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StyleRepository extends CrudRepository<Style, Integer> {
}
