package com.jspiders.multithreading.waitandnotify.resources;

public class Supplier extends Thread {
	
	private Shop shop;
	private int noOfProducts;
	
	public Supplier(Shop shop, int noOfProducts) {
		super();
		this.shop=shop;
		this.noOfProducts= noOfProducts;
		
	}
	@Override
	public void run() {
		shop.restockProducts (noOfProducts, noOfProducts);
		
	}

}
