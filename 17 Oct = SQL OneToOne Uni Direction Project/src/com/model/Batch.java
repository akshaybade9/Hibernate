package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Batch {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private int bid;
	private String bName;
	@OneToOne(cascade = CascadeType.ALL)
	private Faculty faculty;

	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public Faculty getFaculty() {
		return faculty;
	}
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	@Override
	public String toString() {
		return "Batch [bid=" + bid + ", bName=" + bName + ", faculty=" + faculty + "]";
	}


	
	
}



