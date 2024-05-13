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

<title>notice.jsp</title>
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
	<section id="hero" class="hero">
	
    <div class="info d-flex align-items-center">
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-lg-10 text-center">
						<h2 data-aos="fade-down">공지사항</h2>
							<div class="row gy-10">
							
	<form method='get'>
		<select name='searchCondition'>
			<option value='nTitle'>제목</option>
			<option value='nContent'>내용</option>
			<option value='nWriter'>작성자</option>
		</select>
		<input type='text' name='searchKeyword'>
		<input type='submit' value='검색'>
	</form>
                    </div>
                    <div class="card-body">
                        <table class="table">
                        <div class="col-md-4 text-center"></div>
                            <div class="col-md-4 text-center">
                                <div class="error-message"></div>
                            </div>
                            <div class="col-md-4 text-center"></div>
                            
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <thead>
        <tr>
        	<th>No.</th>
            <th>Title</th>
            <th>Writer</th>
        </tr>
    </thead>
    <c:forEach items="${notice }" var="notice">
    	<tr>
    		<td>${notice.nNo }</td>
    		<td align="notice"><a href="${path}/getNotice?nNo=${notice.nNo }">
    		${notice.nTitle }</a></td>
    		<td>${notice.nWriter }
    		</td>
    	</tr>
    </c:forEach>
        	</table>
            	</div>
            		</div>
           		 		</div>
        					</div>
   								</div>
    
    <div id="hero-carousel" class="carousel slide" data-bs-ride="carousel"
			data-bs-interval="5000">

			<div class="carousel-item active"
				style="background-image: url(${path}/resources/assets/img/main_img/main_arena_1.jpg)"></div>
			<div class="carousel-item"
				style="background-image: url(${path}/resources/assets/img/main_img/main_arena_2.jpg)"></div>
			<div class="carousel-item"
				style="background-image: url(${path}/resources/assets/img/main_img/main_arena_3.jpg)"></div>
			<div class="carousel-item"
				style="background-image: url(${path}/resources/assets/img/main_img/main_arena_4.jpg)"></div>
			<div class="carousel-item"
				style="background-image: url(${path}/resources/assets/img/main_img/main_arena_5.jpg)"></div>

			<a class="carousel-control-prev" href="#hero-carousel" role="button"
				data-bs-slide="prev"> <span
				class="carousel-control-prev-icon bi bi-chevron-left"
				aria-hidden="true"></span>
			</a> <a class="carousel-control-next" href="#hero-carousel" role="button"
				data-bs-slide="next"> <span
				class="carousel-control-next-icon bi bi-chevron-right"
				aria-hidden="true"></span>
			</a>

		</div>

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