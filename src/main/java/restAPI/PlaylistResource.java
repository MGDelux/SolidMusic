/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restAPI;

import com.google.gson.Gson;
import dto.UserDTO;
import entities.User;
import facade.UserFacade;
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
import static restAPI.UserResource.USER_FACADE;
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

    public String searchSpotify(String param ) throws InterruptedException, ExecutionException, AuthenticationException{ //TODO: ROLES // DTO
      try {

        String thisuser = securityContext.getUserPrincipal().getName();
          System.out.println(thisuser);
         User user;
         user = USER_FACADE.getUser(thisuser);
         USER_FACADE.addPlayListToUser(param, user);
   
      }catch (WebApplicationException e){
          System.out.println(e.toString());
           //TODO throw new WebApplicationException
      }
            return "SUCK MY DICK";
    }
    
    
    //wip
    @Path("/new")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes(MediaType.APPLICATION_JSON)
    public String search(@QueryParam("q") String param ){ //TODO: ROLES // DTO
           return "not implemented";
        }

}
