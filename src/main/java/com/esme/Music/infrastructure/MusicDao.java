package com.esme.Music.infrastructure;

import com.esme.Music.domain.Music.Music;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Service

public class MusicDao {

    private ArtistRepository artistRepository;
    private MusicRepository musicRepository;

    public MusicDao(ArtistRepository artistRepository, MusicRepository musicRepository) {
        this.artistRepository = artistRepository;
        this.musicRepository = musicRepository;
    }

    public List<Music> findMusicsByArtistId() {
        return StreamSupport.stream(musicRepository.findAll().spliterator(), false)
                .map(musicEntity -> buildMusic(musicEntity))
                .collect(Collectors.toList());
    }

    public List<Music> findMusicsByArtistId(Long artistId) {
        return musicRepository.findByArtistEntityId(artistId)
                .stream()
                .map(foodEntity -> buildMusic(foodEntity))
                .collect(Collectors.toList());
    }

    public Music findMusicById(Long artistId) {
        return buildMusic(musicRepository.findById(artistId).orElse(null));
    }

    public Music addMusics(Long artistId, Music music) {
        MusicEntity musicEntity = buildMusicEntity(music, artistRepository.findById(artistId).orElse(null));

        return buildMusic(musicRepository.save(musicEntity));
    }


    private MusicEntity buildMusicEntity(Music music, ArtistEntity artistEntity) {
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


    private Music buildMusic(MusicEntity musicEntity) {
        return Music.builder()
            .id(musicEntity.getId())
            .name(musicEntity.getName())
            .album(musicEntity.getAlbum())
            .genre(musicEntity.getGenre())
            .note(musicEntity.getNote())
            .feat(musicEntity.getFeat())
            .duration(musicEntity.getDuration())
            .BPM(musicEntity.getBPM())
            .release_date(musicEntity.getRelease_date())
            .build();
    }
}
