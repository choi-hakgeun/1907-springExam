<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<div id='member' class='frm_modify'>
	<div id='header'>회원 정보 상세보기 </div>

	<form name='frm_mm' id='frm_mm' method='post'>
		<!-- UI  -->
			<label>아이디</label>
			<input type='text' name='mId' value='${vo.mId }'><br/>
			<label>성 명</label>
			<input type='text' name='mName' value='${vo.mName }'><br/>
			
			<label>등록일</label>
			<input type='date' name='rDate' value='${vo.rDate }'><br/>
		
			<label>학년</label>
			<select name='grade'>
				<option value='1'>1 학년</option>
				<option value='2'>2 학년</option>
				<option value='3'>3 학년</option>
				<option value='4'>4 학년</option>
				<option value='5'>5 학년</option>
				<option value='6'>6 학년</option>
				<option value='7'>7 학년</option>
				<option value='8'>8 학년</option>
				<option value='9'>9 학년</option>
				<option value='10'>10 학년</option>
			</select><br/>
			<div class='photos'>
				<c:choose>
					<c:when test="${fn:length(vo.photos)==0 }">
						<span class='photo'>
							<img src='./images/anno.png'>
						</span>
					</c:when>
				
					<c:when test="${fn:length(vo.photos)>0 }">
						<c:forEach var='ph' items='${vo.photos }'>
							<span class='photo'>
								<img src='./photo/${ph.sysFile }' width='150px' height='180px'>
							</span>
						</c:forEach>
					</c:when>
				</c:choose>
			</div>
		<br/>
		<input type='button' id='btnModify' value='수정'/>
		<input type='button' id='btnDelete' value='삭제'/>
		<input type='button' id='btnSelect' value='목록으로'/>
		
		<input type='hidden' name='nowPage' value='${p.nowPage }'/>
		<input type='hidden' name='findStr' value='${p.findStr }'/>
		<input type='hidden' name='pwd''/>
	</form>

	<script>
		mm.func()
		mm.setGrade('${vo.grade}')
	
	</script>


</div>