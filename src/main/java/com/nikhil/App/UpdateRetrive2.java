package com.nikhil.App;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;




public class UpdateRetrive2 {

	public static void main(String[] args) 
	{
		Configuration config = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		
		config=new Configuration();
		
		config.configure();

		sessionFactory=config.buildSessionFactory();
		
		session=sessionFactory.openSession();
		//SELECT *FROM Student_Info WHERE city=?;
		try
		{
			//Query<Student_Info> query = session.createQuery("FROM Student_Info WHERE city=:city", Student_Info.class);
			Query<String> query = session.createQuery("SELECT name FROM Student_Info WHERE city IN (:city1,:city2)", String.class);
			query.setParameter("city1", "Raipur");
			query.setParameter("city2", "Jaipur");
			List<String> liststudent = query.list();
			
//			for(Student_Info s:liststudent)
//			{
//				System.out.println(s);
//			}
			liststudent.forEach((s)->System.out.println(s));
			
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			
			
			session.close();
			sessionFactory.close();
		}


	}

}
