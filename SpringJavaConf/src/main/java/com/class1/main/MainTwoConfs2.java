package com.class1.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.class1.config.ConfigPartMain;
import com.class1.spring.MemberInfoPrinter;
import com.class1.spring.MemberRegisterService;
import com.class1.spring.RegisterRequest;

public class MainTwoConfs2 {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigPartMain.class); //ConfigPart1, ConfigPart2둘다 가져올 필요없이  ConfigPartMain만 가져오면 된다 (ConfigPartMain에서 ConfigPartSub를 import해줘서 합쳤기 때문)
		
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
