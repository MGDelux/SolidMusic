/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.Genius;

import java.util.List;

/**
 *
 * @author mathi
 */
public class GeniusMidDTO {
    List<GeniusDTO> hits;

    public GeniusMidDTO(List<GeniusDTO> hits) {
        this.hits = hits;
    }

    
    
    public List<GeniusDTO> getHits() {
        return hits;
    }

    public void setHits(List<GeniusDTO> hits) {
        this.hits = hits;
    }

    @Override
    public String toString() {
        return "GeniusMidDTO{" + "hits=" + hits + '}';
    }
    
    
}
