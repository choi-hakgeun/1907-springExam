let brd = {}

brd.func = function(){
	$('#btnFind').click(function(){
		frm_brd.enctype='';
		frm_brd.nowPage.value = 1;
		let param = $('#frm_brd').serialize();
		$.post("select.brd", param, function(data, state){
			$('#main').html(data)
		});
		
	})
	
	$('#btnSelect').click(function(){
		frm_brd.enctype='';
		let param = $('#frm_brd').serialize();
		$.post("select.brd", param, function(data, state){
			$('#main').html(data)
		});
	})
	
	
	$('#btnInsert').click(function(){
		let param = $('#frm_brd').serialize();
		$.post("insert.brd", param, function(data, state){
			$('#main').html(data)
		});
	})

	$('#btnRegister').click(function(){
		let fd =  new FormData($('#frm_brd')[0]);
		
		$.ajax({
			url : 'insertR.brd',
			type : 'post',
			data : fd,
			contentType : false,
			processData : false,
			error : function(xhr, status, error){
				console.log(error);
			},
			success : function(data, xhr, status ){
				$('#main').html(data);
			}
				
		})
			
	})

	$('#btnModify').click(function(){// 수정 폼
		let param = $('#frm_brd').serialize();
		$.post("modify.brd", param, function(data, state){
			$('#main').html(data)
		});
	})

	$('#btnUpdate').click(function(){//수정내용 저장
		let pwd = prompt("삭제하려면 암호 입력!");
		if(pwd==null || pwd=='') return;
		frm_brd.pwd.value = pwd;
		let fd =  new FormData($('#frm_brd')[0]);
		$.ajax({
			url : 'modifyR.brd',
			type : 'post',
			data : fd,
			contentType : false,
			processData : false,
			error : function(xhr, status, error){
				console.log(error);
			},
			success : function(data, xhr, status ){
				$('#main').html(data);
			}
		})
	})

	$('#btnDelete').click(function(){
		let pwd = prompt("삭제하려면 암호 입력!");
		if(pwd==null || pwd=='') return;
		
		frm_brd.pwd.value = pwd;
		let param = $('#frm_brd').serialize();
		$.post("deleteR.brd", param, function(data, state){
			$('#main').html(data)
		});
	})

	$('#btnRepl').click(function(){ //답변 폼
		let param = $('#frm_brd').serialize();
		$.post("repl.brd", param, function(data, state){
			$('#main').html(data)
		});
	})
	$('#btnReplR').click(function(){ // 답변 저장
		let fd =  new FormData($('#frm_brd')[0]);
		$.ajax({
			url : 'replR.brd',
			type : 'post',
			data : fd,
			contentType : false,
			processData : false,
			error : function(xhr, status, error){
				console.log(error);
			},
			success : function(data, xhr, status ){
				$('#main').html(data);
			}
		})
	})
	
	$('#btnAtt').change(function(){ // 첨부 파일 목록
		let str = '<ol>';
		//let files = frm_brd.attFile.files;/* js type */
		let files = $('#btnAtt')[0].files;
		for(f of files){
			str += "<li>" + f.name + " [ " + parseInt(f.size/1000) + " Kb ]";
		}
		str += '</ol>';
		$('#attList').html(str);
	})	
	
	
	
}

brd.init = function(){
	$('#main').load('select.brd');
}

brd.view = function(serial){
	frm_brd.serial.value = serial;
	let param = $('#frm_brd').serialize();

	$.post("view.brd", param, function(data, state){
		$('#main').html(data)
	});
}

brd.go = function(nowPage){
	frm_brd.nowPage.value = nowPage;
	let param = $('#frm_brd').serialize();
	console.log(param)
	$.post("select.brd", param, function(data, state){
		$('#main').html(data)
	});
}

brd.delCheck = function(ev){ // ev -> ckeckbox
	let tag = ev.parentElement.childNodes[1];
	if(ev.checked){
		tag.style.textDecoration = 'line-through';
		tag.style.color='#f00';
	}else{
		tag.style.textDecoration = 'none';
		tag.style.color='';
		
	}
}






