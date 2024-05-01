package com.samjaygill.Samify.components;

import com.samjaygill.Samify.models.Album;
import com.samjaygill.Samify.models.Artist;
import com.samjaygill.Samify.models.Song;
import com.samjaygill.Samify.repository.AlbumRepository;
import com.samjaygill.Samify.repository.ArtistRepository;
import com.samjaygill.Samify.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Profile("!test") //Run every time EXCEPT Tests
@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    ArtistRepository artistRepository;

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    SongRepository songRepository;


    public DataLoader() {
    }

    public void run(ApplicationArguments args) {


        Artist eminem = new Artist("Eminem", "Marshall Mathers", "https://d3ne5nhbe3knix.cloudfront.net/s3/ttf-media/images/event/P-Eminem.jpg", 48, "17/10/1972", "Detroit", "Bio of Eminem");
        artistRepository.save(eminem);

        Album mmlp = new Album("The Marshall Mathers LP", "https://i1.sndcdn.com/artworks-46d4a422-15df-4966-a771-33fdbca3922f-0-t500x500.jpg", "23/05/2000", "Hip-Hop", 5);
        mmlp.setArtist(eminem);

        eminem.getAlbums().add(mmlp);

        List<Song> mmlpSongs = new ArrayList<>();
        mmlpSongs.add(new Song("Public Service Announcement 2000"));
        mmlpSongs.add(new Song("Kill You"));
        mmlpSongs.add(new Song("Stan"));
        mmlpSongs.add(new Song("Paul (skit)"));
        mmlpSongs.add(new Song("Who Knew"));
        mmlpSongs.add(new Song("Steve Berman (skit)"));
        mmlpSongs.add(new Song("The Way I Am"));
        mmlpSongs.add(new Song("The Real Slim Shady"));
        mmlpSongs.add(new Song("Remember Me?"));
        mmlpSongs.add(new Song("I'm Back"));
        mmlpSongs.add(new Song("Marshall Mathers"));
        mmlpSongs.add(new Song("Ken Kaniff (skit)"));
        mmlpSongs.add(new Song("Drug Ballad"));
        mmlpSongs.add(new Song("Amityville"));
        mmlpSongs.add(new Song("Bitch Please II"));
        mmlpSongs.add(new Song("Kim"));
        mmlpSongs.add(new Song("Under the Influence"));
        mmlpSongs.add(new Song("Criminal"));

        mmlpSongs.forEach(mmlp::addSong);
        albumRepository.save(mmlp);


    }
}
