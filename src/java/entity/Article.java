/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;

/**
 *
 * @author bactv
 */
public class Article {
    private int id;
    private String title;
    private int year;
    private String publisher;
    private List<Author> listAuthor;
    private String Abstract;

    public Article() {
    }

    public Article(int id, String title, int year, String publisher, List<Author> listAuthor, String Abstract) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.publisher = publisher;
        this.listAuthor = listAuthor;
        this.Abstract = Abstract;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public List<Author> getListAuthor() {
        return listAuthor;
    }

    public void setListAuthor(List<Author> listAuthor) {
        this.listAuthor = listAuthor;
    }

    public String getAbstract() {
        return Abstract;
    }

    public void setAbstract(String Abstract) {
        this.Abstract = Abstract;
    }

  

            
}
