package com.esme.Music.application.graphql;

import com.esme.Music.domain.Artist;
import com.esme.Music.domain.ArtistService;
import io.leangen.graphql.annotations.GraphQLQuery;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public class MusicResolver {

    private ArtistService artistService;

    public MusicResolver(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GraphQLQuery
    public List<Artist> getArtists() {
        return artistService.findArtists();
    }
}

