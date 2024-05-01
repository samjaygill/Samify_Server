package com.samjaygill.Samify.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "artists")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "stage_name")
    private String stageName;
    @Column(name = "real_name")
    private String realName;
    @Column(name = "artist_img")
    private String artistImg;
    @Column(name = "age")
    private int age;
    @Column(name = "dob")
    private String dob;
    @Column(name = "location")
    private String location;
    @Column(name = "bio")
    private String bio;
    @JsonIgnoreProperties("artist")
    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL)
    private List<Album> albums;

    public Artist(String stageName, String realName, String artistImg, int age, String dob, String location, String bio) {
        this.stageName = stageName;
        this.realName = realName;
        this.artistImg = artistImg;
        this.age = age;
        this.dob = dob;
        this.location = location;
        this.bio = bio;
        this.albums = new ArrayList<Album>();
    }

    public Artist() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getArtistImg() {
        return artistImg;
    }

    public void setArtistImg(String artistImg) {
        this.artistImg = artistImg;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    public void addAlbum(Album album){
        this.albums.add(album);
    }
}
