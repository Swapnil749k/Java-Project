package com.jspiders.multithreading.waitandnotify.resources;

public class Shop {
	int noOfProducts;
	
	public Shop(int noOfProducts) {
		super();
		this.noOfProducts=noOfProducts;
	}

	public synchronized void  restockProducts(int noOfProducts, int restockProducts) {
		 noOfProducts +=restockProducts;
		 System.out.println(restockProducts
				 + " :succesfully added to the stock");
		 System.out.println("now available products :"
				 + noOfProducts);
		 this.notify();
	}
	public synchronized void purchaseProducts1(int purchaseproducts) {
		if(noOfProducts< purchaseproducts) {
			System.out.println(purchaseproducts + 
					" :products not available please wait");
			try {
				this.wait();
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		noOfProducts -=purchaseproducts;
		System.out.println(purchaseproducts + " :Succesfully purchsed");
		System.out.println("now available products :" + noOfProducts);
		
	}

}