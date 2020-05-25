package com.esme.Music.application.graphql;

import com.esme.Music.domain.Music;
import com.esme.Music.domain.MusicService;
import io.leangen.graphql.annotations.GraphQLQuery;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public class MusicResolver {

    private MusicService musicService;

    public MusicResolver(MusicService musicService) {
        this.musicService = musicService;
    }

    @GraphQLQuery
    public List<Music> getMusics() {
        return musicService.findMusics();
    }
}

