// 사진 업로드
function uploadAjax() {

	$('#file').on('change', changeEvent => {
		
		let formData = new FormData();
		formData.append('file', $('input[name=file]').prop('files')[0]);
		formData.append('adNo', $('#adNo').val());
		
		$.ajax({
		
			url: getContextPath() + 'admin/sliderBanner',
			method:'POST',
			data: formData,
			contentType: false,
			processData: false,
			beforeSend: function (xhr) {
		       xhr.setRequestHeader(header, token);
			}
		}).done(function(success) {
			pageDialogs.dialog('upload');
		})
			
			
	})
}	

// 순서 등록
function sequenceAjax(elem, idx) {
	
	$.ajax({
		
		url: getContextPath() + 'admin/sliderBanner',
		method:'PUT',
		data: JSON.stringify({sequence:idx+1, no:$(elem).data('no')}),
		contentType : 'application/json; charset=utf-8',
		beforeSend: function (xhr) {
	       xhr.setRequestHeader(header, token);
		}
	})
	
}

function deleteAjax() {
	
	let tr = $('#tb input:radio:checked').closest('tr');

	$.ajax({
		
		url: getContextPath() + 'admin/banner',
		method:'DELETE',
		data: JSON.stringify({uri:tr.data('uri'),no:tr.data('no')}),
		contentType : 'application/json; charset=utf-8',
		beforeSend: function (xhr) {
	       xhr.setRequestHeader(header, token);
		}
	
	}).done(function(success) {
		if(success) {
			pageDialogs.dialog('success');
		}
	})
	
}
