/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author mathi
 */
@Entity

public class Song implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String full_title;
    private String header_image_thumbnail_url;
    private String header_image_url;
    private String path;
    private String url;
    
    @OneToOne(cascade = CascadeType.PERSIST)
    private Artist artist;
  

    public Song() {
    }

    public Song(String full_title, String header_image_thumbnail_url, String header_image_url, String path, String url, Artist artist ) {
        this.full_title = full_title;
        this.header_image_thumbnail_url = header_image_thumbnail_url;
        this.header_image_url = header_image_url;
        this.path = path;
        this.url = url;
        this.artist = artist;
     
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFull_title() {
        return full_title;
    }

    public void setFull_title(String full_title) {
        this.full_title = full_title;
    }

    public String getHeader_image_thumbnail_url() {
        return header_image_thumbnail_url;
    }

    public void setHeader_image_thumbnail_url(String header_image_thumbnail_url) {
        this.header_image_thumbnail_url = header_image_thumbnail_url;
    }

    public String getHeader_image_url() {
        return header_image_url;
    }

    public void setHeader_image_url(String header_image_url) {
        this.header_image_url = header_image_url;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "Song{" + "id=" + id + ", full_title=" + full_title + ", header_image_thumbnail_url=" + header_image_thumbnail_url + ", header_image_url=" + header_image_url + ", path=" + path + ", url=" + url + ", artist=" + artist + '}';
    }

   
    
   
    
}
