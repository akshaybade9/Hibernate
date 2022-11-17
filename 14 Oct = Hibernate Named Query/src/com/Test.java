  package com;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class Test {

	public static void main(String[] args) {
		
	
	SessionFactory sf = HibernateUtil.getSessionFactory();
	
	
	Session session = sf.openSession();
	
//	Student student = new Student();
//	
//	student.setName("Vanve");
//	student.setAddress("Ashti");
//	session.save(student);
//	System.out.println("Data Stored....");
//	
	Query<Student> query = session.createNamedQuery("allData");
	List<Student> slist = query.getResultList();
	System.out.println(slist);
	
	
    Query<Student> query1 = session.createNamedQuery("singleStudent") ;
    query1.setParameter("id1", "Akshay");
    Student s= query1.getSingleResult();
    System.out.println(s);
	
	session.beginTransaction();

    Query<Student> query2 = session.createNamedQuery("Update");
    query2.setParameter("name1", "Vanve");
    query2.setParameter("address1", "Moha");

    query2.setParameter("i", 2);
    query2.executeUpdate();
    session.getTransaction();
    
    
	
	
	
	
	}
	
}
