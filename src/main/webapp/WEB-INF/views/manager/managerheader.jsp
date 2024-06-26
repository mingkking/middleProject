<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<body>
	<!-- ======= Header ======= -->
	<header id="managerheader" class="header d-flex align-items-center">
		<div class="container-fluid container-xl d-flex align-items-center justify-content-between">
			
			<!-- 로고 -->
			<a href="${path}/index.do" class="logo d-flex align-items-center">
				<img alt="logo" src="${path}/resources/assets/img/main_img/Logo.png">
			</a> 
			<i class="mobile-nav-toggle mobile-nav-show bi bi-list"></i>
			<i class="mobile-nav-toggle mobile-nav-hide d-none bi bi-x"></i>
			<nav id="navbar" class="navbar">
				<ul>
					<!-- <li><a href="${path}/#">관리자</a></li> -->
					<li><a href="${path}/managermemberList">회원관리</a></li>
					<li><a href="${path}/managerproduct">상품</a></li>
					<li><a href="${path}/managerreservation">예약현황</a></li>
					<li><a href="${path}/managergraph">통계</a></li>					
				</ul>
			</nav>
			<!-- .navbar -->

		</div>
	</header>
	<!-- End Header -->
</body>
