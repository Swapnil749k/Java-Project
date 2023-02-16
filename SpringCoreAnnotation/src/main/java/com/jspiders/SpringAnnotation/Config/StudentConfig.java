package com.jspiders.SpringAnnotation.Config;

import org.springframework.context.annotation.Bean;

import com.jspiders.SpringAnnotation.beans.StudentBean;

public class StudentConfig {
@Bean
	public StudentBean getStudent() {
	StudentBean student =new StudentBean();
	student.setId(1);
	student.setName("swapnil");
	student.setEmail("swap12@gmail.com");
	student.setCity("pune");
	return student;
}
}