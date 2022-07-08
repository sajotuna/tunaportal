<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<label for="captcha" style="display: block">자동 로그인 방지</label>
	<div style="overflow: hidden">
		<div style="float: left">
			<img title="캡차이미지" src="${pageContext.request.contextPath }/captchaImg.do" alt="캡차이미지" />
			<div id="ccaudio" style="display: none"></div>
		</div>
	</div>
	<div style="padding: 3px">
		<input id="reload" type="button" onclick="javaScript:getImage()"
			value="새로고침" /> <input id="soundOn" type="button"
			onclick="javaScript:audio()" value="음성듣기" />
	</div>
	<div style="padding: 3px">
		<input id="answer" type="text" value=""> <input id="check"
			type="button" value="확인" />
	</div>

	<script type="text/javascript">
		window.onload = function() {
			getImage(); // 이미지 가져오기

			document.querySelector('#check').addEventListener(
					'click',
					function() {
						var params = {
							answer : document.querySelector('#answer').value
						};
						AF.ajax('chkAnswer.do', params, function(
								returnData) {
							if (returnData == 200) {
								alert('입력값이 일치합니다.');
								// 성공 코드
							} else {
								alert('입력값이 일치하지 않습니다.');
								getImage();
								document.querySelector('#answer').setAttribute(
										'value', '');
							}
						}, 'json');
					});
		}
		/*매번 랜덤값을 파라미터로 전달하는 이유 : IE의 경우 매번 다른 임의 값을 전달하지 않으면 '새로고침' 클릭해도 정상 호출되지 않아 이미지가 변경되지 않는 문제가 발생된다*/
		function audio() {
			var rand = Math.random();
			var uAgent = navigator.userAgent;
			var soundUrl = 'captchaAudio.do?rand=' + rand;
			if (uAgent.indexOf('Trident') > -1 || uAgent.indexOf('MISE') > -1) { /*IE 경우 */
				audioPlayer(soundUrl);
			} else if (!!document.createElement('audio').canPlayType) { /*Chrome 경우 */
				try {
					new Audio(soundUrl).play();
				} catch (e) {
					audioPlayer(soundUrl);
				}
			} else {
				window.open(soundUrl, '', 'width=1,height=1');
			}
		}
		function getImage() {
			var rand = Math.random();
			var url = 'captchaImg.do?rand=' + rand;
			document.querySelector('img').setAttribute('src', url);
		}
		function audioPlayer(objUrl) {
			document.querySelector('#ccaudio').innerHTML = '<bgsoun src="' +objUrl +'">';
		}
	</script>

</body>
</html>