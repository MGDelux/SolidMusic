/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import facade.testFacade;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import javax.persistence.EntityManagerFactory;
import static org.codehaus.groovy.ast.tools.GeneralUtils.params;

/**
 *
 * @author mathi
 */
public class test {
           public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
         EntityManagerFactory emf = EntityManagerCreator.CreateEntityManager();
         testFacade f = testFacade.getDummyFacade(emf);
         ThreadManager tm = new ThreadManager();
       String r =  tm.searchGeniusAPI("pinkguy");
        System.out.println("RETURN 1 _ : " + r);
         tm.searchGeniusAPI("xd");
          String r2 = tm.searchGeniusAPI("sai");
           String s = tm.searchSpotifyAPI("dont cry snowman");
               System.out.println("spotify: " + s);
            
         System.out.println("RETURN 2 _ : " + r2);
         



               
    }

}
