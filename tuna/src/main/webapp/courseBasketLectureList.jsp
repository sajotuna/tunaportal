<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width,initial-scale=1.0">

  <title>수강신청 강의목록</title>

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
    tr {
      text-align: center;
    }

    td {
      text-align: center;
    }
  </style>
</head>

<body>
  <div id="section">

    <div id="page-container">
      <div class="content content-boxed ">
        <h3 class="h3 fw-bold mb-2">수강꾸러미 강의목록</h3>
        <div class="bg-body-extra-light" style="padding: 10px;">
          <div class="mb-4">
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
          </div>
        </div>
      </div>
    </div>
  </div>
  <script src="assets/js/oneui.app.min.js"></script>
</body>

</html>