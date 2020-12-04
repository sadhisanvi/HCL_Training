package com.annotation;

import java.lang.reflect.Modifier;

class MyFoo {
	
	@MyAnnotation(hello = "we all are champ", isDone = true)
	public void doWork() {
		System.out.println("some logic...");
	}
}

public class DemoAnnotationProcessing {
	public static void main(String[] args) throws ClassNotFoundException {
		
		Class clazz  = Class.forName("com.annotation.MyFoo");
		
		java.lang.reflect.Method[] methods = clazz.getDeclaredMethods();
		
		for(java.lang.reflect.Method m: methods) {
			System.out.println(m.getName());
			if(m.isAnnotationPresent(MyAnnotation.class)) {
				MyAnnotation ann = m.getDeclaredAnnotation(MyAnnotation.class);
				System.out.println(ann.isDone());
				System.out.println(ann.hello());
			}
		}
	}
}
