package com.nvn.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Alien mars=new Alien();
        mars.setAid(101);
        mars.setAname("Chitti");
        mars.setColor("White");
        
        
        Configuration con=new Configuration().configure().addAnnotatedClass(Alien.class);
       SessionFactory sf=con.buildSessionFactory();
     
        Session session=sf.openSession();//
        Transaction tx=session.beginTransaction();//Acid properties
        session.save(mars);// belongs to Session interface it belogs to hibe framework
        tx.commit();
    }
}
