package com.esme.Music.application;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

//Return Code Controller

@RestController
@RequestMapping("/api/codes")
public class ReturnCodeController {
    private ArrayList<String> musics = new ArrayList();

    public ReturnCodeController() {
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
        return new ResponseEntity<String>("Response from POST", HttpStatus.OK);
    }

    @RequestMapping(value = "/musics/{name}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteMusics(@PathVariable String name) {
        this.musics.remove(name);
        return new ResponseEntity<String>("Response from DELETE", HttpStatus.OK);
    }

    @RequestMapping(value = "/musics", method = RequestMethod.PUT)
    public ResponseEntity<String> putMusics(@RequestBody ArrayList<String> musics) {
        this.musics = musics;
        return new ResponseEntity<String>("Response from PUT", HttpStatus.OK);
    }

    @RequestMapping(value = "/musics/{name}", method = RequestMethod.PATCH)
    public ResponseEntity<String> patchMusics(@PathVariable String name,  String newname) {
        this.musics.set(this.musics.indexOf(name), newname);
        return new ResponseEntity<String>("Response from PATCH", HttpStatus.OK);
    }
}
