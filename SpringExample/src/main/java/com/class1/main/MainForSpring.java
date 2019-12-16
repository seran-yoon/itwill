package com.class1.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.class1.spring.AlreadyExsitingMemberException;
import com.class1.spring.ChangePasswordService;
import com.class1.spring.IdpasswordNotMatchingException;
import com.class1.spring.Member;
import com.class1.spring.MemberDao;
import com.class1.spring.MemberNotFoundException;
import com.class1.spring.MemberRegisterService;
import com.class1.spring.RegisterRequest;

public class MainForSpring {
	
	//ApplicationContext -> [bean에 대한 집합] 오브젝트 생성, 관계 설정, 만들어지는 방식, 자동생성, 후처리 등 여러가지 일을 하는 역할 (BeanFactory를 상속받고 있음)
	private static ApplicationContext ctx = null;
	
	public static void main(String[] args) throws IOException {
		
		//GenericXmlApplicationContext은 ApplicationContext의 종류중에 하나로, xml의 파일경로가 생성자에 들어가 있어서 편하게 xml을 로딩 할 수 있다
		//GenericXmlApplicationContext를 사용해서 스프링 컨테이너를 생성한다
		ctx = new GenericXmlApplicationContext("classpath:appCtx.xml"); //classtpath는 자바의 src/main/resources를 얘기 함
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println("명령어를 입력하십시오. ex)new, change, exit");
			String command = reader.readLine();
		
			if(command.equals("exit")) {
				System.out.println("종료합니다.");
				break;
			}
			
			if(command.startsWith("new ")) {
				processNewCommand(command.split(" "));
				continue;
			}else if(command.startsWith("change ")) {
				processChangeCommand(command.split(" "));
				continue;
			}
			
			printHelp();
		}
		
	}//end - public static void main(String[] args) throws IOException
	
	//새로 생성	(insert)
	private static void processNewCommand(String[] arg) {
		if(arg.length != 5) {
			printHelp();
			return;
		}
			
		//스프링 컨테이너로부터 이름(id)이 memberRegSvc인 빈(bean)객체를 가져온다
		MemberRegisterService regSvc = ctx.getBean("memberRegSvc", MemberRegisterService.class); //appCtx.xml의 Bean의 id, 실제 클래스 이름
		RegisterRequest req = new RegisterRequest();
		req.setEmail(arg[1]);
		req.setName(arg[2]);
		req.setPassword(arg[3]);
		req.setConfirmPassword(arg[4]);
			
		if(!req.isPasswordEqualToConfirmPassword()) {
			System.out.println("비밀번호와 비밀번호 확인이 다릅니다.");
			return;
		}
		
		try {
			regSvc.regist(req);
			System.out.println("자료를 등록하였습니다.");
		} catch (AlreadyExsitingMemberException e) {
			System.out.println("이미 존재하는 이메일입니다.");
		}
	}//end - private static void processNewCommand(String[] arg)

	//수정 (update)
	private static void processChangeCommand(String[] arg) {
		if(arg.length != 4) {
			printHelp();
			return;
		}
			
		//스프링 컨테이너로부터 이름(id)이 changePwdSvc인 빈(bean)객체를 가져온다
		ChangePasswordService changePwdSvc = ctx.getBean("changePwdSvc", ChangePasswordService.class);
		
		try {
			changePwdSvc.changePassword(arg[1], arg[2], arg[3]);
			System.out.println("비밀번호를 변경하였습니다.");
		} catch (MemberNotFoundException e) {
			System.out.println("이미 존재하는 이메일입니다.");
		} catch (IdpasswordNotMatchingException e) {
			System.out.println("이메일과 암호가 일치하지 않습니다.");
		}
	}//end - private static void processChangeCommand(String[] arg)
		
	private static void printHelp() {
		System.out.println();
		System.out.println("아래의 사용법을 확신하신 후 사용하십시오");
		System.out.println("명령어 사용방법");
		System.out.println("new 이메일 이름 비밀번호 비밀번호확인");
		System.out.println("change 이메일 현재비번 변경비번");
		System.out.println("exit");
		System.out.println();
	}//end - private static void printHelp()

}
