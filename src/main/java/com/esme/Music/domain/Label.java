package com.esme.Music.domain;

import lombok.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

@Getter
@ToString
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Label {
    public Long id;
    public String name_label;
    public ArrayList artist;
    public String genre;
    public Integer note;
    public String feat;
    public SimpleDateFormat duration;
    public Integer BPM;
    public LocalDate release_date;
}
