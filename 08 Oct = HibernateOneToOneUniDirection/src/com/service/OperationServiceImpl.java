package com.service;

import java.util.Scanner;

import javax.persistence.Query;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.mapping.List;

import com.model.Address;
import com.model.Student;
import com.util.HibernateUtil;

public class OperationServiceImpl implements OperationService {

	
	SessionFactory sf = HibernateUtil.getSessionFactory();
	Scanner sc = new Scanner(System.in);
	
	@Override
	public void insertStudentWithAddress() {

		Session session = sf.openSession();

		Student s = new Student();
		Address a = new Address();

		System.out.println("Enter Student name: ");
		s.setName(sc.next());

		System.out.println("Enter Student email: ");
		s.setEmail(sc.next());

		System.out.println("Enter City: ");
		a.setCity(sc.next());

		System.out.println("Enter Dist");
		a.setDist(sc.next());

		s.setAddress(a);
		session.save(s);
		session.beginTransaction().commit();
		System.out.println("Insert Student Suscessfully...");

	}

	@Override
	public void showAllData() {
		
		Session session = sf.openSession();
		
	org.hibernate.query.Query<Student> query=session.createQuery("from Student");
	java.util.List<Student> slist=query.getResultList();
	System.out.println(slist);
		

	}

	@Override
	public void getSingleStudentWithAddress() {
	
		Session session = sf.openSession();
		
		System.out.println("Enter Id: ");
		int Id = sc.nextInt();
		Student student = session.get( Student.class, Id );
		
		if(student !=null) {
			System.out.println(student);
		}else {
			System.out.println("Student Not Found");
		}
		
	
	}

	@Override
	public void updateStudent() {

		Session session = sf.openSession();
		
		System.out.println("Enter Id: " );
		int Id = sc.nextInt();
		
	
		Student student=session.get(Student.class, Id);
		
		if(student!=null) {
			System.out.println("Enter Student name: ");
			student.setName(sc.next());

			System.out.println("Enter Student email: ");
			student.setEmail(sc.next());
			
			session.update(student);
			session.beginTransaction().commit();
			System.out.println("Update Student Succesfully...");
			
			
			
		}
		
		
	}

	@Override
	public void updateAddressUsingStudent() {

		Session session= sf.openSession();
		
		System.out.println("Enter Id: ");
		int iid = sc.nextInt();
		
		Student student = session.get(Student.class, iid);
		
		
		if(student!=null) {
			Address address = student.getAddress();
			if(address!=null) {
			
				System.out.println("Enter City: ");
				address.setCity(sc.next());

				System.out.println("Enter Dist");
				address.setDist(sc.next());
				
				session.update(student);
				session.beginTransaction().commit();
				
				System.out.println("Update Address Using Student Successfully...");
				
			}else {
				System.out.println("Address Not Found...");
			}
		}else {
			System.out.println("Student Not Found...");
		}
		
		
	}
	
	@Override
	public void deleteStudent() {
		Session session = sf.openSession();
		
		System.out.println("Enter Id: ");
		int Id = sc.nextInt();
		Student student = session.get(Student.class, Id);
		if(student!=null) {
			session.delete(student);
			session.beginTransaction().commit();
			System.out.println("Delete Student Succesfully...");
		}else {
			System.out.println("Student Not Found");
		}
		
	}
	

	
	
}
