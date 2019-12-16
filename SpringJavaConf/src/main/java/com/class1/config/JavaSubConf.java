package com.class1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.class1.spring.MemberDao;
import com.class1.spring.MemberPrinter;
import com.class1.spring.MemberRegisterService;

@Configuration
public class JavaSubConf {

	@Autowired
	private MemberDao memberDao;
	
	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao);
	}
	
}
