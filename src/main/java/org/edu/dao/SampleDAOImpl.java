package org.edu.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.edu.vo.MemberVO;

public class SampleDAOImpl implements IF_SampleDAO{
	
	@Inject
	private SqlSession sqlSession;
	//오버라이드  - 다형성 (형태가 다양하다) 목차에 있는 안에 내용에서 재정의 한다~
	@Override//메소드 명이같고 매개변수가 같은것
	public void insertMember(MemberVO vo) {
		sqlSession.insert("org.edu.dao.IF_SampleDAO", vo);
	}

	@Override
	public List<MemberVO> selectMember() {
		return sqlSession.selectList("org.edu.dao.IF_SampleDAO");//바꿔줘야함null;
	}

	@Override
	public void updateMember(MemberVO vo) {
		sqlSession.update("org.edu.dao.IF_SampleDAO", vo);
		
	}

	@Override
	public void deleteMember(String userid) {
		sqlSession.delete("org.edu.dao.IF_SampleDAO", userid);
		
	}

	@Override
	public String getTime() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUname(String uid, String upw) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUserId(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String searchUname(String type, String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
