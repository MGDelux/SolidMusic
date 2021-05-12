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
public class GeniusDTO {
    private String index;
    private String type;
    private GeniusResultDTO result;

    public GeniusResultDTO getResult() {
        return result;
    }

    public void setResult(GeniusResultDTO result) {
        this.result = result;
    }

    public GeniusDTO(String index, String type, GeniusResultDTO result) {
        this.index = index;
        this.type = type;
        this.result = result;
    }

 
    
    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "GeniusDTO{" + "index=" + index + ", type=" + type + ", result=" + result + '}';
    }

  
    
}
