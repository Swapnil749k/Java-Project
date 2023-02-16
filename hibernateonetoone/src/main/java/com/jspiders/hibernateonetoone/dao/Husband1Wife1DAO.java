package com.jspiders.hibernateonetoone.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernateonetoone.dto.Husband1DTO;
import com.jspiders.hibernateonetoone.dto.Wife1DTO;

public class Husband1Wife1DAO {
	
	private static EntityManagerFactory factory;
	
	private static EntityManager manager;
	
	private static EntityTransaction transaction;
	
	private static void openConnection() {
		
		factory=Persistence.createEntityManagerFactory("OneToOne");
		
		manager=factory.createEntityManager();
		
		transaction=manager.getTransaction();
		
	}
	
	private static void closeConnection() {
		
		if(factory !=null) {
			factory.close();
		}
		if(manager !=null) {
			manager.close();
		}
		if(transaction.isActive()) {
			transaction.rollback();
		}
	}
	
	public static void main(String[] args) {
		
		openConnection();
		transaction.begin();
		
		Husband1DTO husband1=new Husband1DTO();
		husband1.setId(1);
		husband1.setName("Jethalal");
		husband1.setAge(33);
		
		manager.persist(husband1);
		
		Wife1DTO wife1=new Wife1DTO();
		wife1.setId(1);
		wife1.setName("Daya");
		wife1.setAge(30);
		wife1.setHusband(husband1);
		
		manager.persist(wife1);
		transaction.commit();
		
		closeConnection();
	}

}
