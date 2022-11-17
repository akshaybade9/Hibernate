package com.service;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.model.Batch;
import com.model.Course;
import com.model.Faculty;
import com.model.Student;

import com.util.*;

public class OperationServiceImpl implements OperationService {
	SessionFactory sf = HibernateUtil.getSessionFactory();
	Scanner sc = new Scanner(System.in);

	@Override
	public void addCourse() {

		Session session = sf.openSession();
		Course c = new Course();
		System.out.println("Enter Course Name: ");
		c.setName(sc.next());

		session.save(c);
		session.beginTransaction().commit();
		System.out.println("Course added Successfully....");

	}

	@Override
	public void displayCourse() {
		Session session = sf.openSession();
		Query<Course> query = session.createQuery("from Course");
		List<Course> clist = query.getResultList();

		for (Course course : clist) {
			System.out.println(course);
		}

	}

	@Override
	public void addFacalty() {
		Session session = sf.openSession();
		Faculty faculty = new Faculty();

		System.out.println("Enter Faculty Name: ");
		faculty.setfName(sc.next());

		System.out.println("Enter Course id: ");
		int cid = sc.nextInt();

		Course course = session.get(Course.class, cid);

		if (course != null) {
			faculty.setCourse(course);
			session.save(faculty);
			session.beginTransaction().commit();
			System.out.println("Faculty Added Successfully...");

		} else {
			System.out.println("Course Not Found....................You Entered Invalid Course Id");
			addFacalty();
		}

	}

	@Override
	public void displayFacalty() {
		Session session = sf.openSession();

		Query<Faculty> query = session.createQuery("from Faculty");
		List<Faculty> flist = query.getResultList();
		for (Faculty faculty : flist) {
			System.out.println(faculty);
		}
	}

	@Override
	public void AddBatch() {
		Session session = sf.openSession();
		Batch batch = new Batch();

		System.out.println("Enter Batch Name: ");
		batch.setbName(sc.next());

		System.out.println("Enter Faculty Id:");
		int fid = sc.nextInt();

		Faculty faculty = session.get(Faculty.class, fid);
		if (faculty != null) {

			batch.setFaculty(faculty);

			session.save(batch);
			session.beginTransaction().commit();
			System.out.println("Add Batch Successfully...");
		} else {
			System.out.println("Faculty Not Found.....................You Enter Invalid Faculty Id");
			AddBatch();
		}
	}

	@Override
	public void DisplayBatch() {
		Session session = sf.openSession();
		Query<Batch> query = session.createQuery("from Batch");
		List<Batch> blist = query.getResultList();

		for (Batch batch : blist) {
			System.out.println(batch);
		}

	}

	@Override
	public void AddStudent() {
		Session session = sf.openSession();
		Student student = new Student();

		System.out.println("Enter Student Name: ");
		student.setsName(sc.next());

		System.out.println("Enter Batch Id: ");
		int bid = sc.nextInt();

		Batch batch = session.get(Batch.class, bid);

		if (batch != null) {
			student.setBatch(batch);

			session.save(student);
			session.beginTransaction().commit();

			System.out.println("Student added Successfully..");

		} else {
			System.out.println("Batch Not Found.............You Enter Inavalid Batch Id");
			AddStudent();
		}
	}

	@Override
	public void DisplayStudent() {
		Session session = sf.openSession();
		Query<Student> query = session.createQuery("from Student");
		List<Student> slist = query.getResultList();

		for (Student student : slist) {
			System.out.println(student);

		}
	}

}