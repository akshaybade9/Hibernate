package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Test {

	
	public static void main(String[] args) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		
		Session session = sf.openSession();
		
		Employee e = new Employee();
		
		e.setId(13);
		e.setName("Bade");
		e.setSalary(30000);
		
		session.save(e);
		
		session.beginTransaction().commit();
		
		System.out.println("Data Stored...");
	}
}
