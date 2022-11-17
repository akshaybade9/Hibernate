package com.service;

import java.util.List;
import java.util.Scanner;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.model.Product;
import com.util.HibernateUtil;

public class OperationInterfaceImpl implements OperationInterface {

	SessionFactory sf = HibernateUtil.getSessionFactory();

	Scanner sc = new Scanner(System.in);

	@Override
	public void addProductData() {
		Session session = sf.openSession();

		Product product = new Product();

		System.out.println("Enter Product Name: ");
		product.setName(sc.next());

		System.out.println("Enter Product Price: ");
		product.setPrice(sc.nextDouble());

		session.save(product);

		session.beginTransaction().commit();
		System.out.println("Data Stored......");

	}

	@Override
	public void showAllData() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();

		CriteriaBuilder builder = session.getCriteriaBuilder();
		
		CriteriaQuery<Product> criteriaQuery=builder.createQuery(Product.class);
		
		Root<Product> root = criteriaQuery.from(Product.class);
		                     criteriaQuery.select(root);
		                     
	    Query<Product> query = session.createQuery(criteriaQuery);
	    
	    List<Product> plist = query.getResultList();
	    
	    System.out.println(plist);
	    
	}

	@Override
	public void getSingleProduct() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();

		System.out.println("Enter Product Id : ");
		int id = sc.nextInt();
		try {
			CriteriaBuilder builder = session.getCriteriaBuilder();

			CriteriaQuery<Product> criteriaQuery  = builder.createQuery(Product.class);

			Root<Product> root = criteriaQuery.from(Product.class);
			criteriaQuery.select(root).where(builder.equal(root.get("id"), id));

			Query<Product> query = session.createQuery(criteriaQuery);
			Product product = query.getSingleResult();
			System.out.println(product);
		}catch (NoResultException e) {
			// TODO: handle exception
			System.out.println(new NoResultException("Procuct Not Found"));
		}
	}

	@Override
	public void getSingleColomnData() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();

		CriteriaBuilder builder = session.getCriteriaBuilder();

		CriteriaQuery<String> criteriaQuery  = builder.createQuery(String.class);
		
		Root<Product> root = criteriaQuery.from(Product.class);
		                     criteriaQuery.select(root.get("name"));
		Query<String> query = session.createQuery(criteriaQuery);
		List<String> slist = query.getResultList();
		System.out.println(slist);

	}

	@Override
	public void getMultipleColomnData() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();

		CriteriaBuilder builder = session.getCriteriaBuilder();

		CriteriaQuery<Object[]> criteriaQuery  = builder.createQuery(Object[].class);
		
		Root<Product> root = criteriaQuery.from(Product.class);
		                     criteriaQuery.multiselect(root.get("name"),root.get("price"));
		                     
		Query<Object[]> query = session.createQuery(criteriaQuery);
		List<Object[]>  oList = query.getResultList();
		
		for(Object[] obj : oList) {
		   System.out.println("Product Name : " + obj[0]);
		   System.out.println("Product price : " + obj[1]);
		}
	}
}
