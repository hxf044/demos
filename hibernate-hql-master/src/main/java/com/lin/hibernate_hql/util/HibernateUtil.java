package com.lin.hibernate_hql.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {

	private static HibernateUtil instance=new HibernateUtil();
	private SessionFactory f;
	
	
	private Session s;
	
	public SessionFactory getSessionFactory(){
		if(f==null){
			Configuration configuration=new Configuration().configure();
			ServiceRegistry registry=new ServiceRegistryBuilder()
										.applySettings(configuration.getProperties())
										.buildServiceRegistry();
			
			f=configuration.buildSessionFactory(registry);
		}
		return f;
	}
	
	public Session getSession(){
		if(f==null){
			this.getSessionFactory();
		}
		s=f.getCurrentSession();
		return s;
		
	}
	
	public static HibernateUtil getInstance(){
		return instance;
	}
}
