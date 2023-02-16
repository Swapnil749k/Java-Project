package com.jspiders.SpringAnnotation.Main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jspiders.SpringAnnotation.beans.StudentBean;

public class StudentMain {
public static void main(String[] args) {
	ApplicationContext context=new AnnotationConfigApplicationContext("StudentConfig.class");
	StudentBean student=context.getBean(StudentBean.class);
	System.out.println(student);
	((ClassPathXmlApplicationContext)context).close();
}
}
