/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author mathi
 */
@Entity
@Table(name = "playlist")

public class PlaylistEnitity implements Serializable {

    private static final long serialVersionUID = 1L;
  
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    //TODO Description
    @OneToMany(targetEntity = Song.class,cascade = CascadeType.PERSIST,fetch=FetchType.EAGER)
    private List<Song> songs;
    @Column(name = "creation_Date")
    private Date creationDate;
   @OneToOne(mappedBy = "playlist")
    private User owner;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public User getOwner() {
        return owner;
    }
    
    
    
    
    public PlaylistEnitity() {
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    
    
    
    public PlaylistEnitity(String name, List<Song> songs, User user) {
        this.name = name;
        this.songs = songs;
        this.creationDate = new Date();
        this.owner = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Song> getSongs() {
        return songs;
    }
    
     public void addSong(Song songs) {
        this.songs .add(songs);
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PlaylistEnitity{" + "id=" + id + ", name=" + name + ", songs=" + songs + ", creationDate=" + creationDate + '}';
    }

   
 
 
}
