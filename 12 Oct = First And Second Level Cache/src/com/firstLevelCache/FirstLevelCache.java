package com.firstLevelCache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class FirstLevelCache {
	
	
	public static void main(String[] args) {
		
	SessionFactory sf=HibernateUtil.getSessionFactory();
		
		Session session =sf.openSession();
		// first level cache Check...(i.e....session)
		
		Student  s= session.get(Student.class, 1);           
		System.out.println(s.getId());
		System.out.println(s.getName());
		System.out.println(s.getAddress());
		
//		Student  s2= session.get(Student.class, 2);           
//		System.out.println(s2.getId());
//		System.out.println(s2.getName());
//		System.out.println(s2.getAddress());
		
		
		
		System.out.println("==============================");
		
	//	session.evict(s);                                       	// to remove particular object from first level cache
	//	session.clear();
      	
		System.out.println("==============================");
		
		Student  s1= session.get(Student.class, 1);         
		System.out.println(s1.getId());
		System.out.println(s1.getName());
		System.out.println(s1.getAddress());
		
		Student  s3= session.get(Student.class, 2);         
		System.out.println(s3.getId());
		System.out.println(s3.getName());
		System.out.println(s3.getAddress());
	}

}
