package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
	
	
	
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		
		SessionFactory sf =cfg.buildSessionFactory();
		
		Session session =sf.openSession();
		
		Employee e = session.get(Employee.class, 14);
		
		System.out.println(e);
	}

}
