/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.APIKeysEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mathi
 */
public class ApiKeyDTO {
    private String AuthKey;

 public ApiKeyDTO(APIKeysEntity api){
     this.AuthKey = api.getAuthKey();
 }

      public ApiKeyDTO(String auth) {
          this.AuthKey = auth;
      }
      

     public static List<ApiKeyDTO> getDtos(List<APIKeysEntity> rms){
        List<ApiKeyDTO> rmdtos = new ArrayList();
        rms.forEach(rm->rmdtos.add(new ApiKeyDTO(rm)));
        return rmdtos;
    }

 

    public String getAuthKey() {
        return AuthKey;
    }

    public void setAuthKey(String AuthKey) {
        this.AuthKey = AuthKey;
    }

    @Override
    public String toString() {
        return "ApiKeyDTO{" + "AuthKey=" + AuthKey + '}';
    }
    
    
    
}
