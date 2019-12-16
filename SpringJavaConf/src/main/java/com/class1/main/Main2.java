package com.class1.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.class1.config.JavaConfig2;
import com.class1.spring.MemberInfoPrinter;
import com.class1.spring.MemberRegisterService;
import com.class1.spring.RegisterRequest;

public class Main2 {
	//MemberInfoPrinter의 set 메서드에 @Autowired 를 적용해야 정상적으로 동작한다.
	
	public static void main(String[] args) {
		ApplicationContext ctx =
				new AnnotationConfigApplicationContext(JavaConfig2.class);
		MemberRegisterService regSvc =
				ctx.getBean("memberRegSvc", MemberRegisterService.class);
		MemberInfoPrinter infoPrinter =
				ctx.getBean("infoPrinter", MemberInfoPrinter.class);
		
		RegisterRequest regReq = new RegisterRequest();
		
		regReq.setEmail("honggildong@gilldong.com");
		regReq.setName("홍길동");
		regReq.setPassword("1234");
		regReq.setConfirmPassword("1234");
		regSvc.regist(regReq);

		infoPrinter.printMemberInfo("honggildong@gilldong.com");
	}
}



















