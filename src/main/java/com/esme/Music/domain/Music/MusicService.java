package com.esme.Music.domain.Music;

import com.esme.Music.infrastructure.MusicDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class MusicService {

    private MusicDao musicDao;

    public MusicService(MusicDao musicDao) {
        this.musicDao = musicDao;
    }

    public Music addMusics(Long artistId, Music music) {
        return musicDao.addMusics(artistId, music);
    }

    public List<Music> findMusicsByArtistId(Long artistId) {
        return musicDao.findMusicsByArtistId(artistId);
    }

}
