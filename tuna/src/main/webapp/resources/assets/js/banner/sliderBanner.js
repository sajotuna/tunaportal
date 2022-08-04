
// 배너 미리보기
function sliderPreview() {
	
	$('#sliderPreview').on('click', function() {
		
		$('#tb tr').each(function (idx) {
			let uri = $('#tb tr').eq(idx).data('uri');
			$('.img-fluid').eq(idx+1).attr('src', 
									getContextPath() 
									+ `display?fileName=${uri}&folder=banner`);
		})
		
	})	
	
}
	
// 사진 1건 미리보기
function preview() {
	
	$('#tb tr').on('click', function() {
		
		$('#tb tr').removeClass('table-primary');
		$(this).closest('tr').addClass('table-primary')
							 .find('input[type=radio]').prop("checked", true);
		$('#previewImg').attr('src', 
							  getContextPath() 
							  + `display?fileName=${$(this).data('uri')}&folder=banner`);
	})
	
}

// 순서 등록, 삭제 버튼 클릭
function submit(updTitle, updMsg, 
				delTitle, delMsg, 
				errTitle, errMsg,
				subSucTitle, subSucMsg,
				delSucTitle, delSucMsg) {
	
	$('.submit-btn').on('click', function () {
		
		let job = $(this).data('job');
	
		if (job === 'submit') {
			
			Dialogs.dialog('checkConfirm', 
	                       updTitle, 
	                       updMsg,
	                       function() {
								$('#tb tr').each(function(idx) {
									sequenceAjax(this, idx, subSucTitle, subSucMsg);
								})
						  });
						  
		} else if (job === 'delete') {
			
			if($('#tb input:radio:checked').length) {
				
				Dialogs.dialog('warnConfirm', 
		                       delTitle, 
		                       delMsg,
		                       function() {
									deleteAjax(delSucTitle, delSucMsg);
							   });
			} else {
				Dialogs.dialog('error', 
		                       errTitle, 
		                       errMsg)
			}
			
		}
	})
}

// 위로 이동
function trUp() {
	$('#up').on('click', function() {
		let tr = $('#tb input:radio:checked').closest('tr');
		let prevTr = tr.prev();
		tr.insertBefore(prevTr);
	})
}

// 아래로 이동
function trDown() {
	$('#down').on('click', function() {
		let tr = $('#tb input:radio:checked').closest('tr');
		let nextTr = tr.next();
		tr.insertAfter(nextTr);
	})
}


