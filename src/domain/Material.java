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
    private int quantity;
    private String id;
    private int available;
    private String description;

    public Material(int quantity, String id, int available, String description) {
        this.quantity = quantity;
        this.id = id;
        this.available = available;
        this.description = description;
    }

    public Material() {
    }

    public int getQuantity() {
        return quantity;
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

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
        return "Material{" + "quantity=" + quantity + ", id=" + id + ", available=" + available + ", description=" + description + '}';
    }
    
    // Tamanno que va a tener el objeto en el RAF
    public int size(){
        return this.getDescription().length() * 2 // description 
                + this.getId().length() * 2 // id
                + 4 // available
                + 4; // quantity
    }
    
}