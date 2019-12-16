package com.class1.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.class1.config.JavaMainConf;
import com.class1.spring.MemberInfoPrinter;
import com.class1.spring.MemberRegisterService;
import com.class1.spring.RegisterRequest;

public class MainJavaXml {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(JavaMainConf.class); 	
		MemberRegisterService regSvc = ctx.getBean("memberRegSvc", MemberRegisterService.class);
		
		MemberInfoPrinter infoPrinter = ctx.getBean("infoPrinter", MemberInfoPrinter.class);
		
		RegisterRequest regReq = new RegisterRequest();
		regReq.setEmail("abcd@efg.com");
		regReq.setName("David");
		regReq.setPassword("a123");
		regReq.setConfirmPassword("a123");
		regSvc.regist(regReq);
		
		infoPrinter.printMemberInfo("abcd@efg.com");
	}
	
}
