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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">
	
</script>
</head>

<body>
	<!-- 헤더 영역 불러오기 -->
	<c:import url="${path}/WEB-INF/views/header.jsp"></c:import>

	<!-- ======= Hero Section ======= -->
	<section id="insertMemberFormHero" class="hero">

		<div class="info align-items-center">

			<div class="row justify-content-center" id='insertMemberForm'>
				<div class="col-lg-6 text-center">

					<h2 data-aos="fade-down" id='insertMemberForm'>소개</h2>

					<div class="row gy-4">
						<%-- <h2 data-aos="fade-down" id='insertMemberForm'>${productVO.pName}</h2> --%>
						<table class="table table-default">
							<thead>
								<tr class="table-dark">
									<th>구분</th>
									<th>1타임</th>
									<th>2타임</th>
									<th>3타임</th>
									<th>4타임</th>
									<th>5타임</th>
									<th>6타임</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>시간</td>
									<td>10~12</td>
									<td>12~14</td>
									<td>14~16</td>
									<td>16~18</td>
									<td>18~20</td>
									<td>20~22</td>
								</tr>
								<tr>
									<td colspan="7" class="aboutInfoTd">
										<h3 class="aboutInfoTdTitle">풋살경기장 예약신청</h3><br/>
										예약신청 후 예약 승인이 완료 되려면, 예약자명과 입금자명이 동일하게 전용 입금계좌에 입금하셔야 합니다.<br/>
										입금자명이 다르거나, 다른 경기장 전용 입금계좌에 입금시 취소 처리가 될 수 있으니, 반드시 예약신청 후 자동으로 발송되는 안내문자의 전용입금계좌에 입금해 주시기 바랍니다.<br/>
										<span class="aboutSpan1">※입금자명 예시 : [예약자명 : 홍길동], [입금자명 : 홍길동] (O)</span><br/>
										<span class="aboutSpan1">※입금자명 예시 : [예약자명 : 홍길동], [입금자명 : 7/15홍길동] (X)</span><br/>
										예약대기 상태로 2시간 내에 입금이 완료되지 않을 경우에는 예약신청은 자동취소 처리 됩니다.<br/>
										<span class="aboutSpan1">※입금 예시 : [예약신청일 사용금액 : 115,000], [입금 금액 : 115,000](O)</span><br/>
										<span class="aboutSpan1">※입금 예시 : [예약신청일 사용금액 : 115,000], [입금 금액 : 10,500](X)</span><br/>
										<span class="aboutSpan1">※입금 예시 : [예약신청일 사용금액 : 115,000], [입금 금액 : 100,000+5,000 분산입금](X)</span><br/>
										예약신청은 익일부터 다음달 말까지 예약신청이 가능합니다. (당일예약 불가)<br/>
										모든 경기장 신규예약 신청일은 매월 1일 00:00시에 시작됩니다.<br/>
										※신규예약 신청 예시 : 05월 01일 00:00시 예약 개시 : 05월 02일 ~ 06월 30일 예약 가능<br/>
										매월 1일 신규예약 오픈시 과도한 트래픽으로 인하여 중복예약 오류가 발생하여 예약신청후 정상적인 금액(입금안내) 문자가 발송되지 않을시, 예약신청페이지의 해당날짜의 ＂대관상태 및 정보＂를 반드시 확인해 주시기 바라며, 본인의 예약정보가 아닌 다른 예약정보가 표시되어있는 경우 중복예약 오류가 발생되어 해당일은 사용이 불가능 하여 다른 날짜를 신청해 주시기 바랍니다.<br/>
										ID당 일일 경기장별 예약신청 횟수는 1회만 가능하며, 전체 경기장에 한하여 총 5회 까지만 예약신청이 제한 됩니다.<br/>
										※예약신청 제한예시 : ID당 일일 1~5구장 각 1건씩 총 5건 까지만 예약신청 가능 합니다.<br/>
										문의사항 : 02-2012-3810<br/>
										(근무시간 평일 09:00~18:00, 이외의 시간은 전화 확인이 불가합니다.)<br/>
										<h3 class="aboutInfoTdTitle">풋살경기장 환불규정</h3><br/>
										예약완료 후 대관일정 및 시간변경은 불가능하며, 취소신청 및 환불규정에 의거해 환불 후, 신규대관을 신청하셔야 합니다.<br/>
										대관 당일에는 취소가 불가능합니다.<br/>
										예약이 완료된 시점으로 환불규정에 정해진 날짜에 따라 금액이 환불됩니다.<br/>
										취소신청은 일일 단위로만 가능합니다.<br/>
										<span class="aboutSpan1">~21일 전 : 100% / 20~16일전 : 90% / 15~11일전 : 80% / 10~6일전 : 70% / 5~2일전 : 60% / 1일전 : 50% / 대관당일 : 취소 불가</span><br/>
										천재지변으로 인해 당일 이용이 불가능할 경우 100% 환불적용(실내구장 제외)<br/>
										※천재지변으로 인한 환불은 당일 이용시간 2시간전 기상청 날씨누리 기상특보 발표기준으로 합니다. (용산구 한강로 기준) 취소번복 불가. 일부 시간이라도 사용 확인시 환불이 불가합니다.<br/>
										호우주의보 : 3시간 강우량이 60mm 이상 예상되거나, 12시간 강우량이 110mm 이상이 예상될 때<br/>
										강풍주의보 : 육상에서 풍속 14m/s 이상 또는 순간풍속 20m/s 이상이 예상될 때<br/>
										대설주의보 : 24시간 신적설이 5cm이상 예상될 때<br/>
										한파주의보 : 아침 최저기온이 -12°C 이하가 2일 이상 지속 될 것이 예상될 때 (10월~4월 사이)<br/>
										황사주의보 : 400㎍/㎥ 이상일 때<br/>
										폭염주의보 : 일 최고기온이 33°C 이상인 상태가 2일 이상 지속될 것으로 예상될 때<br/>
										환불은 주말 제외, 4~5일 정도 소요됩니다.<br/>
									</td>
								</tr>
							</tbody>
						</table>

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
