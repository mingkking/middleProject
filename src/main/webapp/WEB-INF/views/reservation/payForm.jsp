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
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script type="text/javascript">
	$(function() {
		let accountCheck = 0; // 무통장 입금 확인
		
		$('input[type=radio]').change(function() {
			let check = $("input[type=radio]:checked").val();
			if(check == '핸드폰'){
				$('#account').text('');
			}
			
			if(check == '카카오페이'){
				$('#account').text('');
			}
			
			if(check == '무통장입금'){
				$('#account').text('입금주:홍길동 / 신한은행 / 계좌번호:110110123456 으로 입금해주세요.');
				
				// 시간 지연 함수
				setTimeout(function() {
					accountCheck = 1; // 무통장 입금 완료 확인
				}, 10000); // 15초 뒤에 완료
			}
		});
		
		$('.loginBtn').click(function() {
			let check = $("input[type=radio]:checked").val();
			
			if(check == '핸드폰'){
				iamport2();
			}
			
			if(check == '카카오페이'){
				iamport();
			}
			
			if(check == '무통장입금'){
				let param = $('#insertFrm').serialize();
				if(accountCheck == 1){
					$.ajax({
						type : 'post',
						url : 'insertAccountReservation',
						data : param,
						dataType : 'json', // 응답 데이타 종류 (text/html/xml/json.....)
						success : function(result) {
							if(result == '1'){
								alert('무통장입금으로 예약되었습니다.');
								location.href="index";
							}
						},
						error : function(err) {
							alert('무통장입금으로 예약이 실패하였습니다.');
							console.log(err);
						}
					});
				}else{
					alert('적혀있는 계좌로 입금을 해주세요.');
				}
				
			}
			
		});
		
		function iamport(){
			//가맹점 식별코드
			IMP.init('imp01534004');
			IMP.request_pay({
			    pg : 'kakaopay',
			    pay_method : 'card',
			    merchant_uid : 'merchant_' + new Date().getTime(),
			    name : $('#pName').val(), //결제창에서 보여질 이름
			    amount : 1, //실제 결제되는 가격
			    buyer_email : 'iamport@siot.do',
			    buyer_name : $('#name').val(),
			    buyer_tel : $('#tel').val(),
			    buyer_addr : '서울 강남구 도곡동',
			    buyer_postcode : '123-456'
			}, function(rsp) {
			    if ( rsp.success ) {
			    	let param = $('#insertFrm').serialize();
			    	
					$.ajax({
						type : 'post',
						url : 'insertKakaoPayReservation',
						data : param,
						dataType : 'json', // 응답 데이타 종류 (text/html/xml/json.....)
						success : function(result) {
							if(result == '1'){
								alert('카카오페이 결제성공 구장예약이 완료되었습니다.');
								location.href="index";
							}
						},
						error : function(err) {
							alert('카카오페이 결제성공 구장예약이 실패하였습니다.');
							console.log(err);
						}
					});
					
			    } else {
			    	alert('결제에 실패하였습니다.');
			    }
			    
			});
		}
		
		function iamport2(){
			//가맹점 식별코드
			IMP.init('imp01534004');
			IMP.request_pay({
			    pg : 'kicc',
			    pay_method : 'phone',
			    merchant_uid : 'merchant_' + new Date().getTime(),
			    name : $('#pName').val(), //결제창에서 보여질 이름
			    amount : 10000, //실제 결제되는 가격
			    buyer_email : 'iamport@siot.do',
			    buyer_name : $('#name').val(),
			    buyer_tel : $('#tel').val(),
			    buyer_addr : '서울 강남구 도곡동',
			    buyer_postcode : '123-456'
			}, function(rsp) {
			    if ( rsp.success ) {
					let param = $('#insertFrm').serialize();
			    	
					$.ajax({
						type : 'post',
						url : 'insertPhoneReservation',
						data : param,
						dataType : 'json', // 응답 데이타 종류 (text/html/xml/json.....)
						success : function(result) {
							if(result == '1'){
								alert('핸드폰 결제성공 구장예약이 완료되었습니다.');
								location.href="index";
							}
						},
						error : function(err) {
							alert('핸드폰 결제성공 구장예약이 실패하였습니다.');
							console.log(err);
						}
					});
			    	
			    } else {
			    	alert('결제에 실패하였습니다.');
			    }
			    
			});
		}
		
	});
