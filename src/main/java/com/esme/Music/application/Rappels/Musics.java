package com.esme.Music.application.Rappels;

import lombok.*;

import java.time.LocalDate;

@ToString
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter


public class Musics {
    private String name;
    private String artist;
    private String album;
    private String genre;
    private Integer note;
    private String feat;
    private Integer BPM;
    private LocalDate release_date;
}


