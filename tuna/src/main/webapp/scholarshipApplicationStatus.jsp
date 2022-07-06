<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width,initial-scale=1.0">

  <title>장학금 신청 현황</title>

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
        <h3 class="h3 fw-bold mb-2">장학금 신청현황</h3>
        <div class="bg-body-extra-light" style="padding: 10px;">
          <div class="m-4">
            <div class="mb-4">
              <table class="table table-striped table-vcenter">
                <thead>
                  <tr>
                    <th class="d-none d-sm-table-cell" style="width: 30px;">순번</th>
                    <th class="d-none d-sm-table-cell" style="width: 80px;">장학년도</th>
                    <th class="d-none d-sm-table-cell" style="width: 50px;">학기</th>
                    <th class="d-none d-sm-table-cell" style="width: 80px;">장학명</th>
                    <th class="d-none d-sm-table-cell" style="width: 80px;">접수번호</th>
                    <th class="d-none d-sm-table-cell" style="width: 80px;">학번</th>
                    <th class="d-none d-sm-table-cell" style="width: 80px;">성명</th>
                    <th class="d-none d-sm-table-cell" style="width: 80px;">소속</th>
                    <th class="d-none d-sm-table-cell" style="width: 50px;">학년</th>
                    <th class="d-none d-sm-table-cell" style="width: 80px;">신청상태</th>
                    <th class="d-none d-sm-table-cell" style="width: 50px;">서류<br>업로드</th>
                    <th class="d-none d-sm-table-cell" style="width: 50px;">비고</th>
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
                    <td class="fw-semibold fs-sm"></td>
                    <td class="fw-semibold fs-sm"></td>
                  </tr>
                </tbody>
              </table>
            </div>
            <hr>
            <div class="col">
              <h4>[장학신청안내]</h4>
              <p>TUNA대학교에서는 교내 학부 복학생 및 신(편)입생 장학생 선발을 위한 신청/접수 절차를 진행합니다.</p>
              <ol type="1">
                <li>교내장학신청 - 저장 후(가족장학금/교직원가족 장학금) 해당대상자는 증빙자료 업로드 필요<br>
                  스캔 혹은 휴대폰 등으로 사진 촬영 후 증빙서류 파일 업로드(사진촬영시 내용 미확인시 불인정)<br>
                  * 파일형식 : 학번_이름_pdf(jpg 등)</li>
                <li>성적우수장학금 경우에는, 따로 서류를 증빙하지 않고, 신청만 하면 접수가 완료됌</li>
              </ol>
              <p>학업성적 장학금은 본인 소속 학부(과)에서 선발하므로 본인 소속 학부(과)로 문의</p>
              <p>장학금은 수업료 범위 내에서 이중수혜 가능</p>
              <p>등록금 분납 신청자는 장학금도 분납에 따라 각각의 분납 회차에 감면이 되며, 등록 완료 후 장학금 총액이 표시가 됩니다.</p>
              <p style="color: red; font-weight: bold;">장학금은 당해학기에 한하여 유효하며, 당해학기에 등록금을 납입하지 않으면 장학생 자격 상실(장학금 소멸)</p>
              <p style="color: red; font-weight: bold;">일부 장학금은 휴학이 불가능하거나 또는 휴학 및 제적(자퇴) 시 수혜 장학금을 (전액)반납하여야 합니다.</p>
              <p style="color: red; font-weight: bold;">국가장학금 수혜자가 분납신청을 한 경우 등록금 전액을 완납하지 않고 중도에 자퇴(제적)하는 경우에는 자비로
                국가장학금
                전액을 반납하여야 합니다.</p>
              <p>장학금 수혜내역의 “지급구분”란 설명</p>
              <ul>
                <li>우선감면: 장학금을 등록금 고지서에 반영하여 감면방식으로 지급(장학금을 제외한 차액 납부)</li>
                <li> - 학생지급: URP에 등록된 학생계좌로 지급<br>
                  ※ 단, 해당 학기 학자금 대출이 있으나 대출이 상환되지 않고 학생계좌로 학자금 대출 상환분을 지급받은 경우에는 학생이 직접 학자금 대출 기관에 상환처리해야 함
                </li>
                <li>직접상환: 한국장학재단에서 직접 학자금 대출을 상환(장학금이 학교로 입금되지 않음)</li>
                <li>상환: 학교에서 한국장학재단 또는 공무원연금공단 학자금 대출을 상환</li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <script src="assets/js/oneui.app.min.js"></script>
</body>

</html>