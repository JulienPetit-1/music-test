package com.esme.Music.infrastructure;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ArtistRepository extends CrudRepository<ArtistEntity, Long> {
}
