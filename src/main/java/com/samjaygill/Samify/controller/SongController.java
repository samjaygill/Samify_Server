package com.samjaygill.Samify.controller;

import com.samjaygill.Samify.models.Song;
import com.samjaygill.Samify.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
public class SongController {
    @Autowired
    SongRepository songRepository;

    @GetMapping(value = "/songs")
    public ResponseEntity<List<Song>> getAllSongs(){
        return new ResponseEntity<>(songRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/songs/{id}")
    public ResponseEntity getSong(@PathVariable Long id){
        return new ResponseEntity<>(songRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/songs")
    public ResponseEntity<Song> postSong(@RequestBody Song song){
        songRepository.save(song);
        return new ResponseEntity<>(song, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/songs/{id}")
    public ResponseEntity<Song> deleteSong(@PathVariable Long id) {
        Optional<Song> songToDelete = songRepository.findById(id);
        songRepository.delete(songToDelete.get());
        return new ResponseEntity<>(songToDelete.get(), HttpStatus.OK);
    }

    @PutMapping(value = "/songs/{id}")
    public ResponseEntity<Song> updateSong(@RequestBody Song updatedSong, @PathVariable Long id) {
        Song existingSong = songRepository.findById(id).get();

        existingSong.setTitle(updatedSong.getTitle());
        existingSong.setAlbum(updatedSong.getAlbum());

        songRepository.save(existingSong);

        return new ResponseEntity<>(existingSong, HttpStatus.OK);
    }
}
