/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.Genius;

/**
 *2
 * @author mathi
 */
public class ResultDTO {
    private GeniusResultDTO result;

    public ResultDTO(GeniusResultDTO result) {
        this.result = result;
    }

    public GeniusResultDTO getResult() {
        return result;
    }

    public void setResult(GeniusResultDTO result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ResultDTO{" + "result=" + result + '}';
    }
    
    
    
}
