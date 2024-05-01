package com.samjaygill.Samify.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "albums")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
//    @JsonIgnoreProperties({"albums"})
    @ManyToOne
    @JoinColumn(name = "artist_id", nullable = false)
    private Artist artist;
    @Column(name = "name")
    private String name;
    @Column(name = "album_img")
    private String albumImg;
    @Column(name = "release_date")
    private String releaseDate;
    @Column(name = "genre")
    private String genre;
    @Column(name = "rating")
    private int rating;
    @JsonManagedReference
    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
    private List<Song> songs;

    public Album(String name, String albumImg, String releaseDate, String genre, int rating) {
        this.name = name;
        this.albumImg = albumImg;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.rating = rating;
        this.songs = new ArrayList<Song>();
    }

    public Album() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlbumImg() {
        return albumImg;
    }

    public void setAlbumImg(String albumImg) {
        this.albumImg = albumImg;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public void addSong(Song song) {
        if (songs == null) {
            songs = new ArrayList<>();
        }
        songs.add(song);
        song.setAlbum(this);
    }
}
