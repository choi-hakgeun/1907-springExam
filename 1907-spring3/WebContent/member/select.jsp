<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div id='member'>
	<div id='header'>회원 정보 조회 </div>

	<form name='frm_mm' id='frm_mm' method='post' class='frm_mm'>
		<input type='hidden' name='nowPage' value='${p.nowPage }'/>
		<input type='hidden' name='mId'/>
		<input type='button' value='입력' id='btnInsert' />
		<input type='text' name='findStr' value='${p.findStr }'/>
		<input type='button' value='검색' id='btnFind'/>
	</form>
	<!-- list  -->
	<div class='list'>
		<c:forEach var='i' items='${list }'>
			<div class='items' onclick="mm.view('${i.mId}')">
				<span class='mId'>아이디 : <br/>${i.mId}</span>
				<span class='mName'>성명 : <br/>${i.mName }</span>
				<span class='rDate'>등록일 : <br/> ${i.rDate }</span>
				<span class='grade'>학년 : <br/>${i.grade }</span>
				
				<c:choose>
					<c:when test="${fn:length(i.photos)==0 }">
						<span class='photo'>
							<img src='./images/anno.png'>
						</span>
					</c:when>
				
					<c:when test="${fn:length(i.photos)>0 }">
						<c:forEach var='ph' items='${i.photos }'>
							<span class='photo'>
								<img src='./photo/${ph.sysFile }' width='150px' height='180px'>
							</span>
						</c:forEach>
					</c:when>
				</c:choose>
				
				
			</div>		
		</c:forEach>
	</div>
		
	
	<div id='paging'>
		<c:if test="${p.startPage>p.blockSize }">
			<input type='button' value=' 이전 ' onclick = 'mm.go(${p.startPage-1})' />
		</c:if>
		
		<c:forEach var='i' begin='${p.startPage }' end='${p.endPage }'>
			<input type='button' value=' ${i } ' class="${(i==param.nowPage)? 'here' : '' }" 
						onclick='mm.go(${i})' />
		</c:forEach>
		<c:if test="${p.endPage < p.totPage }">
			<input type='button' value=' 다음 ' onclick='mm.go(${p.endPage+1})' />
		</c:if>
		
	</div>	
	
	<script>mm.func()</script>


</div>