package com.esme.Music.domain;


import lombok.*;

import java.time.Duration;
import java.time.LocalDate;

@Getter
@ToString
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Music {
    public Long id;
    public String name;
    public Artist artist;
    public Album album;
    public String genre;
    public Integer note;
    public String feat;
    public Duration duration;
    public Integer BPM;
    public LocalDate release_date;
}

