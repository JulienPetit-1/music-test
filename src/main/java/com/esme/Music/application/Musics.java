package com.esme.Music.application;


import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.UUID;

class Album{
    public UUID id;
    public Artist artist;
    public String name_album;
    public LocalDate release_date;
    public Integer nb_tracks;
    public Integer duration;
    public Integer fans;
    public String label;
    public Boolean disponibility;
}

class Artist{
    public UUID id;
    public String name;
    public Integer nb_fans;
    public Integer nb_albums;
}
public class Musics implements Serializable {
    public UUID id;
    public String name;
    public Artist artist;
    public Album album;
    public String genre;
    public Integer note;
    public String feat;
    public SimpleDateFormat duration;
    public Integer BPM;
    public LocalDate release_date;

}
