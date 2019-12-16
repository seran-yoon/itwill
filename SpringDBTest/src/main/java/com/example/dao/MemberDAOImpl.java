package com.example.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.dto.MemberVO;

//MemberDATImpl은 SqlSession을 주입받아서 memberMapper.xml에 등록한 쿼리문을 실행한다
//쿼리 실행결과가 여러개의 데이터를 가져오게 되므로 List로 받아서 리턴한다

//MemberDaoImpl작성 후 Bean으로 등록을 해야한다
//Bean 등록을 하기 위해서 root-context.xml에 기술한다

//MemberDAOImpl에 @repository 어노테이션이 설정되어있더라도, 스프링에서 해당 패키지를 스캔하지 않으면 스프링 Bean으로 등록되지 않는다
//그래서 root-context.xml에 Bean을 등록해야 한다

@Repository
public class MemberDAOImpl implements MemberDAO{

	@Inject
	private SqlSession sqlSession;
	
	private static final String Namespace = "com.example.mapper.memberMapper";
	
	@Override
	public List<MemberVO> selectMember() throws Exception{
		return sqlSession.selectList(Namespace + ".selectMember");
	}
	
}
