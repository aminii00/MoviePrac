<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.*" isELIgnored="false"%>
<%@ taglib prefix ="fmt" uri ="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix ="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value = "${pageContext.request.contextPath}" />
<%
request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.main_container {
	width: 25%;
	height: auto;
	margin-left: 37%;
	text-align: center;
	background-color: pink;
	margin-top: 280px;
	border-radius: 50px;
	border: solid 2px #ff9999;
}

.selectT {
	width: 200px;
	height: 40px;
	background-color: white;
	border-radius: 50px;
	border:0px;
}

.selectT:hover {
  background-color: #ffe6e6;
}

.serve {
	width: 99%;
	height: auto;
	display: flex;
	align-items: center;
	flex-wrap: nowrap;
	align-content: stretch;
	justify-content: center;
	flex-direction: column;
}
</style>
</head>
<body>
<div class ="main_container">
<div class ="serve">
<br><br><br>
<button type ="button" class = "selectT" onclick= "location.href = '${contextPath}/movie1/movieticket.do'">영화 예매하기</button></p>
<button type ="button" class = "selectT" onclick= "location.href = '${contextPath}/movie1/movieCheck.do'">영화 확인하기</button></p>
<button type ="button" class = "selectT" onclick= "location.href = '${contextPath}/movie1/MemberForm.do'">예매 취소하기</button></p>
<button type ="button" class = "selectT" onclick= "location.href ='${contextPath}/movie1/listMembers.do'">관리자모드로 로그인</button></p>
<button type ="button" class = "selectT" onclick= "location.href ='${contextPath}/movie1/MemberForm.do'">로그아웃</button></p>
</div>
</body>
</div>
</html>