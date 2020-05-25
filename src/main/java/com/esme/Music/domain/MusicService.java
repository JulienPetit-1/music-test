package com.esme.Music.domain;

import com.esme.Music.infrastructure.MusicDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class MusicService {

    private MusicDao musicDao;

    public MusicService(MusicDao musicDao){
        this.musicDao = musicDao;
    }

    public List<Music> findMusics(){
        return musicDao.getMusics();
    }

    @Cacheable("musics")
    public Music getMusics(Long id) throws NotFoundException {
        return musicDao.findMusics(id);
    }

    public Music addMusics(Music music) {
        return musicDao.addMusic(music);
    }

    public void deleteMusic(Long id) {
        musicDao.deleteMusic(id);
    }

    public void updateMusic(Music music) {
        musicDao.updateMusic(music);
    }

}
