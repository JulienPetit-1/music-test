package com.esme.Music.application;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MusicController {
    private List<String> musics = Arrays.asList("Travis Scott", "Pink Floyd", "PNL");

    @RequestMapping(value = "/musics", method = RequestMethod.GET)
    public ResponseEntity<List<String>> getMusics () {
        return new ResponseEntity<>(this.musics, HttpStatus.OK );
    }
}
