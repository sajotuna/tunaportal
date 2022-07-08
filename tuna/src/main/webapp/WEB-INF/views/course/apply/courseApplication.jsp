<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width,initial-scale=1.0">

  <title>수강신청</title>
  <meta name="_csrf" content="${_csrf.token}">
  <meta name="_csrf_header" content="${_csrf.headerName}">
  <meta name="description"
    content="OneUI - Bootstrap 5 Admin Template &amp; UI Framework created by pixelcave and published on Themeforest">
  <meta name="author" content="pixelcave">
  <meta name="robots" content="noindex, nofollow">

  <!-- Open Graph Meta -->
  <meta property="og:title" content="OneUI - Bootstrap 5 Admin Template &amp; UI Framework">
  <meta property="og:site_name" content="OneUI">
  <meta property="og:description"
    content="OneUI - Bootstrap 5 Admin Template &amp; UI Framework created by pixelcave and published on Themeforest">
  <meta property="og:type" content="website">
  <meta property="og:url" content="">
  <meta property="og:image" content="">
  

  <!-- Icons -->
  <!-- The following icons can be replaced with your own, they are used by desktop and mobile browsers -->
  <link rel="shortcut icon" href="assets/media/favicons/favicon.png">
  <link rel="icon" type="image/png" sizes="192x192" href="assets/media/favicons/favicon-192x192.png">
  <link rel="apple-touch-icon" sizes="180x180" href="assets/media/favicons/apple-touch-icon-180x180.png">
  <!-- END Icons -->

  <!-- Stylesheets -->
  <!-- Fonts and OneUI framework -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700&display=swap">
  <link rel="stylesheet" id="css-main" href="assets/css/oneui.min.css">

  <!-- You can include a specific file from css/themes/ folder to alter the default color theme of the template. eg: -->
  <!-- <link rel="stylesheet" id="css-theme" href="assets/css/themes/amethyst.min.css"> -->
  <!-- END Stylesheets -->
  <style>
    h5 {
      margin-top: 50px;
      margin-left: 20px;
    }

    .fomrtag {
      margin-left: 50px;
    }
  </style>

</head>

