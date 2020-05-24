package com.esme.Music;

import com.esme.Music.infrastructure.MusicEntity;
import com.esme.Music.infrastructure.MusicRepository;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

@ToString
@Slf4j
@SpringBootApplication
@EnableScheduling

public class MusicApplication implements CommandLineRunner {

	@Autowired
	private MusicRepository musicRepository;

	public static void main(String[] args) {
		SpringApplication.run(MusicApplication.class, args);
		System.out.println("Hello World !");
	}
	@Override
	public void run(String... args) {

		log.info("Data initilisation...");
		saveMusic(1, "Money", "Pink Floyd", "The Dark Side of the Moon", "Progressive Rock",
				4, null, 00.06, 120, '1973-05-07');
		saveMusic(2, "Bohemian Raphsody", "Queen", "A Night at the Opera", "Opera Rock",
				5, null, 00.06, 140, '1975-10-31');
	}

	private void saveMusic(long id, String name, String artist, String album,
							String genre, int note, String feat, SimpleDateFormat duration,
							int BPM, LocalDate release_date) {
		this.musicRepository.save(
				MusicEntity
						.builder()
						.id(id)
						.name(name)
						.artist(artist)
						.album(album)
						.genre(genre)
						.note(note)
						.feat(feat)
						.duration(duration)
						.BPM(BPM)
						.release_date(release_date)
						.build());
	}

}
