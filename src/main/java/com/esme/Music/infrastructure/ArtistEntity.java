package com.esme.Music.infrastructure;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Getter
@ToString
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity

//Table BDD
public class ArtistEntity {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "Name", length=50, nullable = false)
    private String name_artist;
    @Column(name = "Number of fans", nullable = false)
    private Integer nb_fans;
    @Column(name = "Number of albums", nullable = false)
    private Integer nb_albums;

    @ManyToOne
    private LabelEntity labelEntity;
    @OneToMany(mappedBy = "artistEntity", cascade = CascadeType.ALL, orphanRemoval = true , fetch = FetchType.EAGER)
    private List<AlbumEntity> albumEntities;
    @OneToMany(mappedBy = "artistEntity", cascade = CascadeType.ALL, orphanRemoval = true , fetch = FetchType.EAGER)
    private List<MusicEntity> musicEntities;
}
