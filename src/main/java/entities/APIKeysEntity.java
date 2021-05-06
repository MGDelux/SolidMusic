/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author mathi
 */
@Entity
public class APIKeysEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Service;
    private String AuthKey;

    public APIKeysEntity(String Service, String AuthKey) {
        this.Service = Service;
        this.AuthKey = AuthKey;
    }

    public APIKeysEntity() {
    }

    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getService() {
        return Service;
    }

    public void setService(String Service) {
        this.Service = Service;
    }

    public String getAuthKey() {
        return AuthKey;
    }

    public void setAuthKey(String AuthKey) {
        this.AuthKey = AuthKey;
    }

    @Override
    public String toString() {
        return "APIKeysEntity{" + "id=" + id + ", Service=" + Service + ", AuthKey=" + AuthKey + '}';
    }
    

}
