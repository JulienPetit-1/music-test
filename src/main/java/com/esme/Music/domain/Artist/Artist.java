package com.esme.Music.domain.Artist;

import com.esme.Music.domain.Music.Music;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Artist {
    private Long id;
    private String name_artist;
    private Integer nb_fans;
    private Integer nb_albums;
    private List<Music> musics;
}


