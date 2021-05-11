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
public class GeniusArtistDTO {
   private String api_path;
   private String header_image_url;
   private String name;
   private String url;

   public GeniusArtistDTO(String api_path, String header_image_url, String name, String url) {
        this.api_path = api_path;
        this.header_image_url = header_image_url;
        this.name = name;
        this.url = url;
    }

    public String getApi_path() {
        return api_path;
    }

    public void setApi_path(String api_path) {
        this.api_path = api_path;
    }

    public String getHeader_image_url() {
        return header_image_url;
    }

    public void setHeader_image_url(String header_image_url) {
        this.header_image_url = header_image_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "GeniusArtistDTO{" + "api_path=" + api_path + ", header_image_url=" + header_image_url + ", name=" + name + ", url=" + url + '}';
    }

   
   
   
}
