var header = $("meta[name='_csrf_header']").attr('content');
var token = $("meta[name='_csrf']").attr('content');
var userNo = $("meta[name='userNo']").attr('content');

// 배너 미리보기
function banner(bannerCode) {
	$.ajax({
		
		url: getContextPath() + `admin/banner/${bannerCode}`,
		type: 'GET',
		dataType: 'json'
		
	}).done(function(basicBn) {
		
		$('#shortcutImg').attr('src', getContextPath() + `display?fileName=${basicBn.uri}&folder=banner`)
		$('#shortcutBtn').css('display', 'inline-block');
		$('#imgDownload').attr('href', getContextPath() + `download?fileName=${basicBn.uri}&originName=${basicBn.fileName}&folder=banner`)
	
	})
}

// 배너 삭제
function bannerDelete(delTitle, delMsg, sucTitle, sucmsg) {
	$('.bnDelete').on('click', function() {
		let uri = $(this).data('uri');
		let no = $(this).data('no');
		
		Dialogs.dialog('warnConfirm', 
	                    delTitle, 
	                    delMsg, 
	                    function() {
		
							$.ajax({
				
								url: getContextPath() + 'admin/admin/banner',
								method:'DELETE',
								data: JSON.stringify({uri,no}),
								contentType : 'application/json; charset=utf-8',
								beforeSend: function (xhr) {
							       xhr.setRequestHeader(header, token);
								}
						
								}).done(function(success) {
									
									if (success) {
										Dialogs.dialog('success', 
									                   sucTitle, 
									                   sucmsg,
									                   function() {
															location.reload();
												       });
									} else {
										error();
									}
									
								}).fail(function() {
									error();
								})
						});
	})
}

// 옵션 배너 등록
function bannerInsert(bannerCode, cfmTitle, cfmMsg) {
	let formData = new FormData();
	
	formData.append("file", $('input[name=file]').get(0).files[0]);
	formData.append("adNo", userNo);
	
	if(bannerCode == '1302') {
		formData.append("url", $('input[name=url]').val());		
	} else if (bannerCode == '1303') {
		formData.append("url", $('select[name=url]').val());
		formData.append("startDate", moment($('input[name=startDate]').val()).format('YYYY-MM-DD'));
		formData.append("endDate", moment($('input[name=endDate]').val()).format('YYYY-MM-DD'));
	}
	
	Dialogs.dialog('checkConfirm', 
                    cfmTitle, 
                    cfmMsg,
                    function() {
	
						$.ajax({
	
							url: getContextPath() + `admin/admin/banner/${bannerCode}`,
							method:'POST',
							data: formData,
							contentType: false,
							processData: false,
							beforeSend: function (xhr) {
						       xhr.setRequestHeader(header, token);
							}
					
						}).done(function(success) {
							
							if(success) {
								insertSuccess();
								$('input[name=file]').get(0).val('');
								$('input[name=url]').val('');
							} else {
								error();
							}
							
						}).fail(function() {
							error();
						})
					}
	            )
}

function getContextPath() {
	var pathName = window.location.pathname.substring(1);
	var webName = pathName == '' ? '' : pathName.substring(0, pathName.indexOf('/'));
	var path_root = window.location.protocol + '//' + window.location.host + '/' + webName + '/';
	return path_root;
}