<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<title>header</title>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#navbar > ul > li a').click(function() {
			/* console.log($(this).text());
			$('#navbar > ul > li').find('a[class="active"]').removeClass();
			$(this).addClass('active'); */
		});
	});
</script>
</head>
<body>
	<!-- ======= Header ======= -->
	<header id="header" class="header d-flex align-items-center">
		<div class="container-fluid container-xl d-flex align-items-center justify-content-between">
			
			<!-- 로고 -->
			<a href="${path}/index" class="logo">
				<img alt="logo" src="${path}/resources/assets/img/main_img/Logo.png">
			</a> 
			<i class="mobile-nav-toggle mobile-nav-show bi bi-list"></i>
			<i class="mobile-nav-toggle mobile-nav-hide d-none bi bi-x"></i>
			<nav id="navbar" class="navbar">
				<ul>
					
					<!-- <li><a href="${path}/#">관리자</a></li> -->
					<li><a href="${path}/#" class="active">소개</a></li>
					<li><a href="${path}/reservation?id=${sessionScope.logid}">예약</a></li>
					<li><a href="${path}/coming?id=${sessionScope.logid}">오시는 길</a></li>
					<li><a href="${path}/question?id=${sessionScope.logid}">문의</a></li>
					<li><a href="${path}/notice?id=${sessionScope.logid}">공지사항</a></li>
					<li><a href="${path}/#">예약확인/취소</a></li>
					<li><a href="${path}/review?id=${sessionScope.logid}">리뷰</a></li>
					<li><a href="${path}/mypage?id=${sessionScope.logid}">마이페이지</a></li>
					
					<!-- 관리자페이지 -->
					<li class="dropdown">
						<c:if test="${sessionScope.logid.equals('admin') }">
								<li class="dropdown">
									<a href="${path}/manager.do"><span>관리자페이지</span>
										<i class="bi bi-chevron-down dropdown-indicator"></i>
									</a>
									<ul>
										<li><a href="${path}/managermemberList">회원관리</a></li>
										<li><a href="${path}/managerproduct">상품</a></li>
										<li><a href="${path}/question">문의사항</a></li>
										<li><a href="${path}/notice">공지사항</a></li>
										<li><a href="${path}/managerreservation">예약현황</a></li>
										<li><a href="${path}/managergraph">통계</a></li>
									</ul>
								</li>
						</c:if>
					</li>
					<c:if test="${sessionScope.logid == null }">
	                    <li><a href="${path}/login">로그인</a></li>
	                </c:if>
	                <c:if test="${sessionScope.logid != null }">
	                    <li><a href="${path}/logout">로그아웃</a></li>
	                </c:if>
				</ul>
			</nav>
			<!-- .navbar -->
		</div>
	</header>
	<!-- End Header -->
</body>
