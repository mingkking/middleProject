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

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('.productDetail').click(function(e) {
			e.preventDefault();

			let pNo = $(this).parent().find("input[type='hidden']").val();

			$.ajax({
				type : 'post',
				url : 'productDetail',
				data : {
					'pNo' : pNo
				},
				dataType : 'json', // 응답 데이타 종류 (text/html/xml/json.....)
				success : function(result) {
					console.log(result);
					$('#productVOPname').text(result.pName);
					$('#productVOPLocation').text(result.pLocation);
					$('#productVOPInfo').text(result.pInfo);
				},
				error : function(err) {
					alert('에러발생');
					console.log(err);
				}
			});

		});
	});
</script>

</head>

<body>
	<!-- 헤더 영역 불러오기 -->
	<c:import url="${path}/WEB-INF/views/header.jsp"></c:import>

	<!-- ======= Hero Section ======= -->
	<section id="hero" class="hero">

		<div class="info d-flex align-items-center">
			<div class="container">
				<div class="row justify-content-center" id="comming_grid">
					<div class="col-lg-6 text-center">
						<h2 data-aos="fade-down">오시는 길</h2>

						<div class="row gy-4">

							<!-- product 전체 목록 -->
							<c:if test="${productList.size() > 0 }">
								<c:forEach var="i" begin="0" end="${productList.size()-1 }">
									<div class="col-md-2">
										<input type="hidden" id="pNo_${productList.get(i).pNo}"
											value="${productList.get(i).pNo }"> <a
											class="productDetail" href="#">${productList.get(i).pName }</a>
									</div>
									<c:if test="${ i != 0 && i % 6 == 0 }">
										<br />
										<br />
										<br />
									</c:if>
								</c:forEach>
							</c:if>

							<div class="content">
								<p>
									<img src="${path}/resources/assets/img/stadium.png" alt=""
										class="stadiumAdd">
								</p>
							</div>
						</div>

						<!-- ajax 상품 상세 정보 -->
						<div class="col-md-12">
							<h4 id="productVOPname"></h4>
							<div class="col-md-12">
									<div class="col-md-12">
										<p></p>
									</div>
								<div class="row">
									<div class="col-md-5" ></div>
									<div class="col-md-7" id="productVOPLocation">
										<p></p>
									</div>
								</div>
								<div class="row">
									<div class="col-md-5" ></div>
									<div class="col-md-7" id="productVOPInfo">
										<p></p>
									</div>
								</div>
							</div>
							<div class="col-md-12" id="pageNum">
								<c:forEach var="i" begin="${pVO.startPage }" end="${pVO.endPage }">
									<c:if test="${sessionScope.logid == null }">
										<a href="${path}/coming?pageNum=${i}&id=${id}">${i }</a>
									</c:if>
									<c:if test="${sessionScope.logid != null }">
										<a href="${path}/coming?pageNum=${i}&id=${sessionScope.logid}">${i }</a>
									</c:if>
								</c:forEach>
							</div>
						</div>

					</div>
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
