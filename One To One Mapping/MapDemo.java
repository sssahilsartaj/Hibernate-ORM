package com.orm.hibernate.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		// create Question1 object
		Question question1 = new Question();
		question1.setQuestionId(1212);
		question1.setQuestion("What is Java?");
		
		//create answer1 object
		Answer answer1 = new Answer();
		answer1.setAnswerId(343);
		answer1.setAnswer("Java is a programming language");
		answer1.setQuestion(question1);
		
		question1.setAnswer(answer1);
		
		// create Question2 object
		Question question2 = new Question();
		question2.setQuestionId(242);
		question2.setQuestion("What is Collection Framework?");

		// create answer2 object
		Answer answer2 = new Answer();
		answer2.setAnswerId(344);
		answer2.setAnswer("API to work with Group of objects");
		answer2.setQuestion(question2);

		question2.setAnswer(answer2);		
		
				
		// Session for save question object
		Session session = factory.openSession();
		// change in database so Transaction
		Transaction tx = session.beginTransaction();
		
		// save objects
		session.save(question1);
		session.save(question2);
		session.save(answer1);
		session.save(answer2);
		
		tx.commit();
		
		// fetching objects...
		Question q = session.get(Question.class, 1212);
		System.out.println(q.getQuestion());
		System.out.println(q.getAnswer().getAnswer());
		session.close();
		factory.close();

	}

}
