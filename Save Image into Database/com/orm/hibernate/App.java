package com.orm.hibernate;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Project Started..." );
        
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
        // create student object
        Student st = new Student();
        st.setId(101);
        st.setName("Sahil Sartaj");
        st.setCity("Kolkata");
        
        // create address object
        Address ad = new Address();
        ad.setStreet("Shukhobristi");
        ad.setCity("Kolkata");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(1234.1234);
        
        // reading image
        FileInputStream img = new FileInputStream("src/main/java/naruto.jpg");
        byte[] data = new byte[img.available()];
        img.read(data);
       
        ad.setImage(data);
        
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(st);
        session.save(ad);
        tx.commit();
        session.close();
        System.out.println("done...");
    }
}
