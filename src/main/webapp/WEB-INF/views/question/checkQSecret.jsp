<%@ page language="java" contentType="text/html; charset=utf-8"
   pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>	
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>checkQSecret.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<meta content="" name="description">
<meta content="" name="keywords">

<!-- Favicons -->
<link href="resources/assets/img/favicon.png" rel="icon">
<link href="resources/assets/img/apple-touch-icon.png"
   rel="apple-touch-icon">
 
<!-- Google Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
   href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,600;1,700&family=Roboto:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&family=Work+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap"
   rel="stylesheet">

<!-- Vendor CSS Files -->
<link href="resources/assets/vendor/bootstrap/css/bootstrap.min.css"
   rel="stylesheet">
<link href="resources/assets/vendor/bootstrap-icons/bootstrap-icons.css"
   rel="stylesheet">
<link href="resources/assets/vendor/fontawesome-free/css/all.min.css"
   rel="stylesheet">
<link href="resources/assets/vendor/aos/aos.css" rel="stylesheet">
<link href="resources/assets/vendor/glightbox/css/glightbox.min.css"
   rel="stylesheet">
<link href="resources/assets/vendor/swiper/swiper-bundle.min.css"
   rel="stylesheet">

<!-- Template Main CSS File -->
<link href="resources/assets/css/main.css" rel="stylesheet">

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
                  <h2 data-aos="fade-down">문의 게시판</h2>
                     <legend>비밀글보기</legend>
                   <h6>이 글은 비밀글입니다. 비밀번호를 입력하여 주세요.</h6>
	

	<%
    // 데이터베이스에서 비밀번호를 가져오는 로직
    String dbSecret = "저장된 비밀번호";
    String enteredSecret = request.getParameter("qSecret");

    // 입력한 비밀번호가 데이터베이스의 비밀번호와 일치하는지 확인
    if (enteredSecret != null && enteredSecret.equals(dbSecret)) {
        // 비밀번호가 일치하는 경우 getQuestion.jsp로 이동
        response.sendRedirect("getQuestion.jsp?qNo=" + request.getParameter("qNo"));
    } else {
        // 비밀번호가 일치하지 않는 경우 실패 메시지 표시
        out.println("<p style='color:red;'>비밀번호가 틀렸습니다. 다시 시도해주세요.</p>");

        // 비밀번호 입력 폼 (입력값 유지)
%>
        <form method="post" action="checkQSecret.jsp">
            <input type="hidden" name="qNo" value="<%= request.getParameter("qNo") %>">
            <p>비밀글 비밀번호를 입력해주세요:</p>
            <input type="password" name="qSecret" required>
            <input type="submit" value="확인">
        </form>
<%
    }
%>













	




























				</div>
            </div>
        </div>
    </div>
      <div id="hero-carousel" class="carousel slide" data-bs-ride="carousel"
         data-bs-interval="5000">

         <div class="carousel-item active"
            style="background-image: url(resources/assets/img/main_img/main_arena_1.jpg)"></div>
         <div class="carousel-item"
            style="background-image: url(resources/assets/img/main_img/main_arena_2.jpg)"></div>
         <div class="carousel-item"
            style="background-image: url(resources/assets/img/main_img/main_arena_3.jpg)"></div>
         <div class="carousel-item"
            style="background-image: url(resources/assets/img/main_img/main_arena_4.jpg)"></div>
         <div class="carousel-item"
            style="background-image: url(resources/assets/img/main_img/main_arena_5.jpg)"></div>

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

   <a href="#"
      class="scroll-top d-flex align-items-center justify-content-center"><i
      class="bi bi-arrow-up-short"></i></a>

   <div id="preloader"></div>

   <!-- Vendor JS Files -->
   <script
      src="resources/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
   <script src="resources/assets/vendor/aos/aos.js"></script>
   <script src="resources/assets/vendor/glightbox/js/glightbox.min.js"></script>
   <script
      src="resources/assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
   <script src="resources/assets/vendor/swiper/swiper-bundle.min.js"></script>
   <script
      src="resources/assets/vendor/purecounter/purecounter_vanilla.js"></script>
   <!-- <script src="resources/assets/vendor/php-email-form/validate.js"></script> -->

   <!-- Template Main JS File -->
   <script src="resources/assets/js/main.js"></script>

</body>

</html>