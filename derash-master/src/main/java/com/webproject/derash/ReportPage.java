package com.webproject.derash;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "user_form")
public class ReportPage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = true, length = 100)
    private String location;

    @Column(nullable = true, length = 25)
    private String date;
    
    @Column(nullable = true, length = 25)
    private String localtime;
    
    @Column(nullable = true, length = 100)
    private String incident;

    @Column(nullable = true, length = 64)
    private String image;



    
    public int getId() {
        return this.id;
    }
    public String getLocation() {
        return this.location;
    }
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getLocaltime() {
		return localtime;
	}
	public void setLocaltime(String localtime) {
		this.localtime = localtime;
	}
	public String getIncident() {
		return incident;
	}
	public void setIncident(String incident) {
		this.incident = incident;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
}
