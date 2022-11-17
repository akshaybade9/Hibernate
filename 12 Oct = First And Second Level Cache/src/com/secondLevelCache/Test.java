package com.secondLevelCache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

public class Test {
	
	public static void main(String[] args) {
		
	
	SessionFactory sf=HibernateUtil1.getSessionFactory();
	
	Session session =sf.openSession();
	
	Student1 s = new Student1();
	
	//s.setId(1223);
	s.setAddress("Pune");
	s.setName("Akshay");
	
	//System.out.println(s);
	
	
	session.save(s);
	
	session.beginTransaction().commit();
	
	System.out.println("Data Stored.......");
	}
}
