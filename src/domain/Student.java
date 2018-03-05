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
public class Student {
    
    private String name;
    private String lastNames;
    private String id;

    public Student(String name, String lastNames, String id) {
        this.name = name;
        this.lastNames = lastNames;
        this.id = id;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public String getLastNames() {
        return lastNames;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastNames(String lastNames) {
        this.lastNames = lastNames;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", lastNames=" + lastNames + ", id=" + id + '}';
    }
    
    // Tamanno que va a tener el objeto en el RAF
    public int size(){
        return this.getLastNames().length() * 2 
                + this.getName().length() * 2 
                + this.getId().length() * 2;
    }
    
}
