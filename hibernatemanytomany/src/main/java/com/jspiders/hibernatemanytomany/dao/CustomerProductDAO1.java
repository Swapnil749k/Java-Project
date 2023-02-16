package com.jspiders.hibernatemanytomany.dao;

import java.util.Arrays;
	import java.util.List;

	import javax.persistence.EntityManager;
	import javax.persistence.EntityManagerFactory;
	import javax.persistence.EntityTransaction;
	import javax.persistence.Persistence;

import com.jspiders.hibernatemanytomany.dto.CustomerDTO1;
import com.jspiders.hibernatemanytomany.dto.ProductDTO1;

	public class CustomerProductDAO1 {
			
		private static EntityManagerFactory factory;
		private static EntityManager manager;
		private static EntityTransaction transaction;
		
		private static void openConnection() {
			
			factory= Persistence.createEntityManagerFactory("ManyToMany");
			manager=factory.createEntityManager();
			transaction=manager.getTransaction();
		}
		
		private static void closeConnect() {
			
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
			
			ProductDTO1 product1=new ProductDTO1();
			product1.setId(1);
			product1.setName("shirt");
			product1.setPrice(1500);
			product1.setCategory("Clothing");
			
			ProductDTO1 product2=new ProductDTO1();
			product2.setId(2);
			product2.setName("Shoes");
			product2.setPrice(2000);
			product2.setCategory("Footware");
			
			ProductDTO1 product3=new ProductDTO1();
			product3.setId(3);
			product3.setName("Watch");
			product3.setPrice(2500);
			product3.setCategory("Accessories");
			
			CustomerDTO1 customer1=new CustomerDTO1();
			customer1.setId(1);
			customer1.setName("Dhiraj");
			customer1.setEmail("dhiraj1@gmail.com");
			customer1.setContact(7887653023l);
			
			CustomerDTO1 customer2=new CustomerDTO1();
			customer2.setId(2);
			customer2.setName("Rocky");
			customer2.setEmail("rocky2@gmail.com");
			customer2.setContact(9011861889l);
			
			CustomerDTO1 customer3=new CustomerDTO1();
			customer3.setId(3);
			customer3.setName("Pushpa");
			customer3.setEmail("pushpa3@gmail.com");
			customer3.setContact(8975162002l);
			
			List<ProductDTO1> products=Arrays.asList(product1,product2,product3);
			
			customer1.setProducts(products);
			customer2.setProducts(products);
			customer3.setProducts(products);
			
			manager.persist(customer1);
			manager.persist(customer2);
			manager.persist(customer3);
			
			List<CustomerDTO1> customers=Arrays.asList(customer1,customer2,customer3);
			
			product1.setCustomers(customers);
			product2.setCustomers(customers);
			product3.setCustomers(customers);
			
			manager.persist(product1);
			manager.persist(product2);
			manager.persist(product3);
			
			transaction.commit();
			closeConnect();
		}
	}

