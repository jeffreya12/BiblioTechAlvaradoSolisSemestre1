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
public class Book extends Media{
    private String author;
    private String language;
    private String format;

    public Book(String author, String language, String format, String title, String genre, Date published) {
        super(title, genre, published);
        this.author = author;
        this.language = language;
        this.format = format;
    }

    public Book(String author, String language, String format) {
        this.author = author;
        this.language = language;
        this.format = format;
    }

    public Book() {
    }

    public String getAuthor() {
        return author;
    }

    public String getLanguage() {
        return language;
    }

    public String getFormat() {
        return format;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return "Book{" + "author=" + author + ", language=" + language + ", format=" + format + '}';
    }

}
