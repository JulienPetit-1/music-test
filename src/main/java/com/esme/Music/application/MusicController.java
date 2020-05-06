package com.esme.Music.application;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

//Rest Controller

@RestController
@RequestMapping("/api/v1")
public class MusicController {
    private ArrayList<String> musics = new ArrayList();

    public MusicController() {
        this.musics.add("Travis Scott");
        this.musics.add("Pink Floyd");
        this.musics.add("PNL");
    }

//Méthode GET
    @RequestMapping(value = "/musics", method = RequestMethod.GET)
    public ResponseEntity<ArrayList<String>> getMusics() {
        return new ResponseEntity<ArrayList<String>>(this.musics, HttpStatus.OK);
    }

//Méthode POST
    @RequestMapping(value = "/musics", method = RequestMethod.POST)
    public ResponseEntity<String> addMusics(String name) {
        this.musics.add(name);
        return new ResponseEntity<String>("Response from POST", HttpStatus.OK);
    }

//Méthode DELETE
    @RequestMapping(value = "/musics/{name}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteMusics(@PathVariable String name) {
        this.musics.remove(name);
        return new ResponseEntity<String>("Response from DELETE", HttpStatus.OK);
    }

//Méthode PUT
    @RequestMapping(value = "/musics", method = RequestMethod.PUT)
    public ResponseEntity<String> putMusics(@RequestBody ArrayList<String> musics) {
        this.musics = musics;
        return new ResponseEntity<String>("Response from PUT", HttpStatus.OK);
    }

//Méthode PATCH
    @RequestMapping(value = "/musics/{name}", method = RequestMethod.PATCH)
    public ResponseEntity<String> patchMusics(@PathVariable String name,  String newname) {
        this.musics.set(this.musics.indexOf(name), newname);
        return new ResponseEntity<String>("Response from PATCH", HttpStatus.OK);
    }
}


