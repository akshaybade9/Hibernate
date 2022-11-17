package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class LazyEagerLoading {
	
	
	public static void main(String[] args) {
		
		SessionFactory sf=HibernateUtil.getSessionFactory();
		
		Session session =sf.openSession();
		
		
		
		// Eager Loading
		
		Student  s= session.get(Student.class, 1);      // get ,   Hit Databade Always,  NullPointer,  after the query all details fetch
		System.out.println(s.getId());
		System.out.println(s.getName());
		System.out.println(s.getAddress());
		
		System.out.println("===========================");
		
		// Lazy Loading
		
		Student s1 = session.load(Student.class, 3);        // load,    Data fetch Partially,  ObjectNotFound,  id aadhi deto baki detail nantr
	
		System.out.println(s1.getId());
		System.out.println(s1.getName());
		System.out.println(s1.getAddress());
	}

}
