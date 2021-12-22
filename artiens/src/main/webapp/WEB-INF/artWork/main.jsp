<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html dir="ltr" lang="en-US">
<head>

	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<meta name="author" content="SemiColonWeb" />

	<!-- Stylesheets
	============================================= -->
	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="/css/bootstrap.css" type="text/css" />
	<link rel="stylesheet" href="/style.css" type="text/css" />
	<link rel="stylesheet" href="/css/swiper.css" type="text/css" />
	<link rel="stylesheet" href="/css/dark.css" type="text/css" />
	<link rel="stylesheet" href="/css/font-icons.css" type="text/css" />
	<link rel="stylesheet" href="/css/animate.css" type="text/css" />
	<link rel="stylesheet" href="/css/magnific-popup.css" type="text/css" />
	<link rel="stylesheet" href="/css/main.css" type="text/css" />
	<link rel="stylesheet" href="/css/custom.css" type="text/css" />
	<meta name="viewport" content="width=device-width, initial-scale=1" />

	<!-- Document Title
	============================================= -->
	<title>::: ARTIZEN | Main :::</title>

	<style>
		
	</style>

</head>
<body>
    	<!-- Document Wrapper
	============================================= -->
	
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

        <!--Banner img-->
        <!-- Hero Section
		============================================= -->
		<section id="slider" class="slider-element include-header block-slider-1">

			<div class="swiper_wrapper overflow-visible min-vh-60" data-loop="true">

				<div class="swiper-container swiper-parent">
					<div class="swiper-wrapper">

						<div class="swiper-slide dark">
							<div class="container">
								<div class="slider-caption">
									<p class="mb-4 text-white-50 text-smaller" data-animate="fadeInUpSmall">인물화</p>
									<h4 data-animate="fadeInUpSmall" data-delay="200">영국 여성화가</h4>
									<h2 data-animate="fadeInUpSmall" data-delay="200">Jenny Savile</h2>
									<div>
										<a href="#" class="button button-border button-light button-rounded button-large ms-0 topmargin-sm" data-animate="fadeInUpSmall" data-delay="400">더 보기</a>
									</div>
								</div>
							</div>
							<div class="swiper-slide-bg" style="background-image: url('/images/artwork/category/13.jpg');"></div>
						</div>

						<!-- Slide 2 -->
						<div class="swiper-slide dark">
							<div class="container">
								<div class="slider-caption slider-caption-right" style="max-width: 650px;">
									<p class="mb-4 text-white-50 text-smaller" data-animate="fadeInUpSmall">Shop for Women</p>
									<h2 data-animate="fadeInUpSmall" data-delay="200">You will be able to go anywhere.</h2>
									<div>
										<a href="#" class="button button-border button-light button-rounded button-large ms-0 topmargin-sm" data-animate="fadeInUpSmall" data-delay="400">Shop Now</a>
									</div>
								</div>
							</div>
							<div class="swiper-slide-bg" style="background-image: url('/images/artwork/category/11.jpg');"></div>
						</div>

						<!-- Slide 3 -->
						<div class="swiper-slide dark">
							<div class="container">
								<div class="slider-caption slider-caption-center">
									<p class="mb-4 text-white-50 text-smaller" data-animate="fadeInUpSmall">Shop for Kids</p>
									<h2 data-animate="fadeInUpSmall" data-delay="200">Bring power to your steps</h2>
									<div>
										<a href="#" class="button button-border button-light button-rounded button-large ms-0 topmargin-sm" data-animate="fadeInUpSmall" data-delay="400">Shop Now</a>
									</div>
								</div>
							</div>
							<div class="swiper-slide-bg" style="background-image: linear-gradient(rgba(0,0,0,.3), rgba(0,0,0,.5)), url('/images/artwork/category/10.jpg');"></div>
						</div>

					</div>
				</div>

				<div class="slider-arrow-left"><i class="icon-angle-left"></i><span>Prev</span></div>
				<div class="slider-arrow-right"><span>Next</span> <i class="icon-angle-right"></i></div>
				<div class="slide-number font-secondary"><div class="slide-number-current"></div><span></span><div class="slide-number-total op-05"></div></div>
			</div>

		</section>
		
		<!-- Content
		============================================= -->
		<section id="content">
			<div class="content-wrap">

				<div class="container">

					<h1> CATEGORY</h1>
					<hr>
					<div class="block-expand-categories flex-column flex-lg-row d-flex justify-content-center">
						<div class="expand-category bg-light" style="background: linear-gradient(to bottom, transparent, rgba(0,0,0,.3) 75%, rgba(0,0,0,0.9) 100%), url('/images/artwork/category/8.jpg')">
							<h4><a href="#" class="text-light">수묵화</a></h4>
						</div>

						<div class="expand-category bg-light" style="background: linear-gradient(to bottom, transparent, rgba(0,0,0,.3) 75%, rgba(0,0,0,0.9) 100%), url('/images/artwork/category/9.jpg');">
							<h4><a href="#" class="text-light">채색화</a></h4>
						</div>

						<div class="expand-category bg-light" style="background: linear-gradient(to bottom, transparent, rgba(0,0,0,.3) 75%, rgba(0,0,0,0.9) 100%), url('/images/artwork/category/10.jpg');">
							<h4><a href="#" class="text-light">풍경화</a></h4>
						</div>

						<div class="expand-category bg-light" style="background: linear-gradient(to bottom, transparent, rgba(0,0,0,.3) 75%, rgba(0,0,0,0.9) 100%), url('/images/artwork/category/11.jpg');">
							<h4><a href="#" class="text-light">인물화</a></h4>
						</div>

						<div class="expand-category bg-light" style="background: linear-gradient(to bottom, transparent, rgba(0,0,0,.3) 75%, rgba(0,0,0,0.9) 100%), url('/images/artwork/category/12.jpg">
							<h4><a href="#" class="text-light">추상화</a></h4>
						</div>

						<div class="expand-category bg-light" style="background: linear-gradient(to bottom, transparent, rgba(0,0,0,.3) 75%, rgba(0,0,0,0.9) 100%), url('/images/artwork/category/13.jpg');">
							<h4><a href="#" class="text-light">정물화</a></h4>
						</div>

						<div class="expand-category bg-light" style="background: linear-gradient(to bottom, transparent, rgba(0,0,0,.3) 75%, rgba(0,0,0,0.9) 100%), url('/images/artwork/category/14.jpg');">
							<h4><a href="#" class="text-light">팝아트</a></h4>
						</div>
					</div>

					<div class="line"></div>

				</div>

			</div>
		</section>
        <!-- Content
		============================================= -->
		<section id="content">

			<div class="content-wrap" style="margin-top: -200px;">
                <div class="container">
					<h1>ART WORK</h1>
                    <hr>
                    <div class="grid-filter-wrap">
						
						<!-- Portfolio Filter
                            ============================================= -->
						</div>
                        
                        <!-- Portfolio Items
                            ============================================= -->
							<div class="masonry-thumbs grid-container grid-1 grid-md-2 grid-lg-3 block-gallery-9 masonry-gap-lg">
								<c:forEach var="content" items="${result }">
									<div class="grid-item">
										<div class="grid-inner" style="background: linear-gradient(to bottom, transparent, rgba(0,0,0,.3) 75%, rgba(0,0,0,0.9) 100%), url('${content.artworkImgName }') no-repeat center center / cover; height: 400px">
											<div class="bg-overlay position-relative">
												<div class="bg-overlay-content flex-column justify-content-end align-items-start px-5 py-4 dark">
													<div class="entry-meta mb-3">
														<ul>
															<li>1 day ago</li>
															<li><a href="blog-single-thumbs.html#comments"><i class="icon-comments"></i> 15</a></li>
														</ul>
													</div>
													<div class="entry-title title-sm">
														<h3><a href="/artizen/artwork/detail/${content.imageId }">${content.title }</a></h3>
													</div>
													<a href="/artizen/blog/${content.id }">BLOG<i class="icon-line-arrow-right btn-more"></i></a>
												</div>
											</div>
										</div>
									</div>
								</c:forEach>
					</div><!-- #portfolio end -->
					
				</div>
			</div>
		</section><!-- #content end -->
	</div>	
	 <!-- Footer
    ============================================= -->
	<footer id="footer" class="dark" style="margin-top: 0px;">
		<c:import url="../include/footer.jsp"/>
	</footer>
	<!-- #footer end -->

</div><!-- #wrapper end-->

<!-- Go To Top
============================================= -->
<div id="gotoTop" class="icon-angle-up"></div>

<!-- JavaScripts
============================================= -->
<script src="/js/jquery.js"></script>
<script src="/js/plugins.min.js"></script>

<script src="/js/jquery.hotspot.js"></script>
<!-- Footer Scripts
============================================= -->
<script src="/js/functions.js"></script>
    </body>