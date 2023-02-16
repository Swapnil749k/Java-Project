package com.jspiders.singleton.object;

public class SingletonEager {
	static SingletonEager object=new SingletonEager();
	static int count;
	
	private SingletonEager() {
		count++;
	}
	public static SingletonEager getObject ()  {
	   System.out.println("object created " +count+ " times");
	   return object;
	}
	}

