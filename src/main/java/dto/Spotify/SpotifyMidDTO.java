/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.Spotify;

import java.util.List;

/**
 *
 * @author mathi
 */
public class SpotifyMidDTO {
    List<String> items;

    public SpotifyMidDTO(List<String> items) {
        this.items = items;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }
    
}
