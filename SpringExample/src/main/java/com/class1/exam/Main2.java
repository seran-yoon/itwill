package com.class1.exam;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main2 {

	public static void main(String[] args) {

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		Greeter g1 = ctx.getBean("greeter", Greeter.class);
		Greeter g2 = ctx.getBean("greeter", Greeter.class);
		System.out.println("g1 == g2 : " + (g1 == g2)); //true
		//스프링은 별도 설정을 하지않는 경우 한 대의 빈 객체만을 생성하며, 이들 빈 객체들이 싱글톤(singleton) 범위를 갖는다고 표현한다
		//스프링은 기본적으로 한개의 <bean>태그에 대해 한개의 빈 객체를 생성한다
		
		Greeter g3 = ctx.getBean("greeter", Greeter.class);
		Greeter g4 = ctx.getBean("greeter4", Greeter.class);
		System.out.println("g3 == g4 : " + (g3 == g4)); //false
		//같은 클래스여도 id가 다르면 다른 객체로 생성한다
		
		ctx.close();
		
	}

}
