package com.esme.Music.domain;

import lombok.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

@Getter
@ToString
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Album {
    public Long id;
    public Artist artist;
    public String name_album;
    public LocalDate release_date;
    public Integer nb_tracks;
    public SimpleDateFormat duration;
    public Integer fans;
    public String label;
    public Boolean disponibility;
}
