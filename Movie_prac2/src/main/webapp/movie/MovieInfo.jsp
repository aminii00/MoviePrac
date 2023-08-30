<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="false"%>
<%@ taglib prefix ="fmt" uri ="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix ="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value ="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<form name = "form" method ="post" action ="${contextPath}/movie001/addMember.do">
<h1 style ="text-align:center">영화 등록창</h1>
<table align ="center">
  <tr>
    <td width="200"><p align ="right">영화 제목</td>
    <td width="400"><input type ="text" name ="title" > 
  </tr>
  <tr>
    <td width="200"><p align ="right">장르</td>
    <td width="400"><input type ="text" name ="genre"></td>
  </tr>
  
    <td width="200"><p>&nbsp;</p></td>
    <td width="400"><input type ="submit" value="등록하기" >
    <input type ="reset" value="다시입력">
    </td>
  </tr>
</table>
</form>
</body>
</html>