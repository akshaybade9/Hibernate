package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {

	
	
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session = sf.openSession();
		
//		student student = new student();
//		student.setId(1);
//		student.setName("Akshay");
//		student.setAddress("Jamkhed");
//		
//		session.save(student);
//		
		session.beginTransaction().commit();

		System.out.println("Data Stored");
		
		
		
	}
}
