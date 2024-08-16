package com.nikhil.App;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.nikhil.model.Student_Info;



public class UpdateRetrive {

	public static void main(String[] args) 
	{
		Configuration config = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		
		config=new Configuration();
		
		config.configure();

		sessionFactory=config.buildSessionFactory();
		
		session=sessionFactory.openSession();
		//SELECT *FROM Student_Info;
		try
		{
			Query<Student_Info> query = session.createQuery("FROM Student_Info", Student_Info.class);
			List<Student_Info> liststudent = query.list();
			
			for(Student_Info s:liststudent)
			{
				System.out.println(s);
			}
			//liststudent.forEach((s)->System.out.println(s));
			
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
