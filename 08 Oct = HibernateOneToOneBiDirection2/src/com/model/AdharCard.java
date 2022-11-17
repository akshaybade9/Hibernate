package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class AdharCard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Aid; 
	private String Aname;
	
	private String Anumber;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Person person;

	public int getAid() {
		return Aid;
	}

	public void setAid(int aid) {
		Aid = aid;
	}

	public String getAname() {
		return Aname;
	}

	public void setAname(String aname) {
		Aname = aname;
	}

	public String getAnumber() {
		return Anumber;
	}

	public void setAnumber(String anumber) {
		Anumber = anumber;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "AdharCard [Aid=" + Aid + ", Aname=" + Aname + ", Anumber=" + Anumber + "]";
	}
	
	
	

}
