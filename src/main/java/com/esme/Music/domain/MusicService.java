package com.esme.Music.domain;

import com.esme.Music.infrastructure.MusicDao;
import com.esme.Music.infrastructure.MusicRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService {

    private MusicDao musicDao;

    public MusicDao(MusicRepository musicRepository){
        this.musicDao = musicDao;
    }

    public List<Music> consultMusics(){
        return musicDao.getMusics();
    }

}
