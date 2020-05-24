package com.esme.Music.infrastructure;

import com.esme.Music.domain.Artist;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.text.SimpleDateFormat;
import java.time.LocalDate;


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
    @Column(name = "Artist", nullable = false)
    private Artist artist;
    @Column(name = "Name", length=50, nullable = false)
    private String name_album;
    @Column(name = "Release Date", nullable = false)
    private LocalDate release_date;
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
}
