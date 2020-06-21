package com.esme.Music.domain.Music;


import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Music {
    private Long id;
    private String name;
    private String artist;
    private String album;
    private String genre;
    private Integer note;
    private String feat;
    private String duration;
    private Integer BPM;
    private String release_date;
}

