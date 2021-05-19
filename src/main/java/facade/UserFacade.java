package facade;

import com.google.gson.Gson;
import dto.Genius.ToSongDTO;
import entities.Artist;
import entities.PlaylistEnitity;
import entities.Role;
import entities.Song;
import entities.User;
import static java.lang.String.format;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static javax.ws.rs.core.Response.Status.BAD_REQUEST;
import secuirty.errorhandling.AuthenticationException;

/**
 * @author lam@cphbusiness.dk
 */
public class UserFacade {

    private static EntityManagerFactory emf;
    private static UserFacade instance;
      private static int counter;
    private UserFacade() {
    }

    /**
     *
     * @param _emf
     * @return the instance of this facade.
     */
    public static UserFacade getUserFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new UserFacade();
        }
        return instance;
    }

    public User getVeryfiedUser(String username, String password) throws AuthenticationException {
        EntityManager em = emf.createEntityManager();
        User user;
        try {
            user = em.find(User.class, username);
            if (user == null) {
                throw new AuthenticationException("Invalid userName");
            }else if(!user.verifyPassword(password)){
              throw new AuthenticationException("password invalid");

            }
        } finally {
            em.close();
        }
        return user;
    }
    
    public User getUser(String username) throws AuthenticationException {
        //ONLY USE IF PERSON HAS BEEN VERIFIRED
        EntityManager em = emf.createEntityManager();
        User user;
        try {
            user = em.find(User.class, username);
        } finally {
            em.close();
        }
        return user;
    }
    
    public void addPlayListToUser(String song, User user){
        try {
 PlaylistEnitity playlist = user.getPlaylist();
           EntityManager em = emf.createEntityManager();
          ToSongDTO song_new;
         Gson gson = new Gson();
         song_new = gson.fromJson(song, ToSongDTO.class);  
            System.out.println("song: "+song);
            System.out.println(song_new);
       
      Song newSong = new Song(song_new.getSelectedSong().getResult().getFull_title(),song_new.getSelectedSong().getResult().getHeader_image_thumbnail_url(),song_new.getSelectedSong().getResult().getHeader_image_url(),song_new.getSelectedSong().getResult().getPath(),song_new.getSelectedSong().getResult().getUrl(), new Artist(song_new.getSelectedSong().getResult().getPrimary_artist().getApi_path(),song_new.getSelectedSong().getResult().getPrimary_artist().getHeader_image_url(),song_new.getSelectedSong().getResult().getPrimary_artist().getName(),song_new.getSelectedSong().getResult().getPrimary_artist().getName()));
      playlist.addSong(newSong);
      em.getTransaction().begin();
       em.merge(playlist);
           em.getTransaction().commit();


      
        System.out.println("humbo new playlist: "+ user.getPlaylist());
        
        }catch (WebApplicationException e){
            throw new WebApplicationException(e.toString());
        }
    }

    
 
    public User createUser(User user) {
        try{
             EntityManager em = emf.createEntityManager();
      User createUser = new User(user.getUserName(),user.getUserPass());
        List<Song> songsInPlaylist = new ArrayList<>();
        Role userRole;
          userRole = em.find(Role.class, "user");
           PlaylistEnitity playlist = new PlaylistEnitity(user.getUserName() + " playlist",createUser);
           playlist.setSongs(songsInPlaylist);
           createUser.setPlaylist(playlist);
           playlist.setOwner(createUser);

   
          em.getTransaction().begin();
                  createUser.addRole(userRole);
                em.persist(createUser);
                  em.persist(userRole);       

 
                    
            
      em.getTransaction().commit();
       return createUser;
        }catch(WebApplicationException e){
         throw new WebApplicationException(Response
          .status(BAD_REQUEST)
          .type(MediaType.APPLICATION_JSON)
          .entity(format("ERROR " +e.toString()))
          .build());
         
        }
   
      }
    
    


}

