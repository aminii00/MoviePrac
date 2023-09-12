<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
</날짜/>
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
.cls1 {
	width: 100%;
	text-align: center;
}

.cls2 {
	width: 50%;
	height: 50%;
	text-align: center;
	background-color: pink;
	margin-top: 15%;
	margin-left: 25%;
	border-radius: 30px;
	border: solid 2px #ff9999;
}

.cls3 {
	font-size: 15px;
	width: 90%;
	text-align: center;
	background-color: white;
	border-radius: 20px;
}

.br {
	border: 0px;
	border-radius: 10px;
}

.br1 {
	border: 0px;
	background-color: white;
	border-radius: 10px;
	border: solid 2px #ff9999;
}

.br2 {
	height: 40px;
	border: 0px;
	background-color: #ffcccc;
	border-radius: 10px;
	border: solid 2px #ff9999;
}

.br1:hover {
	background-color: #ffb3b3;
}

.br2:hover {
	background-color: #ffb3b3;
}

.margin_bott {
	margin-bottom: 5px;
}
</style>
</head>
<body>
	<div class="cls1">
		<div class="cls2">
			<br> <span style="font-weight: bold;">Movie List</span> <br>
			<br>
			<table class="cls3" align="center">
				<tr align="center">
					<td width="7%"><b>번호</b>
					<td width="7%"><b>영화제목</b></td>
					<td width="7%"><b>좌석</b></td>
				</tr>
				<c:choose>
					<c:when test="${ empty movieList }">
						<tr>
							<td colspan=5 align="center"><b>예매한 내역이 없습니다.</b></td>
						</tr>
					</c:when>
					<c:when test="${!empty movieList}">
						<c:forEach var="mem" items="${movieList}">
							<tr align="center">
								<td>${mem.resid}</td>
								<td>${mem.moviename}</td>
								<td>${mem.seat}</td>
							</tr>
						</c:forEach>
					</c:when>
				</c:choose>
			</table>
			
		</div>
	</div>
</body>
</html>