package com.nikhil.App;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nikhil.model.Student_Info;

public class LaunchStandardApp {

	public static void main(String[] args) 
	{
		Configuration config = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		boolean flag=false;
		
		config=new Configuration();
		
		config.configure();

		sessionFactory=config.buildSessionFactory();
		
		session=sessionFactory.openSession();
		
		Student_Info s1=new Student_Info();
		//s1.setId(1);
		s1.setName("Rishi");
		s1.setCity("Raipur");
		
		Student_Info s2=new Student_Info();
		//s2.setId(2);
		s2.setName("Nitu");
		s2.setCity("Mumbai");
		
		Student_Info s3=new Student_Info();
		//s3.setId(3);
		s3.setName("Rishika");
		s3.setCity("Pune");
		
		Student_Info s4=new Student_Info();
		//s4.setId(4);
		s4.setName("Rohit");
		s4.setCity("Nagpur");
		
		Student_Info s5=new Student_Info();
		//s5.setId(5);
		s5.setName("Monika");
		s5.setCity("Jaipur");
		
		try
		{
			transaction=session.beginTransaction();
			
			session.persist(s1);
			session.persist(s2);
			session.persist(s3);
			session.persist(s4);
			session.persist(s5);
			
			flag=true;
			
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
			if(flag==true)
			{
				transaction.commit();
			}
			else
			{
				transaction.rollback();
			}
			
			session.close();
			sessionFactory.close();
		}


	}

}
