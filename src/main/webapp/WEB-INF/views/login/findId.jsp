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

<!-- 이메일 인증 -->
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script type="text/javascript">
    function sendNumber(){
        $("#authEmail").css("display","block");
        $.ajax({
            url:"/mail",
            type:"post",
            dataType:"json",
            data:{"mail" : $("#mail").val()},
            success: function(data){
                alert("인증번호 발송");
                $("#Confirm").attr("value",data);
            },
        });
    }

    function confirmNumber(){
        var number1 = $("#number").val();
        var number2 = $("#Confirm").val();

        if(number1 == number2){
            alert("인증되었습니다.");
        }else{
            alert("번호가 다릅니다.");
        }
    }
</script> -->

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		let checkEmail = 0; // email 유효성
		// email
		function emailCheck() {
			var email = $('#emailCheck').val();
			var emailResult = $('.email-message');

			var emailP = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$"; // email

			if (!email.match(emailP)) {
				emailResult.text("@를 포함한 이메일주소를 작성");
				$('#sendEmail').attr('disabled', true); // 아이디 찾기 email 인증 버튼 활성화
				checkEmail = 0;
			} else {
				emailResult.text('');
				$('#sendEmail').attr('disabled', false); // 아이디 찾기 email 인증 버튼 비활성화
				checkEmail = 1;
			}
		};

		$('#emailCheck').blur(function() {
			emailCheck();
			if ($('#emailCheck').val() == '') {
				$('.email-message').text('');
				$('#emailCheck').val('');
			}
		}); // blur

		$('#sendEmail').click(function() {
			alert('버튼 클릭');
			
			$.ajax({
	               type : 'get',
	               url : 'sendEmail',
	               data : { 'email' : $('#emailCheck').val() },
	               dataType : 'json',
	               success : function(result){
	            	   console.log(result);
	               },
	               error : function(err){
	                   alert('error');
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
				<div class="row justify-content-center">
					<div class="col-lg-6 text-center">
						<h2 data-aos="fade-down">아이디 찾기</h2>
						<div class="row gy-4" id='emailsearch'>

							<div class="col-md-4">
								<p>이메일</p>
							</div>
							<div class="col-md-6">
								<input type="email" name="emailsearch" id="emailCheck" class="form-control" placeholder="abc@naver.com" required />
							</div>
							<div class="col-md-2">
								<button id="sendEmail" class="findIdBtn">이메일인증</button>
							</div>
							<div class="row">
								<div class="col-4"></div>
								<div class="col-6 email-message"></div>
							</div>

							<!-- <div class="col-md-4" id="authEmail" style="display:none"> -->
							<div class="col-md-4" id="authEmail">
								<p>인증번호</p>
							</div>
							<div class="col-md-6" id="authEmail">
								<input type="email" name="emailsearch" id="EmailAuth"
									class="form-control" placeholder="숫자6자리" required />
							</div>


							<div class="findId">
								<button type="submit" class="findIdBtn">확인</button>
							</div>

							<div id='emailinsertment'>
								<p>- 회원가입시 등록한 이메일 주소로 인증하시면 아이디 확인이 가능합니다.</p>
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
