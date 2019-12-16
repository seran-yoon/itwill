package com.class1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.class1.spring.MemberDao;
import com.class1.spring.MemberInfoPrinter;
import com.class1.spring.MemberPrinter;
import com.class1.spring.MemberRegisterService;

@Configuration
public class JavaConfig2 {

	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao());
	}
	@Bean 
	public MemberPrinter printer() {
		return new MemberPrinter();
	}@Bean 
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		return infoPrinter;
	}

}



























