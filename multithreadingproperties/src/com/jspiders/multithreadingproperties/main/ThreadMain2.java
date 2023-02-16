package com.jspiders.multithreadingproperties.main;

import com.jspiders.multithreadingproperties.threads.MyThread2;

public class ThreadMain2 {
	public static void main(String[] args) {
		MyThread2 MyThread2=new MyThread2();
		Thread thread=new Thread(MyThread2);
		thread.setName("T2");
		thread.setPriority(9);
		
		thread.start();
	}
}
