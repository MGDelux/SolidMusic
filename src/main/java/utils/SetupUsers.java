/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import com.google.gson.Gson;
import dto.Genius.GeniusDTO;
import dto.Genius.GeniusMidDTO;
import dto.Genius.GeniusOuterDTO;
import dto.Genius.GeniusResultDTO;
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
    ThreadManager tm = new ThreadManager();
    em.getTransaction().begin();
          APIKeysEntity genius_API = new APIKeysEntity("genius","uGiljUMy8gsJ3JUFJzCLFICsBIkRrxeNJz-3MHGOkXqjySzb3WxXzb5U0Zq1l3AU");
em.persist(genius_API);
        em.getTransaction().commit();

    
    
   List<PlaylistEnitity> list2 = new ArrayList<>();
  List<Song> songsInPlaylist2 = new ArrayList<>();
  List<PlaylistEnitity> list = new ArrayList<>();
  List<Song> songsInPlaylist = new ArrayList<>();
      User user = new User("humbo", "test");
      User admin = new User("admin", "adminpw");
      User ali = new User ("ali","ali");
      Artist artist = new Artist("API PATH","HEADER IMG URL","PINK GUY","URL");
       Artist artist2 = new Artist("API PATH","HEADER IMG URL","DELUX GUY","URL");
       GeniusOuterDTO songenitySong;
       PlaylistEnitity playlist2 = new PlaylistEnitity("ADMIN PLAYLIST",songsInPlaylist,admin);

             PlaylistEnitity playlist = new PlaylistEnitity("MIN PLAYLIST 1",songsInPlaylist,user);
      Song song = new Song("I WANNA FUCKING DIE","url 1","url 2","path","another url",artist);
       Song song2 = new Song("I WANNA FUCKING DIE 2","url 1","url 2","path","another url",artist);
       Song song3 = new Song("ALI IS BETTER THAN JANUS ","url 1","url 2","path","another url",artist2);
         songenitySong = gson.fromJson(tm.searchGeniusAPI("STFU"), GeniusOuterDTO.class);
       Song songx = new Song(songenitySong.getResponse().getHits().get(0).getResult().getFull_title(),songenitySong.getResponse().getHits().get(0).getResult().getHeader_image_thumbnail_url(),songenitySong.getResponse().getHits().get(0).getResult().getHeader_image_url(),songenitySong.getResponse().getHits().get(0).getResult().getPath(),songenitySong.getResponse().getHits().get(0).getResult().getUrl(),new Artist(songenitySong.getResponse().getHits().get(0).getResult().getPrimary_artist().getApi_path(),songenitySong.getResponse().getHits().get(0).getResult().getPrimary_artist().getHeader_image_url(),songenitySong.getResponse().getHits().get(0).getResult().getPrimary_artist().getName(),songenitySong.getResponse().getHits().get(0).getResult().getPrimary_artist().getUrl()));
      songsInPlaylist.add(songx);
      songsInPlaylist.add(song);
      songsInPlaylist.add(song2);
       songsInPlaylist.add(song3);
 
      list.add(playlist);
      
      
        System.out.println("hi: "+ playlist);
          em.getTransaction().begin();
          playlist2.setOwner(admin);
                playlist.setOwner(user);
          user.setPlaylist(playlist);
          admin.setPlaylist(playlist2);
      Role userRole = new Role("user");
      Role adminRole = new Role("admin");
      user.addRole(userRole);
      admin.addRole(adminRole);
       em.persist(userRole);
       em.persist(adminRole);
      em.persist(user);
       em.persist(admin);
        em.getTransaction().commit();
            
              
        //EXAMPLE PROCESS OF GETTING MUSIC QUERY   
      String return_val =  tm.searchGeniusAPI("STFU");
        System.out.println(return_val);
        GeniusOuterDTO dto;
        //Turn into DTO
       dto =  gson.fromJson(return_val, GeniusOuterDTO.class);
       /*
       //get (all) title & artist fromt query
       List<String> getAllTitle = new ArrayList<>();
       List<String> getAllArtist = new ArrayList<>();
        System.out.println("song test:"+dto);
        List<GeniusDTO> geniushits;
        geniushits = dto.getResponse().getHits();
        for (GeniusDTO d : geniushits) {
           getAllTitle.add(d.getResult().getTitle());
           getAllArtist.add(d.getResult().getPrimary_artist().getName());      
        }
        System.out.println("ALL TITLES: "+ getAllTitle.toString()); 
        System.out.println("ALL ARTIST: "+ getAllArtist.toString()); 
       
        // get "first" hit title & artist #0
        
        
        String firstHitTitle;
        String firstHitArtist;
       firstHitTitle = geniushits.get(0).getResult().getTitle();
       firstHitArtist = geniushits.get(0).getResult().getPrimary_artist().getName();
        System.out.println("FIRT HIT: TITLE: "+firstHitTitle);
        System.out.println("FIRT HIT: ARTIST: "+firstHitArtist);
        //USE data above to search spotify
        String spotifySearchParam = firstHitTitle + " " + firstHitArtist;
       String spotifyR = tm.searchSpotifyAPI(spotifySearchParam);
        System.out.println("Spotify search params: "+ spotifySearchParam);
        System.out.println("SPOTIFY RESULT: "+ spotifyR );
        
        
       // Song dtosong = new Song(rdto.get(0).getTitle(),rdto.get(0).getHeader_image_thumbnail_url(),rdto.get(0).getHeader_image_url(),rdto.get(0).getPath(),rdto.get(0).getUrl(),new Artist(rdto.get(0).getPrimary_artist().getApi_path(),rdto.get(0).getPrimary_artist().getHeader_image_url(),rdto.get(0).getPrimary_artist().getName(),rdto.get(0).getPrimary_artist().getUrl()));
        // tempSongs.add(dtosong);
      // tempPlaylist user.getPlaylist();
      
                    

       
*/
        System.out.println("STACK OVERFLOW:");
         System.out.println("PW1: " + user.getUserPass());
         System.out.println("PW2: " + admin.getUserPass());
          System.out.println("Testing user PW " + user.verifyPassword("test"));
          System.out.println("Testing admin PW: " + admin.verifyPassword("adminpw"));
          System.out.println("##############");
          System.out.println("playlist: "+ playlist.getName() + " owner: " +playlist.getOwner().getUserName());
          System.out.println("playlist: "+ playlist2.getName() + " owner: " +playlist2.getOwner().getUserName());
System.out.println("--");
         System.out.println("user enitity get admin playlist: "+admin.getPlaylist().getName());
          System.out.println("##############");

            System.out.println("enitiy song "+ songenitySong);

    }
}
