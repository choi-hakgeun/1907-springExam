<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel='stylesheet' type='text/css' href='./css/index.css'/>
	<link rel='stylesheet' type='text/css' href='./css/board.css'/>
	<link rel='stylesheet' type='text/css' href='./css/member.css'/>
	
	<title>Insert title here</title>
	<script src='./lib/jquery-3.4.1.js'></script>
	<script src='./js/board.js'></script>
	<script src='./js/member.js'></script>

</head>
<body>
	<div id='body'>
		<div id='login'>
			<%@include file="./member/login.jsp" %>
		</div>
		<div>
			<%@include file="header.jsp" %>
		</div>	
		
		<div id='nav'>
			<a href='#' onclick='brd.init()'>게시판 조회</a>
			<a href='#' onclick='mm.init()'>회원 조회</a>
		</div>
		
		<div id='main'>here....</div>
		
		<div >
			<%@include file="./footer.jsp" %>
		</div>
	</div>
	<script>brd.init();</script>
</body>
</html>



