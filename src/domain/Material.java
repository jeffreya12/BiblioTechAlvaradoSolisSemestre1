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
    private int available;
    private String description;

    public Material(int cuantity, String id, int available, String description) {
        this.cuantity = cuantity;
        this.id = id;
        this.available = available;
        this.description = description;
    }

    public Material() {
    }

    public int getCuantity() {
        return cuantity;
    }

    public String getId() {
        return id;
    }

    public int getAvailable() {
        return available;
    }

    public String getDescription() {
        return description;
    }

    public void setCuantity(int cuantity) {
        this.cuantity = cuantity;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Material{" + "cuantity=" + cuantity + ", id=" + id + ", available=" + available + ", description=" + description + '}';
    }
    
}