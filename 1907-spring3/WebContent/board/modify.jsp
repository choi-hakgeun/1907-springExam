<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id='board'>
	<div id='header'>게시물 수정 </div>

	<form name='frm_brd' id='frm_brd' method='post'
	      enctype='multipart/form-data'>
		<!-- UI  -->
	
		<label>작성자</label>
		<input type='text' readonly name='id' value='${vo.id }'/><br/>
		
		<label>제 목</label>
		<input type='text' name='subject' size='90'  value='${vo.subject }'/><br/>
		<textarea name='content' class='content'>${vo.content }</textarea><br/>

		<fieldset><legend>[ 파일 첨부 ]</legend>
			<input type='file' multiple="multiple" id='btnAtt' name='attFile'><hr/>
			<div id='attList'></div>
		</fieldset>	
		
		<fieldset><legend>[ 첨부된 파일 ]</legend>
			<c:forEach var='i' items='${attList }'>
				<div>
					<span>${i.oriFile }</span>
					<input type='checkbox' name='delFile' value='${i.sysFile }'
					       onclick='brd.delCheck(this)' >
				</div>
				
			</c:forEach>		
		</fieldset>
	
		<input type='button' id='btnUpdate' value='수정 저장'/>
		<input type='button' id='btnSelect' value='목록으로'/>
		
		<input type='hidden' name='serial'  value='${vo.serial }'/>
		<input type='hidden' name='findStr' value='${p.findStr }'/>
		<input type='hidden' name='nowPage' value='${p.nowPage }'/>
		<input type='hidden' name='pwd' />
	</form>
	
	<script>brd.func()</script>

</div>