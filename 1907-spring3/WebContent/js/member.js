/**
 * http://usejsdoc.org/
 */
let mm = {}

mm.func = function(){
	$('#btnFind').click(function(){
		frm_mm.nowPage.value = 1;
		let param = $('#frm_mm').serialize();
		$.post("select.mm", param, function(data, state){
			$('#main').html(data)
		});
	})
	
	$('#btnSelect').click(function(){
		let param = $('#frm_mm').serialize();
		$.post("select.mm", param, function(data, state){
			$('#main').html(data)
		});
	})
	
	
	$('#btnInsert').click(function(){
		let param = $('#frm_mm').serialize();
		$.post("insert.mm", param, function(data, state){
			$('#main').html(data);
			frm_mm.rDate.valueAsDate = new Date();
			
		});
	})

	$('#btnRegister').click(function(){
		let flag = mm.checkForm(document.frm_mm);
		if(flag) return;
		
		let fd = new FormData($('#frm_mm')[0]);
		$.ajax({
			url  : 'insertR.mm',
			type : 'post',
			data : fd,
			contentType : false,
			processData : false,
			success : function(data, xhr, status){
				$('#main').html(data);
				
			}
		
		})
		
	})

	$('#btnModify').click(function(){// 수정 폼
		let param = $('#frm_mm').serialize();
		$.post("modify.mm", param, function(data, state){
			$('#main').html(data)
		});
	})

	$('#btnUpdate').click(function(){//수정내용 저장
		let pwd = prompt("수정하려면 암호를", "1");
		if(pwd == null || pwd== '') return;
		
		frm_mm.pwd.value = pwd;
		
		let flag = mm.checkForm(document.frm_mm);
		if(flag) return;
		
		if(frm_mm.photo.files.length== 0){
			frm_mm.delFile.value = '';
		}
		
		let fd = new FormData($('#frm_mm')[0]);
		$.ajax({
			url  : 'modifyR.mm',
			type : 'post',
			data : fd,
			contentType : false,
			processData : false,
			success : function(data, xhr, status){
				$('#main').html(data);
				
			}
		
		})
	})

	$('#btnDelete').click(function(){
		let pwd = prompt("삭제 하려면 암호를", "1");
		if(pwd == null || pwd== '') return;
		
		frm_mm.pwd.value = pwd;
		let param = $('#frm_mm').serialize();
		$.post("deleteR.mm", param, function(data, state){
			$('#main').html(data)
		});
	})
	

	// 이미지 미리보기
	$('#btnPhoto').change(function(){
		let btn = this;
		let file = btn.files[0];
		let reader = new FileReader();
		reader.readAsDataURL(file);
		
		reader.onload = function(e){
			let img = new Image();
			img.src = e.target.result;
			$('#myPhoto').attr('src', img.src);
		}
		
	})
	
	// 로그인 | 로그아웃
	$('#btnLogin').click(function(){
		let param = $('#frm_login').serialize();
		$.post("../login.mm", param, function(data, state){
			alert(data);
			location.href='../index.jsp';
		});
	})	

	$('#btnLogout').click(function(){
		$.post("logout.mm", null, function(data, state){
			alert(data);
			location.href='index.jsp';
		});
		
	})
	
}

mm.init = function(){
	$('#main').load('select.mm');
}

mm.view = function(mId){
	frm_mm.mId.value = mId;
	let param = $('#frm_mm').serialize();
	$.post("view.mm", param, function(data, state){
		$('#main').html(data)
	});
}

mm.go = function(nowPage){
	frm_mm.nowPage.value = nowPage;
	let param = $('#frm_mm').serialize();
	$.post("select.mm", param, function(data, state){
		$('#main').html(data)
	});
}

mm.setGrade = function(grade){
	frm_mm.grade.selectedIndex = grade-1;
}

//form 입력항목 체크
mm.checkForm = function(fd){
	let flag = false;
	
	if(fd.mId.value == ''){
		alert("아이디 필수");
		fd.mId.focus();
		flag=true;
	}else if(fd.pwd.value == ''){
		alert("암호 필수");
		fd.pwd.focus();
		flag=true;
	}else if(fd.mName.value == ''){
		alert('이름 필수');
		fd.mName.focus();
		flag=true;
	}
	
	return flag;
}

