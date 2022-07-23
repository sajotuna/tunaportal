var header = $("meta[name='_csrf_header']").attr('content');
var token = $("meta[name='_csrf']").attr('content');
var userNo = $("meta[name='userNo']").attr('content');

// 사진 업로드
function uploadAjax() {

	$('#file').on('change', changeEvent => {
		
		let formData = new FormData();
		formData.append('file', $('input[name=file]').prop('files')[0]);
		formData.append('adNo', userNo);
		
		$.ajax({
		
			url: getContextPath() + 'admin/admin/banner/1301',
			method:'POST',
			data: formData,
			contentType: false,
			processData: false,
			beforeSend: function (xhr) {
		       xhr.setRequestHeader(header, token);
			}
			
		}).done(function(success) {
			console.log(success);
			if (success) {
				Dialogs.dialog('success', 
		                       '등록 완료', 
		                       '이제 사진 순서를 변경한 후 미리보기에서 등록할 수 있습니다',
							   function() {
								   location.reload();
							   });
			}
		}).fail(function() {
			error();
		})
	})
}	

// 순서 등록
function sequenceAjax(elem, idx) {
	
	$.ajax({
		
		url: getContextPath() + 'admin/admin/banner',
		method:'PUT',
		data: JSON.stringify({sequence:idx+1, no:$(elem).data('no')}),
		contentType : 'application/json; charset=utf-8',
		beforeSend: function (xhr) {
	       xhr.setRequestHeader(header, token);
		}
	}).done(function(success) {
		if(success) {
			Dialogs.dialog('success', 
		                   '순서 등록 완료', 
		                   '슬라이드 배너 순서 변경이 완료되었습니다.');
		}
	}).fail(function(){
		 error();
	})
	
}

function deleteAjax() {
	
	let tr = $('#tb input:radio:checked').closest('tr');

	$.ajax({
		
		url: getContextPath() + 'admin/admin/banner',
		method:'DELETE',
		data: JSON.stringify({uri:tr.data('uri'),no:tr.data('no')}),
		contentType : 'application/json; charset=utf-8',
		beforeSend: function (xhr) {
	       xhr.setRequestHeader(header, token);
		}
	
	}).done(function(success) {
		if(success) {
			Dialogs.dialog('success', 
		                   '삭제 완료', 
		                   '사진 삭제가 완료되었습니다.',
		                   function() {
								location.reload();
						   });
		}
	}).fail(function() {
		error();
	})
	
}

function getContextPath() {
	var pathName = window.location.pathname.substring(1);
	var webName = pathName == '' ? '' : pathName.substring(0, pathName.indexOf('/'));
	var path_root = window.location.protocol + '//' + window.location.host + '/' + webName + '/';
	return path_root;
}
