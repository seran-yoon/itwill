package com.class1.exam;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		
		//1. 실질 정보를 이용해서 빈 객체를 생성한다
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml"); 
		//GenericXmlApplicationContext -> XML로부터 객체 설정 정보를 가져온다.
		
		//2. 빈 객체를 제공한다
		Greeter g = ctx.getBean("greeter", Greeter.class);
		String msg = g.greet("스프링");
		System.out.println(msg);
		
		ctx.close();
		
	}

}
