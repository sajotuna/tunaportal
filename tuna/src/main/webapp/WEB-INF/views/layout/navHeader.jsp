<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var = "path" value = "${pageContext.request.contextPath }/resources"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>navHeader</title>
</head>
<body>
	<!-- Navigation -->
	<div class="bg-primary-darker">
		<div class="content py-3">
			<!-- Toggle Main Navigation -->
			<div class="d-lg-none">
				<button type="button"
					class="btn w-100 btn-alt-secondary d-flex justify-content-between align-items-center"
					data-toggle="class-toggle" data-target="#main-navigation"
					data-class="d-none">
					Menu <i class="fa fa-bars"></i>
				</button>
			</div>
			<!-- END Toggle Main Navigation -->

			<!-- Main Navigation -->
			<div id="main-navigation" class="d-none d-lg-block mt-2 mt-lg-0">
				<ul
					class="nav-main nav-main-dark nav-main-horizontal nav-main-hover">
					<li class="nav-main-item"><a class="nav-main-link"
						href="home"> <i
							class="nav-main-link-icon fa fa-house"></i> <span
							class="nav-main-link-name">홈</span>
					</a></li>
					
					<li class="nav-main-item"><a
						class="nav-main-link nav-main-link-submenu" data-toggle="submenu"
						aria-haspopup="true" aria-expanded="false" href="#"><span
							class="nav-main-link-name">학사정보</span>
					</a>
						<ul class="nav-main-submenu">
							<li class="nav-main-item"><a class="nav-main-link"
								href="portalNoticeList"> <span class="nav-main-link-name">공지사항</span>
							</a></li>
							<li class="nav-main-item"><a class="nav-main-link"
								href="portalSchedule"> <span class="nav-main-link-name">학사일정</span>
							</a></li>
						</ul></li>
						
					<li class="nav-main-item"><a
						class="nav-main-link nav-main-link-submenu" data-toggle="submenu"
						aria-haspopup="true" aria-expanded="false" href="#"><span
							class="nav-main-link-name">조회</span>
					</a>
						<ul class="nav-main-submenu">
							<li class="nav-main-item"><a class="nav-main-link"
								href="lectureAndReportSelect"> <span class="nav-main-link-name">강의/성적 조회</span>
							</a></li>
							<li class="nav-main-item"><a class="nav-main-link"
								href="javascript:void(0)"> <span class="nav-main-link-name">장학 신청 및 조회</span>
							</a></li>
							<li class="nav-main-item"><a class="nav-main-link"
								href="javascript:void(0)"> <span class="nav-main-link-name">등록금납입확인서</span>
							</a></li>
							<li class="nav-main-item"><a class="nav-main-link"
								href="javascript:void(0)"> <span class="nav-main-link-name">당해학기 성적 조회</span>
							</a></li>
						</ul></li>
						
					<li class="nav-main-item"><a
						class="nav-main-link nav-main-link-submenu" data-toggle="submenu"
						aria-haspopup="true" aria-expanded="false" href="#"><span
							class="nav-main-link-name">강의</span>
					</a>
						<ul class="nav-main-submenu">
							<li class="nav-main-item"><a class="nav-main-link"
								href="javascript:void(0)"> <span class="nav-main-link-name">e-class</span>
							</a></li>
							<li class="nav-main-item"><a class="nav-main-link"
								href="javascript:void(0)"> <span class="nav-main-link-name">수강신청</span>
							</a></li>
							<li class="nav-main-item"><a class="nav-main-link"
								href="javascript:void(0)"> <span class="nav-main-link-name">강의평가</span>
							</a></li>
						</ul></li>
						
					<li class="nav-main-item ms-lg-auto"><a
						class="nav-main-link nav-main-link-submenu" data-toggle="submenu"
						aria-haspopup="true" aria-expanded="false" href="#"> <i
							class="nav-main-link-icon far fa-user"></i> <span
							class="nav-main-link-name">유저</span>
					</a>
						<ul class="nav-main-submenu nav-main-submenu-right">
							<li class="nav-main-item">
								<a class="nav-main-link" href="#">
								<span class="nav-main-link-name">내 정보 수정</span>
							</a></li>
							<li class="nav-main-item">
								<a class="nav-main-link" href="#"> 
								<span class="nav-main-link-name">로그아웃</span>
							</a></li>
						</ul></li>
				</ul>
			</div>
			<!-- END Main Navigation -->
		</div>
	</div>
	<!-- END Navigation -->
</body>
</html>