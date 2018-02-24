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

    public Audiovisual(String brand, String model, String kind, int cuantity, String id, int available, String description) {
        super(cuantity, id, available, description);
        this.brand = brand;
        this.model = model;
        this.kind = kind;
    }

    public Audiovisual(String brand, String model, String kind, String description) {
        this.brand = brand;
        this.model = model;
        this.kind = kind;
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

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    @Override
    public String toString() {
        return "Audiovisual{" + "brand=" + brand + ", model=" + model + ", kind=" + kind + '}';
    }    
}
