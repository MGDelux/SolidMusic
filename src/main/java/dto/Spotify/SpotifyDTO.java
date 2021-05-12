/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.Spotify;

/**
 *
 * @author mathi
 */
public class SpotifyDTO {
    private SpotifyMidDTO data;

    public SpotifyMidDTO getData() {
        return data;
    }

    public void setData(SpotifyMidDTO data) {
        this.data = data;
    }

    public SpotifyDTO(SpotifyMidDTO data) {
        this.data = data;
    }


}
