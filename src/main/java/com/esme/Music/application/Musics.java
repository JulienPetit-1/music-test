package com.esme.Music.application;


import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

class Album{
    public UUID id;
    public Artist artist;
    public String name_album;
    public Date release_date;
    public Integer nb_tracks;
    public Integer duration;
    public Integer fans;
    public String label;
}

class Artist{
    public UUID id;
    public String name;
    public Integer nb_fans;
    public Integer nb_albums;
}
public class Musics implements Serializable {
    public UUID id;
    public Artist artist;
    public Album album;
    public String genre;
    public Integer note;
    public String feat;
    public Integer duration;
    public Integer BPM;

}
