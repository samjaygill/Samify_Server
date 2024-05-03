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
        Artist drake = new Artist("Drake", "Aubrey Drake Graham", "https://i.ibb.co/tQSL6N5/drake-removebg-preview.png", 37, "24/10/1986", "Toronto", "Bio of Drake");

        artistRepository.saveAll(Arrays.asList(eminem, fiftyCent, chrisBrown, beyonce, rihanna, vybz, dre, drake));


        Album mmlp = new Album("The Marshall Mathers LP", "https://i1.sndcdn.com/artworks-46d4a422-15df-4966-a771-33fdbca3922f-0-t500x500.jpg", "23/05/2000", "Hip-Hop", 5);
        Album sslp = new Album("The Slim Shady LP", "https://upload.wikimedia.org/wikipedia/en/3/35/Eminem_-_The_Slim_Shady_LP_CD_cover.jpg", "23/02/1999", "Hip-Hop", 4);
        Album tes = new Album("The Eminem Show", "https://upload.wikimedia.org/wikipedia/en/3/35/The_Eminem_Show.jpg", "26/05/2002", "Hip-Hop", 5);
        Album encore = new Album("Encore", "https://upload.wikimedia.org/wikipedia/en/b/b4/Encore_%28Eminem_album%29_coverart.jpg", "12/11/2004", "Hip-Hop", 4);
        Album recovery = new Album("Recovery", "https://upload.wikimedia.org/wikipedia/en/6/60/Recovery_Album_Cover.jpg", "18/06/2010", "Hip-Hop", 5);
        Album mmlptwo = new Album("The Marshall Mathers LP 2", "https://upload.wikimedia.org/wikipedia/en/8/87/The_Marshall_Mathers_LP_2.png", "05/11/2013", "Hip-Hop", 5);

        mmlp.setArtist(eminem);
        sslp.setArtist(eminem);
        tes.setArtist(eminem);
        encore.setArtist(eminem);
        recovery.setArtist(eminem);
        mmlptwo.setArtist(eminem);

        eminem.getAlbums().addAll(Arrays.asList(mmlp, sslp, tes, encore, recovery, mmlptwo));

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

        Album grodt = new Album("Get Rich or Die Tryin'", "https://upload.wikimedia.org/wikipedia/en/9/9d/Get_Rich_Or_Die_Tryin%27.JPG", "06/02/2003", "Hip-Hop", 4);
        grodt.setArtist(fiftyCent);
        fiftyCent.getAlbums().add(grodt);

        List<Song> grodtSongs = new ArrayList<>();
        grodtSongs.add(new Song("Intro"));
        grodtSongs.add(new Song("What Up Gangsta"));
        grodtSongs.add(new Song("Patiently Waiting"));
        grodtSongs.add(new Song("Many Men (Wish Death)"));
        grodtSongs.add(new Song("In da Club"));
        grodtSongs.add(new Song("High All the Time"));
        grodtSongs.add(new Song("Heat"));
        grodtSongs.add(new Song("If I Can't"));
        grodtSongs.add(new Song("Blood Hound"));
        grodtSongs.add(new Song("Back Down"));
        grodtSongs.add(new Song("P.I.M.P."));
        grodtSongs.add(new Song("Like My Style"));
        grodtSongs.add(new Song("Poor Lil Rich"));
        grodtSongs.add(new Song("21 Questions"));
        grodtSongs.add(new Song("Don't Push Me"));
        grodtSongs.add(new Song("Gotta Make It to Heaven"));
        grodtSongs.add(new Song("Wanksta"));
        grodtSongs.add(new Song("U Not Like Me"));
        grodtSongs.add(new Song("Life's on the Line"));
        grodtSongs.forEach(grodt::addSong);

        Album twoone = new Album("2001", "https://upload.wikimedia.org/wikipedia/en/5/56/DrDre-2001.jpg", "16/11/1999", "Hip-Hop", 4);
        twoone.setArtist(dre);
        dre.getAlbums().add(twoone);

        Album kingston = new Album("Kingston Story", "https://i.ibb.co/xfv8xD9/vkks.jpg", "21/06/2011", "Reggae", 5);
        Album kotd = new Album("King Of The Dancehall", "https://i.ibb.co/hgX5yMY/kodh.jpg", "10/06/2016", "Reggae", 3);

        kingston.setArtist(vybz);
        kotd.setArtist(vybz);
        vybz.getAlbums().addAll(Arrays.asList(kingston, kotd));

        List<Song> kingstonSongs = new ArrayList<>();
        kingstonSongs.add(new Song("Jamaica"));
        kingstonSongs.add(new Song("Beautiful Girl"));
        kingstonSongs.add(new Song("Half On A Baby"));
        kingstonSongs.add(new Song("Go Go Wine"));
        kingstonSongs.add(new Song("Yuh Love"));
        kingstonSongs.add(new Song("My Crew"));
        kingstonSongs.add(new Song("Breathless"));
        kingstonSongs.add(new Song("Mi Remember"));
        kingstonSongs.add(new Song("Push It In (Take It Out)"));
        kingstonSongs.add(new Song("Wine Pon Me"));
        kingstonSongs.add(new Song("Fresh"));
        kingstonSongs.add(new Song("Freestyle"));
        kingstonSongs.add(new Song("Money"));
        kingstonSongs.add(new Song("Good P"));
        kingstonSongs.add(new Song("Ghetto Youth"));
        kingstonSongs.forEach(kingston::addSong);

        List<Song> kotdSongs = new ArrayList<>();
        kotdSongs.add(new Song("Colouring This Life"));
        kotdSongs.add(new Song("Most Wanted"));
        kotdSongs.add(new Song("Open up di Door"));
        kotdSongs.add(new Song("Don't Know Someone"));
        kotdSongs.add(new Song("Lipstick"));
        kotdSongs.add(new Song("Can't Say No"));
        kotdSongs.add(new Song("Every Girl"));
        kotdSongs.add(new Song("Which Friend"));
        kotdSongs.add(new Song("Western Union"));
        kotdSongs.add(new Song("Like Google"));
        kotdSongs.add(new Song("Enemy Zone"));
        kotdSongs.add(new Song("Hey Addi"));
        kotdSongs.add(new Song("Don't Know Someone"));
        kotdSongs.add(new Song("Can't Say No"));
        kotdSongs.add(new Song("Fever"));
        kotdSongs.add(new Song("Sorry Babe"));
        kotdSongs.forEach(kotd::addSong);

        albumRepository.saveAll(Arrays.asList(mmlp, sslp, grodt, twoone, tes, encore, recovery, mmlptwo, kingston, kotd));



    }
}
