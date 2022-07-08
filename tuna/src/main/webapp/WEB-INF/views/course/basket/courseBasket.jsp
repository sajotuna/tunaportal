<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width,initial-scale=1.0">

  <title>수강꾸러미</title>

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

    tr {
      text-align: center;
    }

    td {
      text-align: center;
    }

    .fomrtag {
      margin-left: 50px;
    }
  </style>

</head>

<body>
  <div id="section">

    <div id="page-container">
      <div class="content content-boxed ">
        <h3 class="h3 fw-bold mb-2">수강꾸러미</h3>
        <div class="bg-body-extra-light" style="padding: 10px;">
          <div class="m-4">
            <form action="" method="post" class="row">
              <div class="col-md-3 col-xl-2 fomrtag">
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
              <div class="col-md-3 col-xl-2 fomrtag">
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
              <div class="col-md-3 col-xl-2 fomrtag">
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
              <div class="col-md-3 col-xl-2 fomrtag">
                <div class="mb-2">
                  <input type="number" placeholder="직접입력...." class="form-control"
                    id="example-flatpickr-time-standalone-24" name="example-flatpickr-time-standalone-24">
                </div>
              </div>
              <div class="col-md-2 col-xl-1 fomrtag">
                <div class="mb-2 ">
                  <button type="button" class="btn btn-secondary col-sm-12">조회</button>
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
                    <th class="d-none d-sm-table-cell" style="width: 20px;">선택</th>
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
                <form action="" method="post">
                  <tbody>
                    <tr scope="row">
                      <td class="fw-semibold fs-sm"><input type="checkbox"></th>
                      <td class="fw-semibold fs-sm">전공/필수</th>
                      <td class="fw-semibold fs-sm">014-124357</td>
                      <td class="fw-semibold fs-sm">컴퓨터 그래픽스</td>
                      <td class="fw-semibold fs-sm"><a href="#">최규완</a></td>
                      <td class="fw-semibold fs-sm">참치관 103호</td>
                      <td class="fw-semibold fs-sm">13:00~14:00 월/수</td>
                      <td class="fw-semibold fs-sm">3</td>
                      <td class="fw-semibold fs-sm">12/45</td>
                    </tr>
                    <tr scope="row">
                      <td class="fw-semibold fs-sm"><input type="checkbox"></th>
                      <td class="fw-semibold fs-sm">전공/필수</th>
                      <td class="fw-semibold fs-sm">014-124357 <input type="hidden" name="code" value="code"></td>
                      <!-- HTML 5버전 부터는 배열형식으로 체크박스 받는거 가능.-->
                      <td class="fw-semibold fs-sm">컴퓨터 그래픽스</td>
                      <td class="fw-semibold fs-sm"><a href="#">최규완</a></td>
                      <td class="fw-semibold fs-sm">참치관 103호</td>
                      <td class="fw-semibold fs-sm">13:00~14:00 월/수</td>
                      <td class="fw-semibold fs-sm">3</td>
                      <td class="fw-semibold fs-sm">12/45</td>
                    </tr>

                  </tbody>

                </form>
              </div>
            </div>
              </table>
              <div class="d-flex justify-content-end">
                <div class="m-4">
                  <input type="submit" value="신청" class="btn btn-info">
                </div>
              </div>

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
           <div class="mb-5 ">
              <div class="block block-rounded block-themed">
                <div class="block-header bg-primary-darker">
                  <h1 class="block-title">[수강꾸러미]</h1>
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