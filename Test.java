package com.sivasoft.model;

import java.util.ArrayList;
import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sivasoft.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
	Session ses=HibernateUtil.getsf().openSession();
	Transaction tx=null;
		try {
		tx=ses.beginTransaction();
		Course c1=new Course(131,"HIB2222",200.0);
		Course c2=new Course(132,"SPR",300.0);
		Course c3=new Course(133,"BOOT",400.0);
		
		Student s1=new Student();
		s1.setStdId(10);
		s1.setStdName("A");
		s1.setStdMail("a@gmail.com");
		s1.setObs(Arrays.asList(c1,c2));//Link
		
		Student s2=new Student();
		s2.setStdId(11);
		s2.setStdName("B");
		s2.setStdMail("b@gmail.com");
		s2.setObs(Arrays.asList(c2,c3));//Link
		
		ses.save(c1);
		ses.save(c2);
		ses.save(c3);
		
		ses.save(s1);
		ses.save(s2);
		
		tx.commit();
	} catch (Exception e) {
		tx.rollback();
	e.printStackTrace();
	}

	}

}
