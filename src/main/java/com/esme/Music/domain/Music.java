package com.esme.Music.domain;


import lombok.*;

@Getter
@ToString
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Music {

    private Long id;
    private String name;
}
