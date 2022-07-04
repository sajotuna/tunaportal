<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<c:set var = "path" value = "${pageContext.request.contextPath }/resources"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width,initial-scale=1.0">
	<title><tiles:getAsString name="title" /></title>
	<!-- Icons -->
	<link rel="shortcut icon" href="${path }/assets/media/favicons/favicon.png">
	<link rel="icon" type="image/png" sizes="192x192" href="${path }/assets/media/favicons/favicon-192x192.png">
	<link rel="apple-touch-icon" sizes="180x180" href="${path }/assets/media/favicons/apple-touch-icon-180x180.png">
	<!-- END Icons -->
	
	<!-- Stylesheets -->
    <!-- Fonts and OneUI framework -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700&display=swap">
    <link rel="stylesheet" id="css-main" href="${path }/assets/css/oneui.min.css">
    <link rel="stylesheet" id="css-theme" href="${path }/assets/css/themes/modern.min.css">
    <!-- END Stylesheets -->
       
    <!-- Script -->
	<script src="${path }/assets/js/oneui.app.min.js"></script>

</head>
<body>
    <div id="page-container" class="page-header-dark main-content-boxed">
	<tiles:insertAttribute name = "header"/>
	    <!-- Main Container -->
	    <main id="main-container">
			<tiles:insertAttribute name = "body"/>
		</main>
		<!-- END Main Container -->
	<tiles:insertAttribute name = "footer"/>
	</div>
	
</body>
</html>