package com.orm.hibernate.mapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		// create Question
		Question question1 = new Question();
		question1.setQuestionId(1212);
		question1.setQuestion("What is Java?");
		
		//create answer
		Answer answer1 = new Answer();
		answer1.setAnswerId(343);
		answer1.setAnswer("Java is a programming language");
		answer1.setQuestion(question1);
		
		Answer answer2 = new Answer();
		answer2.setAnswerId(33);
		answer2.setAnswer("We can create web application using Java");
		answer2.setQuestion(question1);
		
		Answer answer3 = new Answer();
		answer3.setAnswerId(363);
		answer3.setAnswer("Java supports many frameworks");
		answer3.setQuestion(question1);
		
		List<Answer> list = new ArrayList<Answer>();
		list.add(answer1);
		list.add(answer2);
		list.add(answer3);
		
		question1.setAnswers(list);
	
				
		// Session for save question object
		Session session = factory.openSession();
		// change in database so Transaction
		Transaction tx = session.beginTransaction();
		
		// save objects
		session.save(question1);
		session.save(answer1);
		session.save(answer2);
		session.save(answer3);
		
		tx.commit();
		
		// fetching objects...
		Question q = session.get(Question.class, 1212);
		System.out.println(q.getQuestion());
		
		for(Answer a:q.getAnswers())
		{
			System.out.println(a.getAnswer());
		}
		
		session.close();
		factory.close();

	}

}
