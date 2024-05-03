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


        Artist eminem = new Artist("Eminem", "Marshall Mathers", "https://i.ibb.co/kyNgCDs/eminem-removebg-preview.png", 51, "17/10/1972", "Detroit", "Bio of Eminem");
        Artist fiftyCent = new Artist("50 Cent", "Curtis James Jackson III", "https://i.ibb.co/6rg2y9t/50cent-removebg-preview.png", 48, "06/07/1975", "New York", "Bio of 50 cent");
        Artist chrisBrown = new Artist("Chris Brown", "Christopher Maurice Brown", "https://i.ibb.co/zF8Jwy8/cb-removebg-preview.png", 34, "05/05/1989", "Virginia", "Bio of Chris Brown");
        Artist beyonce = new Artist("Beyoncé", "Beyoncé Giselle Knowles-Carter", "https://i.ibb.co/ZYz4CKR/bey-removebg-preview.png", 42, "04/09/1981", "Houston", "Bio of Beyonce");
        Artist rihanna = new Artist("Rihanna", "Robyn Rihanna Fenty", "https://i.ibb.co/JBVkNsY/rih-removebg-preview.png", 36, "20/02/1988", "Barbados", "Bio of Rihanna");
        Artist vybz = new Artist("Vybz Kartel", "Adidja Azim Palmer", "https://i.ibb.co/L0HsnHZ/vk-removebg-preview.png", 48, "07/01/1976", "Jamaica", "Bio of Vybz Kartel");
        Artist dre = new Artist("Dr. Dre", "Andre Romell Young", "https://i.ibb.co/1Gw86Lk/dre-removebg-preview.png", 59, "18/02/1965", "Compton", "Bio of Dr. Dre");

        artistRepository.saveAll(Arrays.asList(eminem, fiftyCent, chrisBrown, beyonce, rihanna, vybz, dre));


        Album mmlp = new Album("The Marshall Mathers LP", "https://i1.sndcdn.com/artworks-46d4a422-15df-4966-a771-33fdbca3922f-0-t500x500.jpg", "23/05/2000", "Hip-Hop", 5);
        Album sslp = new Album("The Slim Shady LP", "https://upload.wikimedia.org/wikipedia/en/3/35/Eminem_-_The_Slim_Shady_LP_CD_cover.jpg", "23/02/1999", "Hip-Hop", 5);
        mmlp.setArtist(eminem);
        sslp.setArtist(eminem);
        eminem.getAlbums().addAll(Arrays.asList(mmlp, sslp));

        Album grodt = new Album("Get Rich or Die Tryin'", "https://upload.wikimedia.org/wikipedia/en/9/9d/Get_Rich_Or_Die_Tryin%27.JPG", "06/02/2003", "Hip-Hop", 5);
        grodt.setArtist(fiftyCent);
        fiftyCent.getAlbums().add(grodt);

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

        List<Song> sslpSongs = new ArrayList<>();
        sslpSongs.add(new Song("Public Service Announcement"));
        sslpSongs.add(new Song("My Name Is"));
        sslpSongs.add(new Song("Guilty Conscience"));
        sslpSongs.add(new Song("Brain Damage"));
        sslpSongs.add(new Song("Paul (skit)"));
        sslpSongs.add(new Song("If I Had"));
        sslpSongs.add(new Song("'97 Bonnie & Clyde"));
        sslpSongs.add(new Song("Bitch (skit)"));
        sslpSongs.add(new Song("Role Model"));
        sslpSongs.add(new Song("Lounge (skit)"));
        sslpSongs.add(new Song("My Fault"));
        sslpSongs.add(new Song("Ken Kaniff (skit)"));
        sslpSongs.add(new Song("Cum on Everybody"));
        sslpSongs.add(new Song("Rock Bottom"));
        sslpSongs.add(new Song("Just Don't Give a Fuck"));
        sslpSongs.add(new Song("Soap (skit)"));
        sslpSongs.add(new Song("As the World Turns"));
        sslpSongs.add(new Song("I'm Shady"));
        sslpSongs.add(new Song("Bad Meets Evil"));
        sslpSongs.add(new Song("Still Don't Give a Fuck"));
        sslpSongs.forEach(sslp::addSong);

        albumRepository.saveAll(Arrays.asList(mmlp, sslp, grodt));



    }
}
