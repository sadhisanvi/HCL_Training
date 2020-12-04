package com.aop.megician;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//static proxy: i have written this proxy class
// what i wish spring aop should do it ?
// aspectJ: do something called "dynamic proxy"

public class Main {
	
	//when magician was showing magic before the audiance must clap
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("aop.xml");
		
		Magician magic = ctx.getBean("m", Magician.class);
		magic.doMagic();
	}

}