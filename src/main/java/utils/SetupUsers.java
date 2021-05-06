/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import com.google.gson.Gson;
import dto.GeniusDTO;
import dto.GeniusMidDTO;
import dto.GeniusOuterDTO;
import dto.GeniusResultDTO;
import entities.APIKeysEntity;
import entities.Artist;
import entities.PlaylistEnitity;
import entities.Role;
import entities.Song;
import entities.User;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author mathi
 */

public class SetupUsers {
    public static EntityManagerFactory emf;
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        boolean test = false;
        System.out.println("ADDING  (DUMMY) USERS TO DB");
        if (test == false){
                emf = EntityManagerCreator.CreateEntityManagerTest();
                System.out.println("USING TEST DB");
        }else{
                emf = EntityManagerCreator.CreateEntityManager();
                                System.out.println("USING DEV DB");

        }
               Gson gson = new Gson();
    EntityManager em = emf.createEntityManager();
   List<PlaylistEnitity> list2 = new ArrayList<>();
  List<Song> songsInPlaylist2 = new ArrayList<>();
  List<PlaylistEnitity> list = new ArrayList<>();
  List<Song> songsInPlaylist = new ArrayList<>();
      User user = new User("user", "userpw");
      User admin = new User("admin", "adminpw");
      User ali = new User ("ali","ali");
      APIKeysEntity genius_API = new APIKeysEntity("genius","70VO2k3bjvjYqF7ffZ7mrkqS7Mx5BdwwAFG1Pvvs9f9rsNJk1oFbqnTTwqyzuzJu");
      Artist artist = new Artist("API PATH","HEADER IMG URL","PINK GUY","URL");
       Artist artist2 = new Artist("API PATH","HEADER IMG URL","DELUX GUY","URL");

      Song song = new Song("I WANNA FUCKING DIE","url 1","url 2","path","another url",artist);
       Song song2 = new Song("I WANNA FUCKING DIE 2","url 1","url 2","path","another url",artist);
       Song song3 = new Song("ALI IS BETTER THAN JANUS ","url 1","url 2","path","another url",artist2);
      PlaylistEnitity playlist = new PlaylistEnitity("MIN PLAYLIST 1",songsInPlaylist);
      PlaylistEnitity playlist2 = new PlaylistEnitity("MIN PLAYLIST 2",songsInPlaylist2);
 
      
      
      
      songsInPlaylist.add(song);
      songsInPlaylist.add(song2);
       songsInPlaylist2.add(song3);
      list.add(playlist);
      list2.add(playlist2);
          em.getTransaction().begin();
     em.persist(genius_API);
     
      Role userRole = new Role("user");
      Role adminRole = new Role("admin");
      user.addRole(userRole);
      admin.addRole(adminRole);
       em.persist(userRole);
       em.persist(adminRole);
      em.persist(user);
       em.persist(admin);
        em.getTransaction().commit();
          ThreadManager tm = new ThreadManager();
              String value;
              
        //EXAMPLE PROCESS OF GETTING MUSIC QUERY   
          List<Song> tempSongs = new ArrayList<>();
          List<PlaylistEnitity> tempPlaylist = new ArrayList<>();

      value = tm.searchGeniusAPI("Bye Bye Bye");
      GeniusOuterDTO dto = gson.fromJson(value, GeniusOuterDTO.class);
      GeniusMidDTO middto; 
       middto =  dto.getResponse();
       List<GeniusDTO> gmd = new ArrayList<>();
       gmd = middto.getHits();
       List<GeniusResultDTO> rdto = new ArrayList<>();
       for(GeniusDTO g : gmd ){
          rdto.add(g.getResult());
      
       }
        Song dtosong = new Song(rdto.get(0).getTitle(),rdto.get(0).getHeader_image_thumbnail_url(),rdto.get(0).getHeader_image_url(),rdto.get(0).getPath(),rdto.get(0).getUrl(),new Artist(rdto.get(0).getPrimary_artist().getApi_path(),rdto.get(0).getPrimary_artist().getHeader_image_url(),rdto.get(0).getPrimary_artist().getName(),rdto.get(0).getPrimary_artist().getUrl()));
         tempSongs.add(dtosong);
      // tempPlaylist user.getPlaylist();
        System.out.println("D TO SONG: " +dtosong);
         System.out.println(tm.searchSpotifyAPI(dtosong.getFull_title() + " " + dtosong.getArtist().getName()));
                    
  
             
             

             
               
   


       

        System.out.println(dto);
         System.out.println("PW1: " + user.getUserPass());
         System.out.println("PW2: " + admin.getUserPass());
         System.out.println(user);
          System.out.println("Testing user PW " + user.verifyPassword("userpw"));
          System.out.println("Testing admin PW: " + admin.verifyPassword("adminpw"));
          

    
    }
}
