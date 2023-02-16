package com.jspiders.hibernatemanytomany.dto;
	
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

	@Entity
	@Data
	public class ProductDTO1 {
		
		@Id
		private int id;
		
		private String name;
		
		private double price;
		
		private String category;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public List<CustomerDTO1> getCustomers() {
			return customers;
		}
		public void setCustomers(List<CustomerDTO1> customers) {
			this.customers = customers;
		}
		@ManyToMany
		
		private List<CustomerDTO1> customers;
		

	}



