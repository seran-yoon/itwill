package com.class1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.class1.spring.MemberDao;
import com.class1.spring.MemberRegisterService;

@Configuration
@Import(ConfigPartSub.class) //다른 설정클래스를 import한다 (ConfigPartSub를 import해서 합치기)
public class ConfigPartMain {

	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao());
	}
	
}
