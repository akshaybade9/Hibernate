package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Test {

	
	
	public static void main(String[] args) {
		SessionFactory sf =HibernateUtil.getSessionFactory();
	
		Session session = sf.openSession();
		
		
		Student s = new Student();
		s.setName("Akshay");
		s.setAddress("Pune");
		session.save(s);

		
		Employee e = new Employee();
		e.setName("Employee");
		session.save(e);
		
		session.beginTransaction().commit();
		
		System.out.println("Data Stored...");
	}
}
