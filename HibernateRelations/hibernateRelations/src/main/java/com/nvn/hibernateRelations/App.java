package com.nvn.hibernateRelations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    
    
    {
    	
    	
    	Laptop laptop=new Laptop();
    	laptop.setLid(101);
    	laptop.setLname("Dell");
    	
    	
    	Student s= new Student();
    	s.setName("Naveen");
    	s.setRollno(1);
    	s.setMarks(100);
    	s.getLaptop().add(laptop);
    	laptop.getStudent().add(s);
    	
    	Configuration con = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
    	
    	ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();

		SessionFactory sf = con.buildSessionFactory(reg);

		Session session = sf.openSession();//
		Transaction tx = session.beginTransaction();// Acid properties

		session.save(laptop);// belongs to Session interface it belogs to hibe framework
		session.save(s);
		tx.commit();
		//System.out.println);
    }
}
