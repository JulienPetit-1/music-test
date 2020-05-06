package com.esme.Music.application.Rappels;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;


@Service
@ToString
@Slf4j

public class MusicService {
    public static void printMusic() {
        log.info(Musics.builder()
                .name("SICKO MODE")
                .artist("Travis Scott")
                .album("Astroworld")
                .genre("Hip-Hop/Rap")
                .note(4)
                .feat("Drake")
                .BPM(155)
                .release_date(LocalDate.of(2018, Month.AUGUST, 03))
                .build()
                .toString());
    }
}
