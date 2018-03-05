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
public class MediaPlayer extends Material{
    
    private String brand;
    private String model;
    private String kind;

    public MediaPlayer(String brand, String model, String kind, int quantity, String id, int available, String description) {
        super(quantity, id, available, description);
        this.brand = brand;
        this.model = model;
        this.kind = kind;
    }

    public MediaPlayer(String brand, String model, String kind, String description) {
        this.brand = brand;
        this.model = model;
        this.kind = kind;
    }

    

    public MediaPlayer() {
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
        return super.toString() + "\nAudiovisual{" + "brand=" + brand + ", model=" + model + ", kind=" + kind + '}';
    }
    
    // Tamanno que va a tener el objeto en el RAF
    public int size(){
        return super.size()
                + this.getBrand().length() * 2 
                + this.getModel().length() * 2 
                + this.getKind().length() * 2;
    }
}
