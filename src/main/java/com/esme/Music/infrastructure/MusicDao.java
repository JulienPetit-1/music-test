package com.esme.Music.infrastructure;

import com.esme.Music.domain.Music;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MusicDao {

    private MusicRepository musicRepository;

    public MusicDao(MusicRepository musicRepository){
        this.musicRepository = musicRepository;
    }

    public List<Music> getMusics(){
        return StreamSupport.stream(musicRepository.findAll().spliterator(), false)
                .map(musicEntity -> buildMusic(musicEntity))
                .collect(Collectors.toList());
    }

    public Music findMusics(Long id) throws ChangeSetPersister.NotFoundException {
        return buildMusic(musicRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new));
    }

    public Music addMusic(Music music) {
        return buildMusic(musicRepository.save(buildEntity(music)));
    }

    public void deleteMusic(Long id) {
        musicRepository.delete(musicRepository.findById(id).get());
    }

    public void updateMusic(Music music) {
        musicRepository.save(buildEntity(music));
    }

    private MusicEntity buildEntity(Music music) {
        return MusicEntity
                .builder()
                .id(music.getId())
                .name(music.getName())
                .artist(music.getArtist())
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
                .artist(musicEntity.getArtist())
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
