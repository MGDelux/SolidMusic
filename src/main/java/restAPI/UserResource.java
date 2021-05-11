/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restAPI;

import com.google.gson.Gson;
import dto.Genius.GeniusOuterDTO;
import dto.Spotify.SpotifyDTO;
import dto.UserDTO;
import facade.APIFacade;
import facade.UserFacade;
import static java.lang.String.format;
import static java.util.Collections.list;
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
import javax.ws.rs.core.Response;
import static javax.ws.rs.core.Response.Status.BAD_REQUEST;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;
import secuirty.errorhandling.AuthenticationException;
import utils.EntityManagerCreator;
import utils.ThreadManager;

/**
 *
 * @author mathi
 */
@Path("usertest")
public class UserResource {
     @Context
    private UriInfo context;
  private static final EntityManagerFactory EMF = EntityManagerCreator.CreateEntityManager();
    public static final UserFacade USER_FACADE = UserFacade.getUserFacade(EMF);
    @Context
    SecurityContext securityContext;
    
        @Path("/get")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("user")
    public String getFromUser() throws AuthenticationException {
               Gson gson = new Gson();

        String thisuser = securityContext.getUserPrincipal().getName();
         entities.User user = USER_FACADE.getUser(thisuser);
        UserDTO userDTO = new UserDTO(user);
        return gson.toJson(userDTO);
    }
}
