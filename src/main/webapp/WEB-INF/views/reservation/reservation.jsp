<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
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
				<div class="col-lg-6 text-center">
					<h2 data-aos="fade-down" id='insertMemberForm'>예약</h2>
					<form action="payForm.do" id='insertFrm' method="post">
						<div class="row gy-4">
								<c:if test="${productList.size() > 0 }">
									<c:forEach var="i" begin="0" end="${productList.size()-1 }">
										<div class="col-md-4">
											<a href="${path}/reservationForm?pNo=${productList.get(i).pNo}">${productList.get(i).pName }<br />
												<img src="${path}/resources/productUpload/${productList.get(i).p_frealname}" alt=""
												width="300px" height="" class="img-fluid"></a>
										</div>

										<c:if test="${ i != 0 && i % 3 == 0 }">
											<br />
										</c:if>
									</c:forEach>
								</c:if>
								<div class="col-md-12" id="pageNum">
									<a href="${path}/reservation?pageNum=${pVO.pageNum-10}">이전</a>
									<c:forEach var="i" begin="${pVO.startPage }" end="${pVO.endPage }">
										<c:if test="${pVO.pageNum == i }">
											<a href="${path}/reservation?pageNum=${i}" class="paging_color">${i }</a>
										</c:if>
										<c:if test="${pVO.pageNum != i }">
											<a href="${path}/reservation?pageNum=${i}">${i }</a>
										</c:if>
									</c:forEach>
									<c:if test="${pageNum+10 >= pVO.endPage}">
										<a href="${path}/reservation?pageNum=${pVO.endPage}">다음</a>
									</c:if>
									<c:if test="${pageNum+10 < pVO.endPage}">
										<a href="${path}/reservation?pageNum=${pVO.pageNum+10}">다음</a>
									</c:if>
								</div>

							</div>
						</form>
					</div>
				</div>
			</div>

		<div id="hero-carousel" class="carousel slide"></div>
		<!-- <div id="paddingSection"></div> -->
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