</script>
</head>

<body>

	<!-- 헤더 영역 불러오기 -->
	<c:import url="${path}/WEB-INF/views/header.jsp"></c:import>

	<!-- ======= Hero Section ======= -->
	<section id="insertMemberFormHero" class="hero">

		<div class="info align-items-center">

			<div class="row justify-content-center" id='insertMemberForm'>
				<div class="col-lg-6 text-center" id="blackbackground">
					<h2 data-aos="fade-down" id='insertMemberForm'>결제</h2>
					<form action="payForm" id='insertFrm' method="post">
						<div class="row gy-4">
							<div class="col-md-4">
								<p>예약자명</p>
							</div>
							<div class="col-md-5">
								<input type="text" name="name" id="reservationBorder" class="form-control" value="${memberVO.name}" readonly="readonly">
							</div>
							
							<div class="col-md-4">
								<p>전화번호</p>
							</div>
							<div class="col-md-5">
								<input type="text" name="tel" id="reservationBorder" class="form-control" value="${memberVO.tel}" readonly="readonly">
							</div>
							
							<div class="col-md-12">
							<hr/>
							</div>

							<div class="col-md-4">
								<p>구장명</p>
							</div>
							<div class="col-md-5">
								<input type="text" name="pName" id="reservationBorder" class="form-control" value="${productVO.pName}" readonly="readonly">
							</div>

							<div class="col-md-4">
								<p>구장위치</p>
							</div>
							<div class="col-md-5">
								<input type="text" name="pLocation" id="reservationBorder" class="form-control" value="${productVO.pLocation}" readonly="readonly">
							</div>

							<div class="col-md-4">
								<p>날짜</p>
							</div>
							<div class="col-md-5">
								<input type="text" name="rental" id="reservationBorder" class="form-control" value="${reservationVO.rental}" readonly="readonly">
							</div>

							<div class="col-md-4">
								<p>시간대</p>
							</div>
							<div class="col-md-5">
								<input type="text" name="time" id="reservationBorder" class="form-control" value="${time}" readonly="readonly">
							</div>

							<div class="col-md-12">
							<hr/>
							</div>

							<div class="col-md-12">
								<h4>결제수단</h4>
							</div>
							
							<div class="col-md-12">
							<p></p>
							</div>

							
							<div class="row">
							<!-- <div class="col-md-3 form-check form-check-inline"></div> -->
							<div class="col-md-4 form-check ">
								<input class="form-check-input" type="radio" name="rPayMethod" value="핸드폰" checked="checked" required>
								<div>핸드폰</div>
							</div>
							<div class="col-md-4 form-check ">
								<input class="form-check-input" type="radio" name="rPayMethod" value="카카오페이">
								<div>카카오페이</div>
							</div>
							<div class="col-md-4 form-check ">
								<input class="form-check-input" type="radio" name="rPayMethod" value="무통장입금">
								<div>무통장입금</div>
							</div>
							</div>
							
							<div class="col-md-12">
							<p id="account"></p>
							</div>
							<div class="col-md-12">
							<p id="account"></p>
							</div>

							<div class="col-md-12">
								<h4>결제상세</h4>
							</div>
							
							<div class="col-md-4">
								<p>결제 금액</p>
							</div>
							<div class="col-md-5">
								<input type="text" name="totalMoney" id="reservationBorder" class="form-control" value="${reservationVO.totalMoney}" readonly="readonly">
							</div>
							<div class="col-md-12">
							<p id="account"></p>
							</div>
							<div class="col-md-12">
							<p id="account"></p>
							</div>
							
							
							
                        <div class="col-md-4"></div>
                        <div class="col-md-4 text-center">
                           <div class="error-message"></div>
                           <input type="hidden" name="pNo" value="${reservationVO.pNo }">
                           <button type="button" class="loginBtn">결제</button>
                        </div>
                        
                        <div class="col-md-4"></div>
						</div>
					</form>
				</div>
			</div>
		</div>


		<div id="hero-carousel" class="carousel slide"></div>
		<div id="paddingSection"></div>
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