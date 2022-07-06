<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width,initial-scale=1.0">

  <title>장학금 신청 조회</title>

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
      <div class="content content-boxed">
        <h3 class="h3 fw-bold mb-2">장학금 신청조회</h3>
        <div class="bg-body-extra-light" style="padding: 10px;">
        <div class="d-flex justify-content-end ">
          
            <div class="col-md-3 col-xl-2">
              <div class="m-2">
                <form>
                  <select class="form-select" id="example-select" name="example-select" onchange="this.form.submit()">
                    <option selected>연도</option>
                    <option value="1">2022</option>
                    <option value="2">2021</option>
                    <option value="3">2020</option>
                  </select>
                </form>
              </div>
            </div>
            <div class="col-md-3 col-xl-2">
              <div class="m-2">
                <form>
                  <select class="form-select" id="example-select" name="example-select" onchange="this.form.submit()">
                    <option selected>학기</option>
                    <option value="1">1</option>
                    <option value="2">2</option>
                  </select>
                </form>
              </div>
            </div>
          </div>
          <div class="mb-4">
            <table class="table table-striped table-vcenter">
              <thead>
                <tr>
                  <th class="d-none d-sm-table-cell" style="width: 30px;">순번</th>
                  <th class="d-none d-sm-table-cell" style="width: 80px;">장학년도</th>
                  <th class="d-none d-sm-table-cell" style="width: 30px;">학기</th>
                  <th class="d-none d-sm-table-cell" style="width: 80px;">장학명</th>
                  <th class="d-none d-sm-table-cell" style="width: 80px;">접수번호</th>
                  <th class="d-none d-sm-table-cell" style="width: 80px;">학번</th>
                  <th class="d-none d-sm-table-cell" style="width: 80px;">성명</th>
                  <th class="d-none d-sm-table-cell" style="width: 80px;">소속</th>
                  <th class="d-none d-sm-table-cell" style="width: 50px;">학년</th>
                  <th class="d-none d-sm-table-cell" style="width: 80px;">신청상태</th>
                </tr>
              </thead>
              <tbody>
                <tr scope="row">
                  <td class="fw-semibold fs-sm">1</td>
                  <td class="fw-semibold fs-sm">2022년</td>
                  <td class="fw-semibold fs-sm">1학기</td>
                  <td class="fw-semibold fs-sm">성적우수</td>
                  <td class="fw-semibold fs-sm">01432154</td>
                  <td class="fw-semibold fs-sm">22015879</td>
                  <td class="fw-semibold fs-sm">권태현</td>
                  <td class="fw-semibold fs-sm">컴퓨터공학</td>
                  <td class="fw-semibold fs-sm">3학년</td>
                  <td class="fw-semibold fs-sm">신청대기</td>
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