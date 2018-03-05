/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Date;

/**
 *
 * @author jefal
 */
public class Loan {
    
    private Student student;
    private Material material;
    private Date endDate;
    private boolean finished;
    private int fee;

    public Loan(Student student, Material material, Date date, boolean finished, int fee) {
        this.student = student;
        this.material = material;
        this.endDate = date;
        this.finished = finished;
        this.fee = fee;
    }
    
    public Loan(Student student, Material material, Date date) {
        this.student = student;
        this.material = material;
        this.endDate = date;
        this.finished = false;
        this.fee = 0;
    }

    public Loan() {
    }

    public Student getStudent() {
        return student;
    }

    public Material getMaterial() {
        return material;
    }

    public Date getEndDate() {
        return endDate;
    }

    public boolean isFinished() {
        return finished;
    }

    public int getFee() {
        return fee;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public void setEndDate(Date date) {
        this.endDate = date;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "Loan{" + "student=" + student.toString() 
                + ", material=" + material.toString() 
                + ", date=" + endDate + ", finished=" 
                + finished + ", fee=" + fee + '}';
    }
    
    // Tamanno que va a tener el objeto en el RAF    
    public int size(){
        return 8 //Date size
               + 8 //Finished size
               + 4 //Fee size
               + 4 //Student index size
               + 11 * 2 //Type size
               + 4; //Material index size
    }
    
}
