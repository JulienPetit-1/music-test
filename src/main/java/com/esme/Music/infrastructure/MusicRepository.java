package com.esme.Music.infrastructure;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicRepository extends CrudRepository <MusicEntity, Long>{

    List<MusicEntity> findByArtistEntity(ArtistEntity artistEntity);

}
