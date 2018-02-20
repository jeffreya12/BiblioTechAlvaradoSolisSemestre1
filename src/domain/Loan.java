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
    private Date date;
    private boolean finished;
    private int fee;

    public Loan(Student student, Material material, Date date, boolean finished, int fee) {
        this.student = student;
        this.material = material;
        this.date = date;
        this.finished = finished;
        this.fee = fee;
    }

    public Loan() {
    }

    public Student getStudent() {
        return student;
    }

    public Material getMaterial() {
        return material;
    }

    public Date getDate() {
        return date;
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

    public void setDate(Date date) {
        this.date = date;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }
    
    
    
}
