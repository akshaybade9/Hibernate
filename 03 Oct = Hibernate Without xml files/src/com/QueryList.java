package com;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class QueryList {

	
	
	public static void main(String[] args) {
SessionFactory sf = HibernateUtil.getSessionFactory();
		
		Session session = sf.openSession();
		
		Query<Employee> query = session.createQuery("from Employee");
		
		
		List<Employee> list = query.getResultList();
		System.out.println(list);
	}
}
