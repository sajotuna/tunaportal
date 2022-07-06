<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0">

    <title>강의평가 내역</title>

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
      tr{
        text-align: center;
      }
      td{
        text-align: center;
      }
  </style>
    
  </head>
  <body>
    <div class="bg-body-light">
      <div class="content content-full content-boxed">
        <div class="d-flex flex-column flex-sm-row justify-content-sm-between align-items-sm-center py-2">
          <div class="flex-grow-1">
            <h1 class="h1 fw-bold mb-2">
              강의평가 조회
            </h1>
          </div>
        </div>
      </div>
    </div>
      <div id="section">
        <div id="page-container">
          <div class="content content-boxed">
            <div class="block block-rounded">
              
              <div class="mb-4">
                <div style="width:100%; height:500px; overflow:scroll">
                  <table class="table table-vcenter scroll">
                    <thead>
                      <tr>
                        <th class="d-none d-sm-table-cell" style="width: 100px;">교수명</th>
                        <th class="d-none d-sm-table-cell" style="width: 100px;">과목명</th>
                        <th class="d-none d-sm-table-cell" style="width: 30px;">분반</th>
                        <th class="d-none d-sm-table-cell" style="width: 100px;">교과구분</th>
                        <th class="d-none d-sm-table-cell" style="width: 30px;">학점</th>
                        <th class="d-none d-sm-table-cell" style="width: 100px;">강의실</th>
                        <th class="d-none d-sm-table-cell" style="width: 100px;">강의시간</th>
                        <th class="d-none d-sm-table-cell" style="width: 100px;">강의평점</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr scope="row">
                        <td class="fw-semibold fs-sm">최규완</td>
                        <td class="fw-semibold fs-sm">참치분해학</td>
                        <td class="fw-semibold fs-sm">A/C</td>
                        <td class="fw-semibold fs-sm">전공필수</td>
                        <td class="fw-semibold fs-sm">3</td>
                        <td class="fw-semibold fs-sm">TU-101</td>
                        <td class="fw-semibold fs-sm">11:00~12:00 월/수</td>
                        <td class="fw-semibold fs-sm">3.84</td>
                      </tr>
                      <tr scope="row">
                        <td class="fw-semibold fs-sm">최규완</td>
                        <td class="fw-semibold fs-sm">참치분해학</td>
                        <td class="fw-semibold fs-sm">A/C</td>
                        <td class="fw-semibold fs-sm">전공필수</td>
                        <td class="fw-semibold fs-sm">3</td>
                        <td class="fw-semibold fs-sm">TU-101</td>
                        <td class="fw-semibold fs-sm">11:00~12:00 월/수</td>
                        <td class="fw-semibold fs-sm">3.84</td>
                      </tr>
                      <tr scope="row">
                        <td class="fw-semibold fs-sm">최규완</td>
                        <td class="fw-semibold fs-sm">참치분해학</td>
                        <td class="fw-semibold fs-sm">A/C</td>
                        <td class="fw-semibold fs-sm">전공필수</td>
                        <td class="fw-semibold fs-sm">3</td>
                        <td class="fw-semibold fs-sm">TU-101</td>
                        <td class="fw-semibold fs-sm">11:00~12:00 월/수</td>
                        <td class="fw-semibold fs-sm">3.84</td>
                      </tr>
                      <tr scope="row">
                        <td class="fw-semibold fs-sm">최규완</td>
                        <td class="fw-semibold fs-sm">참치분해학</td>
                        <td class="fw-semibold fs-sm">A/C</td>
                        <td class="fw-semibold fs-sm">전공필수</td>
                        <td class="fw-semibold fs-sm">3</td>
                        <td class="fw-semibold fs-sm">TU-101</td>
                        <td class="fw-semibold fs-sm">11:00~12:00 월/수</td>
                        <td class="fw-semibold fs-sm">3.84</td>
                      </tr>
                      <tr scope="row">
                        <td class="fw-semibold fs-sm">최규완</td>
                        <td class="fw-semibold fs-sm">참치분해학</td>
                        <td class="fw-semibold fs-sm">A/C</td>
                        <td class="fw-semibold fs-sm">전공필수</td>
                        <td class="fw-semibold fs-sm">3</td>
                        <td class="fw-semibold fs-sm">TU-101</td>
                        <td class="fw-semibold fs-sm">11:00~12:00 월/수</td>
                        <td class="fw-semibold fs-sm">3.84</td>
                      </tr>
                    </tbody>
                  </table>
                </div>
              </div>
              <div class="d-flex justify-content-end">
                <div class="m-4">
                  <a href="#" class="btn btn-info" onclick="javascript:window.close()">닫기</a>
                </div>
              </div>
            </div>    
          </div>
        </div>
      </div>
    
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="assets/js/oneui.app.min.js"></script>
    
  </body>
</html>