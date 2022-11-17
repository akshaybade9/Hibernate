package com.secondLevelCache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.firstLevelCache.Student;

public class SecondLevelCache {
	
	public static void main(String[] args) {
		
	SessionFactory sf = HibernateUtil1.getSessionFactory();
		Session session =sf.openSession();
		
		Student1  s= session.get(Student1.class, 1);           
		System.out.println(s);
		
		session.clear();
		System.out.println("=======================================");
		
		Session session2 = sf.openSession();
		
		Student1  s2= session2.get(Student1.class, 1);           
		System.out.println(s2);
		
		
		
	}

}
