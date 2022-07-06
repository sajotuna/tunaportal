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

    td {
      text-align: center;
    }
  </style>

</head>

<body>

  <div id="section ">

    <div id="page-container">

      <div class="content content-boxed ">
        <h3 class="h3 fw-bold mb-2">장학금 신청</h3>
        <div class="row">
          <div class="col-lg-12 col-xl-12 bg-body-extra-light "style="padding: 10px;">
            <div class="m-4">
              <form action="" method="post">
                <div class="mb-4">
                  <div class="input-group">
                    <span class="input-group-text">소속</span>
                    <input type="text" class="form-control" id="example-group1-input1" name="example-group1-input1">
                  </div>
                </div>
                <div class="mb-4">
                  <div class="input-group">
                    <span class="input-group-text">이름</span>
                    <input type="text" class="form-control" id="example-group1-input1" name="example-group1-input1">
                  </div>
                </div>
                <div class="mb-4">
                  <div class="input-group">
                    <span class="input-group-text">생년월일</span>
                    <input type="text" class="form-control" id="example-group1-input1" name="example-group1-input1">
                  </div>
                </div>
                <div class="mb-4">
                  <div class="input-group">
                    <span class="input-group-text">전화번호</span>
                    <input type="text" class="form-control" id="example-group1-input1" name="example-group1-input1">
                  </div>
                </div>
                <div class="mb-4">
                  <div class="input-group">
                    <span class="input-group-text">휴대전화</span>
                    <input type="text" class="form-control" id="example-group1-input1" name="example-group1-input1">
                  </div>
                </div>
                <div class="row">
                  <div class="col-lg-12">
                    <div class="input-group">
                      <span class="input-group-text">계좌정보</span>
                      <span class="input-group-text">은행</span>
                      <div class="col-md-3 col-xl-2">
                        <select class="form-select" id="example-select" name="example-select">
                          <option value="">은행명을 선택하세요</option>
                          <option value="35">경남은행</option>
                          <option value="29">광주은행</option>
                          <option value="7">국민은행</option>
                          <option value="5">기업은행</option>
                          <option value="15">농협중앙회</option>
                          <option value="17">농협회원조합</option>
                          <option value="25">대구은행</option>
                          <option value="47">도이치은행</option>
                          <option value="27">부산은행</option>
                          <option value="3">산업은행</option>
                          <option value="41">상호저축은행</option>
                          <option value="37">새마을금고</option>
                          <option value="11">수협중앙회</option>
                          <option value="36">신한금융투자</option>
                          <option value="60">신한은행</option>
                          <option value="39">신협중앙회</option>
                          <option value="9">외환은행</option>
                          <option value="19">우리은행</option>
                          <option value="56">우체국</option>
                          <option value="33">전북은행</option>
                          <option value="31">제주은행</option>
                          <option value="68">카카오뱅크</option>
                          <option value="67">케이뱅크</option>
                          <option value="59">하나은행</option>
                          <option value="23">한국씨티은행</option>
                          <option value="45">HSBC은행</option>
                          <option value="21">SC제일은행</option>
                        </select>
                      </div>
                      <span class="input-group-text">계좌 번호</span>
                      <input type="text" class="form-control" id="example-group1-input1" name="example-group1-input1">
                      <span class="input-group-text">예금주</span>
                      <input type="text" class="form-control" id="example-group1-input1" name="example-group1-input1">
                    </div>
                  </div>
                </div>
                <br>
                <table class="table table-striped table-vcenter table-bordered">
                  <thead>
                    <tr>
                      <th class="fw-semibold fs-sm" rowspan="2"><input type="radio"><br>학업성적우수장학금</th>
                      <th class="fw-semibold fs-sm">안내사항</th>
                      <td class="fw-semibold fs-sm">직전학기 과락없이 수강신청 기준학점(단, 모든 학부(과)의 최종학기 직전학기는 14학점) 이상 취득하고, 직전학기 학업성적
                        평점평균이 B(3.0) 이상이며 품행이 단정한 자로서 학부(과)장이 추천한 자. 단, 시행에 관한 사항은 별도로 정한다.</td>
                    </tr>
                    <tr>
                      <th class="fw-semibold fs-sm">제출서류</th>
                      <td class="fw-semibold fs-sm">없음</td>
                    </tr>
                    <tr>
                      <th class="fw-semibold fs-sm" rowspan="2"><input type="radio"><br>가족 장학금</th>
                      <th class="fw-semibold fs-sm">안내사항</th>
                      <td class="fw-semibold fs-sm">친가족 2명 이상 본 대학교(학부과정)에 재학하고 있는 자 중 1인에게 지원(단, 모든 학부(과)의 직전학기는 12학점.
                        4학년은 8학점)이상 취득하고, 직전학기 학업성적 평점평균이 C+(2.5)이상 </td>

                    </tr>
                    <tr>
                      <th class="fw-semibold fs-sm">제출서류</th>
                      <td class="fw-semibold fs-sm">가족관계증명서</td>
                    </tr>
                    <tr>
                      <th class="fw-semibold fs-sm" rowspan="2"><input type="radio"><br>교직원가족 장학금</th>
                      <th class="fw-semibold fs-sm">안내사항</th>
                      <td class="fw-semibold fs-sm">대학 교직원 가족 또는 법인 소속 교직원 가족이며, 직전학기 17학점(졸업예정 학생은 12학점) 이상 취득하고, 직전학기
                        학업성적 평점평균이 C(2.0)이상 </td>

                    </tr>
                    <tr>
                      <th class="fw-semibold fs-sm">제출서류</th>
                      <td class="fw-semibold fs-sm">가족관계증명서</td>
                    </tr>


                  </thead>
                  <tbody>
                  </tbody>
                </table>
                <input type="submit" class="btn btn-info" style="margin: 0 auto; display: block;" value="제출">
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <script src="assets/js/oneui.app.min.js"></script>
</body>

</html>