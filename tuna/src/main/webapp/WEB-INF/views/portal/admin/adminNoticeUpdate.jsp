<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath }/resources" />
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link rel="stylesheet" id="css-main" href="${path}/assets/css/oneui.min.css">
    <link rel="stylesheet" href="${path}/assets/js/plugins/simplemde/simplemde.min.css">
<title>NoticeUpdate</title>
</head>
<body>     
        <!--폼 시작-->

            <div class="content content-boxed">

                <h3 class="fw-bold">학사공지 수정</h3>
                <div class="block block-rounded">
                            <form class="block-content block-content-full">
                            <div >
                                <input type="text" class="mb-4 form-control" id="example-text-input"
                                    placeholder="학사공지 수정">
                                <hr>
                                <textarea class="js-simplemde" id="simplemde" name="simplemde">내용을 입력하세요</textarea>
                            </div>
                            <hr>
                            <div class="row mb-3">
                                <div class="col-6">
                                    <input class="form-control" type="file" id="example-file-input-multiple" multiple="">
                                </div>
                                <div class="col-6">
                                    <select class="form-select">
                                        <option value="1">공개</option>
                                        <option value="2">비공개</option>
                                    </select>
                                </div>
                            </div>
                                <div class="d-flex justify-content-end">
                                    <button type="submit" class="btn btn-outline-secondary me-2">수정</button>
                                    <button type="button" class="btn btn-outline-secondary" onclick="location.href='adminNoticeList'">홈으로</button>
                                </div>

                    </form>
                    </div>

            </div>

    
    <script src="${path}/assets/js/oneui.app.min.js"></script>
    <script src="${path}/assets/js/plugins/simplemde/simplemde.min.js"></script>
    
    <script>
        One.helpersOnLoad(['js-simplemde']);
    </script>
</body>
</html>