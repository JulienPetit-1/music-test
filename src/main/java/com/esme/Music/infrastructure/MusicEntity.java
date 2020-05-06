package com.esme.Music.infrastructure;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Getter
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
}
