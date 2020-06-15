package org.edu.test;

import java.util.StringTokenizer;

public class Split {

	public static void main(String[] args) {
		String str = "아이디, 이름, 패스워드";
		//방법1 split() 메소드 사용
		System.out.println("Split을 사용한 문자열 분리");
		String[] tokens = str.split(",");//regex 정규식
		int cnt = 0;
		for(String token:tokens) {
			System.out.print("배열["+ cnt++ +"]" +token +"|");//token : 의미있는 데이터가 들어있는 경우 토큰이라는 말을 쓴다.
		}
		//방법 2 Tokenizer 이용
		StringTokenizer st = new StringTokenizer(str,",");
		while(st.hasMoreTokens()) {
			String token = st.nextToken();
			System.out.println(token);
			System.out.println();
		}
	}

}
