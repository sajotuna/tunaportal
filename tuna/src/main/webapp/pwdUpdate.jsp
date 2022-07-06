<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width,initial-scale=1.0">

  <title>비밀번호 수정</title>

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
</head>

<body>
  
  <div class="bg-body-light">
    <div class="content content-full content-boxed">
      <div class="d-flex flex-column flex-sm-row justify-content-sm-between align-items-sm-center py-2">
        <div class="flex-grow-1">
          <h1 class="h1 fw-bold mb-2">
            비밀번호 수정
          </h1>
        </div>
      </div>
    </div>
  </div>
      <div id="section">
      <div id="page-container">
        <div class="content content-boxed ">
          <div class="bg-body-extra-light">
              <div class="row">
                <div class="col-10 m-4">
                  <form action="" method="post">
                    <div class="mb-4">
                      <div class="input-group">
                        <input type="password" class="form-control" id="example-group1-input1"
                          name="example-group1-input1" placeholder="기존 비밀번호">
                      </div>
                    </div>
                    <div class="mb-4">
                      <div class="input-group">
                        <input type="password" class="form-control" id="example-group1-input1"
                          name="example-group1-input1" placeholder="변경 비밀번호">
                      </div>
                    </div>
                    <div class="mb-4">
                      <div class="input-group">
                        <input type="password" class="form-control" id="example-group1-input1"
                          name="example-group1-input1" placeholder="비밀번호 확인">
                      </div>
                    </div>
                    <div class="mb-4">
                      <div class="center">
                        <a href="#" class="btn btn-info" onclick="javascript:window.close()">닫기</a>
                        <button class="btn btn-info" onclick="showPopup();">등록</button>
                      </div>
                    </div>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <script src="assets/js/oneui.app.min.js"></script>
</body>

</html>