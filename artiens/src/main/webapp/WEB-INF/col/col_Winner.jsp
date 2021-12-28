<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="author" content="SemiColonWeb" />
<!-- Stylesheets ============================================= -->
<link href="https://fonts.googleapis.com/css?family=Lato:300,400,400i,700|Poppins:300,400,500,600,700|PT+Serif:400,400i&display=swap" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href='<c:url value="/css/bootstrap.css"></c:url>' type="text/css" />
<link rel="stylesheet" href='<c:url value="/style.css"></c:url>' type="text/css" />
<link rel="stylesheet" href='<c:url value="/css/dark.css"></c:url>' type="text/css" />
<link rel="stylesheet" href='<c:url value="/css/font-icons.css"></c:url>' type="text/css" />
<link rel="stylesheet" href='<c:url value="/css/animate.css"></c:url>' type="text/css" />
<link rel="stylesheet" href='<c:url value="/css/magnific-popup.css"></c:url>' type="text/css" />
<link rel="stylesheet" href='<c:url value="/css/custom.css"></c:url>' type="text/css"/>
<meta name="viewport" content="width=device-width, initial-scale=1" />

<!-- Document Title	============================================= -->
<title>대상자 선정 페이지</title>
</head>

<body class="stretched">
	<!-- Document Wrapper ============================================= -->
	<div id="wrapper">

		<!-- Header
		============================================= -->
		<header id="header" class="full-header transparent-header semi-transparent dark">
			<c:choose>
				<c:when test="${userid eq null }">
					<c:import url="../include/noneLoginHeader.jsp" />
				</c:when>
				<c:when test="${userid ne null }">
					<c:import url="../include/header.jsp" />
				</c:when>
			</c:choose>
		</header><!-- #header end -->

		<!-- 타이틀 ============================================= -->
		<section id="page-title" class="page-title-center"
			style="background-color: white; border: none; padding-bottom: 0px;">
			<div class="container clearfix" style="background-color: white;">

				<h1>${collaborator.title }</h1>
				<span style="margin-top: 20px;">
					<div class="d-flex align-items-center"
						style="justify-content: center;">
						<a href="/blog/${collaborator.creatorId }"> <img src="${collaborator.creatorimage }"
							alt="Author" class="rounded-circle" width="35" height="35">
						</a>
						<div class="entry-meta mt-0">
							<div class="entry-meta" style="margin-bottom: 10px; padding-left: 10px;">
								<ul>
									<li><a href="/blog/${collaborator.creatorId }">${collaborator.onenickname }</a></li>
									<li><i class="icon-calendar3"></i>${collaborator.registerdate }</li>
								</ul>
							</div>
						</div>
					</div>
				</span>

				<!-- 서브메뉴 ============================================= -->
				<%@ include file="../include/colNav.jsp"%>
				<!-- 서브메뉴 끝 -->
			</div>

		</section>
		<!-- 타이틀 끝 -->

		<!-- 대상자 선정 리스트 ============================================= -->
		<section id="content">
			<div class="content-wrap">
				<div class="container">
					<form name="frm" method="POST" action="/collaboration/choice" >
					<table class="table cart mb-5">
						<colgroup>
							<col width="30%">
							<col width="30%">
							<col width="30%">
							<col width="10%">
						</colgroup>
						<thead>
							<tr class="fs-4">
								<th class="cart-product-remove">image</th>
								<th class="cart-product-thumbnail">title</th>
								<th class="cart-product-thumbnail">creator</th>
								<th class="cart-product-subtotal">choice</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="result" items="${result}">
								<tr class="cart_item">
									<td class="cart-product-thumbnail">
										<a href="${result.image }" data-lightbox="image">
											<img width="240" height="128" src="${result.image }">
										</a>
									</td>

									<td class="cart-product-name">
										<a href="/collaboration/art/${result.colArtworkId }">${result.title }</a>
									</td>

									<td class="cart-product-name">
										<a href="/blog/${result.creatorId }">${result.nickname }</a>
									</td>

									<td class="cart-product-subtotal">
										<input type="checkbox" name="checkeds" value="${result.colArtworkId }"></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div class="row">
						<div class="col" style="text-align: right">
							<button type="submit" name="submit" id="btn_save"
									class="button button-3d mt-2 mt-sm-0 me-0 ">대상자 선정</button>
						</div>
					</div>
					</form>
				</div>
			</div>
		</section>
		<!-- #content end -->

		<!-- Footer ============================================= -->
		<footer id="footer" class="dark">
			<%@ include file="../include/footer.jsp"%>
		</footer>
		<!-- #footer end -->

	</div>
	<!-- #wrapper end -->
	
	

	<!-- Go To Top ============================================= -->
	<div id="gotoTop" class="icon-angle-up"></div>

	<!-- JavaScripts ============================================= -->
	<script src='<c:url value="/js/jquery.js"/>'/></script>
	<script src='<c:url value="/js/plugins.min.js"/>'/></script>
	<!-- Footer Scripts
	============================================= -->
	<script src='<c:url value="/js/functions.js"/>'/></script>
</body>
</html>