package com.esme.Music.application;

import com.esme.Music.domain.Artist;
import com.esme.Music.domain.ArtistService;
import io.swagger.annotations.Api;
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
@Api("API de gestion d'une librairie musicale")

public class MusicController {

    private ArtistService artistService;

    public MusicController(ArtistService artistService) {
        this.artistService = artistService;
    }


    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the ressource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })

//Méthode GET

    @RequestMapping(value = "/artists", method = RequestMethod.GET)
    public ResponseEntity<List<Artist>> getArtists() {
        return new ResponseEntity<>(artistService.findArtists(), HttpStatus.OK);
    }

//méthode GET by ID

    @RequestMapping(value = "/artists/{id}", method = RequestMethod.GET)
    public ResponseEntity<Artist> getArtistsById(@PathVariable(value = "id") Long id) {
        try {
            return new ResponseEntity<>(artistService.getArtists(id), HttpStatus.OK);
        } catch (NotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Artist Not Found", e);
        }
    }
//Méthode POST
    @RequestMapping(value = "/artists", method = RequestMethod.POST)
    public ResponseEntity<Artist> addArtists(@RequestBody Artist artist) throws NotFoundException{
        artist = artistService.addArtist(artist);
        return new ResponseEntity<>(artist, HttpStatus.CREATED);
    }

//Méthode DELETE
    @RequestMapping(value = "/artists/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Artist> deleteArtists(@PathVariable(value = "id") Long id) {
        artistService.deleteArtist(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//Méthode PUT
    @RequestMapping(value = "/artists/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Artist> putArtist(@PathVariable(value = "id") Long id, @RequestBody Artist artist) {
        artist.setId(id);
        artistService.updateArtist(artist);
        return new ResponseEntity<>(artist, HttpStatus.OK);
    }
}


