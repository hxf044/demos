package com.lin.hibernate_hql.base;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;

public class BaseConnection {

	protected Logger log=Logger.getLogger(this.getClass());
	protected SessionFactory sessionFactory;
	
	protected Session session;
	
	protected Transaction transaction;
	
	@Before
	public void init (){
		//configuration  ����ע��, ���sessionFactory -->���seesion --->��������
		Configuration configuration=new Configuration().configure();
		ServiceRegistry registry=new ServiceRegistryBuilder()
									.applySettings(configuration.getProperties())
									.buildServiceRegistry();
		
		sessionFactory=configuration.buildSessionFactory(registry);
		
		//ʹ��getCurrentSession  session�������ύ���Զ��ر�
//		session=sessionFactory.getCurrentSession();
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		
	}
	
	@After
	public void destory(){
		
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
}
