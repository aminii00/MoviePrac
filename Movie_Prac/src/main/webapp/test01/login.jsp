<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.login-wrapper {
	width: 100%;
	height: 100%;
	display: flex;
	justify-content: center;
	align-content: space-between;
}

.login-form {
	width: 300px;
	height: 300px;
	margin-top: 300px;
}

.main_container {
	width: 400px;
	height: 500px;
	text-align: center;
	background-color: #ffe6e6;
	margin-top: 100px;
	border-radius: 50px;
}

.serve_container {
	width: 400px;
	height: 800px; text-align : center;
	margin-top: 100px;
	text-align: center;
}

.inputT {
	width: 180px;
	height: 40px;
	border-radius: 10px;
}

.login {
	width: 180px;
	height: 40px;
	border: 0;
	background-color: pink;
	border-radius: 10px;
}
</style>
</head>
<body>

	<div class="login-wrapper">
		<form class="login-form" method="post"
			action="${contextPath}/movie1/cuslist.do">
			<div class="main_container">
				<div class="serve_container">
					<br>
					<br>
					<br>
					<br>
					<br>
					<h2>로그인</h2>
					<br>
					<input class="inputT" type="text" placeholder=" 아이디 입력"
						name="user_id"></label><br> <input class="inputT"
						type="password" placeholder=" 비밀번호 입력" name="user_pw"></label> </label> <br>
					<br><br> <input class="login" type="submit" value="로그인"> <br>
				</div>
			</div>
		</form>
	</div>
</body>
</html>