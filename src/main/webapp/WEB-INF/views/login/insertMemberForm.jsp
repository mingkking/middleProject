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

<!-- 유효성 검사 -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">

	$(function() {
		// 달력 오늘 날짜 이후 꺼는 선택 금지
		let now_utc = Date.now() // 지금 날짜를 밀리초로
		// getTimezoneOffset()은 현재 시간과의 차이를 분 단위로 반환
		let timeOff = new Date().getTimezoneOffset()*60000; // 분단위를 밀리초로 변환
		// new Date(now_utc-timeOff).toISOString()은 '2022-05-11T18:09:38.134Z'를 반환
		let today = new Date(now_utc-timeOff).toISOString().split("T")[0];
		$("#birth").attr("max", today);
		// 달력 오늘 날짜 이후 꺼는 선택 금지

		// 아이디 유효성 검사 및 중복검사
		$('#idCheck').click(function() {
			let id = $('#id').val();
			
			if (id == "") {
				$('.id-message').text('아이디를 입력해주세요.');
				return;
			}
			
			if(!id.match(/^[a-zA-Z0-9_]{6,16}$/)){
				$('.id-message').text('아이디 형식이 맞지 않습니다.');
				return;
			}

			$.ajax({
				type : 'get',
				data : {
					'id' : id
				},
				url : 'selectCheckID',
				success : function(result) {
					if (result == '1') {
						$('.id-message').text("이미 사용중인 아이디입니다.");
						$('#id').focus();
					} else {
						$('#id').attr('readonly', true);
						$('#idCheck').attr('disabled', true);
						$('.id-message').text("");
						alert("사용 가능한 아이디입니다.");
					}
				},
				error : function(err) {
					console.log(err);
				}
			}); // ajax
		}); // idCheckclick

		$('#telCheck').click(function() {
			let tel1 = $('#tel1').val();
			let tel2 = $('#tel2').val();
			let tel3 = $('#tel3').val();
			let tel = tel1 + tel2 + tel3;

			if (tel == "") {
				$('.tel-message').text("번호를 입력해주세요.");
				return;
			}
		    if (!tel.match(/^01[016789][ -]?\d{3,4}[ -]?\d{4}$/)) {
		        $('.tel-message').text('번호 형식이 맞지 않습니다.');
		        return;
		    } 
		    
			$.ajax({
				type : 'get',
				data : {
					'tel' : tel
				},
				url : 'selectCheckTel',
				success : function(result) {
					if (result == '1') {
						$('.tel-message').text("이미 등록된 번호입니다.");
						$('#tel1').focus();
					} else {
						$('#tel1').attr('readonly', true);
						$('#tel2').attr('readonly', true);
						$('#tel3').attr('readonly', true);
						$('#telCheck').attr('disabled', true);
						$('.tel-message').text("");
						alert("사용 가능한 번호입니다.");
					}
				},
				error : function(err) {
					console.log(err);
				}
			}); // ajax

		}); // idCheckclick

		$('#emailCheck').click(function() {
			let email = $('#email').val();

			console.log(email);

			if (email == "") {
				$('.email-message').text("메일을 입력해주세요.");
				return;
			}
			if (!email.match(/^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/)) {
				console.log('no');
				$('.email-message').text('메일 형식이 맞지 않습니다.');
				return;
			} 
					
			$.ajax({
				type : 'get',
				data : {
					'email' : email
				},
				url : 'selectCheckEmail',
				success : function(result) {
					if (result == '1') {
						$('.email-message').text(
								"이미 등록된 메일입니다.");
						$('#email').focus();
					} else {
						$('#email').attr('readonly',
								true);
						alert("사용 가능한 메일입니다.");
						$('.email-message').text("");
					}
				},
				error : function(err) {
					console.log(err);
				}
			}); // ajax

		}); // idCheckclick

		$('.loginBtn').click(function(e) {
			// submit 의 이벤트를 막기
			e.preventDefault();
			e.stopPropagation();

			// 아이디 중복검사를 아직 안 한 경우
			if ($('#id').attr('readonly') != 'readonly') {
				alert("아이디 중복검사를 완료해주세요.");
				return;
			}

			// 전화번호 중복검사를 아직 안 한 경우
			if ($('#tel1').attr('readonly') != 'readonly') {
				alert("전화번호 중복검사를 완료해주세요.");
				return;
			}
			
			let name = $('#name').val();
			if(!name.match(/^[가-힣]{2,5}$/)){
				$('.name-message').text('이름 형식이 맞지 않습니다.');
				return;
			}
			$('.name-message').text('');
			
			if($('#birth').val() == ""){
				$('.birth-message').text('생년 월일을 선택해주세요.');
				return;
			}
			$('.birth-message').text('');

			// 이메일 중복검사를 아직 안 한 경우
			if ($('#email').attr('readonly') != 'readonly') {
				alert("email 중복검사를 완료해주세요.");
				return;
			}
			
			// 비밀번호 체크
			let pw = $('#pw').val();
			let pw1 = $('#pw1').val();
			if(pw == "" || pw1 == ""){
				$('.pwcheck-message').text('비밀번호를 입력해주세요.');
				return;
			}
			if(pw != pw1){
				$('.pwcheck-message').text('비밀번호가 같아야 합니다.');
				return;
			}
			if(!pw.match(/^(?=.*[a-z])(?=.*\d)[a-z\d]{8,}$/)){
				$('.pwcheck-message').text('비밀번호 형식이 맞지 않습니다.');
				return;
			}
			$('.pwcheck-message').text('');
			
			// 약관 동의 안한 경우
			let agree = $('input[id="memberAgree"]:checked').val();
			console.log(agree);
			if (agree != 'agree') {
				alert("약관에 동의해주세요");
				return;
			}
			
			// 여기까지 왔으면 회원가입 가능하게
			alert("회원가입이 완료되었습니다.");
			insertFrm.submit();
			

		});

	}); // function
