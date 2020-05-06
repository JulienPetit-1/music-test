package com.esme.Music.application;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

// Exception Controller

@RestController
@RequestMapping("/api/v2")
public class ExceptionController {
    private ArrayList<String> musics = new ArrayList();

    public ExceptionController() {
        this.musics.add("v2Travis Scott"); //On rajoute un préfixe v2 pour vérifier les résultats dans PostMan
        this.musics.add("v2Pink Floyd");
        this.musics.add("v2PNL");
    }

//Méthode GET
    @RequestMapping(value = "/musics", method = RequestMethod.GET)
    public ResponseEntity<ArrayList<String>> getMusics() {
        //return new ResponseEntity<ArrayList<String>>(this.musics, HttpStatus.OK); Ancien Code
        throw new NullPointerException("Server error"); //Cette fois ci, on renvoie une exception
    }

//Méthode POST
    @RequestMapping(value = "/musics", method = RequestMethod.POST)
    public ResponseEntity<String> addMusics(String name) throws Exception {
        this.musics.add(name);
        throw new Exception("Internal server error");
    }

//Méthode DELETE
    @RequestMapping(value = "/musics/{name}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteMusics(@PathVariable String name) throws Exception {
        this.musics.remove(name);
        throw new Exception("Ressource not found");
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
