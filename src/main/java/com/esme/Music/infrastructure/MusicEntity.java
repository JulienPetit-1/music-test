package com.esme.Music.infrastructure;

import lombok.*;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDate;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity

//Table BDD
public class MusicEntity {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "Name", length=50, nullable = false)
    private String name;
    @Column(name = "Album", nullable = false)
    private String album;
    @Column(name = "Genre", length=50, nullable = false)
    private String genre;
    @Column(name = "Note")
    private Integer note;
    @Column(name = "Feat", length=50)
    private String feat;
    @Column(name = "Duration", nullable = false)
    private Duration duration;
    @Column(name = "BPM")
    private Integer BPM;
    @Column(name = "Release_Date")
    private LocalDate release_date;

//    @ManyToOne
//    private AlbumEntity albumEntity;
    @ManyToOne
    private ArtistEntity artistEntity;
}
