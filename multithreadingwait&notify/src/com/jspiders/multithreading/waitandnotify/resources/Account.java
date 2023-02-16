package com.jspiders.multithreading.waitandnotify.resources;

public class Account {
	int accountBalance;
	public Account (int accountBalance) {
		super();
		this.accountBalance=accountBalance;
	
	}
	public void deposit(int depositAmount) {
		System.out.println("Depositing"+ depositAmount
		+"rupees in the account");
		accountBalance+=depositAmount;
		System.out.println("Avaliable balance :" +accountBalance);
	}
	public void withdraw(int withdrawAmount) {
		if(accountBalance>=withdrawAmount) {
			System.out.println("Withdrawing"+ withdrawAmount
					+"From the account");
			accountBalance-=withdrawAmount;
			System.out.println("Avaliable Balance");
		}
	}
}
