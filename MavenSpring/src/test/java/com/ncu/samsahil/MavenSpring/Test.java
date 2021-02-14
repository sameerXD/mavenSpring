package com.ncu.samsahil.MavenSpring;

import java.util.Random;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("web.xml");
		
		try {
		NewLoan NL = context.getBean("newLoan",NewLoan.class);
		
		 Random rand = new Random(); 
		 int random = rand.nextInt(1000);
		 int r = rand.nextInt(1000);
		 
		System.out.println(NL.getSourcing());
		
		System.out.println("auto generated number " + r);
		
		System.out.println(NL.getDe());
		
		System.out.println("loan status " + NL.loanStatus(NL.getDe(), NL.getSourcing()));
		if(NL.loanStatus(NL.getDe(), NL.getSourcing())){
			System.out.println("Cant take loan you are in black list");
		}else {
			System.out.println("congratulations you can get a loan");
		}
		System.out.println("Your credit score is "+ NL.Scoring(NL.getDe(), NL.getSourcing()));
		
		}catch(Exception E){
			System.out.println(E);
		}
		
	}

}
