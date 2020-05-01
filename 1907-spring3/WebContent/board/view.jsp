<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div id='board'>
	<div id='header'>게시물 상세보기 </div>

	<form name='frm_brd' id='frm_brd' method='post'>
		<!-- UI  -->
		<label>작성자</label>
		<input type='text' readonly name='id' value='${vo.id }'/><br/>
		
		<label>제 목</label>
		<input type='text' name='subject' size='90' value='${vo.subject }'/><br/>
		<textarea name='content' class='content'>${vo.content }</textarea><br/>

		<c:if test="${fn:length(attList)>0 }">
			<fieldset><legend>[ 첨부된 파일 ]</legend>
				<ul>
				<c:forEach var='i' items='${attList }'>
					<div>
						 <li><a href='./upload/${i.sysFile }' download='${i.oriFile }'>${i.oriFile }</a></li>
					</div>
				</c:forEach>
				</ul>
			</fieldset>
		</c:if>

	
		<input type='button' id='btnModify' value='수정'/>
		<input type='button' id='btnDelete' value='삭제'/>
		<input type='button' id='btnRepl' value='답글'/>
		<input type='button' id='btnSelect' value='목록으로'/>
		
		<input type='hidden' name='pwd' />
		<input type='hidden' name='serial' value='${vo.serial }'/>
		<input type='hidden' name='findStr' value='${p.findStr }'/>
		<input type='hidden' name='nowPage' value='${p.nowPage }'/>
	</form>

	<script>brd.func()</script>
</div>