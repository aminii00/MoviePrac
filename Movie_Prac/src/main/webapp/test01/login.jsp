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
body {
    background-color: white;
    color: #fff;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    height: 100vh;
    font-family: 'Lato', sans-serif;
    margin: 0;
}
 @import url('https://fonts.googleapis.com/css2?family=Lato:ital@1&display=swap');
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
	background-color: pink;
	border-radius: 50px;
	border: solid 2px #ff9999;
}

.serve_container {
	width: 400px;
	height: 800px;
	text-align: center;
}

.inputT {
	border: solid 1px #cccccc;
    width: 230px;
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

.clear {
	background: #777;
	border: 2px solid #777;
	border-radius: 5px;
	width: 186px;
	margin-top: 10px;
	font-size: 14px;
	font-weight: 600;
	height: 44px;
}

}
.clear:hover {
	cursor: pointer;
}

.margin_bott{
margin-bottom:5px;
}
</style>
</head>
<body>

	<div class="login-wrapper">
		<form class="login-form" method="post"
			action="${contextPath}/movie1/login.do">
			<div class="main_container">
				<div class="serve_container">
					<br> <br> <br> <br> <br>
					<h2>Login</h2>
					<br> <input class="inputT margin_bott" type="text" placeholder=" 아이디 입력"
						name="id"> <br> <input class="inputT" type="password"
						placeholder=" 비밀번호 입력" name="pwd"></label> </label> <br> <br> <br>
					<input class="clear" type="submit" value="로그인"> <br>
				</div>
			</div>
		</form>
	</div>
</body>
</html>