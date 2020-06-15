<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!-- prefix 축약 -->
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<style>
	table{
		border:1px solid skyblue;
	}
	tr,td,th {
		border : 1px solid skyblue;
	}
</style>
</head>
<body>
	<h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.</P>
	<table class="bbsListTbl"  summary="회원정보리스트">
		<caption class="hdd">공지사항 목록:제작자${jspMaker}</caption>
		<thead>
			<tr>
				<th scope="col">번호</th>
				<th scope="col">사용자ID</th>
				<th scope="col">사용자암호</th>
				<th scope="col">사용자이름</th>
				<th scope="col">사용자이메일</th>
				<th scope="col">사용자수정일</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${memberList}" var="vo" varStatus="status"><!-- maker와 같은 역활 -->
			<tr>
				<td>${status.count}</td>
				<td>${vo.userid}</td>
				<td>${vo.userpw}</td>
				<td>${vo.username}</td>
				<td>${vo.email}</td>
				<td>${vo.regdate}</td>
				<td>${vo.updatedate}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>