</script>


</head>

<body>

	<!-- 헤더 영역 불러오기 -->
	<c:import url="${path}/WEB-INF/views/header.jsp"></c:import>

	<!-- ======= Hero Section ======= -->
	<section id="insertMemberFormHero" class="hero">

		<div class="info align-items-center">
			<div class="container">
				<div class="row justify-content-center" id='insertMemberForm'>
					<div class="col-lg-6 text-center">
						<h2 data-aos="fade-down" id='insertMemberForm'>회원가입</h2>
						<form action="insertMember" id='insertFrm' method="post">
							<div class="row gy-4">

								<div class="col-md-4">
									<p>아이디</p>
								</div>
								<div class="col-md-6">
									<input type="text" name="id" id="id" class="form-control" placeholder="영어+숫자, 6~16자리"/>
								</div>
								<div class="col-md-2">
									<button type="button" id="checkInfo" class="form-control btn btn-primary">중복검사</button>
								</div>

								<div class="row">
									<div class="col-md-12">
										<div class="id-message"></div>
									</div>
								</div>
								<div class="col-md-4">
									<p>휴대폰번호</p>
								</div>
								<div class="col-md-2">
									<input type="text" name="tel1" id="tel1" class="form-control" placeholder="010" />
								</div>
								<div class="col-md-2">
									<input type="text" name="tel2" id="tel2" class="form-control" placeholder="1234" />
								</div>
								<div class="col-md-2">
									<input type="text" name="tel3" id="tel3" class="form-control" placeholder="5678" />
								</div>
								<div class="col-md-2">
									<button type="button" id="checkInfo" class="form-control btn btn-primary">중복검사</button>
								</div>
								<div class="row">
									<div class="col-md-12">
										<div class="tel-message"></div>
									</div>
								</div>
								
								<div class="col-md-4">
									<p>이름</p>
								</div>
								<div class="col-md-4">
									<input type="text" name="name" id="name" class="form-control" />
								</div>
								<div class="col-md-4"></div>
								<div class="row">
									<div class="col-md-12">
										<div class="name-message"></div>
									</div>
								</div>

								<div class="col-md-4">
									<p>성별</p>
								</div>
								<div class="col-md-4 form-check form-check-inline">
									<input class="form-check-input" type="radio" name="gender" value="남자" checked="checked">
									<p>남자</p>
								</div>
								<div class="col-md-3 form-check form-check-inline">
									<input class="form-check-input" type="radio" name="gender" value="여자">
									<p>여자</p>
								</div>

								<div class="col-md-4">
									<p>생년월일</p>
								</div>
								<div class="col-md-8">
									<input type="date" name="birth" id="birth" class="form-control" />
								</div>
								<div class="row">
									<div class="col-md-12">
										<div class="birth-message"></div>
									</div>
								</div>

								<div class="col-md-4">
									<p>이메일</p>
								</div>
								<div class="col-md-6">
									<input type="text" class="form-control" id="email" name="email"
										placeholder="abc@naver.com" />
								</div>
								<div class="col-md-2">
									<button type="button" id="checkInfo" class="form-control btn btn-primary">중복검사</button>
								</div>
								<div class="row">
									<div class="col-md-12">
										<div class="email-message"></div>
									</div>
								</div>

								<div class="col-md-4">
									<p>비밀번호</p>
								</div>
								<div class="col-md-8">
									<input type="password" class="form-control" id="pw" name="password" placeholder="소문자+숫자, 7~14자리" />
								</div>
								<div class="row">
									<div class="col-md-12">
										<div class="pw-message"></div>
									</div>
								</div>

								<div class="col-md-4">
									<p>비밀번호확인</p>
								</div>
								<div class="col-md-8">
									<input type="password" class="form-control" name="password1" id="pw1" placeholder="소문자+숫자, 7~14자리" />
								</div>
								<div class="row">
									<div class="col-md-12">
										<div class="pwcheck-message"></div>
									</div>
								</div>

								<div class="col-md-4">
									<p>
										개인정보처리방침<br /> 및 이용약관 동의
									</p>
								</div>
								<div class="col-md-3 form-check form-check-inline">
									<input class="form-check-input" type="radio" id="memberAgree" value="agree"/>
									<p>동의</p>
								</div>
								<div class="col-md-4"></div>

								<div class="col-md-4"></div>
								<div class="col-md-4 text-center">
									<div class="error-message"></div>
									<button type="submit" class="loginBtn">회원가입</button>
								</div>
								<div class="col-md-4"></div>

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
