<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.*" isELIgnored="false"%>
<%@ taglib prefix ="fmt" uri ="http://java.sun.com/jsp/jstl/fmt" %> </날짜/>
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
<h1>좌석 선택</h1>
---------------------------- <br>
        S C R E E N          <br>
---------------------------- <br>
A ㅁㅁㅁㅁㅁㅁㅁㅁㅁ <br>
B ㅁㅁㅁㅁㅁㅁㅁㅁㅁ <br>
C ㅁㅁㅁㅁㅁㅁㅁㅁㅁ <br>
D ㅁㅁㅁㅁㅁㅁㅁㅁㅁ <br>
E ㅁㅁㅁㅁㅁㅁㅁㅁㅁ <br>
       1__________________9
<form method = "post" action ="${contextPath}/movie1/rowcol.do">
 좌석 선택 : <input type ="text" name = "row" size="10">
 <select>
   <option>A</option>
   <option>B</option>
   <option>C</option>
   <option>D</option>
   <option>E</option>
</select>
 <input type ="text" name = "col" size="10">
<select>
   <option>1</option>
   <option>2</option>
   <option>3</option>
   <option>4</option>
   <option>5</option>
   <option>6</option>
   <option>7</option>
   <option>8</option>
   <option>9</option>
 </select>
 <input type ="submit" value= "선택" >
</form>
</body>
</html>