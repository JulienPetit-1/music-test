package com.esme.Music.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

//Rest Controller

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class MusicController {
    private ArrayList<String> musics = new ArrayList();

    public MusicController() {
        this.musics.add("Travis Scott");
        this.musics.add("Pink Floyd");
        this.musics.add("PNL");
    }

    @RequestMapping(value = "/musics", method = RequestMethod.GET)
    public ResponseEntity<ArrayList<String>> getMusics() {
        return new ResponseEntity<ArrayList<String>>(this.musics, HttpStatus.OK);
    }

    @RequestMapping(value = "/musics", method = RequestMethod.POST)
    public ResponseEntity<String> addMusics(String name) {
        this.musics.add(name);
        log.info("Artist created :" + name);
        return new ResponseEntity<String>("Artist created from POST : " + name, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/musics/{name}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteMusics(@PathVariable String name) {
        this.musics.remove(name);
        log.info("animal with name :" + name + " is deleted");
        return new ResponseEntity<String>("Artist deleted from DELETE : " + name, HttpStatus.OK);
    }

    @RequestMapping(value = "/musics", method = RequestMethod.PUT)
    public ResponseEntity<String> putMusics(@RequestBody ArrayList<String> musics) {
        this.musics = musics;
        return new ResponseEntity<String>("List changed from PUT : " + musics, HttpStatus.OK);
    }

    @RequestMapping(value = "/musics/{name}", method = RequestMethod.PATCH)
    public ResponseEntity<String> patchMusics(@PathVariable String name, String newname) {
        this.musics.set(this.musics.indexOf(name), newname);
        log.info("animal with id :" + name + " is now :" + newname);
        return new ResponseEntity<String>("Artist "+ name + " replace by " + newname + " from PATCH ", HttpStatus.OK);
    }
}


