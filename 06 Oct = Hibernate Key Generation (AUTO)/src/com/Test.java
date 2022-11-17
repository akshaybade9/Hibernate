package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Test {
	
	
	public static void main(String[] args) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
	   Session session = sf.openSession();
	   
	   
	   School s = new School();
	   s.setName("Nagesh Vidyalaya");
	   
	   session.save(s);
	   
	//   session.beginTransaction().commit();

	   
	   
	   System.out.println("Stored...");
	   
	   Employee e = new Employee();
	   e.setEname("Akshay");
	   
	   session.save(e);
	   
	   
	   session.beginTransaction().commit();

	   
	   
	}
	

}
