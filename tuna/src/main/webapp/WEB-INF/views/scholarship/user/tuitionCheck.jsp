<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width,initial-scale=1.0">

  <title>장학금 신청</title>

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

    p {
      font-weight: bold;
    }

    #tuna {
      font-size: 46px;
      font-weight: 500;
      text-align: center;
    }

    .text {
      font-size: 30px;
      margin-top: 70px;
      vertical-align: middle;
    }

    .text img {
      position: absolute;
      text-align: center;
      top: 30px;
      left: 50px;
      width: 200px;
    }
  </style>

</head>

<body>

  <div class="bg-body-light">
    <div class="content content-full content-boxed">
      <div class="d-flex flex-column flex-sm-row justify-content-sm-between align-items-sm-center py-2">
        <div class="flex-grow-1">
          <h1 class="h1 fw-bold mb-2">
            등록금 내역 조회
          </h1>
        </div>
      </div>
    </div>
  </div>

  <div id="section">

    <div id="page-container">
      <div class="content content-boxed">
        <div class="bg-body-extra-light">
          <div style="padding: 40px;">
            <h1 style="text-align: center;">등록금 납입 확인서</h1>

            <div class="d-flex justify-content-end">
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
            <table class="table table-striped table-vcenter table-bordered">
              <thead>
                <tr>
                  <th class="fw-semibold fs-sm">대학</th>
                  <td class="fw-semibold fs-sm" colspan="2"></td>
                  <th class="fw-semibold fs-sm">학과</th>
                  <td class="fw-semibold fs-sm" colspan="2"></td>
                </tr>
                <tr>
                  <th class="fw-semibold fs-sm">학번</th>
                  <td class="fw-semibold fs-sm"></td>
                  <th class="fw-semibold fs-sm">학년</th>
                  <td class="fw-semibold fs-sm"></td>
                  <th class="fw-semibold fs-sm">성명</th>
                  <td class="fw-semibold fs-sm"></td>

                </tr>
                <tr>
                  <th class="fw-semibold fs-sm" rowspan="2">구분</th>
                  <th class="fw-semibold fs-sm" rowspan="2">등록금</th>
                  <th class="fw-semibold fs-sm" colspan="3">등록금감면내역</th>
                  <th class="fw-semibold fs-sm" rowspan="2">실 납부 금액(A-B)</th>
                </tr>
                <tr>
                  <th class="fw-semibold fs-sm">교내장학</th>
                  <th class="fw-semibold fs-sm">성적우수</th>
                  <th class="fw-semibold fs-sm">대학교직원가족</th>
                </tr>
                <tr>
                  <th class="fw-semibold fs-sm">수업료</th>
                  <td class="fw-semibold fs-sm"></td>
                  <td class="fw-semibold fs-sm"></td>
                  <td class="fw-semibold fs-sm"></td>
                  <td class="fw-semibold fs-sm"></td>
                  <td class="fw-semibold fs-sm"></td>

                </tr>
                <tr>
                  <th class="fw-semibold fs-sm">총계</th>
                  <td class="fw-semibold fs-sm"></td>
                  <td class="fw-semibold fs-sm"></td>
                  <td class="fw-semibold fs-sm"></td>
                  <td class="fw-semibold fs-sm"></td>
                  <td class="fw-semibold fs-sm"></td>
                </tr>
              </thead>
              <tbody>

              </tbody>
            </table>

            <p>위 금액을 납부하시길 바랍니다.</p>
            <p>납부기간 : </p>
            <p>납부장소 : </p>
            <p>가상계좌 : </p>

            <p>문의처 : 입학관리 담당자 최규완 (010-XXXX-XXXX)</p>

            <div id="tuna" class="text">TUNA대학교 수입징수관

            </div>



            <div class="d-flex justify-content-center">
              <button id="app" class="btn btn-secondary">출력</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <script src="http://code.jquery.com/jquery-latest.min.js"></script>
  <script src="assets/js/oneui.app.min.js"></script>
  <script>
    $('#app').on('click', function () {
      window.print();
    })
  </script>


</body>

</html>