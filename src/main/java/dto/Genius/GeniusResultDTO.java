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
public class GeniusResultDTO {
    private String api_path;
    private String full_title;
    private String header_image_thumbnail_url;
    private String header_image_url;
    private String path;
    private String url;
    private String title;
    private String title_with_featured;
 
    private GeniusResultDTO result;
    private GeniusArtistDTO primary_artist;

    public GeniusResultDTO(String api_path, String full_title, String header_image_thumbnail_url, String header_image_url, String path, String url, String title, String title_with_featured, GeniusResultDTO result, GeniusArtistDTO primary_artist) {
        this.api_path = api_path;
        this.full_title = full_title;
        this.header_image_thumbnail_url = header_image_thumbnail_url;
        this.header_image_url = header_image_url;
        this.path = path;
        this.url = url;
        this.title = title;
        this.title_with_featured = title_with_featured;
        this.result = result;
        this.primary_artist = primary_artist;
    }

    public String getApi_path() {
        return api_path;
    }

    public void setApi_path(String api_path) {
        this.api_path = api_path;
    }

    public String getFull_title() {
        return full_title;
    }

    public void setFull_title(String full_title) {
        this.full_title = full_title;
    }

    public String getHeader_image_thumbnail_url() {
        return header_image_thumbnail_url;
    }

    public void setHeader_image_thumbnail_url(String header_image_thumbnail_url) {
        this.header_image_thumbnail_url = header_image_thumbnail_url;
    }

    public String getHeader_image_url() {
        return header_image_url;
    }

    public void setHeader_image_url(String header_image_url) {
        this.header_image_url = header_image_url;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle_with_featured() {
        return title_with_featured;
    }

    public void setTitle_with_featured(String title_with_featured) {
        this.title_with_featured = title_with_featured;
    }

    public GeniusResultDTO getResult() {
        return result;
    }

    public void setResult(GeniusResultDTO result) {
        this.result = result;
    }

    public GeniusArtistDTO getPrimary_artist() {
        return primary_artist;
    }

    public void setPrimary_artist(GeniusArtistDTO primary_artist) {
        this.primary_artist = primary_artist;
    }

    @Override
    public String toString() {
        return "GeniusResultDTO{" + "api_path=" + api_path + ", full_title=" + full_title + ", header_image_thumbnail_url=" + header_image_thumbnail_url + ", header_image_url=" + header_image_url + ", path=" + path + ", url=" + url + ", title=" + title + ", title_with_featured=" + title_with_featured + ", result=" + result + ", primary_artist=" + primary_artist + '}';
    }

   
}
