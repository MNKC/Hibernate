package com.nvn.Hibernate;

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

public class App {
	public static void main(String[] args) {

		AlienName an = new AlienName();
		an.setFname("Naveen");
		an.setMname("Kumar");
		an.setLname("Morampudi");

		Alien mars = new Alien();
		mars.setAid(11);
		mars.setColor("red");
		mars.setAname(an);

		Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);

		// After 4.1 we have new interface(ServiceRegistry)/class from which
		// ServiceRegistryBuilder().

		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();

		SessionFactory sf = con.buildSessionFactory(reg);

		Session session = sf.openSession();//
		Transaction tx = session.beginTransaction();// Acid properties

		session.save(mars);// belongs to Session interface it belogs to hibe framework

		tx.commit();
		System.out.println(mars);
	}
}
