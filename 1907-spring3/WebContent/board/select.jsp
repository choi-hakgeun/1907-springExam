<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id='board'>
	<div id='header'>게시물 검색</div>
	<form name='frm_brd' id='frm_brd' method='post' class='frm_brd'>
		<input type='hidden' name='nowPage' value='${p.nowPage }'/>
		<input type='hidden' name='serial' value='${param.serial }'/>
		<input type='button' value='입력' id='btnInsert' />
		<input type='text' name='findStr' value='${p.findStr }'/>
		<input type='button' value='검색' id='btnFind'/>
	</form>
	<!-- title -->
	<div class='title'>
		<span class='no'>NO</span>
		<span class='subject'>제목</span>
		<span class='id'>작성자</span>
		<span class='mDate'>작성일</span>
		<span class='hit'>조회수</span>
	</div>
	<!-- list  -->
	<div class='list'>
		<c:forEach var='i' items='${list }'>
			<div class='items' onclick='brd.view(${i.serial})'>
				<span class='no'>${i.serial }</span>
				<span class='subject'>${i.subject} ${(i.attCnt>0)? [ i.attCnt ] : '' }</span>
				<span class='id'>${i.id }</span>
				<span class='mDate'>${i.mDate }</span>
				<span class='hit'>${i.hit }</span>
			</div>		
		</c:forEach>
	</div>
		
	
	<div id='paging'>
		<c:if test="${p.startPage>p.blockSize}">
				<input type='button' value=' 이전 ' 
							onclick = 'brd.go(${p.startPage-1})' />
		</c:if>	
		
		<c:forEach var='i' begin='${p.startPage }' end='${p.endPage }'>
			<input type='button' value=' ${i } ' 
			       class="${(i==p.nowPage)? 'here' : '' }" 
						 onclick='brd.go(${i})' />
		</c:forEach>
		<c:if test="${p.endPage<p.totPage }">
				<input type='button' value=' 다음 ' 
							onclick='brd.go(${p.endPage+1})' />
		</c:if>
		
	</div>	
	
	<script>brd.func()</script>
	
</div>