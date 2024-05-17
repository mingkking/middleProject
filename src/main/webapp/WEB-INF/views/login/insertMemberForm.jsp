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

<!-- 유효성 검사 -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">
	/* $(function() {
	 let idP = "^[a-z0-9]{5,10}$" // 아이디 유효성 패턴
	 let nameP = "^[가-힣]{2,5}$"; // 한글이름 유효성 패턴
	 let emailP = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$"; // email
	 let pwP = "^[a-z0-9]{7,15}$" // 비밀번호 유효성 패턴
	
	 $('.loginBtn').click(function(e) {
	 e.preventDefault();
	 e.stopPropagation();
	
	 let id = $('#id').val();
	 let email = $('').val();
	
	 if(!id.match(idP)){
	 alert("아이디를 형식에 맞게 입력해주세요");
	 // $('.id-message').text("틀렸어");
	 return;
	 }
	
	 if(!email.match(emailP)){
	 alert("이메일을 형식에 맞게 입력해주세요");
	 // $('.id-message').text("틀렸어");
	 return;
	 }

	 $('#insertFrm').submit();
	 alert("회원가입이 완료되었습니다!");
	
	 });
	 });
	 */

	$(function() {
		let checkId = 0; // id 유효성
		let checkName = 0; // 이름 유효성
		let checkEmail = 0; // email 유효성
		let checkPassword = 0; // password 유효성
		let checkPasswordDupl = 0; // password password확인 비교

		// ID
		function idCheck() {
			var id = $('#id').val();
			var idResult = $('.id-message');

			var idP = "^[a-z0-9]{5,10}$" // 아이디 유효성 패턴

			if (!id.match(idP)) {
				idResult.text("영어 소문자, 숫자를 포함하여 5~10자 이내 작성");
				$('#idCheck').attr('disabled', true); // 중복검사
				checkId = 0;
			} else {
				idResult.text('');
				$('#idCheck').attr('disabled', false);
				checkId = 1;
			}
		} // idCheck()

		$('#id').blur(function() {
			idCheck();
			if ($('#id').val() == '') {
				$('.id-message').text('');
				$('#id').val('');
			}
		}); // id blur

		// 이름
		function nameCheck() {
			var name = $('#name').val();
			var nameResult = $('.name-message')

			var nameP = "^[가-힣]{2,5}$"; // 이름

			if (!name.match(nameP)) {
				nameResult.text("2~5 한글만 가능합니다.");
				checkName = 0;
			} else {
				nameResult.text('');
				checkName = 1;
			}
		}
		; // nameCheck()

		$('#name').blur(function() {
			nameCheck();
			if ($('#name').val() == '') {
				$('.name-message').text('');
				$('#name').val('');
			}
		}); // blur

		// pw
		function pwCheck() {
			var pw = $('#pw').val();
			var pwResult = $('.pw-message');

			var pwP = "^[a-z0-9]{7,15}$" // 비밀번호 유효성 패턴

			if (!pw.match(pwP)) {
				pwResult.text('영어 소문자, 숫자를 포함하여 7~15자 이내 작성');
				checkPassword = 0;
			} else {
				pwResult.text('');
				checkPassword = 1;
			}
		}
		; // pwCheck()

		$('#pw').blur(function() {
			pwCheck();
			if ($('#pw').val() == '') {
				$('.pwcheck-message').text('');
				$('#pw').val('');
			}
		}); // blur

		// pw 일치확인
		function checkPw() {
			var pw = $('#pw').val();
			var pw1 = $('#pw1').val();

			if (pw != pw1) {
				$('.pwcheck-message').text('비밀번호가 일치하지 않습니다');
				checkPasswordDupl = 0;
			} else {
				$('.pwcheck-message').text('');
				checkPasswordDupl = 1;
			}
		}

		$('#pw1').change(function() {
			checkPw();
		}); // change

		$('#idCheck').click(function() {
			if ($('#id').val() == "") {
				$('.id-message').text('제대로 된 아이디를 입력해주세요.');
				return;
			}

			$.ajax({
				type : 'get',
				data : {
					id : $('#id').val()
				},
				url : 'selectCheckID',
				success : function(result) {
					if (result == '1') {
						$('.id-message').text("이미 사용중인 아이디입니다.");
						$('#id').focus();
					} else {
						$('#id').attr('readonly', true);
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
			console.log(tel);
			
			if(tel != null && tel != ""){
				if (!tel.match("^[0-9]{9,11}$")) {
					$('.tel-message').text('알맞은 번호를 입력해주세요');
					return;
				}else{
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
								alert("사용 가능한 번호입니다.");
								$('.tel-message').text("");
							}
						},
						error : function(err) {
							console.log(err);
						}
					}); // ajax
				}
			}else{
				$('.tel-message').text("번호를 입력해주세요.");
			}
			
		}); // idCheckclick
		
		$('#emailCheck').click(function() {
			let email = $('#email').val();
			
			console.log(email);
			
			if(email != null && email != ""){
				if (!email.match("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$")) {
					console.log('no');
					$('.email-message').text('알맞은 메일을 입력해주세요');
					return;
				}else{
					$.ajax({
						type : 'get',
						data : {
							'email' : email
						},
						url : 'selectCheckEmail',
						success : function(result) {
							if (result == '1') {
								$('.email-message').text("이미 등록된 메일입니다.");
								$('#email').focus();
							} else {
								$('#email').attr('readonly', true);
								alert("사용 가능한 메일입니다.");
								$('.email-message').text("");
							}
						},
						error : function(err) {
							console.log(err);
						}
					}); // ajax
				}
			}else{
				$('.email-message').text("메일을 입력해주세요.");
			}
			
		}); // idCheckclick
		

		$('.loginBtn').click(
				function(e) {
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
					
					// 전화번호 중복검사를 아직 안 한 경우
					if ($('#email').attr('readonly') != 'readonly') {
						alert("email 중복검사를 완료해주세요.");
						return;
					}
					
					// 약관 동의 안한 경우
					let agree = $('#memberAgree').val();
					console.log(agree);
					if (agree != 'on') {
						alert("약관에 동의해주세요");
						return;
					}
					
					console.log(checkId + " " + checkEmail + " " + checkPassword + " " + checkPasswordDupl + " " + checkName);
					
					// 모든 유효성 검사가 완료 된 경우
					if (checkId == 1 && checkPassword == 1 && checkPasswordDupl == 1	&& checkName == 1) {
						alert("회원가입이 완료되었습니다.");
						insertFrm.submit();
					} else { // 그렇지 않은 경우
						alert("형식에 맞게 입력해주세요.");
					}
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
						<form action="insertMember.do" id='insertFrm' method="post">
							<div class="row gy-4">

								<div class="col-md-4">
									<p>아이디</p>
								</div>
								<div class="col-md-6">
									<input type="text" name="id" id="id" class="form-control" required />
								</div>
								<div class="col-md-2">
									<button id="idCheck" class="form-control btn btn-primary">중복검사</button>
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
									<input type="text" name="tel1" id="tel1" class="form-control"
										placeholder="010" required />
								</div>
								<div class="col-md-2">
									<input type="text" name="tel2" id="tel2" class="form-control"
										placeholder="1234" required />
								</div>
								<div class="col-md-2">
									<input type="text" name="tel3" id="tel3" class="form-control"
										placeholder="5678" required />
								</div>
								<div class="col-md-2">
									<button id="telCheck" class="form-control btn btn-primary">중복검사</button>
								</div>
								<div class="row">
									<div class="col-md-12">
										<div class="tel-message"></div>
									</div>
								</div>
								<!-- 								<div class="col-md-2">
									<button id="telCheck" class="form-control btn btn-primary">인증</button>
								</div> -->

								<div class="col-md-4">
									<p>이름</p>
								</div>
								<div class="col-md-4">
									<input type="text" name="name" id="name" class="form-control"
										required />
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
									<input class="form-check-input" type="radio" name="gender"
										value="남자" checked="checked" >
									<p>남자</p>
								</div>
								<div class="col-md-3 form-check form-check-inline">
									<input class="form-check-input" type="radio" name="gender"
										value="여자">
									<p>여자</p>
								</div>

								<div class="col-md-4">
									<p>생년월일</p>
								</div>
								<div class="col-md-8">
									<input type="date" name="birth" class="form-control"
										placeholder="19000101" required />
								</div>

								<div class="col-md-4">
									<p>이메일</p>
								</div>
								<div class="col-md-6">
									<input type="text" class="form-control" id="email" name="email"
										placeholder="abc@naver.com" required />
								</div>
								<div class="col-md-2">
									<button id="telCheck" class="form-control btn btn-primary">중복검사</button>
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
									<input type="password" class="form-control" id="pw"
										name="password" placeholder="소문자, 숫자, 7~14자리" required />
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
									<input type="password" class="form-control" name="password1"
										id="pw1" placeholder="소문자, 숫자, 7~14자리" required />
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
									<input class="form-check-input" type="radio" id="memberAgree" required />
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
