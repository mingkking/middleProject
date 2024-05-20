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
<link
	href="${path}/resources/assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="${path}/resources/assets/vendor/bootstrap-icons/bootstrap-icons.css"
	rel="stylesheet">
<link
	href="${path}/resources/assets/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet">
<link href="${path}/resources/assets/vendor/aos/aos.css"
	rel="stylesheet">
<link
	href="${path}/resources/assets/vendor/glightbox/css/glightbox.min.css"
	rel="stylesheet">
<link
	href="${path}/resources/assets/vendor/swiper/swiper-bundle.min.css"
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
		let now_utc = Date.now() // 지금 날짜를 밀리초로
		// getTimezoneOffset()은 현재 시간과의 차이를 분 단위로 반환
		let timeOff = new Date().getTimezoneOffset()*60000; // 분단위를 밀리초로 변환
		// new Date(now_utc-timeOff).toISOString()은 '2022-05-11T18:09:38.134Z'를 반환
		let today = new Date(now_utc-timeOff).toISOString().split("T")[0];
		$("#rental").attr("min", today);
	});
	
	// ajax 달력 클릭 시 선택할 수 있는 시간만 나오게
	$(function() {
	    $('#rental').change(function() {
	        let rental = $('#rental').val();
	        let pNo = $('#pNo').val();
	        console.log(rental + " " + pNo);
	
	        $.ajax({
	            type : 'get',
	            url : 'selectListTime',
	            data : { 'rental' : rental, 'pNo' : pNo },
	            dataType : 'json',
	            success : function(result){
	                let obj = ['10:00 - 12:00', '12:00 - 14:00', '14:00 - 16:00', '16:00 - 18:00', '18:00 - 20:00', '20:00 - 22:00'];
	                let time = $('#time'); // 시간 select 태그 아이디를 가져오기
	                time.empty(); // 기존 옵션 삭제
	
	                for(let timeSlot of obj) {
	                    let isOverlap = false;
	                    for(let row of result) {
	                        let startTime = row['start_time'] + ":00";
	                        let endTime = row['end_time'] + ":00";
	                        let serverTimeSlot = startTime + " - " + endTime;
	
	                        if (timeSlot === serverTimeSlot) {
	                            isOverlap = true;
	                            break;
	                        }
	                    }
	                    if (!isOverlap) {
	                        let option = $('<option/>').text(timeSlot); // 겹치지 않는 시간만 옵션에 추가
	                        time.append(option); // 옵션 추가
	                    }
	                }
	            },
	            error : function(err){
	                alert('error');
	                console.log(err);
	                console.log('test2');
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

		<div class="info align-items-center">
			<div class="container">
				<div class="row justify-content-center" id='reservationFormPadding'>
					<div class="col-lg-6 text-center">
						<h2 data-aos="fade-down">구장 상세보기</h2>
						<form action="payForm" method="post">
							<div class="row gy-4">

								<div class="col-md-6">
									<img src="${path}/resources/productUpload/${vo.p_frealname}" alt=""
										width="300px" height="" class="img-fluid">
								</div>
								<div class="col-md-6">

									<div class="row" class="reservationPadding">
										<div class="col-md-5">구장명 :</div>
										<div class="col-md-7">     
											<input type="text" name="pName" class="form-control reservationBorder" value="${vo.pName}" readonly="readonly">
										</div>
									</div>
									<div class="row" class="reservationPadding">
										<div class="col-md-5">구장위치 :</div>
										<div class="col-md-7">
											<input type="text" name="pLocation" class="form-control reservationBorder" value="${vo.pLocation}" readonly="readonly">
										</div>
									</div>
									<div class="row" class="reservationPadding">
										<div class="col-md-5">구장정보 :</div>
										<div class="col-md-7">
											<input type="text" name="pLocation" class="form-control reservationBorder" value="${vo.pInfo}" readonly="readonly">
										</div>
									</div>

									<div class="row" class="reservationPadding">
										<div class="col-md-5">날짜 선택 :</div>
										<div class="col-md-7">
											<input type="date" name="rental" id="rental"
												class="form-control" required />
										</div>
									</div>

									<div class="row" class="reservationPadding">
										<div class="col-md-5">시간대 선택 :</div>
										<div class="col-md-7">
											<select name="time" id="time" class="form-control">
												<option value="1012">10:00 - 12:00</option>
												<option value="1214">12:00 - 14:00</option>
												<option value="1416">14:00 - 16:00</option>
												<option value="1618">16:00 - 18:00</option>
												<option value="1820">18:00 - 20:00</option>
												<option value="2022">20:00 - 22:00</option>
											</select>
										</div>
									</div>

									<div class="row" class="reservationPadding">
										<div class="col-md-5">총 금액 :</div>
										<div class="col-md-7">
											<input type="text" name="totalMoney" class="form-control reservationBorder" value="${vo.pPrice}" readonly="readonly">
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 reservationPadding">
											<input type="hidden" name="pNo" id="pNo" value="${vo.pNo }">
											<button type="submit" class="findIdBtn">예약</button>
										</div>
									</div>

								</div>
							</div>
						</form>
					</div>
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
	<script
		src="${path}/resources/assets/vendor/glightbox/js/glightbox.min.js"></script>
	<script
		src="${path}/resources/assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
	<script
		src="${path}/resources/assets/vendor/swiper/swiper-bundle.min.js"></script>
	<script
		src="${path}/resources/assets/vendor/purecounter/purecounter_vanilla.js"></script>
	<!-- <script src="${path}/resources/assets/vendor/php-email-form/validate.js"></script> -->

	<!-- Template Main JS File -->
	<script src="${path}/resources/assets/js/main.js"></script>

</body>

</html>
