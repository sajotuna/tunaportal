	var header = $("meta[name='_csrf_header']").attr('content');
var token = $("meta[name='_csrf']").attr('content');

$(function() {
	preview();
	sliderPreview();
	uploadAjax();
	submit();
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
			$('#tb tr').each(function(idx) {
				sequenceAjax(this, idx);
			})
			pageDialogs.dialog(job);
			
		} else if (job === 'delete') {
			pageDialogs.dialog(job);
		}
		
	})
	
}

// dialog
class pageDialogs {
	
	static dialog(job, txt) {
		
	    let toast = Swal.mixin({
	      buttonsStyling: false,
	      target: '#page-container',
	      customClass: {
	        confirmButton: 'btn btn-dark m-1',
	        cancelButton: 'btn btn-light m-1',
	        input: 'form-control'
	      }
	    });
	    
	    success();
	    
	    function success() {
	    	
	    	if(job === 'upload') {
	    		
	    		toast.fire({
		
		    			title:'업로드 완료', 
		    			text:'이제 사진 순서를 변경한 후 미리보기에서 등록할 수 있습니다.', 
		    			icon: 'success',
		    			confirmButtonText: '확인'
		    			
	    		}).then(result => {
	    			if (result.value) location.reload();
	    		});
	    		
	    	} else if (job === 'submit') {
	    		
	    		toast.fire({
	    			
		  	          title: '등록 완료',
		  	          text: '메인 페이지로 돌아가 배너를 확인해 보세요.',
		  	          icon: 'success',
		  	          showCancelButton: true,
		  	          customClass: {
		  	            confirmButton: 'btn btn-dark m-1',
		  	            cancelButton: 'btn btn-light m-1'
		  	          },
		  	          confirmButtonText: '메인으로 가기',
		  	          cancelButtonText: '취소',
	  	          
	  	        }).then(result => {
	  	          if (result.value) location.href = '/tuna/admin';
	  	          else if (result.dismiss === 'cancel') location.reload();
	  	        });
	    		
	    	} else if (job === 'delete') {
	    		
	    		toast.fire({
	    			
	  	          title: '정말로 삭제하시겠습니까?',
	  	          text: '이 작업은 취소할 수 없습니다.',
	  	          icon: 'warning',
	  	          showCancelButton: true,
	  	          customClass: {
	  	            confirmButton: 'btn btn-danger m-1',
	  	            cancelButton: 'btn btn-light m-1'
	  	          },
	  	          confirmButtonText: '삭제하기',
	  	          cancelButtonText: '취소',
			  	          
	  	       }).then(result => {
		  	        if (result.value) deleteAjax();
		  	   });
	    	} else if (job === 'success') {
	    		
				toast.fire({
						
						title:'삭제 완료', 
						text:'삭제가 정상적으로 처리되었습니다.', 
						icon: 'success',
						confirmButtonText: '확인'
					  	          
				}).then(result => { 
					location.reload(); 
				});
	    		
	    	}
	  	}
	}
}

// 위로 이동
$('#up').on('click', function() {
	let tr = $('#tb input:radio:checked').closest('tr');
	let prevTr = tr.prev();
	tr.insertBefore(prevTr);
})

// 아래로 이동
$('#down').on('click', function() {
	let tr = $('#tb input:radio:checked').closest('tr');
	let nextTr = tr.next();
	tr.insertAfter(nextTr);
})

function getContextPath() {
	var pathName = window.location.pathname.substring(1);
	var webName = pathName == '' ? '' : pathName.substring(0, pathName.indexOf('/'));
	var path_root = window.location.protocol + '//' + window.location.host + '/' + webName + '/';
	return path_root;
}