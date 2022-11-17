package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sid;
	
	private String name;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
	List<Subject> slist = new ArrayList<>();


	public int getSid() {
		return sid;
	}


	public void setSid(int sid) {
		this.sid = sid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<Subject> getSlist() {
		return slist;
	}


	public void setSlist(List<Subject> slist) {
		this.slist = slist;
	}


	@Override
	public String toString() {
		return "Student [sid=" + sid + ", name=" + name + " ]";
	}
	
	
	
	
}
