package com.esme.Music.application;

import com.esme.Music.domain.Music.Music;
import com.esme.Music.domain.Music.MusicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Rest Controller

@RestController
@RequestMapping("/api/v1")
@Api("API de gestion d'une librairie musicale")

public class MusicController {

    private MusicService musicService;

    public MusicController(MusicService musicService) {
        this.musicService = musicService;
    }


    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the ressource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })

//Méthode GET

    @RequestMapping(value = "/artists/{id}/musics", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<Music>> getArtists(@PathVariable(value = "id") Long artistId) {
        return new ResponseEntity<List<Music>>(musicService.findMusicsByArtistId(artistId), HttpStatus.OK);
    }

    //Méthode POST
    @RequestMapping(value = "/artists/{id}/musics", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Music> addMusics(@PathVariable(value = "id") Long artistId, @RequestBody Music music) {
        music = musicService.addMusics(artistId, music);
        return new ResponseEntity<>(music, HttpStatus.CREATED);
    }

}

////Méthode DELETE
//    @RequestMapping(value = "/artists/{id}", method = RequestMethod.DELETE)
//    @CrossOrigin(origins = "http://localhost:4200")
//    public ResponseEntity<Artist> deleteArtists(@PathVariable(value = "id") Long id) {
//        artistService.deleteArtist(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
////Méthode PUT
//    @RequestMapping(value = "/artists/{id}", method = RequestMethod.PUT)
//    public ResponseEntity<Artist> putArtists(@PathVariable(value = "id") Long id, @RequestBody Artist artist) throws NotFoundException{
//        artist.setId(id);
//        artist = artistService.updateArtist(artist);
//        return new ResponseEntity<>(artist, HttpStatus.OK);
//    }
//
////Méthode PATCH
//    @RequestMapping(value = "/artists/{id}", method = RequestMethod.PATCH, consumes = "application/json")
//    public ResponseEntity<String> patchArtist(
//            @PathVariable(value = "id") Long id,
//            @RequestBody JsonPatch patch)  {
//        try {
//            artistService.patchArtist(applyPatchToCustomer(patch, artistService.getArtists(id)));
//            return new ResponseEntity<>(HttpStatus.OK);
//        } catch (NotFoundException e) {
//            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//        } catch (JsonPatchException | JsonProcessingException e) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    private Artist applyPatchToCustomer(JsonPatch patch, Artist targetArtist ) throws JsonPatchException, JsonProcessingException {
//        JsonNode patched = patch.apply(objectMapper.convertValue(targetArtist, JsonNode.class));
//        return objectMapper.treeToValue(patched, Artist.class);
//    }
//}


