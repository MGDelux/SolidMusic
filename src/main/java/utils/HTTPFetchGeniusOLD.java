/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 *
 * @author mathi
 */
public class HTTPFetchGeniusOLD {
    public static String fetchData(String _url) throws MalformedURLException, IOException {
       String Genius_AUTHKEY = "70VO2k3bjvjYqF7ffZ7mrkqS7Mx5BdwwAFG1Pvvs9f9rsNJk1oFbqnTTwqyzuzJu"; //Todo: DO NOT STORE IN PLAIN TEXT!
           String baseURL = "https://api.genius.com/search?q="+"SIA"+"&access_token="+Genius_AUTHKEY;
         
        
        URL url = new URL(baseURL);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Accept", "application/json;charset=UTF-8");
        con.setRequestProperty("Accept", "application/json");
        con.setRequestProperty("User-Agent", "server");

        Scanner scan = new Scanner(con.getInputStream());
        String jsonStr = null;
        if (scan.hasNext()) {
            jsonStr = scan.nextLine();
        }
        scan.close();
        System.out.println("old non theard: "+jsonStr);
        return jsonStr;
    }
}
