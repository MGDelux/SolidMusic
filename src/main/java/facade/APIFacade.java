/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dto.ApiKeyDTO;
import entities.APIKeysEntity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author mathi
 */
public class APIFacade {
      private static APIFacade instance;
    private static EntityManagerFactory emf;

    public APIFacade() {
    }
    
     public static APIFacade getFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new APIFacade();
        }
        return instance;
    }
      private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
      
      
      public List<ApiKeyDTO> getGeniusAPIKey(){
      EntityManager em = emf.createEntityManager();
      List<APIKeysEntity> apikey= new ArrayList<>();
      try{
        TypedQuery<APIKeysEntity> query = em.createQuery("SELECT c FROM APIKeysEntity c WHERE c.Service LIKE :servName", APIKeysEntity.class)
                .setParameter("servName", "genius");
        apikey = query.getResultList();
      }catch(Exception e){
    e.toString();
      }
       return ApiKeyDTO.getDtos(apikey);
      }
}

