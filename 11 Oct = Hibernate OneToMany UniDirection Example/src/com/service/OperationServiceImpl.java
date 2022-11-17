package com.service;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.Product;
import com.model.User;
import com.util.HibernateUtil;

public class OperationServiceImpl implements OperationService {

	SessionFactory sf = HibernateUtil.getSessionFactory();

	@Override
	public void addUserDataWithMultipleProduct() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Scanner sc = new Scanner(System.in);

		User user = new User();

		System.out.println("Enter User Name: ");
		user.setName(sc.next());

		System.out.println("Enter User Address:  ");
		user.setAddress(sc.next());

		System.out.println("How Many Product Want To Buy?");

		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			Product product = new Product();

			System.out.println("Enter Product Name: ");
			product.setName(sc.next());

			System.out.println("Enter Product Price: ");
			product.setPrice(sc.nextLong());

			user.getPlist().add(product); // ===================

		}

		session.save(user);

		session.beginTransaction().commit();

		System.out.println("Data Add Suussesfully.....");

	}

	@Override
	public void showAllUserWithMultipleProductData() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();

		org.hibernate.Query<User> query = session.createQuery("from User");

		List<User> ulist = query.getResultList();

		for (User user : ulist) {
			System.out.println(user);

		}

	}

	@Override
	public void getSingleUserWithMultipleProductData() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter User Id: ");
		int id = sc.nextInt();

		User user = session.get(User.class, id);

		if (user != null) {
			System.out.println(user);
		} else {
			System.out.println("User Not Found...");
		}
	}

	@Override
	public void updateUser() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter User Id: ");
		int id = sc.nextInt();

		User user = session.get(User.class, id);
		if (user != null) {
			System.out.println("Enter User Name: ");
			user.setName(sc.next());

			System.out.println("Enter User Address: ");
			user.setAddress(sc.next());

			session.update(user);
			session.beginTransaction().commit();
		} else {
			System.out.println("User Not Found...");
		}
		System.out.println("Data Updated.....");

	}

	@Override
	public void updatePerticularProductDataUsingUserId() {
		// TODO Auto-generated method stub

		Session session = sf.openSession();
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter User Id: ");
		int id = sc.nextInt();

		User user = session.get(User.class, id);
		// System.out.println(user);
		if (user != null) {
			// System.out.println(user);
			List<Product> plist = user.getPlist();

			System.out.println("Enter Product Id: ");
			int pid = sc.nextInt();

			for (Product product : plist) {

				if (product.getPid() == pid) {
					System.out.println("Enter Product name :");
					product.setName(sc.next());
					System.out.println("Enter Product Price : ");
					product.setPrice(sc.nextLong());

				}

			}

			session.update(user);
			session.beginTransaction().commit();
			System.out.println("Update Sucsessfully....");

		} else {
			System.out.println("Product Not Found...");
		}

	}

	@Override
	public void deletePerticularProductDataUsingUserId() {
		// TODO Auto-generated method stub

		Session session = sf.openSession();
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter User Id: ");
		int id = sc.nextInt();

		User user = session.get(User.class, id);

		if (user != null) {

			List<Product> plist = user.getPlist();

			System.out.println("Enter Produt Id: ");
			int pid = sc.nextInt();

			for (Product product : plist) {

				if (product != null && (product.getPid() == pid)) {

					plist.remove(product);
					session.delete(product);
					session.beginTransaction().commit();
					break;

				} else {
					System.out.println("Product Not Found....");
					deletePerticularProductDataUsingUserId();
				}
			}

		} else {
			System.out.println("User Not Found");
			deletePerticularProductDataUsingUserId();
		}

	}

	@Override
	public void deleteUser() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter User Id: ");
		int id = sc.nextInt();

		User user = session.get(User.class, id);
		if (user != null) {

			session.delete(user);
			session.beginTransaction().commit();
		} else {
			System.out.println("User Not Found...");

		}
		System.out.println("Data Deleted....");

	}

	@Override
	public void addProductDataToExistingUser() {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		Session session = sf.openSession();

		System.out.println("Enter User Id: ");
		int id = sc.nextInt();

		User user = session.get(User.class, id);
		if (user != null) {

			Product product1 = new Product();

			System.out.println("Enter Product Name: ");
			product1.setName(sc.next());

			System.out.println("Enter Product Price: ");
			product1.setPrice(sc.nextLong());

			user.getPlist().add(product1);
			session.save(product1);
			session.beginTransaction().commit();

		}

		else {
			System.out.println("User Not Found");
			addProductDataToExistingUser();
		}

		System.out.println("Data Add Successfully...");

	}

}
