<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<body>
	<!-- ======= Header ======= -->
	<header id="managerheader" class="header d-flex align-items-center">
		<div class="container-fluid container-xl d-flex align-items-center justify-content-between">
			
			<!-- 로고 -->
			<a href="index.do" class="logo d-flex align-items-center">
				<img alt="logo" src="resources/assets/img/main_img/Logo.png">
			</a> 
			<i class="mobile-nav-toggle mobile-nav-show bi bi-list"></i>
			<i class="mobile-nav-toggle mobile-nav-hide d-none bi bi-x"></i>
			<nav id="navbar" class="navbar">
				<ul>
					<!-- <li><a href="#">관리자</a></li> -->
					<li><a href="managermemberList">회원관리</a></li>
					<li><a href="managerproduct">상품</a></li>
					<li><a href="managerquestion">문의사항</a></li>
					<li><a href="managernotice">공지사항</a></li>
					<li><a href="managerreservation">예약현황</a></li>
					<li><a href="managergraph">통계</a></li>
					<li><a href="login.do">로그인사원</a></li>
				</ul>
			</nav>
			<!-- .navbar -->

		</div>
	</header>
	<!-- End Header -->
</body>
