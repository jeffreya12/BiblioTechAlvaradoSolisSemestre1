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
public class Media extends Material{
    private String title;
    private String genre;
    private Date published;

    public Media(String title, String genre, Date published, int quantity, String id, int available, String description) {
        super(quantity, id, available, description);
        this.title = title;
        this.genre = genre;
        this.published = published;
    }

    public Media(String title, String genre, Date published) {
        this.title = title;
        this.genre = genre;
        this.published = published;
    }

    public Media() {
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public Date getPublished() {
        return published;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPublished(Date published) {
        this.published = published;
    }

    @Override
    public String toString() {
        return super.toString() + "\nMedia{" + "title=" + title 
                + ", genre=" + genre + ", published=" + published + '}';
    }
    
    public int size(){
        return super.size()
                + this.getTitle().length() * 2 
                + this.getGenre().length() * 2 
                + 8; // Tamanno long de Date
    }
    
}
