package com.esme.Music.infrastructure;

import com.esme.Music.domain.Artist.Artist;
import com.esme.Music.domain.Music.Music;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Service
public class ArtistDao {

    private ArtistRepository artistRepository;
    private MusicRepository musicRepository;

    public ArtistDao(ArtistRepository artistRepository, MusicRepository musicRepository) {
        this.artistRepository = artistRepository;
        this.musicRepository = musicRepository;
    }

    public List<Artist> getArtists(){
        return StreamSupport.stream(artistRepository.findAll().spliterator(), false)
                .map(artistEntity -> buildArtist(artistEntity, musicRepository.findByArtistEntity(artistEntity)))
                .collect(Collectors.toList());
    }

    public Artist findArtists(Long id) throws NotFoundException {
        ArtistEntity artistEntity = artistRepository.findById(id).orElseThrow(NotFoundException::new);
        return buildArtist(artistEntity, musicRepository.findByArtistEntity(artistEntity));
    }

    public Artist addArtist(Artist artist) throws NotFoundException {
        ArtistEntity artistEntity = artistRepository.save(buildArtistEntity(artist));

        artist.getMusics()
                .stream()
                .forEach(music -> musicRepository.save(buildMusicEntity(artistEntity, music)));

        return buildArtist(artistRepository.findById(artistEntity.getId()).orElseThrow(NotFoundException::new), musicRepository.findByArtistEntity(artistEntity));
    }

    public void deleteArtist(Long id) {
        artistRepository.delete(artistRepository.findById(id).get());
    }

    public Artist replaceArtist(Artist artist){

        //ajouter ligne pour supprimer artiste remplacé

        ArtistEntity artistEntity = artistRepository.save(buildArtistEntity(artist));

        artist.getMusics()
                .stream()
                .forEach(music -> musicRepository.save(buildMusicEntity(artistEntity, music)));

        return buildArtist(artistEntity, musicRepository.findByArtistEntity(artistEntity));
    }

    private MusicEntity buildMusicEntity(ArtistEntity artistEntity, Music music) {
        return MusicEntity.builder()
                .id(music.getId())
                .name(music.getName())
                .artistEntity(artistEntity)
                .album(music.getAlbum())
                .genre(music.getGenre())
                .note(music.getNote())
                .feat(music.getFeat())
                .duration(music.getDuration())
                .BPM(music.getBPM())
                .release_date(music.getRelease_date())
                .build();
    }

    private ArtistEntity buildArtistEntity(Artist artist) {
        return ArtistEntity
                .builder()
                .id(artist.getId())
                .name_artist(artist.getName_artist())
                .nb_fans(artist.getNb_fans())
                .nb_albums(artist.getNb_albums())
                .build();
    }

    private Artist buildArtist(ArtistEntity artistEntity, List<MusicEntity> musicEntities) {
        return Artist.builder()
                .id(artistEntity.getId())
                .name_artist(artistEntity.getName_artist())
                .nb_fans(artistEntity.getNb_fans())
                .nb_albums(artistEntity.getNb_albums())
                .musics(
                        musicEntities
                        .stream()
                        .map(musicEntity -> Music.builder()
                                .id(musicEntity.getId())
                                .name(musicEntity.getName())
                                .artist(artistEntity.getName_artist())
                                .album(musicEntity.getAlbum())
                                .genre(musicEntity.getGenre())
                                .note(musicEntity.getNote())
                                .feat(musicEntity.getFeat())
                                .duration(musicEntity.getDuration())
                                .BPM(musicEntity.getBPM())
                                .release_date(musicEntity.getRelease_date())
                                .build())
                        .collect(Collectors.toList())

                )
                .build();
    }
}
