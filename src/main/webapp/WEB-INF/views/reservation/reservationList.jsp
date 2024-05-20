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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		let pageNum = 1;
		let pageNum2 = 1;
		let startPage = 1;
		let endPage = 1;
		let prePageNum = 1;
		let endPageNum = 1;
		let totalPage = 1;
		
		reservationListAll(pageNum);
		function reservationListAll(pageNum) {
			$.ajax({
	            type : 'get',
	            url : 'reservationListAll',
	            data : {
	            	'pageNum' : pageNum
	            },
	            dataType : 'json',
	            success : function(result){
	            	console.log(result);
	            	pageNum = result.pageNum;
	            	startPage = result.startPage;
	            	endPage = result.endPage;
	            	totalPage = result.totalPage;
	                var reservationList = result.reservationList;
	            	
	                let reservationListAll = $('#reservationListAll'); // 시간 select 태그 아이디를 가져오기
	                let ajaxPagingReservation = $('#ajaxPagingReservation');
	                reservationListAll.empty(); // 기존 옵션 삭제
	                ajaxPagingReservation.empty();
	                
	             	// ajax 테이블리스트
					var tr = $('<tr/>'); 
                	var th = $('<td/>').text('예약번호'); 
 					tr.append(th);
 					var th1 = $('<td/>').text('아이디'); 
 					tr.append(th1);
 					var th2 = $('<td/>').text('구장명'); 
 					tr.append(th2);
 					var th3 = $('<td/>').text('예약일'); 
 					tr.append(th3);
 					var th4 = $('<td/>').text('시간'); 
 					tr.append(th4);
 					var th5 = $('<td/>').text('금액'); 
 					tr.append(th5);
 					var th6 = $('<td/>').text('결제수단'); 
 					tr.append(th6);
 					var th7 = $('<td/>').text('결제상태'); 
 					tr.append(th7);
 					var th8 = $('<td/>').text('예약취소'); 
 					tr.append(th8);
 					reservationListAll.append(tr);
	 					
	                for(var row of reservationList){ 
	                	var tr1 = $('<tr/>'); 
	                	var rNo = $('<td/>').text(row['rNo']); 
	 					tr1.append(rNo);
	 					var id = $('<td/>').text(row['id']); 
	 					tr1.append(id);
	 					var pNo = $('<td/>').text(row['pNo']); 
	 					tr1.append(pNo);
	 					var rental = $('<td/>').text(row['rental']); 
	 					tr1.append(rental);
	 					var time = $('<td/>').text(row['start_time'] + ':00 - ' + row['end_time'] + ':00'); 
	 					tr1.append(time);
	 					var totalMoney = $('<td/>').text(row['totalMoney']); 
	 					tr1.append(totalMoney);
	 					var rPayMethod = $('<td/>').text(row['rPayMethod']); 
	 					tr1.append(rPayMethod);
	 					var rPayStatus = $('<td/>').text(row['rPayStatus']); 
	 					tr1.append(rPayStatus);
	 					var deleteBtn = $('<td/>').html('<button class="delete">삭제</button>');
	 					tr1.append(deleteBtn);
	 					reservationListAll.append(tr1);
	 				}
	                // ajax 페이징
	                console.log(pageNum-10);
	                console.log(pageNum+10);
	                pageNum2 = pageNum;
	                if(pageNum-10 <= 1){
	                	prePageNum = 1;
	                }
	                if(pageNum-10 > 1){
	                	prePageNum = pageNum-10;
	                }
	                if(pageNum+10 >= totalPage){
	                	endPageNum = totalPage;
	                }
	                if(pageNum+10 < totalPage){
	                	endPageNum = pageNum+10;
	                }
	                var a;
	                var pre = $('<a class="pre_btn">이전</a>');
	                ajaxPagingReservation.append(pre);
	                for(var i = startPage; i <= endPage; i++){
	                	if(pageNum == i){
	                		a = $('<a class="page-btn paging_color">' + i + '</a>');
		                	ajaxPagingReservation.append(a);	
	                	}
	                	if(pageNum != i){
	                		a = $('<a class="page-btn">' + i + '</a>');
		                	ajaxPagingReservation.append(a);	
	                	}
	                	
	                }
	                if(pageNum + 10 >= endPage){
	                	var next = $('<a class="next_btn">다음</a>');
		                ajaxPagingReservation.append(next);	                	
	                }
	                if(pageNum + 10 < endPage){
	                	var next = $('<a class="next_btn">다음</a>');
		                ajaxPagingReservation.append(next);	                	
	                }
	            },
	            error : function(err){
	                alert('error');
	                console.log(err);
	            }
	        });
			
		}
		
		$('#ajaxPagingReservation').on('click', '.pre_btn', function(){
	        // 현재 활성화된 페이지 버튼의 active 클래스 제거
	        reservationListAll(prePageNum);
	    });
		
	    $('#ajaxPagingReservation').on('click', '.page-btn', function(){
	        // 현재 활성화된 페이지 버튼의 active 클래스 제거
	        reservationListAll($(this).text());
	    });
	    
	    $('#ajaxPagingReservation').on('click', '.next_btn', function(){
	        // 현재 활성화된 페이지 버튼의 active 클래스 제거
	        reservationListAll(endPageNum);
	    });
	    
		// '삭제' 버튼이 눌렸을 때
	 	$('#reservationListAll').on('click', '.delete', function(){
	 		// 각 버튼을 클릭했을 때 tr부모까지 가서 자식들 중 0번째
	 		let rNo = $(this).parents('tr').children().eq(0).text();
	 		if(confirm('삭제하시겠습니까?')){
	 			$.ajax({
					type : 'get',
					url : 'deleteReservation',
					data : {
						'rNo' : rNo
					},
					dataType : 'json',
					success : function(result){
						reservationListAll(pageNum2);
					},
					error : function(err){
						alert('error');
						console.log(err);
					}
				});
	 		}
	 		
	 	});
	 	
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
				
					<h2 data-aos="fade-down" id='insertMemberForm'>예약확인/취소</h2>
					<table class="table table-default table-hover" id="reservationListAll">
						<%-- <tr class="table-dark">
							<td>예약번호</td>
							<td>아이디</td>
							<td>구장명</td>
							<td>예약일</td>
							<td>시간</td>
							<td>금액</td>
							<td>결제수단</td>
							<td>결제상태</td>
							<td>예약취소</td>
						</tr>
						<c:if test="${reservationList.size() > 0 }">
							<c:forEach var="i" begin="0" end="${reservationList.size() - 1}">
								<tr>
									<td>${reservationList.get(i).rNo}</td>
									<td>${reservationList.get(i).id}</td>
									<td>${reservationList.get(i).pNo}</td>
									<td>${reservationList.get(i).rental}</td>
									<td>${reservationList.get(i).start_time}:00 - ${reservationList.get(i).end_time}:00</td>
									<td>${reservationList.get(i).totalMoney}</td>
									<td>${reservationList.get(i).rPayMethod}</td>
									<td>${reservationList.get(i).rPayStatus}</td>
									<td>
										<input type="button" value="예약취소" class="findIdBtn" onclick="location.href='deleteReservation?rNo=${reservationList.get(i).rNo}'">
									</td>
								</tr>
							</c:forEach>
						</c:if> --%>
					</table>
					<div class="row">
						<div class="col-md-12" id="ajaxPagingReservation"></div>
					</div>
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
