<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0">

    <title>마이페이지</title>

    <meta name="description" content="OneUI - Bootstrap 5 Admin Template &amp; UI Framework created by pixelcave and published on Themeforest">
    <meta name="author" content="pixelcave">
    <meta name="robots" content="noindex, nofollow">

    <!-- Open Graph Meta -->
    <meta property="og:title" content="OneUI - Bootstrap 5 Admin Template &amp; UI Framework">
    <meta property="og:site_name" content="OneUI">
    <meta property="og:description" content="OneUI - Bootstrap 5 Admin Template &amp; UI Framework created by pixelcave and published on Themeforest">
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
  </style>
    
  </head>
  <body>
    <div class="bg-body-light">
      <div class="content content-full content-boxed">
        <div class="d-flex flex-column flex-sm-row justify-content-sm-between align-items-sm-center py-2">
          <div class="flex-grow-1">
            <h1 class="h1 fw-bold mb-2">
              내 정보수정
            </h1>
          </div>
        </div>
      </div>
    </div>
      <div id="section">
        <div class="content content-boxed">
          <div class="block block-rounded">
            <div id="page-container">

              <div class = "content content-boxed">
                
                  <div class="row">
                    <div class="col-md-6 col-xl-4 ">
                      <div class="mb-4">
                        <h4>기본 정보
                        <button class="btn btn btn-outline-secondary"  onclick="showPopup();">비밀번호변경</button></h4>
                      </div>
                    </div>
                    <form action="" method="post">
                    <div class="row">
                      <div class="col-lg-12 col-xl-12">
                      
                        <div class="mb-3">
                          <div class="input-group">
                            <span class="input-group-text">소속</span>
                            <input type="text" class="form-control" id="example-group1-input1" name="example-group1-input1">
                            <span class="input-group-text">이름</span>
                            <input type="text" class="form-control" id="example-group1-input1" name="example-group1-input1">
                            <span class="input-group-text">생년월일</span>
                            <input type="text" class="form-control" id="example-group1-input1" name="example-group1-input1">
                          </div>
                    </div>
                    <div class="mb-3">
                      <div class="input-group">
                        <span class="input-group-text">소속</span>
                        <input type="text" class="form-control" id="example-group1-input1" name="example-group1-input1">
                        <span class="input-group-text">이름</span>
                        <input type="text" class="form-control" id="example-group1-input1" name="example-group1-input1">
                        <span class="input-group-text">생년월일</span>
                        <input type="text" class="form-control" id="example-group1-input1" name="example-group1-input1">
                      </div>
                    </div>
                  </div>
                </div>
                <div class="col-md-6 col-xl-4 ">
                  <div class="mb-4">
                    <h4>현 주소</h4>
                  </div>
                </div>
                
                <div class="row mb-2">
                  <div class="col-4">
                    <div class = "row">
                      <div class = "col-10">
                      <input type="text" class="form-control" id="postcode" placeholder="우편번호">
                    </div>
                    <div class = "col-2">
                      <button type="button" class="btn btn-secondary" onclick="execDaumPostcode()">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                          <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
                        </svg>
                      </button>
                    </div>
                    </div>  
                  </div>
                  <div class="col-4">
                    <input type="text" id="address" class="form-control" placeholder="주소"><br>
                  </div>
                  <div class="col-4">
                    <input type="text" id="extraAddress" class="form-control" placeholder="상세주소">
                  </div>
                </div>
                <div class="d-flex justify-content-end">
                  <div class="m-2">
                  <a href ="#" class = "btn btn-secondary">돌아가기</a>
              </div>
              <div class="m-2">
                <button type="button" class="btn btn-secondary">수정하기</button>
              </div>
            </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
    
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="assets/js/oneui.app.min.js"></script>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script>
      function showPopup(){
          window.open("/tuna/pwdUpdate","비밀번호변경","width=600, height=400, top=10, left=10");
      }

      function execDaumPostcode() {
            new daum.Postcode({
                oncomplete: function(data) {
                    
                    var addr = ''; 
                    var extraAddr = ''; 
                    if (data.userSelectedType === 'R') { 
                        addr = data.roadAddress;
                    } else { 
                        addr = data.jibunAddress;
                    }
                    if(data.userSelectedType === 'R'){
                        if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                            extraAddr += data.bname;
                        }
                        if(data.buildingName !== '' && data.apartment === 'Y'){
                            extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                        }
                        if(extraAddr !== ''){
                            extraAddr = ' (' + extraAddr + ')';
                        }
                        document.getElementById("extraAddress").value = extraAddr;
    
                    } else {
                        document.getElementById("extraAddress").value = '';
                    }
                    document.getElementById('postcode').value = data.zonecode;
                    document.getElementById("address").value = addr;
                    document.getElementById("extraAddress").focus();
                }
            }).open();
        }
  </script>
  </body>
</html>