package com;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate                                                                           // Dirty Check Overcome Krte...evrytime saglya field update karat nahi
public class Product {                                                                   // Performance Increase
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int pid;

	private String name;
	
	private String Type;

	private long Price;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPrice() {
		return Price;
	}

	public void setPrice(long price) {
		Price = price;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", name=" + name + ", Type=" + Type + ", Price=" + Price + "]";
	}





}
