<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>getNotice.jsp</title>
<meta content="" name="description">
<meta content="" name="keywords">

<!-- Favicons -->
<link href="resources/assets/img/favicon.png" rel="icon">
<link href="resources/assets/img/apple-touch-icon.png"
	rel="apple-touch-icon">

<!-- Google Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,600;1,700&family=Roboto:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&family=Work+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap"
	rel="stylesheet">

<!-- Vendor CSS Files -->
<link href="resources/assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="resources/assets/vendor/bootstrap-icons/bootstrap-icons.css"
	rel="stylesheet">
<link href="resources/assets/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet">
<link href="resources/assets/vendor/aos/aos.css" rel="stylesheet">
<link href="resources/assets/vendor/glightbox/css/glightbox.min.css"
	rel="stylesheet">
<link href="resources/assets/vendor/swiper/swiper-bundle.min.css"
	rel="stylesheet">

<!-- Template Main CSS File -->
<link href="resources/assets/css/main.css" rel="stylesheet">

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
	<section id="hero" class="hero">

		<div class="info d-flex align-items-center">
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-lg-6 text-center">
						<h2 data-aos="fade-down">공지 상세</h2>
						<form method="post" action="${path}/managerUpdateNotice">
							<div class="row gy-4">

								<div class="col-md-4">
									<p type='hidden'></p>
								</div>
								<div class="col-md-8">
									<input type="hidden" name="nNo" class="form-control"
										value='${notice.nNo }'>
								</div>

								<div class="col-md-4">
									<p>작성일시</p>
								</div>
								<div class="col-md-8">
									<input type="text" name="nRegdate" class="form-control"
										value='${notice.nRegdate }' readonly>
								</div>
								<c:if test="${sessionScope.logid == 'admin'}">
									<div class="col-md-4">
										<p>제목</p>
									</div>
									<div class="col-md-8">
										<input type="text" class="form-control" name="nTitle"
											placeholder="제목을 입력해주세요." value='${notice.nTitle }' required />
									</div>
	
									<div class="col-md-4">
										<p>공지 내용</p>
									</div>
									<div class="col-md-8">
										<textarea name="nContent" class="form-control" rows="5"
											placeholder="공지내용을 입력해주세요." required>${notice.nContent }</textarea>
									</div>
								</c:if>
								<c:if test="${sessionScope.logid != 'admin'}">
									<div class="col-md-4">
										<p>제목</p>
									</div>
									<div class="col-md-8">
										<input type="text" class="form-control" name="nTitle"
											placeholder="제목을 입력해주세요." value='${notice.nTitle }' readonly="readonly"/>
									</div>
	
									<div class="col-md-4">
										<p>공지 내용</p>
									</div>
									<div class="col-md-8">
										<textarea name="nContent" class="form-control" rows="5"
											placeholder="공지내용을 입력해주세요." required readonly="readonly">${notice.nContent }</textarea>
									</div>
								</c:if>
								
								<div class="col-md-4 text-center"></div>
								<div class="col-md-4 text-center">
									<div class="error-message"></div>
									<c:if test="${sessionScope.logid == 'admin'}">
										<input type="submit" class="finalBtn" value='수정'>
										<a href='${path}/managerDeleteNotice?nNo=${notice.nNo}'><input type="button" class="finalBtn" value='삭제'></a>
									</c:if>
									<a href='${path}/notice'><input type='button' class="finalBtn" value='닫기'></a>
								</div>
								<div class="col-md-4 text-center"></div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>

		<div id="hero-carousel" class="carousel slide"></div>

	</section>
	<!-- End Hero Section -->

	<!-- 푸터 영역 불러오기 -->
	<c:import url="${path}/WEB-INF/views/footer.jsp"></c:import>

	<a href="#"
		class="scroll-top d-flex align-items-center justify-content-center"><i
		class="bi bi-arrow-up-short"></i></a>

	<div id="preloader"></div>

	<!-- Vendor JS Files -->
	<script
		src="resources/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="resources/assets/vendor/aos/aos.js"></script>
	<script src="resources/assets/vendor/glightbox/js/glightbox.min.js"></script>
	<script
		src="resources/assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
	<script src="resources/assets/vendor/swiper/swiper-bundle.min.js"></script>
	<script
		src="resources/assets/vendor/purecounter/purecounter_vanilla.js"></script>
	<!-- <script src="resources/assets/vendor/php-email-form/validate.js"></script> -->

	<!-- Template Main JS File -->
	<script src="resources/assets/js/main.js"></script>

</body>

</html>