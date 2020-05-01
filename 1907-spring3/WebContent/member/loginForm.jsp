<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel='stylesheet' type='text/css' href='../css/index.css'/>
	<script src='../lib/jquery-3.4.1.js'></script>
	<script src='../js/member.js'></script>
</head>
<body>

<div id='body' class='login'>
	<div><%@include file="../header.jsp" %></div>
	<form name='frm_login' id='frm_login' method='post'>
		<fieldset>
			<legend> [ LOGIN ] </legend>
			<label>아뒤</label>
			<input type='text' name='mId' value='hong'></br/>
			<label>암호</label>
			<input type='password' name='pwd' value='1'></br/>
			<br/>
			<input type='button' id='btnBack'   class='btnLogin' 
			       value='취소' onclick='history.back()'/>
			<input type='button' id='btnLogin' class='btnLogin' value='로그인'/>
			<br/><br/>
			<a href='' >아이디/암호찾기</a>
		</fieldset>
	</form>
	<div><%@include file="../footer.jsp" %></div>
</div>
<script>mm.func()</script>
</body>
</html>