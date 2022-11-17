package com;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
	
	
	
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		
		SessionFactory sf=cfg.buildSessionFactory();
		Session  session=sf.openSession();
		
		Employee e1 = new Employee();
		
		e1.setId(15);
		e1.setName("Sonu");
	
		
		session.save(e1);
		
		session.beginTransaction().commit();
		
		System.out.println("Data Stored...");
		
	}

}
