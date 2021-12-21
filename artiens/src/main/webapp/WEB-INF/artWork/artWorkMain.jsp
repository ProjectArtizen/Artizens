<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="author" content="SemiColonWeb" />

<!-- Stylesheets
	============================================= -->
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<link
	href="https://fonts.googleapis.com/css?family=Lato:300,400,400i,700|Poppins:300,400,500,600,700|PT+Serif:400,400i&display=swap"
	rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="/css/bootstrap.css" type="text/css" />
<link rel="stylesheet" href="/style.css" type="text/css" />
<link rel="stylesheet" href="/css/dark.css" type="text/css" />
<link rel="stylesheet" href="/css/font-icons.css" type="text/css" />
<link rel="stylesheet" href="/css/animate.css" type="text/css" />
<link rel="stylesheet" href="/css/magnific-popup.css" type="text/css" />

<link rel="stylesheet" href="/css/custom.css" type="text/css" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>작품메인페이지</title>
<style>
.block-expand-categories h1, .block-expand-categories h2,
	.block-expand-categories h3 {
	font-family: Playfair Display, serif !important;
}

.block-expand-categories .expand-category { -
	-height: 50vh; -
	-responsive-height: 60px; -
	-hover-flex: 10;
	position: relative;
	background-position: center center;
	background-size: cover;
	border-radius: 20px;
	margin: 10px 0;
	min-height: var(- -responsive-height);
	cursor: pointer;
}

.block-expand-categories .expand-category h4 {
	position: absolute;
	top: 50%;
	left: 0;
	right: 0;
	text-align: center;
	margin: 0;
	transform: translateY(-50%);
}

