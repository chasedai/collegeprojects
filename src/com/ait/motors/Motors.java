package com.ait.motors;


import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Motors {

    private int id;

    private String make;

    private String year;

    private String mileage;
    
    private String colour;

    private String engine;
    
    private String description;
    
    private String picture;

    
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMileage() {
		return mileage;
	}

	public void setMileage(String milleage) {
		this.mileage = milleage;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}
	
	public String getEngine() {
		return engine;
	}

	public void setEngine(String EngineSize) {
		this.engine = EngineSize;
	}
		

}

