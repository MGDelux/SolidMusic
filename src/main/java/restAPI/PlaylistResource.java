/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restAPI;

import com.google.gson.Gson;
import entities.Song;
import entities.User;
import facade.UserFacade;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import secuirty.errorhandling.AuthenticationException;
import utils.EntityManagerCreator;

/**
 *
 * @author mathi
 */
@Path("playlist")
public class PlaylistResource {
     @Context
    SecurityContext securityContext;
     private static final EntityManagerFactory EMF = EntityManagerCreator.CreateEntityManager();
    public static final UserFacade USER_FACADE = UserFacade.getUserFacade(EMF);
        @Path("/addsong")
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes(MediaType.APPLICATION_JSON)
      @RolesAllowed("user")

    public String addSong(String param ) throws InterruptedException, ExecutionException, AuthenticationException{ //TODO: ROLES // DTO
        Gson gson = new Gson();
        try {

        String thisuser = securityContext.getUserPrincipal().getName();
         User user;
         user = USER_FACADE.getUser(thisuser);
         USER_FACADE.addPlayListToUser(param, user);
       
     
          System.out.println(param);
      }catch (WebApplicationException e){
          System.out.println(e.toString());
           //TODO throw new WebApplicationException
      }
            return  gson.toJson("Song added");
    }
     @Path("/get")
     @GET
     @Produces({MediaType.APPLICATION_JSON})
     @Consumes(MediaType.APPLICATION_JSON)
     @RolesAllowed("user")
    public String getUserPlaylist() throws AuthenticationException{
                       Gson gson = new Gson();
         String thisuser = securityContext.getUserPrincipal().getName();
             User user;
            
             user = USER_FACADE.getUser(thisuser);


              List<Song> songs =  user.getPlaylist().getSongs();
             return gson.toJson(songs);
    }
    
    //wip

}
