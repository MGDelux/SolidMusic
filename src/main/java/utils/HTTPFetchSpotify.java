/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.credentials.ClientCredentials;
import com.wrapper.spotify.model_objects.specification.Paging;
import com.wrapper.spotify.model_objects.specification.Track;
import com.wrapper.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
import com.wrapper.spotify.requests.data.search.simplified.SearchTracksRequest;
import dto.ApiKeyDTO;
import facade.APIFacade;
import java.io.IOException;
import static java.lang.String.format;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static javax.ws.rs.core.Response.Status.BAD_REQUEST;
import org.apache.hc.core5.http.ParseException;


/**
 *
 * @author mathi
 */
public class HTTPFetchSpotify implements Callable<String>   {
  private static final String clientId = "8a9c6107563e49848b65637401eb3a92";
  private static final String clientSecret = "ad143793012d4b178ab94f2f6052880d";
  private String params;
  private String returnValue;
  private static final EntityManagerFactory EMF = EntityManagerCreator.CreateEntityManager();
  private static final APIFacade FACADE = APIFacade.getFacade(EMF);
  private static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
  .setClientId(clientId)
  .setClientSecret(clientSecret)
  .build();
  private static final ClientCredentialsRequest clientCredentialsRequest = spotifyApi.clientCredentials()
    .build();

public static void clientCredentials_Sync() throws SpotifyWebApiException, org.apache.hc.core5.http.ParseException {
    try {
      final ClientCredentials clientCredentials = clientCredentialsRequest.execute();

      // Set access token for further "spotifyApi" object usage
      spotifyApi.setAccessToken(clientCredentials.getAccessToken());

      System.out.println("Expires in: " + clientCredentials.getExpiresIn());
    } catch (IOException | SpotifyWebApiException  e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
    public  HTTPFetchSpotify(String setParams) {
        this.params = setParams;
    }
    
    
        @Override
    public String call() throws MalformedURLException, SpotifyWebApiException, ParseException {
        try {
            fetchData();
        } catch (IOException ex) {
            Logger.getLogger(HTTPFetchSpotify.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.returnValue ;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getReturnValue() {
        return returnValue;
    }
    
    
       public  Paging<Track> fetchData() throws MalformedURLException, IOException, SpotifyWebApiException, ParseException {
         List<ApiKeyDTO> apiKey;
        try{
            clientCredentials_Sync();  
        apiKey = FACADE.getGeniusAPIKey();
        }catch(WebApplicationException e){
            throw new WebApplicationException(Response.status(BAD_REQUEST).type(MediaType.APPLICATION_JSON).entity(format("Error with API authentication")).build());
        }
           String paramsEncoded = java.net.URLEncoder.encode(params,"UTF-8"); //encodes String to HTML Format to avoid 505 error 
           String baseURL = "https://api.spotify.com/v1/search?q="+paramsEncoded+"&type=track&limit=2";
         
     SearchTracksRequest searchTracksRequest = spotifyApi.searchTracks(params).limit(2).includeExternal("audio").build();
      final Paging<Track> trackPaging = searchTracksRequest.execute();
           System.out.println(trackPaging.getTotal());
         this.returnValue = trackPaging.toString();
        return trackPaging;
    }

    @Override
    public String toString() {
        return "HTTPFetchGenius{" + "returnValue=" + returnValue + '}';
    }
       
    
      
}
