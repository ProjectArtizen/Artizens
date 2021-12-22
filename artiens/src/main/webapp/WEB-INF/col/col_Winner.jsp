<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<meta name="author" content="SemiColonWeb" />
	<!-- Stylesheets ============================================= -->
	<link href="https://fonts.googleapis.com/css?family=Lato:300,400,400i,700|Poppins:300,400,500,600,700|PT+Serif:400,400i&display=swap" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href="/css/bootstrap.css" type="text/css" />
	<link rel="stylesheet" href="/style.css" type="text/css" />
	<link rel="stylesheet" href="/css/dark.css" type="text/css" />
	<link rel="stylesheet" href="/css/font-icons.css" type="text/css" />
	<link rel="stylesheet" href="/css/animate.css" type="text/css" />
	<link rel="stylesheet" href="/css/magnific-popup.css" type="text/css" />
	<link rel="stylesheet" href="/css/custom.css" type="text/css" />
	<meta name="viewport" content="width=device-width, initial-scale=1" /> 
	<!-- Document Title	============================================= -->
	<title>대상자 선정 페이지</title>
</head>
<body class="stretched">
	<!-- Document Wrapper ============================================= -->
	<div id="wrapper">
	
		<!-- Header ============================================= -->
		<header id="header" 
				class="full-header transparent-header semi-transparent dark">
			<%@ include file="../include/header.jsp"%>
		</header><!-- #header end -->
		
		<!-- 타이틀 ============================================= -->
		<section id="page-title" 
				 class="page-title-center"
				 style="background-color: white; 
				 		border: none; 
				 		padding-bottom: 0px;">
			<div class="container clearfix" style="background-color: white;">

				<h1>콜라보레이션 타이틀</h1>
				<span style="margin-top: 20px;">
					<div class="d-flex align-items-center" style="justify-content: center;">
						<a href="#">
							<img src="/images/collaboration/author.jpg"
								 alt="Author" 
								 class="rounded-circle" 
								 width="35" 
								 height="35">
						</a>
						<div class="entry-meta mt-0">
							<div class="entry-meta"
								 style="margin-bottom: 10px; padding-left: 10px;">
								<ul>
									<li><a href="/blog/{blogURL}">Author</a></li>
									<li><i class="icon-calendar3"></i>2021.11.21</li>
								</ul>
							</div>
						</div>
					</div>
				</span>
				
				<div style="width: 1600px;">
					<!-- 서브메뉴 ============================================= -->
					<nav class="primary-menu"
						 style="margin-top: 100px; 
						 		border-top: 2px solid #f3f3f3; 
						 		border-bottom: 2px solid #f3f3f3">

						<ul class="menu-container" style="margin-Left: 150px;">
							<li class="menu-item">
								<a class="menu-link" href="../artizen/colDetail">
									<div style="font-size: 20px; font-weight: normal;">콜라보레이션 소개</div>
								</a>
							</li>
							<li class="menu-item">
								<a class="menu-link" href="../artizen/colArtList">
									<div style="font-size: 20px; font-weight: normal;">참여작품</div>
								</a>
							</li>
							<div style="margin-left: 750px;">
								<a href="#block-modal-request" data-lightbox="inline" data-target="#block-modal-request">
									<button class="button m-3">당선작 선정하기</button>
								</a>			
							</div>
						</ul>

					</nav><!-- 서브메뉴 끝 -->
				</div>
			</div>

		</section><!-- 타이틀 끝 -->
		
		<!-- 대상자 선정 리스트 ============================================= -->
		<section id="content">
			<div class="content-wrap">
				<div class="container">

					<table class="table cart mb-5">
						<thead>
							<tr>
								<th class="cart-product-remove" colspan="2">&nbsp;</th>
								<th class="cart-product-thumbnail">title</th>
								<th class="cart-product-name">&nbsp;</th>
								<th class="cart-product-price">creator</th>
								<th class="cart-product-subtotal">choice</th>
							</tr>
						</thead>
						<tbody>
							<tr class="cart_item">
								<td class="cart-product-thumbnail" colspan="2">
									<a href="/{collaborationId}"><img src="https://sunminki.s3.ap-northeast-2.amazonaws.com/7ee3d22c-4284-430b-aae4-f516c3a5682a.JPG"></a>
								</td>

								<td class="cart-product-name">
									<a href="#">Pink Printed Dress</a>
								</td>

								<td class="cart-product-quantity">
									<a href="#">creatorName</a>
								</td>

								<td class="cart-product-subtotal">
									<input type="checkbox" name="">
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</section><!-- #content end -->	
	
		<!-- Footer ============================================= -->
		<footer id="footer" class="dark">
			<%@ include file="../include/footer.jsp"%>
		</footer><!-- #footer end -->	
  
	</div><!-- #wrapper end -->

	<!-- Go To Top ============================================= -->
	<div id="gotoTop" class="icon-angle-up"></div>

	<!-- JavaScripts ============================================= -->
 	<script src="/js/jquery.js"></script>
	<script src="/js/plugins.min.js"></script>

	<!-- Footer Scripts
	============================================= -->
	<script src="/js/functions.js"></script>
</body>
</html>