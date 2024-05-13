<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>UpConstruction Bootstrap Template - Index</title>
<meta content="" name="description">
<meta content="" name="keywords">

<!-- Favicons -->
<link href="${path}/resources/assets/img/favicon.png" rel="icon">
<link href="${path}/resources/assets/img/apple-touch-icon.png"
	rel="apple-touch-icon">

<!-- Google Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,600;1,700&family=Roboto:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&family=Work+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap"
	rel="stylesheet">

<!-- Vendor CSS Files -->
<link href="${path}/resources/assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${path}/resources/assets/vendor/bootstrap-icons/bootstrap-icons.css"
	rel="stylesheet">
<link href="${path}/resources/assets/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet">
<link href="${path}/resources/assets/vendor/aos/aos.css" rel="stylesheet">
<link href="${path}/resources/assets/vendor/glightbox/css/glightbox.min.css"
	rel="stylesheet">
<link href="${path}/resources/assets/vendor/swiper/swiper-bundle.min.css"
	rel="stylesheet">

<!-- Template Main CSS File -->
<link href="${path}/resources/assets/css/main.css" rel="stylesheet">

<!-- =======================================================
  * Template Name: UpConstruction
  * Template URL: https://bootstrapmade.com/upconstruction-bootstrap-construction-website-template/
  * Updated: Mar 17 2024 with Bootstrap v5.3.3
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
</head>

<body>
	<!-- 헤더 영역 불러오기 -->
	<c:import url="${path}/WEB-INF/views/header.jsp"></c:import>

	<!-- ======= Hero Section ======= -->
	<section id="insertMemberFormHero" class="hero">

		<div class="info align-items-center">

			<div class="row justify-content-center" id='insertMemberForm'>
				<div class="col-lg-6 text-center" id="blackbackground">
					<h2 data-aos="fade-down" id='insertMemberForm'>리뷰</h2>
					<form action="payForm" id='insertFrm' method="post">
						<div class="row gy-4">
							<div class="col-md-4">
								<p>예약자명</p>
							</div>
							<div class="col-md-5">
								<p><!-- 로그인 한 사람 이름 출력 --></p>
							</div>
							
							<div class="col-md-4">
								<p>전화번호</p>
							</div>
							<div class="col-md-5">
								<p><!-- 로그인 한 사람 전화번호 출력 --></p>
							</div>
							
							<div class="col-md-12">
							<hr/>
							</div>

							<div class="col-md-4">
								<p>구장명</p>
							</div>
							<div class="col-md-5">
								<p>${vo.pName }</p>
							</div>

							<div class="col-md-4">
								<p>구장위치</p>
							</div>
							<div class="col-md-5">
								<p>${vo.pLocation }</p>
							</div>

							<div class="col-md-4">
								<p>날짜</p>
							</div>
							<div class="col-md-5">
								<p>
									<!-- 날짜값 -->
								</p>
							</div>

							<div class="col-md-4">
								<p>시간대</p>
							</div>
							<div class="col-md-5">
								<p>
									<!-- 시간대값 -->
								</p>
							</div>

							<div class="col-md-12">
							<hr/>
							</div>

							<div class="col-md-12">
								<p>결제수단</p>
							</div>
							
							<div class="col-md-12">
							<p></p>
							</div>

							
							<div class="row">
							<!-- <div class="col-md-3 form-check form-check-inline"></div> -->
							<div class="col-md-4 form-check ">
								<input class="form-check-input" type="radio" name="pay"
									value="카드" checked="checked" required>
								<p>카드</p>
							</div>
							<div class="col-md-4 form-check ">
								<input class="form-check-input" type="radio" name="pay"
									value="카카오페이">
								<p>카카오페이</p>
							</div>
							<div class="col-md-4 form-check ">
								<input class="form-check-input" type="radio" name="pay"
									value="무통장입금">
								<p>무통장입금</p>
							</div>
							</div>
							<div class="col-md-12">
							<p></p>
							</div>
							
							<div class="col-md-12">
								<p>결제상세</p>
							</div>
							
							<div class="col-md-4">
								<p>결제 금액</p>
							</div>
							<div class="col-md-5">
								<p>
									<!-- 결제금액값 출력 -->
								</p>
							</div>
							
							
							
                        <div class="col-md-4"></div>
                        <div class="col-md-4 text-center">
                           <div class="error-message"></div>
                           <button type="submit" class="loginBtn">결제</button>
                        </div>
                        
                        <div class="col-md-4"></div>
						</div>
					</form>
				</div>
			</div>
		</div>


		<div id="hero-carousel" class="carousel slide"></div>
	</section>
	<!-- End Hero Section -->

	<!-- 푸터 영역 불러오기 -->
	<c:import url="${path}/WEB-INF/views/footer.jsp"></c:import>

	<a href="${path}/#"
		class="scroll-top d-flex align-items-center justify-content-center"><i
		class="bi bi-arrow-up-short"></i></a>

	<div id="preloader"></div>

	<!-- Vendor JS Files -->
	<script
		src="${path}/resources/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="${path}/resources/assets/vendor/aos/aos.js"></script>
	<script src="${path}/resources/assets/vendor/glightbox/js/glightbox.min.js"></script>
	<script
		src="${path}/resources/assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
	<script src="${path}/resources/assets/vendor/swiper/swiper-bundle.min.js"></script>
	<script
		src="${path}/resources/assets/vendor/purecounter/purecounter_vanilla.js"></script>
	<!-- <script src="${path}/resources/assets/vendor/php-email-form/validate.js"></script> -->

	<!-- Template Main JS File -->
	<script src="${path}/resources/assets/js/main.js"></script>

</body>

</html>
