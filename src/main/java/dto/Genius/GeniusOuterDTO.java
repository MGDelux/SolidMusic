/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.Genius;

/**
 *
 * @author mathi
 */
public class GeniusOuterDTO {
   private GeniusMidDTO response;

    public GeniusOuterDTO(GeniusMidDTO response) {
        this.response = response;
    }

   
   
   
    public GeniusMidDTO getResponse() {
        return response;
    }

    public void setResponse(GeniusMidDTO response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "GeniusOuterDTO{" + "response=" + response + '}';
    }


 
    
   
   
}
