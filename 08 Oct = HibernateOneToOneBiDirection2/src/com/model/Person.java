package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Pid;
	
	private String Pname;
	
	private String Paddress;
	@OneToOne(cascade = CascadeType.ALL)
	private AdharCard adharCard;
	public int getPid() {
		return Pid;
	}
	public void setPid(int pid) {
		Pid = pid;
	}
	public String getPname() {
		return Pname;
	}
	public void setPname(String pname) {
		Pname = pname;
	}
	public String getPaddress() {
		return Paddress;
	}
	public void setPaddress(String paddress) {
		Paddress = paddress;
	}
	public AdharCard getAdharCard() {
		return adharCard;
	}
	public void setAdharCard(AdharCard adharCard) {
		this.adharCard = adharCard;
	}
	@Override
	public String toString() {
		return "Person [Pid=" + Pid + ", Pname=" + Pname + ", Paddress=" + Paddress + "]";
	}
	
	
	

}