/* Larger Device */
@media ( min-width : 992px) {
	.block-expand-categories .expand-category {
		height: var(- -height);
		flex: 1;
		margin: 0 10px;
		transition: flex 1s ease;
		-webkit-backface-visibility: hidden;
		transform: translate3d(0, 0, 0);
	}
	.block-expand-categories:not(.on-click) .expand-category:hover,
		.block-expand-categories.on-click .expand-category.active {
		flex: var(- -hover-flex);
	}
	.block-expand-categories .expand-category h4 {
		opacity: 1;
		top: auto;
		bottom: 10px;
		transform: none;
		transition: opacity .4s ease;
	}
	.block-expand-categories:hover .expand-category:not(.active):not(:hover) h4,
		.block-expand-categories.on-click .expand-category:not(.active) h4 {
		opacity: 0;
	}
}
</style>
</head>
<body class="stretched">

	<!-- Document Wrapper
	============================================= -->
	<div id="wrapper" class="clearfix">

		<!-- Header
		============================================= -->
		<header id="header"
			class="full-header transparent-header semi-transparent dark">
			<c:choose>
				<c:when test="${userid eq null }">
					<c:import url="../include/noneLoginHeader.jsp" />
				</c:when>
				<c:when test="${userid ne null }">
					<c:import url="../include/header.jsp" />
				</c:when>
			</c:choose>
		</header>
		<!-- #header end -->
		
		<!-- 상세내용
		============================================= -->
		<section id="content">
			<div class="content-wrap"
				style="padding-top: 0px; margin-bottom: 0px;">

				<div class="container">

					<h2 class="text-center">Category</h2><br>
					<div class="block-expand-categories flex-column flex-lg-row d-flex justify-content-center" style="height:500px;"/>
						<div class="expand-category bg-light" style="background-image: url('/images/artwork/category/8.jpg');"
							onclick="location.href='artWorkInkPainting'">
							<h4 class="text-light">수묵화</h4>
						</div>

						<div class="expand-category bg-light"
							style="background-image: url('/images/artwork/category/9.jpg');"
							onclick="location.href='artWorkColoring'">
							<h4 class="text-light">채색화</h4>
						</div>

						<div class="expand-category bg-light"
							style="background-image: url('/images/artwork/category/10.jpg');"
							onclick="location.href='artWorkLandscape'">
							<h4 class="text-light">풍경화</h4>
						</div>

						<div class="expand-category bg-light"
							style="background-image: url('/images/artwork/category/11.jpg');"
							onclick="location.href='artWorkFigure'">
							<h4 class="text-light">인물화</h4>
						</div>

						<div class="expand-category bg-light"
							style="background-image: url('/images/artwork/category/12.jpg');"
							onclick="location.href='artWorkAbstract'">
							<h4 class="text-light">추상화</h4>
						</div>

						<div class="expand-category bg-light"
							style="background-image: url('/images/artwork/category/13.jpg');"
							onclick="location.href='artWorkStill'">
							<h4 class="text-light">정물화</h4>
						</div>

						<div class="expand-category bg-light"
							style="background-image: url('/images/artwork/category/14.jpg');"
							onclick="location.href='artWorkPop'">
							<h4 class="text-light">팝아트</h4>
						</div>
					</div>

					<div class="line" style="margin-bottom: 45px;"></div>
					<h2 class="text-center">ArtWork</h2>
				</div>
				<div class="container">
					<!-- Posts
				============================================= -->
					<div id="posts" class="post-grid grid-container row gutter-40 mx-3">
						<c:forEach var="content" items="${result }"> 
						<div class="entry col-lg-3 col-md-4 col-sm-6 col-12">
							<div class="grid">
								<div class="entry-image">
									<a style="cursor:pointer;" onclick="location.href='/artizen/blog/${content.id}'"><img
										src="${content.artworkImgName }"
										alt="Standard Post with Image"></a>
								</div>
								<div class="entry-title">
									<h2>
										<a href="blog-single.html">${content.title }</a>
									</h2>
								</div>
								<div class="author-image" style="margin-top: 15px;">
									<img src="${content.creatorImgName }" alt="image"
										class="rounded-circle">
								</div>
								<div class="entry-meta"
									style="margin-top: 55px; padding-left: 10px;">
									<ul>
										<li><a href="blog-single.html#comments"><i
												class="icon-comments"></i> 13</a></li>
										<li><a href="#"><i class="icon-thumbs-up2"></i> 20</a></li>
									</ul>
								</div>
							</div>
						</div>
						
						</c:forEach>
						
						<div class="entry col-lg-3 col-md-4 col-sm-6 col-12">
							<div class="grid-inner">
								
								<div class="entry-image">
									<a href="/images/artwork/category/8.jpg" data-lightbox="image"><img
										src="/images/artwork/category/8.jpg"
										alt="Standard Post with Image"></a>
								</div>
								<div class="entry-title">
									<h2>
										<a href="blog-single.html"></a>
									</h2>
								</div>
								<div class="author-image" style="margin-top: 15px;">
									<img src="/images/artwork/author1.jpg" alt="image"
										class="rounded-circle">
								</div>
								<div class="entry-meta"
									style="margin-top: 55px; padding-left: 10px;">
									<ul>
										<li><a href="blog-single.html#comments"><i
												class="icon-comments"></i> 13</a></li>
										<li><a href="#"><i class="icon-thumbs-up2"></i> 20</a></li>
									</ul>
								</div>


							</div>
						</div>

						<div class="entry col-lg-3 col-md-4 col-sm-6 col-12">
							<div class="grid-inner">
								<div class="entry-image">
									<a href="/images/blog/full/9.jpg" data-lightbox="image"><img
										src="/images/artwork/category/9.jpg"
										alt="Standard Post with Image"></a>
								</div>
								<div class="entry-title">
									<h2>
										<a href="blog-single.html">작품 타이틀</a>
									</h2>
								</div>
								<div class="author-image" style="margin-top: 15px;">
									<img src="/images/artwork/author1.jpg" alt="image"
										class="rounded-circle">
								</div>
								<div class="entry-meta"
									style="margin-top: 55px; padding-left: 10px;">
									<ul>
										<li><a href="blog-single.html#comments"><i
												class="icon-comments"></i> 13</a></li>
										<li><a href="#"><i class="icon-thumbs-up2"></i> 20</a></li>
									</ul>
								</div>

							</div>
						</div>

						<div class="entry col-lg-3 col-md-4 col-sm-6 col-12">
							<div class="grid-inner">
								<div class="entry-image">
									<a href="/images/blog/full/17.jpg" data-lightbox="image"><img
										src="/images/artwork/category/10.jpg"
										alt="Standard Post with Image"></a>
								</div>
								<div class="entry-title">
									<h2>
										<a href="blog-single.html">작품 타이틀</a>
									</h2>
								</div>
								<div class="author-image" style="margin-top: 15px;">
									<img src="/images/artwork/author1.jpg" alt="image"
										class="rounded-circle">
								</div>
								<div class="entry-meta"
									style="margin-top: 55px; padding-left: 10px;">
									<ul>
										<li><a href="blog-single.html#comments"><i
												class="icon-comments"></i> 13</a></li>
										<li><a href="#"><i class="icon-thumbs-up2"></i> 20</a></li>
									</ul>
								</div>

							</div>
						</div>

						<div class="entry col-lg-3 col-md-4 col-sm-6 col-12">
							<div class="grid-inner">
								<div class="entry-image">
									<a href="/images/blog/full/17.jpg" data-lightbox="image"><img
										src="/images/artwork/category/11.jpg"
										alt="Standard Post with Image"></a>
								</div>
								<div class="entry-title">
									<h2>
										<a href="blog-single.html">작품 타이틀</a>
									</h2>
								</div>
								<div class="author-image" style="margin-top: 15px;">
									<img src="/images/artwork/author1.jpg" alt="image"
										class="rounded-circle">
								</div>
								<div class="entry-meta"
									style="margin-top: 55px; padding-left: 10px;">
									<ul>
										<li><a href="blog-single.html#comments"><i
												class="icon-comments"></i> 13</a></li>
										<li><a href="#"><i class="icon-thumbs-up2"></i> 20</a></li>
									</ul>
								</div>

							</div>
						</div>

						<div class="entry col-lg-3 col-md-4 col-sm-6 col-12">
							<div class="grid-inner">
								<div class="entry-image">
									<a href="/images/blog/full/17.jpg" data-lightbox="image"><img
										src="/images/artwork/category/12.jpg"
										alt="Standard Post with Image"></a>
								</div>
								<div class="entry-title">
									<h2>
										<a href="blog-single.html">작품 타이틀</a>
									</h2>
								</div>
								<div class="author-image" style="margin-top: 15px;">
									<img src="/images/artwork/author1.jpg" alt="image"
										class="rounded-circle">
								</div>
								<div class="entry-meta"
									style="margin-top: 55px; padding-left: 10px;">
									<ul>
										<li><a href="blog-single.html#comments"><i
												class="icon-comments"></i> 13</a></li>
										<li><a href="#"><i class="icon-thumbs-up2"></i> 20</a></li>
									</ul>
								</div>

							</div>
						</div>

						<div class="entry col-lg-3 col-md-4 col-sm-6 col-12">
							<div class="grid-inner">
								<div class="entry-image">
									<a href="/images/blog/full/17.jpg" data-lightbox="image"><img
										src="/images/artwork/category/13.jpg"
										alt="Standard Post with Image"></a>
								</div>
								<div class="entry-title">
									<h2>
										<a href="blog-single.html">작품 타이틀</a>
									</h2>
								</div>
								<div class="author-image" style="margin-top: 15px;">
									<img src="/images/artwork/author1.jpg" alt="image"
										class="rounded-circle">
								</div>
								<div class="entry-meta"
									style="margin-top: 55px; padding-left: 10px;">
									<ul>
										<li><a href="blog-single.html#comments"><i
												class="icon-comments"></i> 13</a></li>
										<li><a href="#"><i class="icon-thumbs-up2"></i> 20</a></li>
									</ul>
								</div>

							</div>
						</div>


					</div>
					<!-- #posts end -->
				</div>

			</div>

		</section>
		<!-- #content end -->

		<!-- Footer
				============================================= -->
		<footer id="footer" class="dark" style="margin-top: 0px;">
			<%@ include file="../include/footer.jsp"%>
		</footer>
		<!-- #footer end -->
	</div>
	<!-- #wrapper end -->



	<!-- Go To Top
	============================================= -->
	<div id="gotoTop" class="icon-angle-up"></div>

	<!-- JavaScripts
	============================================= -->
	<script src="/js/jquery.js"></script>
	<script src="/js/plugins.min.js"></script>

	<!-- Footer Scripts
	============================================= -->
	<script src="/js/functions.js"></script>

	<script>
		$(document).ready(
				function() {

					jQuery('.block-expand-categories').find('.expand-category')
							.on('click', function() {
								let category = $(this);

								category.siblings().removeClass('active');
								category.addClass('active');
							});

				});
	</script>

</body>
</html>