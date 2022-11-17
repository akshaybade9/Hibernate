package com.util1;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import com.model1.Batch;
import com.model1.Course;
import com.model1.Faculty;
import com.model1.Student;

public class HibernateUtil11 {
	private static SessionFactory sf = null;
	private static StandardServiceRegistry registry;

	public static SessionFactory getSessionFactory() {

		if (sf == null) {
			Map<String, Object> map = new HashMap<>();

			map.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
			map.put(Environment.URL, "jdbc:mysql://localhost:3306/SQL_OneToMAny_UniDirection_Example");
			map.put(Environment.USER, "root");
			map.put(Environment.PASS, "root");

			map.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
			map.put(Environment.SHOW_SQL, true);
			map.put(Environment.HBM2DDL_AUTO, "update");

			
			registry = new StandardServiceRegistryBuilder().applySettings(map).build();
			MetadataSources mds = new MetadataSources(registry).addAnnotatedClass(Course.class).addAnnotatedClass(Faculty.class).addAnnotatedClass(Batch.class).addAnnotatedClass(Student.class);
			Metadata md = mds.getMetadataBuilder().build();

			sf = md.buildSessionFactory();

		}

		return sf;
	}
}
