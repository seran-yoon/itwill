package com.class1.main;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.class1.spring.MemberInfoPrinter;
import com.class1.spring.MemberRegisterService;
import com.class1.spring.RegisterRequest;

public class MainXmlJava {

	public static void main(String[] args) {
		//1. 컨테이너 초기화
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:main-conf.xml");
		
		//2. 컨테이너 사용
		MemberRegisterService regSvc = ctx.getBean("memberRegSvc", MemberRegisterService.class);
		
		MemberInfoPrinter infoPrinter = ctx.getBean("infoPrinter", MemberInfoPrinter.class);
		
		RegisterRequest regReq = new RegisterRequest();
		regReq.setEmail("abcd@efg.com");
		regReq.setName("David");
		regReq.setPassword("a123");
		regReq.setConfirmPassword("a123");
		regSvc.regist(regReq);
		
		infoPrinter.printMemberInfo("abcd@efg.com");
		
		//3. 컨테이너 종료
		ctx.close();
	}
	
}
