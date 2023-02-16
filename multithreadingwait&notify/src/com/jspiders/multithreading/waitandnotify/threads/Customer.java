package com.jspiders.multithreading.waitandnotify.threads;

import com.jspiders.multithreading.waitandnotify.resources.Shop;

public class Customer extends Thread {
	
	private Shop shop;
	private int noOfProducts;
	
	public Customer (Shop shop2,int noOfProducts) {
		super();
		this.shop=shop2;
		this.noOfProducts=noOfProducts;
		
	}
	@Override
	public void run() {
		shop.purchaseProducts1(noOfProducts);
			}
}
