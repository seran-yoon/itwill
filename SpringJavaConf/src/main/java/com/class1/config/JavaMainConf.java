package com.class1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.class1.spring.MemberDao;
import com.class1.spring.MemberPrinter;
import com.class1.spring.MemberRegisterService;

@Configuration
@ImportResource("Classpath:sub-conf.xml")
public class JavaMainConf {

	@Autowired
	private MemberDao memberDao;
	
	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService();
	}
	
}
