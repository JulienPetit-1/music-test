package com.esme.Music.domain;

import lombok.*;

@Getter
@ToString
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Artist {
    public Long id;
    public String name_artist;
    public Integer nb_fans;
    public Integer nb_albums;
}