<body>

  <div id="section">
    <div id="page-container">
      <div class="content content-boxed">
        <h3 class="h3 fw-bold mb-2">수강신청</h3>
        <div class="bg-body-extra-light" style="padding: 10px;">
          <div class="m-4">
            <form action="" method="post" class="row">
              <div class="col-md-3 col-xl-2 col-10 fomrtag">
                <div class="mb-5">
                  <select class="form-select" id="example-select" name="example-select">
                    <option selected>학부(과)</option>
                    <option value="1">참치과</option>
                    <option value="1">사조과</option>
                    <option value="1">컴퓨터공학과</option>
                    <option value="1">정보통신학과</option>
                  </select>
                </div>
              </div>
              <div class="col-md-3 col-xl-2 col-10 fomrtag">
                <div class="mb-2">
                  <select class="form-select" id="example-select" name="example-select">
                    <option selected>이수구분</option>
                    <option value="">전공필수</option>
                    <option value="">전공선택</option>
                    <option value="">교양필수</option>
                    <option value="">교양선택</option>
                  </select>
                </div>
              </div>
              <div class="col-md-3 col-xl-2 col-10 fomrtag">
                <div class="mb-2">
                  <select class="form-select" id="example-select" name="example-select">
                    <option selected>학년</option>
                    <option value="1">1학년</option>
                    <option value="2">2학년</option>
                    <option value="3">3학년</option>
                    <option value="4">4학년</option>
                  </select>
                </div>
              </div>
              <div class="col-md-3 col-xl-2 col-10 fomrtag">
                <div class="mb-2">
                  <input type="number" placeholder="직접입력...." class="form-control"
                    id="example-flatpickr-time-standalone-24" name="example-flatpickr-time-standalone-24">
                </div>
              </div>
              <div class="col-md-2 col-xl-1 fomrtag">
                <div class="mb-2 ">
                  <button type="button" class="btn btn-secondary col-sm-10 col-10">조회</button>
                </div>
              </div>

            </form>
            
            <div class="mb-5 ">
              <div class="block block-rounded block-themed">
                <div class="block-header bg-primary-darker">
                  <h1 class="block-title">[개설과목]</h1>
                </div>

                <table class="table table-striped table-vcenter">

                  <thead>
                    <tr>
                      <th class="d-none d-sm-table-cell" style="width: 100px;">이수구분</th>
                      <th class="d-none d-sm-table-cell" style="width: 100px;">과목코드</th>
                      <th class="d-none d-sm-table-cell" style="width: 100px;">과목명</th>
                      <th class="d-none d-sm-table-cell" style="width: 100px;">교수명</th>
                      <th class="d-none d-sm-table-cell" style="width: 110px;">강의실</th>
                      <th class="d-none d-sm-table-cell" style="width: 120px;">강의시간</th>
                      <th class="d-none d-sm-table-cell" style="width: 50px;">학점</th>
                      <th class="d-none d-sm-table-cell" style="width: 50px;">인원수</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr scope="row">
                      <th class="fw-semibold fs-sm">전공/필수</th>
                      <td class="fw-semibold fs-sm">014-124357</td>
                      <td class="fw-semibold fs-sm">컴퓨터 그래픽스</td>
                      <td class="fw-semibold fs-sm"><a href="#">최규완</a></td>
                      <td class="fw-semibold fs-sm">참치관 103호</td>
                      <td class="fw-semibold fs-sm">13:00~14:00 월/수</td>
                      <td class="fw-semibold fs-sm">3</td>
                      <td class="fw-semibold fs-sm">12/45</td>
                    </tr>
                  </tbody>
                </table>
                <ul class="pagination justify-content-center">
                  <li class="page-item">
                    <a class="page-link" href="javascript:void(0)" tabindex="-1" aria-label="Previous">
                      <span aria-hidden="true">
                        <i class="fa fa-angle-double-left"></i>
                      </span>
                      <span class="visually-hidden">Previous</span>
                    </a>
                  </li>
                  <li class="page-item active">
                    <a class="page-link" href="javascript:void(0)">1</a>
                  </li>
                  <li class="page-item">
                    <a class="page-link" href="javascript:void(0)">2</a>
                  </li>
                  <li class="page-item">
                    <a class="page-link" href="javascript:void(0)">3</a>
                  </li>
                  <li class="page-item">
                    <a class="page-link" href="javascript:void(0)">4</a>
                  </li>
                  <li class="page-item">
                    <a class="page-link" href="javascript:void(0)" aria-label="Next">
                      <span aria-hidden="true">
                        <i class="fa fa-angle-double-right"></i>
                      </span>
                      <span class="visually-hidden">Next</span>
                    </a>
                  </li>
                </ul>
              </div>
            </div>
            <div class="mb-5">
              <div class="block block-rounded block-themed">
                <div class="block-header bg-primary-darker">
                  <h1 class="block-title">[수강꾸러미 목록]</h1>
                </div>
                <table class="table table-bordered">
                  <thead>
                    <tr>
                      <th class="d-none d-sm-table-cell" style="width: 100px;">이수구분</th>
                      <th class="d-none d-sm-table-cell" style="width: 100px;">과목코드</th>
                      <th class="d-none d-sm-table-cell" style="width: 100px;">과목명</th>
                      <th class="d-none d-sm-table-cell" style="width: 100px;">교수명</th>
                      <th class="d-none d-sm-table-cell" style="width: 110px;">강의실</th>
                      <th class="d-none d-sm-table-cell" style="width: 120px;">강의시간</th>
                      <th class="d-none d-sm-table-cell" style="width: 50px;">학점</th>
                      <th class="d-none d-sm-table-cell" style="width: 50px;">인원수</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr scope="row">
                      <th class="fw-semibold fs-sm">전공/필수</th>
                      <td class="fw-semibold fs-sm">014-124357</td>
                      <td class="fw-semibold fs-sm">컴퓨터 그래픽스</td>
                      <td class="fw-semibold fs-sm"><a href="javascript:showPopup();">최규완</a></td>
                      <td class="fw-semibold fs-sm">참치관 103호</td>
                      <td class="fw-semibold fs-sm">13:00~14:00 월/수</td>
                      <td class="fw-semibold fs-sm">3</td>
                      <td class="fw-semibold fs-sm">12/45</td>
                    </tr>
                  </tbody>
                </table>
              </div>
            </div>
            <div class="mb-5 ">
              <div class="block-contents">
              <form action="" method="post">
                <div class="row">
                  <div class="col-md-2 col-xl-1 mt-4">
                    <label class="form-label" for="example-flatpickr-time-standalone-24">과목코드</label>
                  </div>
                  <div class="col-md-3 col-xl-2 mt-4">
                    <input type="text" class="form-control" id="example-flatpickr-time-standalone-24"
                      name="example-flatpickr-time-standalone-24">
                  </div>
                  <div class="col-md-2 col-xl-1 mt-4">
                    <button type="button" class="btn btn-info col-12">신청</button>
                  </div>

                  <div class ="col-md-3 col-xl-3">
                    <span style="display: block; text-align : center;">자동 로그인 방지</span>
                    <div style="overflow: hidden">
                      <div class = "d-flex justify-content-center">
                        <img title="캡차이미지" src="${pageContext.request.contextPath }/stud/captchaImg.do" alt="캡차이미지" />
                        <div id="ccaudio" style="display: none"></div>
                      </div>
                    </div>
                  </div>
                  <div class ="col-md-2 col-xl-2">
                    <input id="reload" type="button" onclick="javaScript:getImage()" class="col-12 btn btn-outline-secondary"
                      value="새로고침" /> 
                      <input id="soundOn" type="button" class="col-12 btn btn-outline-secondary" style="margin: 0 auto;"
                      onclick="javaScript:audio()" value="음성듣기" />
                    
                  </div>
                  <div class ="col-md-3 col-xl-2 mt-4">
                    <input id="answer" type="text" class="form-control" value=""> 
                  </div>
                  <div class ="col-md-2 col-xl-1 mt-4">
                    <input id="check" class="btn btn-info col-12" type="button" value="확인" />
                  </div>
                </div>
              </form>
            </div>
            </div>


            <div class="mb-5">
              <div class="block block-rounded block-themed">
                <div class="block-header bg-primary-darker">
                  <h1 class="block-title">[수강신청 목록]</h1>
                </div>
                <table class="table table-striped table-vcenter">
                  <thead>
                    <tr>
                      <th class="d-none d-sm-table-cell" style="width: 100px;">이수구분</th>
                      <th class="d-none d-sm-table-cell" style="width: 100px;">과목코드</th>
                      <th class="d-none d-sm-table-cell" style="width: 100px;">과목명</th>
                      <th class="d-none d-sm-table-cell" style="width: 100px;">교수명</th>
                      <th class="d-none d-sm-table-cell" style="width: 110px;">강의실</th>
                      <th class="d-none d-sm-table-cell" style="width: 120px;">강의시간</th>
                      <th class="d-none d-sm-table-cell" style="width: 50px;">학점</th>
                      <th class="d-none d-sm-table-cell" style="width: 50px;">인원수</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr scope="row">
                      <th class="fw-semibold fs-sm">전공/필수</th>
                      <td class="fw-semibold fs-sm">014-124357</td>
                      <td class="fw-semibold fs-sm">컴퓨터 그래픽스</td>
                      <td class="fw-semibold fs-sm">최규완</td>
                      <td class="fw-semibold fs-sm">참치관 103호</td>
                      <td class="fw-semibold fs-sm">13:00~14:00 월/수</td>
                      <td class="fw-semibold fs-sm">3</td>
                      <td class="fw-semibold fs-sm">12/45</td>
                    </tr>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <script src="assets/js/oneui.app.min.js"></script>
  <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
  <script>
  
    function showPopup() {
      window.open("/tuna/stud/lectureEvaluationSearch", "강의평가조회", "width=650, height=600, top=10, left=10");
    }

    var header = $("meta[name='_csrf_header']").attr('content');
    var token = $("meta[name='_csrf']").attr('content');
		window.onload = function() {
			getImage(); // 이미지 가져오기

			document.querySelector('#check').addEventListener(
					'click',
					function() {
						$.ajax(
								{
									url:'${pageContext.request.contextPath}/stud/chkAnswer.do', 
									method:'POST',
									data: {'answer':document.querySelector('#answer').value},
									beforeSend: function (xhr) {
								       xhr.setRequestHeader(header, token);
									}
								}).done(function(result) {
									console.log(result);
									if (result == '200') {
										alert('입력값이 일치합니다.');
										// 성공 코드
									} else {
										alert('입력값이 일치하지 않습니다.');
										getImage();
										document.querySelector('#answer').setAttribute(
												'value', '');
									}
								}).done(function(result){
									console.log(result)
								})
              })
            }
		
		/*매번 랜덤값을 파라미터로 전달하는 이유 : IE의 경우 매번 다른 임의 값을 전달하지 않으면 '새로고침' 클릭해도 정상 호출되지 않아 이미지가 변경되지 않는 문제가 발생된다*/
		function audio() {
			var rand = Math.random();
			var uAgent = navigator.userAgent;
			var soundUrl = '${pageContext.request.contextPath }/stud/captchaAudio.do?rand=' + rand;
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
			var url = '${pageContext.request.contextPath }/stud/captchaImg.do?rand=' + rand;
			document.querySelector('img').setAttribute('src', url);
		}
		function audioPlayer(objUrl) {
			document.querySelector('#ccaudio').innerHTML = '<bgsoun src="' +objUrl +'">';
		}
  </script>
</body>