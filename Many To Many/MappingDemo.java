package com.orm.hibernate.mapping.manytomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingDemo {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Employee e1 = new Employee();
		Employee e2 = new Employee();
		e1.seteId(12);
		e1.seteName("Ram");		
		e2.seteId(13);
		e2.seteName("Shyam");
		
		Project p1 = new Project();
		Project p2 = new Project();
		p1.setpId(2);
		p1.setpName("Library Management System");		
		p2.setpId(3);
		p2.setpName("CHATBOT");
		
		List<Employee> list1 = new ArrayList<Employee>();
		List<Project> list2 = new ArrayList<Project>();
		
		list1.add(e1);
		list1.add(e2);
		
		list2.add(p1);
		list2.add(p2);
		
		// set values for list
		e1.setProjects(list2);
		p1.setEmployees(list1);
		
		// Open Session
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		session.save(e1);
		session.save(e2);
		session.save(p1);
		session.save(p2);
		
		tx.commit();
		session.close();
		factory.close();
		
		
	}

}
