package org.edu.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatConvert {

	public static void main(String[] args) {
		Date now = new Date();// Date now()는 컴퓨터의 현재 시간을 나타냅니다.
		SimpleDateFormat sdf = new SimpleDateFormat("yyy년 MM월 dd일 E요일 mm분 ss초");
		System.out.println("현재 날짜와 시간은" + sdf.format(now));
	}

}
