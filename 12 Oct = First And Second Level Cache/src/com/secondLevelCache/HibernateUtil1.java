package com.secondLevelCache;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

public class HibernateUtil1 {

	private static StandardServiceRegistry registry;

	private static SessionFactory sf = null;

	public static SessionFactory getSessionFactory() {

		if (sf == null) {

			Map<String, Object> map = new HashMap<>();

			map.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
			
			map.put(Environment.URL, "jdbc:mysql://localhost:3306/SecondLevel_Cache_Example");
			map.put(Environment.USER, "root");
			map.put(Environment.PASS, "root");

			map.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
			map.put(Environment.SHOW_SQL, true);
			map.put(Environment.HBM2DDL_AUTO, "update");
			
			//Add Second Level Cache Property
			map.put(Environment.USE_SECOND_LEVEL_CACHE, true);
			map.put(Environment.CACHE_REGION_FACTORY, "org.hibernate.cache.ehcache.internal.EhcacheRegionFactory");
			
			
			
			

			registry = new StandardServiceRegistryBuilder().applySettings(map).build();

			MetadataSources mds = new MetadataSources(registry).addAnnotatedClass(Student1.class);

			Metadata md = mds.getMetadataBuilder().build();
			
			sf = md.buildSessionFactory();

		}

		return sf;
	}
}
