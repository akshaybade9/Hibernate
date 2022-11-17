package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UpdateData {
	
	
	
	public static void main(String[] args) {
		
	SessionFactory sf = HibernateUtil.getSessionFactory();
		
		Session session = sf.openSession();
		
		
		
		Employee e =session.get(Employee.class, 13);
	//	System.out.println(e);
		
		e.setSalary(45000);
		
		session.update(e);
		session.beginTransaction().commit();
		
		
		
		
	}

}
