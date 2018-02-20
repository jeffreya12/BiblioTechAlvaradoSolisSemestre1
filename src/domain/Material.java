/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author jefal
 */
public class Material {
    private int cuantity;
    private String id;

    public Material(int cuantity, String id) {
        this.cuantity = cuantity;
        this.id = id;
    }

    public Material() {
    }

    public int getCuantity() {
        return cuantity;
    }

    public String getId() {
        return id;
    }

    public void setCuantity(int cuantity) {
        this.cuantity = cuantity;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
    
}
