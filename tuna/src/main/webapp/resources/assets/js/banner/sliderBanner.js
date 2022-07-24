$(function() {
	preview();
	sliderPreview();
	uploadAjax();
	submit();
	trUp();
	trDown();
})

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
function submit() {
	
	$('.submit-btn').on('click', function () {
		
		let job = $(this).data('job');
	
		if (job === 'submit') {
			
			Dialogs.dialog('checkConfirm', 
	                       '순서를 변경하시겠습니까?', 
	                       '설정한 순서대로 배너의 순서를 변경합니다.',
	                       function() {
								$('#tb tr').each(function(idx) {
									sequenceAjax(this, idx);
								})
						  });
						  
		} else if (job === 'delete') {
			
			Dialogs.dialog('warnConfirm', 
	                       '정말로 삭제하시겠습니까?', 
	                       '삭제한 사진은 복구할 수 없습니다.',
	                       function() {
								deleteAjax();
						   });
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

function error() {
	Dialogs.dialog('error', '작업 실패', '작업이 정상적으로 처리되지 않았습니다.')
}

