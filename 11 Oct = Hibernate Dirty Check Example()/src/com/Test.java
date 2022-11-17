package com;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Test {
	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();

		Session session = sf.openSession();
		Scanner sc = new Scanner(System.in);

//		Product p = new Product();
//		
//		System.out.println("Enter Product name: ");
//		p.setName(sc.next());
//		
//		System.out.println("Enter Product Type: ");
//		p.setType(sc.next());
//		
//		System.out.println("Enter Product Price");
//		p.setPrice(sc.nextLong());
//		
//		session.save(p);
//		
//		session.beginTransaction().commit();
//		

		Product product = session.get(Product.class, 1);

		System.out.println("Enter Product name: ");
		product.setName(sc.next());

		session.update(product);

		session.beginTransaction().commit();

		System.out.println("Data Stored...");

	}
}
