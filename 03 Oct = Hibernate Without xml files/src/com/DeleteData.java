package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DeleteData {

	
	public static void main(String[] args) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();

		Session session = sf.openSession();

		Employee e =session.get(Employee.class, 12);
		
		session.delete(e);
		session.beginTransaction().commit();
		

	}
}
