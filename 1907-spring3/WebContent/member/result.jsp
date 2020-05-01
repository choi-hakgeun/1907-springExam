<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id='member'>
	<div id='result'>
		<div id='header'>결과 </div>
		${msg }	
		<br/><br/>
			<form name='frm_mm' id='frm_mm' method='post'>
				<input type='button' id='btnSelect' value='목록으로'/>
				
				<input type='hidden' name='findStr' value='${p.findStr }'/>
				<input type='hidden' name='nowPage' value='${p.nowPage }'/>
			</form>
	 </div>
	<script>mm.func()</script>



</div>