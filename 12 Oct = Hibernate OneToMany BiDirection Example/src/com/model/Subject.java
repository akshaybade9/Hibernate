package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Subject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Sub_id;
	
	private String Sub_name;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "stu_sub_Id")
	private Student student;

	public int getSub_id() {
		return Sub_id;
	}

	public void setSub_id(int sub_id) {
		Sub_id = sub_id;
	}

	public String getSub_name() {
		return Sub_name;
	}

	public void setSub_name(String sub_name) {
		Sub_name = sub_name;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Subject [Sub_id=" + Sub_id + ", Sub_name=" + Sub_name + "]";
	}
	
	
	
	
	
	

}
