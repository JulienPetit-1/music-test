package com.esme.Music.application;

import com.esme.Music.domain.Music;
import com.esme.Music.domain.MusicService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

//Rest Controller

@RestController
@RequestMapping("/api/v1")
public class MusicController {

    private MusicService musicService;

    public MusicController(MusicService musicService) {
        this.musicService = musicService;
    }

<<<<<<< Updated upstream
=======
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the ressource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })

//Méthode GET
>>>>>>> Stashed changes
    @RequestMapping(value = "/musics", method = RequestMethod.GET)
    public ResponseEntity<List<Music>> getMusics() {
        return new ResponseEntity<>(musicService.findMusics(), HttpStatus.OK);
    }

//méthode GET by ID

    @RequestMapping(value = "/musics/{id}", method = RequestMethod.GET)
    public ResponseEntity<Music> getMusicsById(@PathVariable(value = "id") Long id) {
        try {
            return new ResponseEntity<>(musicService.getMusics(id), HttpStatus.OK);
        } catch (NotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Music Not Found", e);
        }
    }

    @RequestMapping(value = "/musics", method = RequestMethod.POST)
    public ResponseEntity<Music> addMusics(@RequestBody Music music) {
        musicService.addMusics(music);
        return new ResponseEntity<>(music, HttpStatus.CREATED);
    }

<<<<<<< Updated upstream
    @RequestMapping(value = "/musics/{name}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteMusics(@PathVariable String name) {
        this.musics.remove(name);
        return new ResponseEntity<String>("Response from DELETE", HttpStatus.OK);
=======
//Méthode DELETE
    @RequestMapping(value = "/musics/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Music> deleteMusics(@PathVariable(value = "id") Long id) {
        musicService.deleteMusic(id);
        return new ResponseEntity<>(HttpStatus.OK);
>>>>>>> Stashed changes
    }

    @RequestMapping(value = "/musics", method = RequestMethod.PUT)
<<<<<<< Updated upstream
    public ResponseEntity<String> putMusics(@RequestBody ArrayList<String> musics) {
        this.musics = musics;
        return new ResponseEntity<String>("Response from PUT", HttpStatus.OK);
    }

    @RequestMapping(value = "/musics/{name}", method = RequestMethod.PATCH)
    public ResponseEntity<String> patchMusics(@PathVariable String name,  String newname) {
        this.musics.set(this.musics.indexOf(name), newname);
        return new ResponseEntity<String>("Response from PATCH", HttpStatus.OK);
=======
    public ResponseEntity<Music> putMusics(@RequestBody Music music) {
        musicService.updateMusic(music);
        return new ResponseEntity<>(music, HttpStatus.OK);
>>>>>>> Stashed changes
    }
}


