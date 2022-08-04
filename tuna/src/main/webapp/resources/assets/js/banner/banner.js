
// 배너 수정, 배너 등록 버튼 클릭
function submit(fileMsg, textMsg, OptMsg,
				cfmTitle, cfmMsg) {
	$('.submit-btn').on('click', function () {
		
		// value check
		let elemAry = [{'element':$('#file'), 'message':fileMsg}, 
						{'element':$('#inputTxt'), 'message':textMsg}, 
						{'element':$('#select'), 'message':OptMsg}, 
						{'element':$('.date'), 'message':OptMsg}];
		
		for (let obj of elemAry) {
			
			let condition = obj.element.length && !obj.element.val();
			if(obj.element.attr('id') === 'select') {
				condition = (obj.element.length && obj.element.val() === 'noSelect');
			}
			
			if(condition) {
				shake(obj.element);
				cautionIn(obj.element, obj.message);
				return;
			} else {
				cautionOut(obj.element);
			}
		}
		
		const job = $(this).data('job');
		bannerInsert(job, cfmTitle, cfmMsg);
		
	}) 
}

// form 입력값 없을 때 경고 텍스트 in
function cautionIn(target, txt) {
	let cautionId = `${target.attr('id')}Check`;
	
	target.addClass('is-invalid');
	$(`#${cautionId}`).remove();
	target.parent().append($('<div>').addClass('invalid-feedback')
								  	 .attr('id', cautionId)
								  	 .text(txt));
}

// form 입력값 없을 때 shake
function shake(target) {
	let shakeObj = `#${target.attr('id')}Shake`;
	$(shakeObj).addClass('js-animation-object animated shake');
}

// form 입력값 있을 때 경고 텍스트 out
function cautionOut(target) {
	let caution = `#${target.attr('id')}Check`;
	
	target.removeClass('is-invalid');
	$(caution).remove();
}

// 배너 미리보기
$('#file').on('change', changeEvent => {
	const reader = new FileReader();
	$(reader).on('load', readerEvent => {
		$('#shortcutImg').attr('src', readerEvent.target.result); 
		$('#shortcutBtn').css('display', 'inline-block');
	})
	
	const img = changeEvent.target.files[0];
	reader.readAsDataURL(img);
})


function insertSuccess() {
	Dialogs.dialog('success', '등록 완료', '등록이 완료되었습니다.')
}

function error() {
	Dialogs.dialog('error', '작업 실패', '작업이 정상적으로 처리되지 않았습니다.')
}