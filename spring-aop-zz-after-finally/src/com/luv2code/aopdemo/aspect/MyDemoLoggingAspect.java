package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))" )
	public void afterFinallyFindAccountAdvice(JoinPoint joinPoint){
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n======@exicuting @after Finally on method: "+method);
	}
	
	@AfterThrowing(
			pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="thrw"
			)
	public void afterThrowingFindAccounts(JoinPoint joinPoint, Throwable thrw){
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n======@exicuting @AfterThrowing  on method: "+method);
		
		System.out.println("\n====== The Exception is: "+thrw);
		
	}
	
	
	@AfterReturning(
			pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result" )
	public void afterReturningFindAccounts(JoinPoint joinPoint, List<Account> result)
	{
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n======@exicuting after returning on method: "+method);
		
		System.out.println("\n====== result: "+result);
		
//		post process to modified the data
//		convert the name to upper case
		
		convertAccountNamesToUppercase(result);
		
		System.out.println("\n ==result UPPERCASE : "+result);
		
	}
	
	
	private void convertAccountNamesToUppercase(List<Account> result){
		for(Account tempAcc : result){
			String name = tempAcc.getName().toUpperCase();
			tempAcc.setName(name);
		}
	}
	
	@Before("com.luv2code.aopdemo.aspect.LvuAopExpressions.excludeSetGetMehosd()")
	public void beforeAddAccountAdvice(JoinPoint theJointPoint) {
		System.out.println("\n=====>>> Executing @Before advice on beforeAddAccountAdvice");
		
		MethodSignature methodSignature = (MethodSignature)theJointPoint.getSignature();
		
		System.out.println("Method : "+methodSignature);
		
		Object org[] = theJointPoint.getArgs();
		
		for(Object tempOrg : org) {
			System.out.println(tempOrg);
			
			if(tempOrg instanceof Account){
				Account tempArg = (Account)tempOrg;
				System.out.println("Account name :"+tempArg.getName());
				System.out.println("Account level :"+tempArg.getLevel());
			}
		}
			
		
		
	}
	
	
}










