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
public class Book extends Material{
    private String author;
    private String title;
    private String genre;
    private String language;
    private String sinopsis;
    private Date published;
    private String format;

    public Book(int cuantity, String id, String author, String title, String genre, String language, String sinopsis, Date published, String format) {
        super(cuantity, id);
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.language = language;
        this.sinopsis = sinopsis;
        this.published = published;
        this.format = format;
    }

    public Book() {
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getLanguage() {
        return language;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public Date getPublished() {
        return published;
    }

    public String getFormat() {
        return format;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public void setPublished(Date published) {
        this.published = published;
    }

    public void setFormat(String format) {
        this.format = format;
    }
    
    
    
}
