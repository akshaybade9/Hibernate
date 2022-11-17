package com.service;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.Student;
import com.model.Subject;
import com.util.HibernateUtil;

public class OperationServiceImpl implements OperationService {

	SessionFactory sf = HibernateUtil.getSessionFactory();

	@Override
	public void addStudentWithMultipleSubject() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Scanner sc = new Scanner(System.in);

		Student student = new Student();

		System.out.println("Enter Student Name: ");
		student.setName(sc.next());

		System.out.println("Enter How Many Subject Registered By Student: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {

			Subject subject = new Subject();

			System.out.println("Enter Subject Name: ");
			subject.setSub_name(sc.next());
			student.getSlist().add(subject);
			subject.setStudent(student);

			session.save(student);
			session.save(subject);

		}
		session.beginTransaction().commit();
		System.out.println("Data Stored......");

	}

	@Override
	public void showAllStudentDataWithMultipleSubject() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();

		List<Student> slist = session.createQuery("from Student").getResultList();
		for (Student s : slist) {
			System.out.println(s);
		}

	}

	@Override
	public void getSingeStudentWithMultipleSubject() {
		// TODO Auto-generated method stub

		Session session = sf.openSession();
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Student Id: ");
		int id = sc.nextInt();

		Student student = session.get(Student.class, id);

		if (student != null) {
			System.out.println(student);
		} else {
			System.out.println("Student Not Found");
			getSingeStudentWithMultipleSubject();
		}

	}

	@Override
	public void updateStudent() {
		// TODO Auto-generated method stub

		Session session = sf.openSession();
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Student Id: ");
		int id = sc.nextInt();

		Student student = session.get(Student.class, id);

		if (student != null) {
			System.out.println("Enter Student Name: ");
			student.setName(sc.next());

			session.update(student);
			session.beginTransaction().commit();
		} else {
			System.out.println("Student Not Found");
			updateStudent();
		}

		System.out.println("Update Data Successfully....");
	}

	@Override
	public void updatePerticularSubjectusingStudentId() {
		// TODO Auto-generated method stub

		Session session = sf.openSession();
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Student Id: ");
		int id = sc.nextInt();

		Student student = session.get(Student.class, id);

		if (student != null) {

			List<Subject> slist = student.getSlist();

			System.out.println("Enter Subject Id: ");
			int sub_id = sc.nextInt();
			for (Subject sub : slist) {
				if (sub.getSub_id() == sub_id) {

					System.out.println("Enter Subject Name ");
					sub.setSub_name(sc.next());
					session.update(sub);

					session.beginTransaction().commit();
				}

			}
		} else {
			System.out.println("Student Not Found");
			updatePerticularSubjectusingStudentId();

		}
	}

	@Override
	public void deleteStudent() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Student Id: ");
		int id = sc.nextInt();

		Student student = session.get(Student.class, id);

		if (student != null) {

			session.delete(student);
			session.beginTransaction().commit();
		} else {
			System.out.println("Student Not Found");
			deleteStudent();
		}

		System.out.println("Delete Student Successfully....");

	}

	@Override
	public void addMultipleSubjectToSingleStudent() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Student Id: ");
		int id = sc.nextInt();

		Student student = session.get(Student.class, id);

		if (student != null) {
			System.out.println("Enter How Many Subject U want To Add: ");
			int n = sc.nextInt();
			for (int i = 1; i <= n; i++) {
				Subject subject = new Subject();

				System.out.println("Enter Subject Name: ");
				subject.setSub_name(sc.next());
				student.getSlist().add(subject);
				subject.setStudent(student);

				session.save(subject);
				session.save(student);
			}
			session.beginTransaction().commit();

		} else {
			System.out.println("Student Not Found...");
			addMultipleSubjectToSingleStudent();
		}

		System.out.println("Add Subject Suscesssfully.....");

	}

	@Override
	public void showAllSubjectWithStudentData() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();

		List<Subject> slist = session.createQuery("from Subject").getResultList();
		for (Subject s : slist) {
			System.out.println(s);
		}

	}

	@Override
	public void getSingleSubjectWithStudentData() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Scanner sc = new Scanner(System.in);
		Subject subject = new Subject();

		System.out.println("Enter Subject Id: ");
		int id = sc.nextInt();

		Subject subject2 = session.get(Subject.class, id);

		if (subject2 != null) {
			System.out.println(subject2);

		} else {
			System.out.println("Subject Not Found....");

		}

	}

	@Override
	public void updateSubject() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Scanner sc = new Scanner(System.in);
		Subject subject = new Subject();

		System.out.println("Enter Subject Id: ");
		int id = sc.nextInt();

		Subject subject2 = session.get(Subject.class, id);

		if (subject2 != null) {

			System.out.println("Enter Subject Name: ");
			subject2.setSub_name(sc.next());

			session.update(subject2);
			session.beginTransaction().commit();

		} else {
			System.out.println("Subject Not Found....");
			updateSubject();

		}

		System.out.println("Update Subject Successfully...");
	}

}
