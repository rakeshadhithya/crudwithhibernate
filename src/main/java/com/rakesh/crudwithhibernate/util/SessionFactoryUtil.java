package com.rakesh.crudwithhibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryUtil {
    private static volatile SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		
		if(sessionFactory == null) {
			synchronized(SessionFactoryUtil.class) {
				if(sessionFactory == null) {
					Configuration configuration = new Configuration();
					configuration.configure();
					configuration.getProperties().put("hibernate.connection.datasource", HikariDataSourceProvider.getHikariDataSource());
					sessionFactory = configuration.buildSessionFactory();
				}
			}
		}	
		return sessionFactory;
	}
	
	public static void closeSessionFactory(SessionFactory sessionFactory) {
		sessionFactory.close();
		System.out.println("session factory successfully closed");
	}
}
