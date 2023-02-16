package com.jspiders.multithreadingproperties.main;

import com.jspiders.multithreadingproperties.threads.MyThread1;

public class ThreadMain {
	public static void main(String[] args) {
		MyThread1 MyThread1=new MyThread1();
		MyThread1.setName("t1");
		MyThread1.setPriority(7);
		
		MyThread1.start();
	}
}
