<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form>

	<c:if test="${empty session_id }">
		<input type='button' value='로그인' onclick="location.href='./member/loginForm.jsp'" />
	</c:if>
	
	<c:if test="${session_id != null }">
		[${session_id } 님 방가~~]
		<input type='button' value='로그아웃' id='btnLogout' />
	</c:if>		
</form>

<script>mm.func()</script>

