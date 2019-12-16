package com.class1.spring;

//설정 메서드를 이용해서 의존 객체를 주입받는다
public class MemberInfoPrinter {
	
	private MemberDao memDao;
	private MemberPrinter printer;
	
	public void setMemberDao(MemberDao memberDao) {
		this.memDao = memberDao;
	}
	
	public void setPrinter(MemberPrinter printer) {
		this.printer = printer;
	}

	public void printMemberInfo(String email) {
		Member member = memDao.selectByEmail(email);
		if(member == null) {
			System.out.println("데이터가 없습니다.");
		}
		
		printer.print(member);
		System.out.println();
	}
	
}
