package com.yuhong.model;
 
import java.io.Serializable;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Toy")
public class Toy implements Serializable {

    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "genre", nullable = false, unique = true)
    private String genre;


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

    public String getGenre() {
    	return genre;
    }

    public void setGenre(String genre) {
    	this.genre = genre;
    }

}