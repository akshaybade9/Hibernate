package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Test {
	
	
	public static void main(String[] args) {
		
	
	SessionFactory sf=HibernateUtil.getSessionFactory();
	
	Session session =sf.openSession();
	
	Student s = new Student();
	
	//s.setId(1223);
	s.setAddress("Jamkhed");
	s.setName("Prakash");
	
	//System.out.println(s);
	
	
	session.save(s);
	
	session.beginTransaction().commit();
	
	System.out.println("Data Stored.......");
	}
}
