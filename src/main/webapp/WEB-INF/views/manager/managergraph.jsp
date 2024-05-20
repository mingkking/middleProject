<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>

<%
	// 오늘날짜
	// 년도
	int year = 2024;
%>


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
<!-- jQuery -->
<script src="https://code.jquery.com/jquery.min.js"></script>

<!-- Google Charts 라이브러리 로드 -->
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script src="https://code.jquery.com/jquery.min.js"></script>
<!-- google charts -->
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
    // Google Charts 라이브러리 로드 완료 후 실행
    
   
    function prepareChartData(data) {
        var chartData = [];
        chartData.push([ '구장', '예약 건수']);

        // 데이터가 있으면 chartData에 추가
        data.forEach(function(item) {
        	var month = parseInt(item.month);// 월 데이터를 숫자를 변환
        	var pNo = item.pNo+'구장'; // 
        	var reservationCount = parseInt(item.reservationCount); //예약 건수 데이터를 숫자로 변환
            chartData.push([ pNo, reservationCount]);
        });

        return chartData;
    }

     
    function drawChart(year,month) {
    	 
        $.ajax({
            url: '${path}/ajaxTest',
            type: 'POST',
            dataType: 'json',
            data: 'year='+year+'&month='+month,
            success: function(response) {
            	
            	console.log("서버로부터 받은 결과 : " + response)
            	
            	
                // Google Charts 로드 완료시 실행
                google.charts.load('current', { packages: ['corechart'] });
                google.charts.setOnLoadCallback(function() {
                    var data = google.visualization.arrayToDataTable(prepareChartData(response));
                    var options = {
                        title: '월 구장별 예약 현황',
                        chartArea: { width: '80%' },
                        hAxis: { title: '구단' },
                        vAxis: { title: '예약수' }
                    };
                    var chart = new google.visualization.AreaChart(document.getElementById('chart_div'));
                    chart.draw(data, options);
                });
            },
            error: function(xhr, status, error) {
                console.error(error);
            }
        });
    }

    // AJAX 버튼 클릭 이벤트 핸들러
    $(document).ready(function() {	
        $('#ajaxButton').click(function() {
            var selectedYear = $('#yearSelect').val();
            var selectedMonth = $('#monthSelect').val();
            drawChart(selectedYear, selectedMonth);
        });
    });
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
							<button type="button" class="btn btn-sm btn-primary"
								id="ajaxButton">예약 확인</button>
						</div>
						<!-- 그래프를 그릴 요소들 -->
						<select id="yearSelect">
							<c:forEach var="year" items="${years}">
								<option value="${year}" ${year==currentYear? 'selected' : ''}>
								${year}</option>
							</c:forEach>
							
						</select> <select id="monthSelect">
							<option value="1">1월</option>
							<option value="2">2월</option>
							<option value="3">3월</option>
							<option value="4">4월</option>
							<option value="5">5월</option>
							<option value="6">6월</option>
							<option value="7">7월</option>
							<option value="8">8월</option>
							<option value="9">9월</option>
							<option value="10">10월</option>
							<option value="11">11월</option>
							<option value="12">12월</option>
						</select>

						

						<div id="chart_div"></div>
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