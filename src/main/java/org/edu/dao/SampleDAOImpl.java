package org.edu.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.edu.vo.MemberVO;
import org.springframework.stereotype.Repository;
@Repository
public class SampleDAOImpl implements IF_SampleDAO{
	private String mapperQuery = "org.edu.dao.IF_SampleDAO"; // 일일히 경로를 지정해 주지 않고 변수를 만들어 식을 좀더 간단히 풀어낸 모습.
	@Inject
	private SqlSession sqlSession;
	//오버라이드  - 다형성 (형태가 다양하다) 목차에 있는 안에 내용에서 재정의 한다~
	@Override//메소드 명이같고 매개변수가 같은것
	public void insertMember(MemberVO vo) {
		sqlSession.insert( mapperQuery+".insertMember", vo);//경로+쿼리 (쿼리를 적을땐 앞에 .을 사용하여 경로를 표시해준다.)
	}

	@Override
	public List<MemberVO> selectMember() {
		return sqlSession.selectList(mapperQuery+".selectMember");//바꿔줘야함null;
	}

	@Override
	public void updateMember(MemberVO vo) {
		sqlSession.update(mapperQuery+".updateMember", vo);
		
	}

	@Override
	public void deleteMember(String userid) {
		sqlSession.delete(mapperQuery+".deleteMember", userid);
		
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
