package com.jspiders.singleton.main.eager;

import com.jspiders.singleton.object.SingletonEager;

public class SingletonMain {

	public static void main(String[] args) {
		SingletonEager.getObject();
		SingletonEager.getObject();
		SingletonEager.getObject();
		SingletonEager.getObject();
	}

}
