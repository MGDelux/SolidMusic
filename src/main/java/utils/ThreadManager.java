/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author mathi
 */
public class ThreadManager {
    
    
    public String searchSpotifyAPI(String params) throws InterruptedException, ExecutionException{
           ExecutorService executor = Executors.newCachedThreadPool();
           Future<String> callback = executor.submit(new HTTPFetchSpotify(params)); 
           return callback.get();
    } 
    
    public String searchGeniusAPI(String params) throws InterruptedException, ExecutionException{
           ExecutorService executor = Executors.newCachedThreadPool();
           Future<String> callback = executor.submit(new HTTPFetchGenius(params)); 
           return callback.get();
    } 
    
}
