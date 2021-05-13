/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.PlaylistEnitity;
import entities.User;
import java.util.List;

/**
 *
 * @author mathi
 */
public class UserDTO {
    private String userName;
    private PlaylistEnitity playlist;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public PlaylistEnitity getPlaylist() {
        return playlist;
    }

    public void setPlaylist(PlaylistEnitity playlist) {
        this.playlist = playlist;
    }

 
    public UserDTO(User user) {
        this.userName = user.getUserName();
        this.playlist = user.getPlaylist();
    }

    @Override
    public String toString() {
        return "UserDTO{" + "userName=" + userName + ", playlist=" + playlist + '}';
    }
    
    
}
