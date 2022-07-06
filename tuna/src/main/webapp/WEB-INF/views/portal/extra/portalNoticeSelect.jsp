<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath }/resources" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" id="css-main" href="${path}/assets/css/oneui.min.css">
<title>portalNoticeSelect</title>
</head>
<body>
        <!--title start-->
        <div class="bg-body-light">
            <div class="content content-full content-boxed">
                <div class="d-flex flex-column flex-sm-row justify-content-sm-between align-items-sm-center py-2">
                    <div class="flex-grow-1">
                        <h1 class="h1 fw-bold mb-2">
                            학사공지
                        </h1>
                        <h2 class="fs-base lh-base fw-medium text-muted mb-0">
                            notice
                        </h2>
                    </div>
                </div>
            </div>
        </div>
        <!--title end-->

        <div class="content content-boxed">
          <form>
            <div class="block block-rounded">
          
                <div class="block-content">
                
                        <div class="row d-flex justify-content-center py-sm-3">
                            <div class="text-center fs-sm push">
                                <h2 class="mt-3">2022-2 생활관 2차 입사 신청 안내</h2>
                                <div class="d-flex justify-content-end">
                                    <span class="py-2 px-2 bg-body-light col-2 rounded">
                                        July 16, 2019
                                    </span>
                                </div>
                            </div>
                        </div>
                        <!--제목 end-->
                        <hr>

                                2022-2 생활관 2차 입사 신청 안내

                                우리대학교 생활관에서는 2022학년도 제2학기 2차 입사 신청 안내를 생활관 홈페이지에 게시하였으니 확인하여 주시기 바랍니다.

                                (단, 코로나 19 관련 사회적 거리두기 방침과 2022학년도 2학기 수업방식에 따라 변경될 수 있습니다.)

                           
                            <hr>
                            <div class="col-5">
                                첨부된 파일
                            </div>
                            <hr>
                            <div class="p-1 d-flex justify-content-end">
                                <button type="button" class="btn btn-outline-secondary m-1" onclick="location.href='portalNoticeList'">목록</button>
                            </div>

                        </div>
                    </div>
                </form>

            </div>

</body>
</html>