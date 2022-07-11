$(function() {
	submit();
})

function submit() {
	$('.submit-btn').on('click', function () {
		
		/*// value check
		let elemAry = [{'element':$('#file'), 'message':'사진 파일을 업로드해 주세요.'}, 
						{'element':$('#inputTxt'), 'message':'빈 칸을 입력해 주세요.'}, 
						{'element':$('#select'), 'message':'옵션을 선택해 주세요.'}, 
						{'element':$('.date'), 'message':'일자를 모두 선택해 주세요.'}];
		
		for (let obj of elemAry) {
			if(obj.element.attr('id') === 'select') {
				if (obj.element.length && obj.element.val() === 'noSelect') {
					shake(obj.element);
					cautionIn(obj.element, obj.message);
					return;
				} else {
					cautionOut(obj.element);
				}
			} else if (obj.element.attr('id') === 'date') {
				if (obj.element.length && (!obj.element.eq(0).val() || !obj.element.eq(1).val())) {
					shake(obj.element);
					cautionIn(obj.element, obj.message);
					return;
				} else {
					cautionOut(obj.element);
				}
			} else {
				if(obj.element.length && !obj.element.val()) {
					shake(obj.element);
					cautionIn(obj.element, obj.message);
					return;
				} else {
					cautionOut(obj.element);
				}
			}
		}*/
		
		// value check
		if($('#file').length && !$('#file').val()) {
			shake($('#file'));
			cautionIn($('#file'), '사진 파일을 업로드해 주세요.');
			return;
		} else {
			cautionOut($('#file'));
		}
		
		if($('#inputTxt').length && !$('#inputTxt').val()) {
			shake($('#inputTxt'));
			cautionIn($('#inputTxt'), '빈 칸을 입력해 주세요.');
			return;
		} else {
			cautionOut($('#inputTxt'));
		}
		
		if ($('#select').length && $('#select').val() === 'noSelect') {
			shake($('#select'));
			cautionIn($('#select'), '옵션을 선택해 주세요.');
			return;
		} else {
			cautionOut($('#select'));
		}
		
		if ($('.date').length && (!$('.date').eq(0).val() || !$('.date').eq(1).val())) {
			shake($('.date'));
			cautionIn($('.date'), '일자를 모두 선택해 주세요.');
			return;
		} else {
			cautionOut($('.date'));
		}
		
		const job = $(this).data('job');
		// ajax
		if (job === 'insert') {
			console.log('insert');
		} else if (job === 'modify') {
			console.log('modify');
		}
		
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
	let shakeObjId = `#${target.attr('id')}Shake`;
	$(shakeObjId).addClass('js-animation-object animated shake');
}

// form 입력값 있을 때 경고 텍스트 out
function cautionOut(target) {
	let cautionId = `#${target.attr('id')}Check`;
	
	target.removeClass('is-invalid');
	$(cautionId).remove();
}

// 배너 미리보기
$('#file').on('change', changeEvent => {
	const reader = new FileReader();
	$(reader).on('load', readerEvent => {
		$('#bnImg').attr("src", readerEvent.target.result); 
	})
	
	const img = changeEvent.target.files[0];
	reader.readAsDataURL(img);
})

