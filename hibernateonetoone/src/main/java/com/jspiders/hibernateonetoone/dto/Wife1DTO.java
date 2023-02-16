package com.jspiders.hibernateonetoone.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Wife1DTO {
	
	@Id
	int id;
	String name;
	int age;
	@OneToOne
	Husband1DTO husband;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Husband1DTO getHusband() {
		return husband;
	}
	public void setHusband(Husband1DTO husband) {
		this.husband = husband;
	}
}
