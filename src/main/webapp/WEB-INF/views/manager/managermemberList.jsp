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
</head>

<body>
	<!-- 헤더 영역 불러오기 -->
	<c:import url="${path}/WEB-INF/views/manager/managerheader.jsp"></c:import>

	<!-- ======= Hero Section ======= -->
	<section id="hero" class="hero">

		<div class="info d-flex align-items-center">
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-lg-10 text-center">
						   
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        th {
            background-color: #f2f2f2;
        }

        tr {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>

<h2 data-aos="fade-down" id="memberListMargin">회원 리스트</h2>	
	<table class="table table-default table-hover">
	    <thead>
	        <tr class="table-dark">
	            <th>id</th>
	            <th>이름</th>
	            <th>전화번호</th>
	            <th>이메일</th>
	            <th>성별</th>
	            <th>가입일</th>
	        </tr>
	    </thead>
	    <c:forEach items="${memberList }" var="mvo">
				<tr>
					<td>${mvo.id }</td>
					<td align="left"><a href="${path}/managemember?id=${mvo.id }">
							${ mvo.name}</a></td>
					<td>${mvo.tel }</td>
					<td>${mvo.email }</td>
					<td>${mvo.gender }</td>
					<td><fmt:formatDate value="${mvo.regDate }" pattern="yyyy-MM-dd"/>${mvo.regDate }</td>	
				</tr>
			</c:forEach>		
	</table>
	
			<form method='get' action='managermemberList'>
			<select name='searchCondition' >
				<option value='ID'>ID</option>
				<option value='name'>이름</option>
				
			</select>
			<input type='text' name='searchKeyword' id='searchBtn'>
			<input type='submit' value='검색' class="searchQuestionBtn">
		</form>
</body>
	<!-- 페이징 -->
		<div id="pagination" class="col-md-12">
    <c:if test="${paging.startPage > 1}">
        <a href="${path}/managermemberList?pageNum=1&searchCondition=${searchCondition}&searchKeyword=${searchKeyword}">&laquo;</a>
    </c:if>
    <c:forEach begin="${paging.startPage}" end="${paging.endPage}" step="1" varStatus="loop">
        <c:choose>
            <c:when test="${loop.index == paging.pageNum}">
                <span class="current">${loop.index}</span>
            </c:when>
            <c:otherwise>
                <a href="${path}/managermemberList?pageNum=${loop.index}&searchCondition=${searchCondition}&searchKeyword=${searchKeyword}">${loop.index}</a>
            </c:otherwise>
        </c:choose>
    </c:forEach>
    <c:if test="${paging.endPage < paging.totalPage}">
        <a href="${path}/managermemberList?pageNum=${paging.totalPage}&searchCondition=${searchCondition}&searchKeyword=${searchKeyword}">&raquo;</a>
    </c:if>
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
