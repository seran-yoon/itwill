package com.class1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.class1.spring.MemberDao;
import com.class1.spring.MemberInfoPrinter;
import com.class1.spring.MemberPrinter;

@Configuration
public class ConfigPartSub {

	@Autowired
	private MemberDao memberDao;

	@Bean
	public MemberPrinter printer() {
		return new MemberPrinter();
	}
	
	@Bean
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		infoPrinter.setMemberDao(memberDao);
		infoPrinter.setPrinter(printer());
		return infoPrinter;
	}
	
}
