package com.esme.Music;

import com.esme.Music.domain.Music;
import com.esme.Music.infrastructure.ArtistEntity;
import com.esme.Music.infrastructure.ArtistRepository;
import com.esme.Music.infrastructure.MusicEntity;
import com.esme.Music.infrastructure.MusicRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.transaction.Transactional;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Slf4j
@SpringBootApplication
@EnableScheduling

public class MusicApplication implements CommandLineRunner {

	private ArtistRepository artistRepository;
	private MusicRepository musicRepository;

	public MusicApplication(ArtistRepository artistRepository, MusicRepository musicRepository) {
		this.artistRepository = artistRepository;
		this.musicRepository = musicRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(MusicApplication.class, args);
		System.out.println("Hello World !");
	}
	@Override
	public void run(String... args) {

		log.info("Data initilisation...");
		saveArtist(1, "Pink Floyd", 159487, 15, Arrays.asList(Music.builder().name("Money").album("The Dark Side of The Moon").genre("Progressive Rock").note(5).feat(null).duration(Duration.ofMinutes(5)).BPM(140).release_date(LocalDate.parse("1973-05-07")).build()));
		saveArtist(2, "Queen", 250694, 16, Arrays.asList(Music.builder().name("Bohemian Rapshody").album("A Night at The Opera").genre("Opera Rock").note(4).feat(null).duration(Duration.ofMinutes(6)).BPM(120).release_date(LocalDate.parse("1975-10-31")).build()));
	}

	@Transactional
	private void saveArtist(long id, String name_artist, int nb_fans, int nb_albums, List<Music> musics) {

		ArtistEntity artistEntity = this.artistRepository.save(
			ArtistEntity
					.builder()
					.id(id)
					.name_artist(name_artist)
					.nb_fans(nb_fans)
					.nb_albums(nb_albums)
					.build());

		musics.stream()
				.forEach(music ->
						musicRepository.save(
								MusicEntity
										.builder()
										.name(music.getName())
										.artistEntity(artistEntity)
										.album(music.getAlbum())
										.genre(music.getGenre())
										.note(music.getNote())
										.feat(music.getFeat())
										.duration(music.getDuration())
										.BPM(music.getBPM())
										.release_date(music.getRelease_date())
										.build()
						));
	}

}
