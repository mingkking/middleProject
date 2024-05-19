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

<title>questionWrite.jsp</title>
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
					<div class="col-lg-6 text-center">
						<h2 data-aos="fade-down">문의 글쓰기</h2>
						<form method="post" action='saveQuestion'>
							<div class="row gy-4">

								<div class="col-md-4">
									<p>작성일시</p>
								</div>
								<div class="col-md-8">
									<input type="text" name="qRegdate" class="form-control" value="<%= new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()) %>" readonlys>
								</div>
								
								<div class="col-md-4">
									<p>제목</p>
								</div>
								<div class="col-md-8">
									<input type="text" name="qTitle" class="form-control" placeholder="이름을 입력해주세요." required />
								</div>
								
								<div class="col-md-4">
                                <p>문의내용</p>
                            </div>
                            <div class="col-md-8">
                                <textarea name="qContent" class="form-control" rows="5" placeholder="문의내용을 입력해주세요." required></textarea>
                            </div>

								<div class="col-md-4">
									<p>비밀번호</p>
								</div>
								<div class="col-md-8">
									<input type="password" class="form-control" name="qPassword"	placeholder="비밀번호를 입력해주세요." required />
								</div>

								<div class="col-md-4">
									<p>비밀글 여부</p>
								</div>
								<div class="col-md-8">
									<input type="checkbox" id="secretCheckbox" name="secret"
										value="true"> <label for="secretCheckbox">비밀글로
										설정하기</label>
								</div>

								<%-- 비밀글 내용 입력란 --%>
								<div id="secretContentRow" class="row" style="display: none;">
									<div class="col-md-4">
										<p>비밀글 비밀번호</p>
									</div>
									<div class="col-md-8">
										<input type="password" name="qSecret" class="form-control"
											placeholder="비밀글에 대한 비밀번호를 남겨주세요.">
									</div>
								</div>

								<div class="col-md-4 text-center"></div>
                            <div class="col-md-4 text-center">
                                <div class="error-message"></div>
                                <a href='question?id=${id}'><input type='button' id='questionWriteExit' class="findIdBtn"  value='닫기'></a>
                                <input type='submit' id='questionBtn' class="findIdBtn" value='글쓰기'>
                            </div>
                            <div class="col-md-4 text-center"></div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

		<script>
			// 비밀글로 설정하기 체크박스의 상태 변화를 감지하여 비밀글 내용 입력란 표시/숨김
			document.getElementById("secretCheckbox").addEventListener(
					"change",
					function() {
						var secretContentRow = document
								.getElementById("secretContentRow");

						// 비밀글로 설정하기 체크박스가 체크되었는지 확인
						if (this.checked) {
							// 비밀글로 설정하기 체크박스가 체크되었을 때 비밀글 내용 입력란 표시
							secretContentRow.style.display = "flex";
						} else {
							// 비밀글로 설정하기 체크박스가 체크 해제되었을 때 비밀글 내용 입력란 숨김
							secretContentRow.style.display = "none";
						}
					});
		</script>

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
