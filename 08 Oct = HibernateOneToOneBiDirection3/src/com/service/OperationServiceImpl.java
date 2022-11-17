package com.service;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.AdharCard;
import com.model.Person;
import com.util.HibernateUtil;

public class OperationServiceImpl implements OperationService {

	

	SessionFactory sf = HibernateUtil.getSessionFactory();
	Scanner sc = new Scanner(System.in);

	@Override
	public void addPersonWithAadharCard() {

		Session session = sf.openSession();

		AdharCard card = new AdharCard();
		Person person = new Person();

		System.out.println("Enter Person Adhar Name: ");
		card.setAname(sc.next());

		System.out.println("Enter Person Adhar Number: ");
		card.setAnumber(sc.next());

		boolean flag = true;

		String name = getValidPersonName();

		while (flag) {
			if (name.equals(card.getAname())) {
				person.setPname(name);
				flag = false;

			} else {
				name= getValidPersonName();
			}
		}
		System.out.println("Enter Person Address: ");
		person.setPaddress(sc.next());

		person.setAdharCard(card);
		card.setPerson(person);

		session.save(person);

		session.beginTransaction().commit();

		System.out.println("Add Data Successfully...");

	}

	private String getValidPersonName() {

		System.out.println("Enter Person Name From Adhar Details: ");
		String name = sc.next();

		return name;

	}

	@Override
	public void getAllPersonDataWithAadharData() {

		Session session = sf.openSession();
		org.hibernate.query.Query<Person> query = session.createQuery("from Person");
		List<Person> pList = query.getResultList();
//		System.out.println(pList);

		for (Person person : pList) {
			System.out.println(person.getPid() + " " + person.getPname() + " " + person.getPaddress());
			System.out.println(person.getAdharCard().getAid() + " " + person.getAdharCard().getAname() + " "
					+ person.getAdharCard().getAnumber());
		}

	}

	@Override
	public void getSinglePersonDataWithAadharData() {

		Session session = sf.openSession();
		System.out.println("Enter Person Id: ");
		int Id = sc.nextInt();
		Person personn = session.get(Person.class, Id);
		if (personn != null) {
			System.out.println(personn);
		} else {

			System.out.println("Person Not Found...");
		}
	}

	@Override
	public void updatePerson() {

		Session session = sf.openSession();

		System.out.println("Enter Person Id: ");
		int Id = sc.nextInt();

		Person person = session.get(Person.class, Id);

		if (person != null) {
			System.out.println("Enter Person Name: ");
			person.setPname(sc.next());

			System.out.println("Enter Person Address: ");
			person.setPaddress(sc.next());

			session.update(person);
			session.beginTransaction().commit();
			System.out.println("Update Person Succesfully...");

		}
	}

	@Override
	public void updateAadharUsingPersonId() {

		Session session = sf.openSession();

		System.out.println("Enter Person Id: ");
		int iid = sc.nextInt();

		Person person = session.get(Person.class, iid);

		if (person != null) {
			AdharCard adharCard = person.getAdharCard();
			if (adharCard != null) {

				System.out.println("Enter Adhar Name: ");
				adharCard.setAname(sc.next());

				System.out.println("Enter Adhar Number: ");
				adharCard.setAnumber(sc.next());

				session.update(adharCard);
				session.beginTransaction().commit();

				System.out.println("Update AdharCard Details Using Person Id Successfully...");

			} else {
				System.out.println("Adhar Card No Not Found...");
			}
		} else {
			System.out.println("Person Not Found...");
		}

	}

	@Override
	public void addAadharDataWithPerson() {

		Session session = sf.openSession();

		AdharCard card = new AdharCard();
		Person person = new Person();

		System.out.println("Enter Person Adhar Name: ");
		card.setAname(sc.next());

		System.out.println("Enter Person Adhar Number: ");
		card.setAnumber(sc.next());

		System.out.println("Enter Person Name: ");
		person.setPname(sc.next());

		System.out.println("Enter Person Address: ");
		person.setPaddress(sc.next());

		card.setPerson(person);
		person.setAdharCard(card);

		session.save(card);

		session.beginTransaction().commit();

		System.out.println("Add Data Successfully...");

	}

	@Override
	public void getAllAadharDataWithPersonData() {

		Session session = sf.openSession();
		org.hibernate.query.Query<AdharCard> query = session.createQuery("from AdharCard");
		List<AdharCard> pList = query.getResultList();
		for (AdharCard adharCard : pList) {
			System.out.println(adharCard.getAid() + " " + adharCard.getAname() + " " + adharCard.getAnumber());
			System.out.println(adharCard.getPerson().getPid() + " " + adharCard.getPerson().getPname() + " "
					+ adharCard.getAnumber());
		}

	}

	@Override
	public void getSingleAadharDatawithPerson() {

		Session session = sf.openSession();
		System.out.println("Enter Adhar Id: ");
		int Id = sc.nextInt();
		AdharCard adharCard = session.get(AdharCard.class, Id);
		if (adharCard != null) {
			System.out.println(adharCard);
		} else {

			System.out.println("Person Not Found...");
		}
	}

	@Override
	public void upadateAadharData() {

		Session session = sf.openSession();

		System.out.println("Enter Adhar Id: ");
		int Id = sc.nextInt();

		AdharCard adharCard = session.get(AdharCard.class, Id);

		if (adharCard != null) {
			System.out.println("Enter Person Name: ");
			adharCard.setAname(sc.next());

			System.out.println("Enter Person Address: ");
			adharCard.setAnumber(sc.next());

			session.update(adharCard);
			session.beginTransaction().commit();
			System.out.println("Update Student Succesfully...");

		}

	}

	@Override
	public void updatePersonUsingAadharData() {

		Session session = sf.openSession();

		System.out.println("Enter Adhar Id: ");
		int iid = sc.nextInt();

		AdharCard adharCard = session.get(AdharCard.class, iid);

		if (adharCard != null) {
			Person person = adharCard.getPerson();
			if (person != null) {

				System.out.println("Enter Person Name: ");
				person.setPname(sc.next());

				System.out.println("Enter Person Address: ");
				person.setPaddress(sc.next());

				session.update(person);
				session.beginTransaction().commit();

				System.out.println("Update Person Details Using Adhar Card Id Successfully...");

			} else {
				System.out.println("Person No Not Found...");
			}
		} else {
			System.out.println("Adhar Card No Not Found...");
		}
	}

}
