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
    height:50%;
	text-align: center;
	background-color: #ffe6e6;
	margin-top:15%;
	margin-left:25%;
	border-radius: 30px;
}
.br{
border:0px;
border-radius:10px;
}

.br1{
border:0px;
background-color: white;
border-radius:10px;
}

.br2{
height:40px;
border:0px;
background-color: #ffcccc;
border-radius:10px;
}


.br2:hover {
  background-color: #ffb3b3;
}
</style>
</head>
<body>
	<div class="cls1">
		<div class="cls2">
		<br>
			<span style="font-weight: bold;">영화 목록</span>
			<br><br>
			<table align="center">
				<tr align="center" bgcolor="pink">
					<td class ="br" width="7%"><b>영화제목</b>
					<td class ="br" width="7%"><b>장르</b></td>
					<td class ="br" width="7%"><b>영화예매</b></td>
				</tr>
				<c:choose>
					<c:when test="${ empty membersList }">
						<tr>
							<td colspan=5 align="center"><b>등록된 회원이 없습니다.</b></td>
						</tr>
					</c:when>
					<c:when test="${!empty membersList}">
						<c:forEach var="mem" items="${membersList}">
							<tr align="center">
								<td class ="br1">${mem.title}</td>
								<td class ="br1">${mem.genre}</td>
								<td class ="br1"><button type ="button" class ="br1"
									onclick = "location.href='${contextPath}/movie1/cusreser.do?id=${mem.id}'">영화 예매</button></td>
							</tr>
						</c:forEach>
					</c:when>
				</c:choose>
			</table>
			<br>
			<button class="br2" onclick="location.href='${contextPath}/movie1/listMembers.do'">영화목록 보기</button>
			<br>
		</div>
	</div>
</body>
</html>