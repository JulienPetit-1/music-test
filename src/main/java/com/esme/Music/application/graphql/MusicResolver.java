package com.esme.Music.application.graphql;

import com.esme.Music.domain.Artist.Artist;
import com.esme.Music.domain.Artist.ArtistService;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLQuery;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component

public class MusicResolver {

    private ArtistService artistService;

    public MusicResolver(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GraphQLQuery
    public List<Artist> getArtists(@GraphQLArgument(name = "first", defaultValue = "null" ) Integer first) {
        if (Objects.isNull(first)){
        return artistService.findArtists();
        }
    return artistService.findArtists()
                .stream()
                .limit(first)
                .collect(Collectors.toList());
    }
}

