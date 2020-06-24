package org.edu.service;

import java.util.List;

import org.edu.vo.MemberVO;

public interface IF_SampleService {//CRUD먼저 생성
	// 회원정보 입력 - 조회 - 수정 - 삭제 메소드
		public void insertMember(MemberVO memberVO) throws Exception; //samplemapper.xml에 있는 insert를 불러오기 위해서 작성해줌 MemberVO의 변수를 insertMember에 가져옴과 동시에 MemberVO는 vo라는 이름을 지어줌
		//List 형식을 쓸때 안에 들어가있는 내용은 꺽쇠로 열고 닫는다.
		public List <MemberVO> selectMember() throws Exception;
		public void updateMember (MemberVO memberVO) throws Exception;
		public void deleteMember(String userid) throws Exception;
}
