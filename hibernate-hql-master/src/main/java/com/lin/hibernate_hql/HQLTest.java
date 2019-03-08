package com.lin.hibernate_hql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;






import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Restrictions;
import org.hibernate.jdbc.Work;
import org.junit.Test;

import com.lin.hibernate_hql.base.BaseConnection;
import com.lin.hibernate_hql.dao.PointDao;
import com.lin.hibernate_hql.pojo.Device;
import com.lin.hibernate_hql.pojo.Point;
import com.lin.hibernate_hql.util.HibernateUtil;

public class HQLTest extends BaseConnection {

	@Test
	public void qryTest() {

		StringBuilder sb = new StringBuilder(
				String.format("From Point p LEFT JOIN p.devices  where p.pointId=:id "));
		Query query = session.createQuery(sb.toString());

		Object[] point = (Object[]) query
				.setString("id", "8a8a9c3f572251eb0157225b201a0000").list()
				.get(0);
		System.out.println(point);
	}

	/**
	 * 根据构造器获取对应的投影
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testGetEntity() {
		StringBuilder sb = new StringBuilder(
				String.format("SELECT new Point(p.pointNo,p.pointName,p.longitude,p.latitude,p.address ) From Point p  where p.pointId=:id "));
		Query query = session.createQuery(sb.toString());
		query.setCacheable(true);
		Point p = (Point) session.get(Point.class,
				"8a8a9c3f572251eb0157225b201a0000");

		transaction.commit();
		session.close();
		session = sessionFactory.openSession();

		transaction = session.beginTransaction();

		Point p1 = (Point) session.get(Point.class,
				"8a8a9c3f572251eb0157225b201a0000");

		System.out.println(p);
		System.out.println(p1);
	}

	@Test
	public void testtQBC() {
		// StringBuilder sb=new StringBuilder(String.format("From Point p   "));
		Criteria c = session.createCriteria(Point.class);
		Conjunction con = new Conjunction();// 综合条件查询
		con.add(Restrictions.eq("isDeleted", 0));
		con.add(Restrictions.eq("pointId", "8a8a9c3f572251eb0157225b201a0000"));
		c.add(con);
		c.addOrder(Order.asc("pointId"));
		List<Point> ps = c.list();
		System.out.println(ps.get(0).getDevices());

		// Conjunction //AND
		// Disjunction // OR
		// Projection //统计查询

		// con.add(criterion)
		// Criterion
	}
	
	
	/**
	 * 缓存查询
	 */
	@Test
	public void testEhcache(){
		
		Point p = (Point) session.get(Point.class,
				"8a8a9c3f572251eb0157225b201a0000");
		System.out.println(p);
		System.out.println(p.getDevices().size());
		//关闭session
		transaction.commit();
		session.close();
		session = sessionFactory.openSession();

		//开启session
		transaction = session.beginTransaction();
		//重新获取
		Point p1 = (Point) session.get(Point.class,
				"8a8a9c3f572251eb0157225b201a0000");
		System.out.println(p1);
		System.out.println(p1.getDevices().size());
		//
//		Point p1 = (Point) session.get(Point.class,
//				"8a8a9c3f572251eb0157225b201a0000");
	}
	
	
	@Test
	public void testQueryIterate(){
		Point p = (Point) session.get(Point.class,
				"8a8a9c3f572251eb0157225b201a0000");
		System.out.println(p);
		System.out.println(p.getDevices().size());
		
	}
	
	@Test
	public void testSaveByThread(){
		Session s=HibernateUtil.getInstance().getSession();
		Transaction tran=s.beginTransaction();
		
				
		PointDao d=new PointDao();
		
		d.save(new Point("1",null,null,null,null));
		tran.commit();
		//交个本地线程管理session 在提交事务时,自动关闭session
	}
	@Test
	public void testBatch(){
		
		session.doWork(new Work() {
			
			public void execute(Connection connection) throws SQLException {
				//通过JDBC原生的API进行操作 ,效率最高
				System.out.println(connection);
			}
		});
	}
	
}
