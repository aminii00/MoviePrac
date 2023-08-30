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
<c:choose>
  <c:when test='${msg=="addMember"}'>
    <script>
     window.onload=function(){
     alert("회원을 등록했습니다.");
     }
     </script>
     </c:when>
      <c:when test='${msg=="deleted"}' >
      <script>
        window.onload=function(){
        	alert("회원정보를 삭제했습니다.");
        }
      </script>
      </c:when>
    </c:choose>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
 .cls1 {
      font-size:40px;
      text-align:center;
 }
 .cls2{
      font-size:20px;
      text-align:center;
      background-color:"pink";
 }
</style>
</head>
<body>
<p class = "cls2">영화 목록</p>
<table align="center" border="1">
<tr align="center" bgcolor="pink">
 <td width="7%"><b>id</b>
 <td width="7%"><b>좌석번호</b>
 <td width="7%"><b>영화</b></td>
 <td width="7%"><b>발급번호</b></td>
</tr>
<c:choose>
  <c:when test="${ empty r }" >
    <tr>
      <td colspan=5 align ="center">
        <b>예매한 영화가 없습니다.</b>
      </td>
    </tr>
  </c:when>
  <c:when test="${!empty r}" >
    <c:forEach var="r" items="${r}">
      <tr align ="center">
        <td>${r.resid}</td>
        <td>${r.seat}</td>
        <td>${r.moviename}</td>
        <td>${r.movieid}</td>
        <td><a href ="${contextPath}/movie1/delMember.do?id=${r.id}">영화 취소</a></td>
        
      </tr>
    </c:forEach>
  </c:when>
</c:choose>
</table>

<a href = "${contextPath}/movie1/MemberForm.do"><p class = "cls2">영화 삽입</a></p>
<a href = "${contextPath}/movie1/listMembers.do"><p class = "cls2">영화 목록 보기</a></p>

</body>
</html>