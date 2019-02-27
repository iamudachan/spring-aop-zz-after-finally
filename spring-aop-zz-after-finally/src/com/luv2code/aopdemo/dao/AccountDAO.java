package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	public List<Account> findAccounts(boolean flage){
		
		if(flage){
			throw new RuntimeException("No soup for you !!!!"); 
		}
		 List<Account> myList = new ArrayList<>();
		 Account a1 = new Account("Kiran1", "Bhat");
		 Account a2 = new Account("Kiran2", "Bhat");
		 Account a3 = new Account("Kiran3", "Bhat");
		 
		 myList.add(a1);
		 myList.add(a2);
		 myList.add(a3);
		 return myList;
	}

	public void addAccount(Account account, boolean f) {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
	}
	
	public boolean doWork() {
		System.out.println(getClass() + ": doWork()");
		return true;
	}

	public String getName() {
		System.out.println(getClass() + ": getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": setServiceCode()");
		this.serviceCode = serviceCode;
	}

	
	
}
