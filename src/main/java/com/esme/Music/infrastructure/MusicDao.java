package com.esme.Music.infrastructure;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicDao {

    private MusicRepository musicRepository;

    public MusicDao(MusicRepository musicRepository){
        this.musicRepository = musicRepository;
    }
    public List<MusicEntity> getMusics(){
        return  musicRepository.findAll();
    }
}

