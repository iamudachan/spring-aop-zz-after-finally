package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = 
				context.getBean("accountDAO", AccountDAO.class);
		
		List<Account> listAcc = theAccountDAO.findAccounts(false);

		System.out.println("\n After returning");
		System.out.println("====================");
		System.out.println(listAcc);
		System.out.println("\n");
		// close the context
		context.close();
	}

}










