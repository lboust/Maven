package com.mytube.servlet;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory sessionFactory;
	private static Logger log = Logger.getLogger(HibernateUtils.class.getName());
			
	
	 static {
		// SessionFactory from standard hibernate.cfg.xml file
	 try {
	     sessionFactory = new Configuration().configure().buildSessionFactory();
	 } catch (Throwable ex) {
	     // Log the exception.
	     log.log(Level.SEVERE,"Initial SessionFactory creation failed.", ex); throw new ExceptionInInitializerError(ex);
		 }
	 }
 
 public static SessionFactory getSessionFactory() {
	    return sessionFactory;
	}

}
