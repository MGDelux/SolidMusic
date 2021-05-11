/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restAPI;

import com.google.gson.Gson;
import dto.Genius.GeniusOuterDTO;
import dto.Spotify.SpotifyDTO;
import facade.APIFacade;
import static java.lang.String.format;
import static java.util.Collections.list;
import java.util.concurrent.ExecutionException;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static javax.ws.rs.core.Response.Status.BAD_REQUEST;
import utils.EntityManagerCreator;
import utils.ThreadManager;

/**
 *
 * @author mathi
 */
@Path("playlist")
public class PlaylistResource {
    
        @Path("/addSong")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes(MediaType.APPLICATION_JSON)
    public String searchSpotify(@QueryParam("q") String param ) throws InterruptedException, ExecutionException{ //TODO: ROLES // DTO
        return "not implemented";
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
