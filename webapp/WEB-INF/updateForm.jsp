<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>전화번호부</h1>

<h2>등록폼</h2>

<p>
	전화번호를 등록하려면<br>
	아래 항목을 기입하고 "등록" 버튼을 클릭하세요
</p>
http://localhost:8080/phonebook3/pbc?action=insert&name=박종희&hp=010&company=02
<form action="http://localhost:8080/phonebook3/pbc" method="get">

	
	<input type="hidden" name="no" value="${param.getNo}">
	<div>
		<label>이름(name)</label>
		<input type="text" name="name" value="${param.name}">
	</div>
	
	<div>
		<label>핸드폰(hp)</label>
		<input type="text" name="hp" value="${param.hp}">
	</div>
	
	<div>
		<label>회사(company)</label>
		<input type="text" name="company" value="${param.company}">
	</div>
	
	<input type="text" name="action" value="update"><br>
	<button type="submit">수정</button>
</form>

<br>
<br>

<a href="">리스트페이지로 이동</a>

</body>
</html>