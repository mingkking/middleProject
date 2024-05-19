<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<%@ page session="false"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<%
    HttpSession session = request.getSession();
    String id = (String) session.getAttribute("logid");
%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>getQuestion.jsp</title>
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
						<h2 data-aos="fade-down">문의 상세</h2>
						<form method="post" action="updateQuestion">
							<div class="row gy-4">

								<div class="col-md-4">
									<p></p>
								</div>
								<div class="col-md-8">
									<input type="hidden" name="qNo" class="form-control"
										value='${question.qNo }'>
								</div>

								<div class="col-md-4">
									<p>작성일시</p>
								</div>
								<div class="col-md-8">
									<input type="date" name="qRegdate" class="form-control"
										value="${question.qRegdate.substring(0, 10)}" readonly>
								</div>

								<div class="col-md-4">
									<p>아이디</p>
								</div>
								<div class="col-md-8">
									<input type="text" class="form-control" name="qWriter"
										value='${question.id }' required readonly />
								</div>

								<c:choose>
									<c:when test="${id eq question.id}">
										<!-- 현재 사용자와 DB에서 가져온 질문의 작성자가 일치할 때 -->
										
											
										<div class="col-md-4">
									<p>제목</p>
								</div>
								<div class="col-md-8">
									<input type="text" class="form-control" name="qTitle" value='${question.qTitle }' required />
								</div>
								
								<div class="col-md-4">
                                <p>문의 내용</p>
                            </div>
                            <div class="col-md-8">
                                <textarea name="qContent" class="form-control" rows="5" required >${question.qContent }</textarea>
                            </div>
									</c:when>
									<c:otherwise>
										<!-- 현재 사용자와 DB에서 가져온 질문의 작성자가 일치하지 않을 때 -->
										<div class="col-md-4">
									<p>제목</p>
								</div>
								<div class="col-md-8">
									<input type="text" class="form-control" name="qTitle" value='${question.qTitle }' required readonly/>
								</div>
								
								<div class="col-md-4">
                                <p>문의 내용</p>
                            </div>
                            <div class="col-md-8">
                                <textarea name="qContent" class="form-control" rows="5" required readonly>${question.qContent }</textarea>
                            </div>
									</c:otherwise>
								</c:choose>

								<div class="col-md-4">
									<p>답변일시</p>
								</div>
								<div class="col-md-8">
									<c:set var="formattedDate"
										value="${empty managerQuestion.qARegdate ? '답변이 작성되지 않았습니다.' : managerQuestion.qARegdate}" />
									<input type="text" name="qARegdate" class="form-control"
										value="${formattedDate}" readonly>
								</div>

								<div class="col-md-4">
									<p>제목</p>
								</div>
								<div class="col-md-8">
									<input type="text" name="qATitle" class="form-control"
										placeholder="답변이 작성되지 않았습니다."
										value='${managerQuestion.qATitle }' readonly>
								</div>

								<div class="col-md-4">
									<p>답변 내용</p>
								</div>
								<div class="col-md-8">
									<textarea name="qAContent" class="form-control" rows="5"
										placeholder="답변이 작성되지 않았습니다." required readonly>${managerQuestion.qAContent }</textarea>
								</div>

								<div class="col-md-4 text-center"></div>
                            <div class="col-md-4 text-center">
                                <div class="error-message"></div>

									<script>
    function confirmDelete() {
        var result = confirm("삭제하시겠습니까?");
        if (result) {
            // 확인 버튼이 눌렸을 때 실행할 코드
            location.href = 'deleteQuestion.do?qNo=${question.qNo}';
        } else {
            // 취소 버튼이 눌렸을 때 실행할 코드	
            location.href = 'question'; // 취소했을 때 question.jsp 페이지로 이동하는 코드
            return false; // 기능 중단
        }
    }

    function confirmUpdate() {
        var result = confirm("수정하시겠습니까?");
        if (result) {
            // 확인 버튼이 눌렸을 때 실행할 코드
            // 수정하는 페이지로 이동하는 코드
            location.href = 'updateQuestion';
            return true; // 수정 페이지로 이동하기 위해 true를 반환
        } else {
            // 취소 버튼이 눌렸을 때 실행할 코드
            location.href = 'question'; // 취소했을 때 question.jsp 페이지로 이동하는 코드
            return false; // 기능 중단 및 원래 페이지에 머무르기 위해 false를 반환
        }
    }

</script>


									<c:if test="${id eq question.id}">
                               		<a href='question?id=${id} '><input type='button' value='닫기'></a>
                               		<a href='deleteQuestion.do?qNo=${ question.qNo}' onclick="return confirmDelete()"><input type='button' value='삭제하기'></a>
                               		<a href='updateQuestion' onclick="return confirmUpdate()"><input type='submit' value='수정하기'></a>
                               </c:if>
                               
                               <c:if test="${id ne question.id}">
                               		<a href='question?id=${id} '><input type='button' value='닫기'></a>
                               </c:if>
                            </div>
                            <div class="col-md-4 text-center"></div>
							
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
