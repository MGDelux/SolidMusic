/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.Genius;

/**
 * 1
 * @author mathi
 */
public class ToSongDTO {
    private ResultDTO SelectedSong;

    public ResultDTO getSelectedSong() {
        return SelectedSong;
    }

    public void setSelectedSong(ResultDTO SelectedSong) {
        this.SelectedSong = SelectedSong;
    }

    public ToSongDTO(ResultDTO SelectedSong) {
        this.SelectedSong = SelectedSong;
    }

    @Override
    public String toString() {
        return "ToSongDTO{" + "SelectedSong=" + SelectedSong + '}';
    }

    
  
  
  
  
}
