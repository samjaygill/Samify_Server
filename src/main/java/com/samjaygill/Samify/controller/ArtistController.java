package com.samjaygill.Samify.controller;

import com.samjaygill.Samify.models.Artist;
import com.samjaygill.Samify.models.Song;
import com.samjaygill.Samify.repository.ArtistRepository;
import com.samjaygill.Samify.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ArtistController {

    @Autowired
    ArtistRepository artistRepository;

    @GetMapping(value = "/artists")
    public ResponseEntity<List<Artist>> getAllArtists(){
        return new ResponseEntity<>(artistRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/artists/{id}")
    public ResponseEntity getArtist(@PathVariable Long id){
        return new ResponseEntity<>(artistRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/artists")
    public ResponseEntity<Artist> postArtist(@RequestBody Artist artist){
        artistRepository.save(artist);
        return new ResponseEntity<>(artist, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/artists/{id}")
    public ResponseEntity<Artist> deleteArtist(@PathVariable Long id) {
        Optional<Artist> artistToDelete = artistRepository.findById(id);
        artistRepository.delete(artistToDelete.get());
        return new ResponseEntity<>(artistToDelete.get(), HttpStatus.OK);
    }

    @PutMapping(value = "/artists/{id}")
    public ResponseEntity<Artist> updateArtist(@RequestBody Artist updatedArtist, @PathVariable Long id) {
        Artist existingArtist = artistRepository.findById(id).get();

        existingArtist.setRealName(updatedArtist.getRealName());
        existingArtist.setStageName(updatedArtist.getStageName());
        existingArtist.setArtistImg(updatedArtist.getArtistImg());
        existingArtist.setAge(updatedArtist.getAge());
        existingArtist.setDob(updatedArtist.getDob());
        existingArtist.setLocation(updatedArtist.getLocation());

        artistRepository.save(existingArtist);

        return new ResponseEntity<>(existingArtist, HttpStatus.OK);
    }
}
