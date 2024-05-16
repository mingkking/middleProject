<%@ page language="java" contentType="text/html; charset=utf-8"
   pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
  <!-- jQuery -->
    <script src="https://code.jquery.com/jquery.min.js"></script>
 
   <!-- Google Charts 라이브러리 로드 -->
  <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
  <script type="text/javascript">
    // Google Charts 라이브러리 로드 완료 후 실행
    google.charts.load('current', {'packages':['corechart']});
    google.charts.setOnLoadCallback(drawCharts);

    function drawCharts() {


     // 차트 5 - 영역 차트
      var data5 = google.visualization.arrayToDataTable([
        ['연도', '매출', '비용'],
        ['2019', 1000, 600],
        ['2020', 1200, 700],
        ['2021', 1400, 800],
        ['2022', 1600, 900]
      ]);

      var options5 = google.visualization.arrayToDataTable([
        ['과일', '판매량'],
        ['사과', 30],
        ['바나나', 50],
        ['딸기', 20],
        ['오렌지', 40]
      ]);

      var chart5 = new google.visualization.AreaChart(document.getElementById('chart_div5'));
      chart5.draw(data5, options5);

    }
    function ajaxTest() {
        $.ajax({
          url: 'ajaxTest', //controller주소
          type: 'post',
        /*   dataType: 'json', */
          data: {},
          success: function(res){
        	alert(res);
          }
        });
     }
  </script>
  
  
</head>


<body>
  

   <!-- 헤더 영역 불러오기 -->
   <c:import url="${path}/WEB-INF/views/manager/managerheader.jsp"></c:import>

   <!-- ======= Hero Section ======= -->
   <section id="hero" class="hero">

      <div class="info d-flex align-items-center">
         <div class="container">
            <div class="row justify-content-center">
               <div class="col-lg-6 text-center">
                  <h3 data-aos="fade-down">통계</h3>
              <div class="pull-right">
               <button type="button" class="btn btn-sm btn-primary" onclick="ajaxTest();">ajax테스트</button>
               </div>
                  <!-- 그래프를 그릴 요소들 -->
                 <div id="chart_div5"></div>
               </div>
            </div>
         </div>
      </div>

      <div id="hero-carousel" class="carousel slide" data-bs-ride="carousel"
         data-bs-interval="5000">

         <div class="carousel-item active"
            style="background-image: url(assets/img/hero-carousel/hero-carousel-1.jpg)"></div>
         <div class="carousel-item"
            style="background-image: url(${path}/resources/assets/img/hero-carousel/hero-carousel-2.jpg)"></div>
         <div class="carousel-item"
            style="background-image: url(${path}/resources/assets/img/hero-carousel/hero-carousel-3.jpg)"></div>
         <div class="carousel-item"
            style="background-image: url(${path}/resources/assets/img/hero-carousel/hero-carousel-4.jpg)"></div>
         <div class="carousel-item"
            style="background-image: url(${path}/resources/assets/img/hero-carousel/hero-carousel-5.jpg)"></div>

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
   <!-- google charts -->
     <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>


</body>

</html>