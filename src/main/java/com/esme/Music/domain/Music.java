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

public class Music {
    public Long id;
    public String name;
    public Artist artist;
    public Album album;
    public String genre;
    public Integer note;
    public String feat;
    public SimpleDateFormat duration;
    public Integer BPM;
    public LocalDate release_date;
}

