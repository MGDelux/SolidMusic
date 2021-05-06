/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import dto.ApiKeyDTO;
import entities.APIKeysEntity;
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
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static javax.ws.rs.core.Response.Status.BAD_REQUEST;


/**
 *
 * @author mathi
 */
public class HTTPFetchGenius implements Callable<String>   {
  private String params;
  private String returnValue;
  private static final EntityManagerFactory EMF = EntityManagerCreator.CreateEntityManager();
  private static final APIFacade FACADE = APIFacade.getFacade(EMF);

    public  HTTPFetchGenius(String setParams) {
        this.params = setParams;
    }
    
    
        @Override
    public String call() {
        try {
            fetchData();
        } catch (IOException ex) {
            Logger.getLogger(HTTPFetchGenius.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.returnValue ;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getReturnValue() {
        return returnValue;
    }
    
    
       public String fetchData() throws MalformedURLException, IOException {
        String jsonStr = null;
         List<ApiKeyDTO> apiKey;
        try{
        apiKey = FACADE.getGeniusAPIKey();
        }catch(WebApplicationException e){
            throw new WebApplicationException(Response.status(BAD_REQUEST).type(MediaType.APPLICATION_JSON).entity(format("Error with API authentication")).build());
        }
           String paramsEncoded =java.net.URLEncoder.encode(params,"UTF-8"); //encodes String to HTML Format to avoid 505 error 
           String Genius_AUTHKEY = apiKey.get(0).getAuthKey(); //"70VO2k3bjvjYqF7ffZ7mrkqS7Mx5BdwwAFG1Pvvs9f9rsNJk1oFbqnTTwqyzuzJu"; //Todo: DO NOT STORE IN PLAIN TEXT!
           String baseURL = "https://api.genius.com/search?q="+paramsEncoded+"&access_token="+Genius_AUTHKEY;
         
        
        URL url = new URL(baseURL);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Accept", "application/json;charset=UTF-8");
        con.setRequestProperty("Accept", "application/json");
        con.setRequestProperty("User-Agent", "server");

        Scanner scan = new Scanner(con.getInputStream());
        if (scan.hasNext()) {
            jsonStr = scan.nextLine();
        }
        scan.close();
        
        this.returnValue = jsonStr;
        return jsonStr;
    }

    @Override
    public String toString() {
        return "HTTPFetchGenius{" + "returnValue=" + returnValue + '}';
    }
       
    
      
}
