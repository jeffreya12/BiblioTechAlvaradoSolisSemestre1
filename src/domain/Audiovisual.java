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
public class Audiovisual extends Material{
    
    private String brand;
    private String model;
    private String kind;
    private String description;

    public Audiovisual(String brand, String model, String kind, String description, int cuantity, String id) {
        super(cuantity, id);
        this.brand = brand;
        this.model = model;
        this.kind = kind;
        this.description = description;
    }

    public Audiovisual() {
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getKind() {
        return kind;
    }

    public String getDescription() {
        return description;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    
}
