<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!-- prefix 축약 -->
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="dist/css/adminlte.min.css">
  <!-- Google Font: Source Sans Pro -->
  <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
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
	<div class="col-md">
            <!-- general form elements disabled -->
            <div class="card card-warning">
              <div class="card-header">
                <h3 class="card-title">General Elements</h3>
              </div>
              <!-- /.card-header -->
              <div class="card-body">
                <form role="form" action = "admin/member/create" method="post">
                  <div class="row">
                    <div class="col-sm-6">
                      <!-- text input -->
                      <div class="form-group">
                        <label>아이디</label>
                        <input name="userid" type="text" class="form-control" placeholder="Enter ...">
                      </div>
                    </div>
                    <div class="col-sm-6">
                      <div class="form-group">
                        <label>비밀번호</label>
                        <input name="userpw" type="text" class="form-control" placeholder="Enter ..." >
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-sm-6">
                      <!-- textarea -->
                      <div class="form-group">
                        <label>이름</label>
                        <input name="username" type="text" class="form-control" placeholder="Enter ..." >
                      </div>
                    </div>
                    <div class="col-sm-6">
                      <div class="form-group">
                        <label>이메일</label>
                        <input name="email" type="email" class="form-control" placeholder="Enter ..." >
                      </div>
                    </div>
                  </div>
                  </div>
                  <button type="submit" class="btn btn-outline-secondary">회원가입</button>
              <!-- /.card-body -->
            </div>
            <!-- /.card -->
            </form>
          </div>
    <!-- /.content -->
	<table class="bbsListTbl"  summary="회원정보리스트">
		<caption class="hdd">공지사항 목록:제작자${jspMaker}</caption>
		<thead>
			<tr>
				<th scope="col">번호</th>
				<th scope="col">사용자ID</th>
				<th scope="col">사용자암호</th>
				<th scope="col">사용자이름</th>
				<th scope="col">사용자이메일</th>
				<th scope="col">사용자등록일</th>
				<th scope="col">사용자수정일</th>
				<th scope="col">수정</th>
				<th scope="col">삭제</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${memberList}" var="vo" varStatus="status"><!-- maker와 같은 역할 -->
			<tr>
				<td>${status.count}</td>
				<form action ="admin/member/update" method="post">
				<td>
				${vo.userid}
				<input type="hidden" name="userid" value="${vo.userid}" ></td>
				<td><input type="text" name="userpw" value=" ${vo.userpw}"></td>
				<td><input type="text" name="username" value="${vo.username}"></td>
				<td><input type="text" name="email" value="${vo.email}"></td>
				<td>${vo.regdate}</td>
				<td>${vo.updatedate}</td>
				<td><input type="submit" value="수정"></td>
				</form>
				<td>
				<form action="/admin/member/delete" method="post">
				<input type="hidden" value="${vo.userid}" name="userid">
				<input type="submit" value="삭제">
				</form>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>
