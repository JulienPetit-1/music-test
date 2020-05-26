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
    private Long id;
    private String name;
    private Artist artist;
    private String album;
    private String genre;
    private Integer note;
    private String feat;
    private Duration duration;
    private Integer BPM;
    private LocalDate release_date;
}

