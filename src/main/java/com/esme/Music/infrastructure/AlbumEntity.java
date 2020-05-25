package com.esme.Music.infrastructure;

import lombok.*;
import org.springframework.format.datetime.joda.LocalDateParser;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.List;


@Getter
@ToString
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity

//Table BDD
public class AlbumEntity {

    @Id
    @GeneratedValue
    private Long id;
//    @Column(name = "Artist", nullable = false)
//    private Artist artist;
//    @Column(name = "Name", length=50, nullable = false)
    private String name_album;
    @Column(name = "Release Date", nullable = false)
    private LocalDateParser release_date;
    @Column(name = "Number of tracks", nullable = false)
    private Integer nb_tracks;
    @Column(name = "Duration", nullable = false)
    private SimpleDateFormat duration;
    @Column(name = "Fans", nullable = false)
    private Integer fans;
    @Column(name = "Label", length = 50)
    private String label;
    @Column(name = "Disponibility")
    private Boolean disponibility;

    @ManyToOne
    private ArtistEntity artistEntity;
    @OneToMany(mappedBy = "albumEntity", cascade = CascadeType.ALL, orphanRemoval = true , fetch = FetchType.EAGER)
    private List<MusicEntity> musicEntities;
}
