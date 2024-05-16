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

<!-- JQuery -->
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
<script>

	$(function() {
		
		// 탈퇴하기
		$('#cancelMember').click(function(){
			// alert($('#nowPassword').val());
			if($('#nowPassword').val() == null || $('#nowPassword').val() == "") {
				alert('현재 비밀번호를 입력해주세요');
			}else{
				location.href='deleteMypage?id=' + $('#nowId').val() + '&password=' + $('#nowPassword').val() + '&name=' + $('#nowName').val() + '&tel=' + $('#nowTel').val() + '&email=' + $('#nowEmail').val() + '&birth=' + $('#nowBirth').val();
			}
		}); // cancelMember click
	
	
    // 정보 수정
	$('#modifyMember').click(function(e) {
		e.preventDefault();
		    var pw  = $('#nowPassword').val();
			var pw1 = $('#password1').val();
			var pw2 = $('#password2').val();
			// alert($('#password1').val());
			
			var pwP = /^[a-z0-9]{7,15}$/; // 비밀번호 유효성 패턴
            
			
			if ( (pw1 != null && pw1 != "") && (pw2 != null && pw2 != "") ) {
				console.log('ok');
				// 변경 비밀번호 유효성검사
				if (!pw1.match(pwP)) {
					alert('영어 소문자, 숫자를 포함하여 7~15자 이내 작성');
					return; 
				}
				
				// 새 비밀번호 / 새 비밀번호 확인 일치 여부
				if (pw1 != pw2) {
					alert('비밀번호가 일치하지 않습니다');
					return;
				}
			
			}; //if null
		$('#updateMypage').submit();	

	});
});

</script>

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
				<div class="row justify-content-center" id='insertMemberForm'>
					<div class="col-lg-6 text-center">
						<h2 data-aos="fade-down" id='mypage'>마이페이지</h2>
						<form action="updateMypage" method="post" id="updateMypage">
							<div class="row gy-4">
									<div class="col-md-4">
										<p>아이디</p>
									</div>
									<div class="col-md-5">
										<input type="text" id="nowId" name="id" class="form-control"
											value="${vo.id }" readonly="readonly"/>
									</div>

									<div class="col-md-4">
										<p>이름</p>
									</div>
									<div class="col-md-5">
										<input type="text" id="nowName" name="name" class="form-control" value="${vo.name }"/>
									</div>

									<div class="col-md-4">
										<p>이메일</p>
									</div>
									<div class="col-md-5">
										<input type="email" id="nowEmail" name="email" class="form-control" placeholder="abc@naver.com" value="${vo.email }" readonly/>
									</div>

									<div class="col-md-4">
										<p>성별</p>
									</div>
									<div class="col-md-4 form-check form-check-inline">
										<input class="form-check-input" type="radio" name="gender"
											value="남자" checked="checked">
										<p>남자</p>
									</div>
									<div class="col-md-3 form-check form-check-inline">
										<input class="form-check-input" type="radio" name="gender"
											value="여자">
										<p>여자</p>
									</div>

									<div class="col-md-4">
										<p>휴대폰번호</p>
									</div>
									<div class="col-md-6">
										<input type="text" id="nowTel" name="tel" class="form-control" value="${vo.tel }" readonly />
									</div>

									<div class="col-md-4">
										<p>생년월일</p>
									</div>
									<div class="col-md-8">
										<input type="date" id="nowBirth" name="birth" class="form-control" value="${vo.birth }"/>
									</div>

									<div class="col-md-4">
										<p>현재 비밀번호</p>
									</div>
									<div class="col-md-8">
										<input type="password" class="form-control" name="password" id="nowPassword" required />
									</div>

									<div class="col-md-4">
										<p>새 비밀번호</p>
									</div>
									<div class="col-md-8">
										<input type="password" class="form-control" name="password1" id="password1" placeholder="소문자, 숫자, 7~14자리" />
									</div>

									<div class="col-md-4">
										<p>새 비밀번호 확인</p>
									</div>
									<div class="col-md-8">
										<input type="password" class="form-control" name="password2" id="password2" placeholder="소문자, 숫자, 7~14자리" />
									</div>

									<div class="col-md-4" id='modifyunregisterBtn'></div>
									<div class="col-md-4 text-center">
										<input type="button" id="cancelMember" value="회원탈퇴" class="unregisterBtn"/>
										<button type="submit" id="modifyMember" class='modifyBtn'>수정하기</button>
									</div>

									<!-- 								<div class="col-md-4"></div>
								<div class="col-md-4 text-center">
									<div class="error-message"></div>
									<button type="submit" class="unregisterBtn">회원탈퇴</button>
								</div> -->
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
