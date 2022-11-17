package com;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class Test {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();


//		Employee e = new Employee();
//		e.setName("Vanve");
//		e.setAddress("Ashti");
//		e.setSalary(55000);
//		
//		session.save(e);
//		session.beginTransaction().commit();
//		System.out.println("Data Stored...."); 

		
		
		// select * from Employee
		Session session = sf.openSession();                                                     // session
		Query<Employee> query = session.createQuery("from Employee");
		
		List<Employee> elist = query.getResultList();                                                  // getResultList
		System.out.println(elist);
		System.out.println("------------------------------------");
	
		
	
		
		// select * from Employee where id = ?
		
		Query<Employee> query1 = session.createQuery("from Employee where id = :MyId");
		query1.setParameter("MyId", 2);
		Employee employee=query1.getSingleResult();                                                     // getSingleResult
		System.out.println(employee);
		System.out.println("------------------------------------");
		
	
		
		

		// update Employee set name = ?,salary = ?, address=? where id=?
		Session session1 = sf.openSession();
		session1.beginTransaction();                                                              // session1
		Query<Employee> query2 = session1.createQuery("update from Employee set name = :n, address = :a, salary= :s where id=:MyId");
	
		query2.setParameter("n", "Dyaneshwar");
		query2.setParameter("a","Ashti");
		query2.setParameter("s", 34000.0);
		
		query2.setParameter("MyId", 2);
		
		query2.executeUpdate();                                                           // execute Update
		
		session1.getTransaction().commit();                                              //--------------------------
		
		
		
		
		
		
		// delete from Employee where id = ?
		
		session1.beginTransaction();                                                         //----------------------
		Query<Employee> query3 = session1.createQuery("delete from Employee where id=:Id1");
		query3.setParameter("Id1", 3);
		
		query3.executeUpdate();
		System.out.println("=====================HQL Aggregation Function===========================");
		
		
		
		// select count(*) from Employee 
		Query<Long> query4 = session1.createQuery("select count(*) from Employee");
		Long count=query4.getSingleResult();
		
		
		System.out.println("Count is : "+count);
		
		
		
		// select max(salary) from Employee
		Query<Double> query5 = session1.createQuery("select max(salary) from Employee");
		Double maxSalary=query5.getSingleResult();
		
		
		System.out.println("Max Salary is : "+maxSalary);
		
	
		
		//select min(salary) from Employee
		Query<Double> query6 = session1.createQuery("select min(salary) from Employee");
		Double minSalary=query6.getSingleResult();
		
		
		System.out.println("Min Salary is : "+minSalary);
		
		
		// select sum(salary) from Employee
		Query<Double> query7 = session1.createQuery("select sum(salary) from Employee");
		Double sumSalary=query7.getSingleResult();
		
		
		System.out.println("Sum of Salary is : "+sumSalary);
		
		
		// select avg(salary) from Employee
		Query<Double> query8 = session1.createQuery("select avg(salary) from Employee");
		Double avgSalary = query8.getSingleResult();

		System.out.println("Average Salary is : " + avgSalary);

	}

}




