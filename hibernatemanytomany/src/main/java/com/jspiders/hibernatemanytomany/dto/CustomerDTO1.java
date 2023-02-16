package com.jspiders.hibernatemanytomany.dto;

	import java.util.List;

	import javax.persistence.Entity;
	import javax.persistence.Id;
	import javax.persistence.ManyToMany;

	import lombok.Data;

	@Entity
	@Data
	public class CustomerDTO1 {
		@Id
		private int id;
		
		private String name;
		
		private String email;
		
		private long contact;
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
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public long getContact() {
			return contact;
		}
		public void setContact(long contact) {
			this.contact = contact;
		}
		public List<ProductDTO1> getProducts() {
			return products;
		}
		public void setProducts(List<ProductDTO1> products) {
			this.products = products;
		}
		@ManyToMany
		private List<ProductDTO1> products;
	}

