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
	$(function() {
		$("input[name=rPicture]").off().on("change", function() {

			if (this.files && this.files[0]) {

				var maxSize = 10 * 1024 * 1024;
				var fileSize = this.files[0].size;

				if (fileSize > maxSize) {
					alert("첨부파일 사이즈는 10MB 이내로 등록 가능합니다.");
					$(this).val('');
					return false;
				}
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

					<h2 data-aos="fade-down" id='insertMemberForm'>리뷰</h2>

					<div class="row gy-4">
						<!-- 리뷰 사진들 출력 -->
						<c:if test="${reviewList.size() > 0 }">
							<c:forEach var="i" begin="0" end="${reviewList.size()-1 }">
								<c:if test="${ i != 0 && i % 6 == 0 }">
									<br />
								</c:if>
								<div class="col-md-2">
									<!-- 이미지 클릭 시 아이디와 상품 번호를 컨트롤러로 보냄 -->
									<a href="${path}/review?id=${id}&pNo=${reviewList.get(i).pNo}&pageNum=${pageNum}">
										<img
										src="${path}/resources/reviewUpload/${reviewList.get(i).r_frealname}"
										alt="${reviewList.get(i).pNo }" width="200px" height=""
										class="img-fluid">
									</a>
								</div>
							</c:forEach>
						</c:if>
						<!-- 리뷰 사진들 페이징 -->
						<div class="col-md-12" id="pageNum">
							<c:forEach var="i" begin="${pVO.startPage }"
								end="${pVO.endPage }">
								<c:if test="${sessionScope.logid == null }">
									<a href="${path}/review?pageNum=${i}&pageNum2=${pageNum2}&id=${id}&pNo=${pNo}">${i }</a>
								</c:if>
								<c:if test="${sessionScope.logid != null }">
									<a href="${path}/review?pageNum=${i}&pageNum2=${pageNum2}&id=${sessionScope.logid}&pNo=${pNo}">${i }</a>
								</c:if>
							</c:forEach>
						</div>

						<c:if test="${pNo > 0 }">
							<div class="row gy-4">

								<hr/>
								<table class="table">
									<tbody>
										<tr>
											<td colspan="6"><img
												src="${path}/resources/assets/img/stadium.png" alt=""
												width="300px" height="" class="img-fluid"></td>
										</tr>
										<tr>
											<td>구장명</td>
											<td>${productVO.pName }</td>
											<td>구장위치</td>
											<td>${productVO.pLocation }</td>
											<td>구장가격</td>
											<td>${productVO.pPrice }</td>
										</tr>
										<tr>
											<td>구장정보</td>
											<td colspan="5">${productVO.pInfo }</td>
										</tr>
									</tbody>
								</table>

							</div>
						</c:if>
						<div class="row gy-4">
							<h2 data-aos="fade-down" id='insertMemberForm'>${productVO.pName}</h2>
							<table class="table">
								<thead>
									<tr>
										<th>아이디</th>
										<th>제목</th>
										<th>리뷰내용</th>
										<th></th>
										<th>구장명</th>
										<th>파일</th>
										<th></th>
									</tr>
								</thead>
								<tbody>
	
									<!-- 상품번호에 해당하는 전체 리스트 출력 -->
									<c:if test="${reviewListPaging.size() > 0 }">
										<c:forEach var="i" begin="0"
											end="${reviewListPaging.size() - 1 }">
											<c:if test="${pNo == reviewListPaging.get(i).pNo }">
												<tr>
													<td>${reviewListPaging.get(i).id }</td>
													<td>${reviewListPaging.get(i).rTitle }</td>
													<td colspan="2">${reviewListPaging.get(i).rContent }</td>
													<td>${reviewListPaging.get(i).rTitle }</td>
													<td><img
														src="${path}/resources/reviewUpload/${reviewListPaging.get(i).r_frealname}"
														alt="" width="150px" height="150px" class="img-fluid"></td>
												</tr>
											</c:if>
										</c:forEach>
									</c:if>
									
									<!-- 리뷰 등록하기 -->
									<form action="${path}/insertReview" method="post" enctype="multipart/form-data">
										<tr>
											<td>${id }</td>
											<td><input type="text" name="rTitle" required="required"></td>
											<td colspan="2"><input type="text" name="rContent">
											</td>
											<td><select name="pNo">
													<c:if test="${productList.size()>0 }">
														<c:forEach var="i" begin="0" end="${productList.size()-1 }">
															<option value="${productList.get(i).pNo }">${productList.get(i).pName}</option>
														</c:forEach>
													</c:if>
											</select></td>
											<td><input type="file" name="rPicture" accept="image/*" /></td>
											<td><input type="hidden" name="id" value="${id}" /> <input
												type="hidden" name="pageNum" value="${pageNum}" /> <input
												type="submit" value="리뷰쓰기" class="findIdBtn" /></td>
										</tr>
									</form>
								</tbody>
							</table>
							
							<!-- 리뷰 사진들 페이징 -->
							<div class="col-md-12" id="pageNum2">
								<c:forEach var="i" begin="${pVO2.startPage }"
									end="${pVO2.endPage }">
									<c:if test="${sessionScope.logid == null }">
										<a href="${path}/review?pageNum=${pageNum}&pageNum2=${i}&id=${id}&pNo=${pNo}">${i }</a>
									</c:if>
									<c:if test="${sessionScope.logid != null }">
										<a href="${path}/review?pageNum=${pageNum}&pageNum2=${i}&id=${sessionScope.logid}&pNo=${pNo}">${i }</a>
									</c:if>
								</c:forEach>
							</div>
							
						</div>
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
