package com.esme.Music.domain;

import com.esme.Music.infrastructure.ArtistDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ArtistService {

    private ArtistDao artistDao;

    public ArtistService(ArtistDao artistDao){
        this.artistDao = artistDao;
    }

    public List<Artist> findArtists(){
        return artistDao.getArtists();
    }

    @Cacheable("artists")
    public Artist getArtists(Long id) throws NotFoundException {
        return artistDao.findArtists(id);
    }

    public Artist addArtist(Artist artist) throws NotFoundException {
        return artistDao.addArtist(artist);
    }

    public void deleteArtist(Long id) {
        artistDao.deleteArtist(id);
    }

    public Artist updateArtist(Artist artist){ return artistDao.replaceArtist(artist); }

    public void patchArtist(Artist artist) { artistDao.replaceArtist(artist); }

}
