package com.aop.megician;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AudianceAspect {
	
	@Before("execution(public void doMagic())")
	public void clapping() {
		System.out.println("clapping");
	}
	
	@Before("execution(public void doMagic())")
	public void sitting() {
		System.out.println("sitting");
	}

}