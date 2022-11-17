package com;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(query =   "from Student", name = "allData"),
	@NamedQuery(query = "from Student where name=:id1" , name = "singleStudent"),
	@NamedQuery(query = "update from Student set name=:name1 , address = :address1 where id =:i" , name = "Update"),
	
	
})
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;

	private String name;

	private String address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
	
	

}
