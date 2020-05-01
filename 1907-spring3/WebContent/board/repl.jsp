<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id='board'>
	<div id='header'>게시물 답변 </div>
	<form name='frm_brd' id='frm_brd' method='post'>
		<!-- UI  -->
		<label>작성자</label>
		<input type='text' name='id' value='${id }'/><br/>
		
		<label>제 목</label>
		<input type='text' name='subject' size='90' /><br/>
		<textarea name='content' class='content'></textarea><br/>

		<label>암호</label>
		<input type='password' name='pwd' /><br/>
	
		<fieldset><legend>[ 파일 첨부 ]</legend>
			<input type='file' multiple="multiple" id='btnAtt' name='attFile'><hr/>
			<div id='attList'></div>
		</fieldset>


	
		<input type='button' id='btnReplR' value='답변 저장'/>
		<input type='button' id='btnSelect' value='목록으로'/>
		
		<input type='hidden' name='pSerial'  value='${param.serial }'/>
		<input type='hidden' name='findStr' value='${param.findStr }'/>
		<input type='hidden' name='nowPage' value='${param.nowPage }'/>
	</form>
	
	<script>brd.func()</script>

</div>