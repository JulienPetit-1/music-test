package com.esme.Music.application;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

//Return Code Controller

@RestController
@RequestMapping("/api/v3") //On update le chemin de l'URI
public class ReturnCodeController {
    private ArrayList<String> musics = new ArrayList();

    public ReturnCodeController() {
        this.musics.add("v3Travis Scott"); //On modifie à nouveau les caractères
        this.musics.add("v3Pink Floyd");
        this.musics.add("v3PNL");
    }

//Méthode GET
    @RequestMapping(value = "/musics", method = RequestMethod.GET)
    public ResponseEntity<ArrayList<String>> getMusics() {
        return new ResponseEntity<ArrayList<String>>(this.musics, HttpStatus.BAD_REQUEST); //On change le code erreur
    }

//Méthode POST
    @RequestMapping(value = "/musics", method = RequestMethod.POST)
    public ResponseEntity<String> addMusics(String name) {
        this.musics.add(name);
        return new ResponseEntity<String>("Artist created from POST : " + name, HttpStatus.BAD_REQUEST);
    }

//Méthode DELETE
    @RequestMapping(value = "/musics/{name}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteMusics(@PathVariable String name) {
        this.musics.remove(name);
        return new ResponseEntity<String>("Artist deleted from DELETE : " + name, HttpStatus.BAD_REQUEST);
    }

//Méthode PUT
    @RequestMapping(value = "/musics", method = RequestMethod.PUT)
    public ResponseEntity<String> putMusics(@RequestBody ArrayList<String> musics) {
        this.musics = musics;
        return new ResponseEntity<String>("List changed from PUT : " + musics, HttpStatus.BAD_REQUEST);
    }

//Méthode PATCH
    @RequestMapping(value = "/musics/{name}", method = RequestMethod.PATCH)
    public ResponseEntity<String> patchMusics(@PathVariable String name,  String newname) {
        this.musics.set(this.musics.indexOf(name), newname);
        return new ResponseEntity<String>("Artist "+ name + " replace by " + newname + " from PATCH ", HttpStatus.BAD_REQUEST);
    }
}
