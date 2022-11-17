package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int Aid;
	private String  City;
	private String Dist;
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getDist() {
		return Dist;
	}
	public void setDist(String dist) {
		Dist = dist;
	}
	public int getAid() {
		return Aid;
	}
	public void setAid(int aid) {
		Aid = aid;
	}
	@Override
	public String toString() {
		return "Address [Aid=" + Aid + ", City=" + City + ", Dist=" + Dist + "]";
	}
	
	
	
	

}
