package com.lin.hibernate_hql.dao;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.lin.hibernate_hql.base.BaseConnection;
import com.lin.hibernate_hql.pojo.Point;
import com.lin.hibernate_hql.util.HibernateUtil;

public class PointDao {

	
	public void save(Point point ){
		//获取和当前线程绑定的session对象
//			1.不需要从外部传入session对象
//			2.多个dao方法可以共用一个事务
		Session session=HibernateUtil.getInstance().getSession();
		
		System.out.println(session.hashCode());
		session.save(point);
	}
}
