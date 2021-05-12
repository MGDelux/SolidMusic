/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restAPI;

import com.google.gson.Gson;
import dto.Genius.GeniusOuterDTO;
import dto.Spotify.SpotifyDTO;
import static java.lang.String.format;
import java.util.concurrent.ExecutionException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static javax.ws.rs.core.Response.Status.BAD_REQUEST;
import utils.ThreadManager;

/**
 *
 * @author mathi
 */
@Path("solidMusic")
public class SolidMusicResource {
    
        @Path("/spotify")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes(MediaType.APPLICATION_JSON)
    public String searchSpotify(@QueryParam("q") String param ) throws InterruptedException, ExecutionException{ //TODO: ROLES // DTO
       Gson gson = new Gson();
       SpotifyDTO dto;
               String returnVal = " ";
  if(param == null || param.isEmpty()){
               throw new WebApplicationException(Response
          .status(BAD_REQUEST)
          .type(MediaType.APPLICATION_JSON)
          .entity(format("Missing info please check "))
          .build());
           }else{
       ThreadManager tm = new ThreadManager();
               returnVal = tm.searchSpotifyAPI(param);
           //  dto = gson.fromJson(returnVal, SpotifyDTO.class);
            //   System.out.println("DTO: "+ dto);
  }
   return returnVal;
  }
    
    
    //wip
    @Path("/search")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes(MediaType.APPLICATION_JSON)
    public String search(@QueryParam("q") String param ){ //TODO: ROLES // DTO
       Gson gson = new Gson();
     GeniusOuterDTO dto;
        String returnVal = " ";
        try {
           if(param == null || param.isEmpty()){
               throw new WebApplicationException(Response
          .status(BAD_REQUEST)
          .type(MediaType.APPLICATION_JSON)
          .entity(format("Missing info please check %s"))
          .build());
           }else{
                ThreadManager tm = new ThreadManager();
               returnVal = tm.searchGeniusAPI(param);
              dto =  gson.fromJson(returnVal, GeniusOuterDTO.class);

               if(returnVal == null){
                      throw new WebApplicationException(Response
          .status(BAD_REQUEST)
          .type(MediaType.APPLICATION_JSON)
          .entity(format("INTERNAL ERROR"))
          .build());
               }
               
           }
        } catch(Exception e){
                  throw new WebApplicationException("Internal Server Problem. We are sorry for the inconvenience: " +e,501);
        }
  //  return returnVal;
     
   return gson.toJson(dto);

    }
}
