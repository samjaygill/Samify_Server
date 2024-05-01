package com.samjaygill.Samify.controller;

import com.samjaygill.Samify.models.Album;
import com.samjaygill.Samify.models.Artist;
import com.samjaygill.Samify.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AlbumController {

    @Autowired
    AlbumRepository albumRepository;

    @GetMapping(value = "/albums")
    public ResponseEntity<List<Album>> getAllAlbums(){
        return new ResponseEntity<>(albumRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/albums/{id}")
    public ResponseEntity getAlbum(@PathVariable Long id){
        return new ResponseEntity<>(albumRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/albums")
    public ResponseEntity<Album> postAlbum(@RequestBody Album album){
        albumRepository.save(album);
        return new ResponseEntity<>(album, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/albums/{id}")
    public ResponseEntity<Album> deleteAlbum(@PathVariable Long id) {
        Optional<Album> albumToDelete = albumRepository.findById(id);
        albumRepository.delete(albumToDelete.get());
        return new ResponseEntity<>(albumToDelete.get(), HttpStatus.OK);
    }

    @PutMapping(value = "/albums/{id}")
    public ResponseEntity<Album> updateAlbum(@RequestBody Album updatedAlbum, @PathVariable Long id) {
        Album existingAlbum = albumRepository.findById(id).get();

        existingAlbum.setName(updatedAlbum.getName());
        existingAlbum.setAlbumImg(updatedAlbum.getAlbumImg());
        existingAlbum.setReleaseDate(updatedAlbum.getReleaseDate());
        existingAlbum.setGenre(updatedAlbum.getGenre());
        existingAlbum.setRating(updatedAlbum.getRating());

        albumRepository.save(existingAlbum);

        return new ResponseEntity<>(existingAlbum, HttpStatus.OK);
    }
}
