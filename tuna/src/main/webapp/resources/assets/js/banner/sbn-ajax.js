var header = $("meta[name='_csrf_header']").attr('content');
var token = $("meta[name='_csrf']").attr('content');
var userNo = $("meta[name='userNo']").attr('content');

// 사진 업로드
function uploadAjax(sucTitle, sucMsg) {

	$('#file').on('change', () => {
		
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
		                       sucTitle, 
		                       sucMsg,
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
function sequenceAjax(elem, idx, subSucTitle, subSucMsg) {
	
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
		                   subSucTitle, 
		                   subSucMsg);
		}
	}).fail(function(){
		 error();
	})
	
}

function deleteAjax(delSucTitle, delSucMsg) {
	
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
		                   delSucTitle, 
		                   delSucMsg,
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
