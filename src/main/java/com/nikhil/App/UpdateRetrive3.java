package com.nikhil.App;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class UpdateRetrive3 {

	public static void main(String[] args) 
	{
		Configuration config = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;	
		boolean flag=false;
		int count=0;
		
		config=new Configuration();
		
		config.configure();

		sessionFactory=config.buildSessionFactory();
		
		try
		{
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			
//			count=session.createMutationQuery("UPDATE Student_Info SET city=:city").
//			setParameter("city", "Pune").executeUpdate();
			count=session.createMutationQuery("UPDATE Student_Info SET city=:city WHERE name=:name").
			setParameter("city", "Amravati").setParameter("name", "Rishi").executeUpdate();
			
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
				System.out.println("No. of rows Updated "+count);
			}
			else
			{
				transaction.rollback();
				System.out.println("No. of rows Updated "+count);
			}
			session.close();
			sessionFactory.close();
		}


	}

}
