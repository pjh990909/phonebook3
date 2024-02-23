<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="java.util.List" %>   
<%@ page import="com.javaex.vo.PersonVo" %>
    
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>전화번호부</h1>

<h2>리스트</h2>

<p>
	등록된 전화번호 리스트입니다.
</p>

<c:forEach items="${requestScope.personList}" var="personVo" >


<table border="1">
	<tr>
		<td>이름(name)</td>
		<td>${personVo.name}</td>
	</tr>
	
	<tr>
		<td>전화번호(hp)</td>
		<td>${personVo.hp}</td>
	</tr>
	
	<tr>
		<td>회사(company)</td>
		<td>${personVo.company}</td>
	</tr>
	
	<tr>
		<td>${personVo.personId}
			<a href="/phonebook3/pbc?action=delete&no=${personVo.personId}">[삭제]</a>
		</td>
		<td>
			<a href="/phonebook3/pbc?action=uform&no=${personVo.personId}&name=${personVo.name}>&hp=${personVo.hp}&company=${personVo.company}">[수정]</a>
		</td>
	</tr>
</table>
<br>

</c:forEach>



</body>
</html>