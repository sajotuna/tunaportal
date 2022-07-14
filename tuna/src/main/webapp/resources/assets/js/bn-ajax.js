var header = $("meta[name='_csrf_header']").attr('content');
var token = $("meta[name='_csrf']").attr('content');

// 배너 미리보기
function banner(job) {
	$.ajax({
		
		url: getContextPath() + `admin/${job}`,
		type: 'GET',
		dataType: 'json'
		
		}).done(function(basicBn) {
			$('#shortcutImg').attr('src', getContextPath() + `display?fileName=${basicBn.uri}&folder=banner`)
			$('#shortcutBtn').css('display', 'inline-block');
			$('#imgDownload').attr('href', getContextPath() + `download?fileName=${basicBn.uri}&originName=${basicBn.fileName}&folder=banner`)
		})
}

// 배너 삭제
function basicBannerDelete() {
	$('.bnDelete').on('click', function() {
		let uri = $(this).data('uri');
		let no = $(this).data('no');
		
		let result = confirm('정말로 삭제하시겠습니까?');
		if(result) {
		
		$.ajax({
			
				url: getContextPath() + 'admin/banner',
				method:'DELETE',
				data: JSON.stringify({uri,no}),
				contentType : 'application/json; charset=utf-8',
				beforeSend: function (xhr) {
			       xhr.setRequestHeader(header, token);
				}
		
				}).done(function(success) {
					if(success) {
						alert('삭제 완료');
						location.reload();
					}
				})
		}
	
	})
}

// 기본 배너 등록
function basicBannerInsert() {
	let formData = new FormData();
	
	formData.append("file", $('input[name=file]').get(0).files[0]);
	formData.append("adNo", $('input[name=adNo]').val());
	formData.append("url", $('input[name=url]').val());			
	
	$.ajax({
		
		url: getContextPath() + 'admin/basicBanner',
		method:'POST',
		data: formData,
		contentType: false,
		processData: false,
		beforeSend: function (xhr) {
	       xhr.setRequestHeader(header, token);
		}

		}).done(function(success) {
			if(success) {
				pageDialogs.dialog();
			}
	})
}

// 옵션 배너 등록
function optionBannerInsert() {
	let formData = new FormData();
	
	formData.append("file", $('input[name=file]').get(0).files[0]);
	formData.append("adNo", $('input[name=adNo]').val());
	formData.append("url", $('select[name=url]').val());
	formData.append("startDate", moment($('input[name=startDate]').val()).format('YYYY-MM-DD'));
	formData.append("endDate", moment($('input[name=endDate]').val()).format('YYYY-MM-DD'));
	
	$.ajax({
		
			url: getContextPath() + 'admin/optionBanner',
			method:'POST',
			data: formData,
			contentType: false,
			processData: false,
			beforeSend: function (xhr) {
		       xhr.setRequestHeader(header, token);
			}
	
			}).done(function(success) {
				if(success) {
					pageDialogs.dialog();
				}
			})
}

function getContextPath() {
	var pathName = window.location.pathname.substring(1);
	var webName = pathName == '' ? '' : pathName.substring(0, pathName.indexOf('/'));
	var path_root = window.location.protocol + '//' + window.location.host + '/' + webName + '/';
	return path_root;
}