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
</head>
<body>
<a href = "${contextPath}/movie1/movieticket.do">영화 예매하기</a></p>
<a href = "${contextPath}/test01/num_form.jsp">영화 확인하기</a></p>
<a href = "${contextPath}/movie1/MemberForm.do">예매 취소하기</a></p>
<a href = "${contextPath}/movie1/listMembers.do">관리자모드로 로그인</a></p>
<a href = "${contextPath}/movie1/MemberForm.do">로그아웃</a></p>
</body>
</html>