package com.esme.Music.infrastructure;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Artist_Entity")

//Table BDD
public class ArtistEntity {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "Name_artist", length = 100, nullable = false)
    private String name_artist;
    @Column(name = "Number_of_fans", nullable = false)
    private Integer nb_fans;
    @Column(name = "Number_of_albums", nullable = false)
    private Integer nb_albums;

//    @ManyToOne
//    private LabelEntity labelEntity;
//    @OneToMany(mappedBy = "artistEntity", cascade = CascadeType.ALL, orphanRemoval = true , fetch = FetchType.EAGER)
//    private List<AlbumEntity> albumEntities;
    @OneToMany(mappedBy = "artistEntity", cascade = CascadeType.ALL)
    private List<MusicEntity> musicEntities;
}
