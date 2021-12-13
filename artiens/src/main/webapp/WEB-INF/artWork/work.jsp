<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html dir="ltr" lang="en-ko">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="author" content="SemiColonWeb" />
<!-- Stylesheets
    ============================================= -->
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="../css/bootstrap.css" type="text/css" />
<link rel="stylesheet" href="../style.css" type="text/css" />
<link rel="stylesheet" href="../css/swiper.css" type="text/css" />
<link rel="stylesheet" href="../css/dark.css" type="text/css" />
<link rel="stylesheet" href="../css/font-icons.css" type="text/css" />
<link rel="stylesheet" href="../css/animate.css" type="text/css" />
<link rel="stylesheet" href="../css/magnific-popup.css" type="text/css" />

<link rel="stylesheet" href="../css/custom.css" type="text/css" />
<meta name="viewport" content="width=device-width, initial-scale=1" />

<!-- Document Title
    ============================================= -->
<title>::: ARTIZEN ::: 작품</title>

</head>
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

/* -------------------------------------------------------------*/
* {
	font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto,
		Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
}

.block-slider-1 .search-form {
	width: 120px;
	transition: width .3s ease;
}

@media ( min-width : 768px) {
	.block-slider-1 .search-form {
		width: 200px;
		transition: width .3s ease;
	}
	.block-slider-1 .search-form:focus-within {
		width: 300px;
	}
}

#header.dark.block-slider-1 .search-form {
	border-bottom-color: rgba(255, 255, 255, 0.6) !important;
}

.block-slider-1.dark .search-form input:focus::-moz-placeholder {
	color: #BBB;
}

.block-slider-1.dark .search-form input:focus:-ms-input-placeholder {
	color: #BBB;
}

.block-slider-1.dark .search-form input:focus::-webkit-input-placeholder
	{
	color: #BBB;
}

.dark .search-form .form-control:not(.not-dark), .dark .search-form i {
	color: #EEE;
}

.block-slider-1 { -
	-t-color: #EEE;
}

.block-slider-1 .slide-number {
	display: flex;
	flex-direction: row;
	align-items: center;
	opacity: 1;
	top: 50%;
	bottom: auto !important;
	left: auto;
	right: 20px;
	color: var(- -t-color);
	text-shadow: none;
	width: auto;
	height: auto;
	padding: 0;
	writing-mode: vertical-rl;
	transform: translateY(-50%);
}

.block-slider-1 .slide-number-current, .block-slider-1 .slide-number-total
	{
	position: relative;
	top: auto;
	bottom: auto;
}

.block-slider-1 .slide-number span {
	position: relative;
	height: 30px;
	width: 1px;
	background-color: var(- -t-color);
	margin: 30px 0;
}

.block-slider-1 .slider-arrow-left, .block-slider-1 .slider-arrow-right
	{
	display: flex;
	align-items: center;
	width: auto;
	height: auto;
	top: auto;
	left: auto;
	right: 110px;
	bottom: 30px;
	transform: translateY(0);
	color: var(- -t-color);
	background-color: transparent !important;
}

.block-slider-1 .slider-arrow-left span, .block-slider-1 .slider-arrow-right span
	{
	margin: 0 10px;
	text-transform: uppercase;
	font-size: 14px;
	letter-spacing: 1px;
}

.block-slider-1 .slider-arrow-left:hover, .block-slider-1 .slider-arrow-right:hover
	{
	background-color: transparent !important;
}

.block-slider-1 .slider-arrow-right {
	right: 30px;
}

.block-slider-1 .slider-arrow-left i, .block-slider-1 .slider-arrow-right i
	{
	position: relative;
	color: var(- -t-color);
	text-shadow: none;
	font-size: 20px;
}
</style>
<body>
	<!-- HEADER
============================================= -->
	<header id="header"
		class="full-header transparent-header semi-transparent dark">
		<jsp:include page="../include/header.jsp"></jsp:include>
	</header>

	<!--Banner img
============================================= -->
	<section id="slider"
		class="slider-element include-header block-slider-1">

		<div class="swiper_wrapper overflow-visible min-vh-60"
			data-loop="true">

			<div class="swiper-container swiper-parent">
				<div class="swiper-wrapper">
					<!-- Slide 1 -->
					<div class="swiper-slide dark">
						<div class="container">
							<div class="slider-caption slider-caption-left">
								<p class="mb-0 text-white-50 text-smaller"
									data-animate="fadeInUpSmall">인물화</p>
								<h4 class="mb-0" data-animate="fadeInUpSmall" data-delay="200">YBA
									여성 화가</h4>
								<p class="mt-0 mb-4 text-white-20 text-smaller"
									data-animate="fadeInUpSmall">Jenny Saville</p>
								<h2 data-animate="fadeInUpSmall" data-delay="200">
									미추의 벽을 <br>부수는 아티스트
								</h2>
								<div>
									<a href="#"
										class="button button-border button-light button-rounded button-middle ms-0 topmargin-sm"
										data-animate="fadeInUpSmall" data-delay="400">더 보기</a>
								</div>
							</div>
						</div>
						<div class="swiper-slide-bg"
							style="background-image: linear-gradient(rgba(0, 0, 0, .3), rgba(0, 0, 0, .5)), url('../images/blocks/preview/slider-1/4.jpg');"></div>
					</div>

					<!-- Slide 2 -->
					<div class="swiper-slide dark">
						<div class="container">
							<div class="slider-caption slider-caption-left"
								style="max-width: 650px;">
								<p class="text-white-20 text-smaller"
									data-animate="fadeInUpSmall">풍경화</p>
								<h4 class="mb-0" data-animate="fadeInUpSmall" data-delay="400">영국
									풍경화가</h4>
								<p class="mt-0 mb-3 text-white-20 text-smaller"
									data-animate="fadeInUpSmall">Adward Hopper</p>
								<h2 data-animate="fadeInUpSmall" data-delay="400">현대사회의
									고독함과 외로움을 표현한 작가</h2>
								<div>
									<a href="#"
										class="button button-border button-light button-rounded button-large ms-0 topmargin-sm"
										data-animate="fadeInUpSmall" data-delay="400">더 보기</a>
								</div>
							</div>
						</div>
						<div class="swiper-slide-bg"
							style="background-image: linear-gradient(rgba(0, 0, 0, .3), rgba(0, 0, 0, .5)), url('../images/blocks/preview/slider-1/5.jpg');"></div>
					</div>

					<!-- Slide 2 -->
					<div class="swiper-slide dark">
						<div class="container">
							<div class="slider-caption slider-caption-center">
								<p class="text-white-20 text-smaller"
									data-animate="fadeInUpSmall">추상화</p>
								<h4 class="mb-0" data-animate="fadeInUpSmall" data-delay="200">현대
									추상화의 거장</h4>
								<p class="mt-0 mb-3 text-white-20 text-smaller"
									data-animate="fadeInUpSmall">Gerhard Richter</p>
								<h2 data-animate="fadeInUpSmall" data-delay="200">구상과 추상,
									사진과 회화의 경계를 넘나들다</h2>
								<div>
									<a href="#"
										class="button button-border button-light button-rounded button-large ms-0 topmargin-sm"
										data-animate="fadeInUpSmall" data-delay="400">더 보기</a>
								</div>
							</div>
						</div>
						<div class="swiper-slide-bg"
							style="background-image: linear-gradient(rgba(0, 0, 0, .3), rgba(0, 0, 0, .5)), url('../images/blocks/preview/slider-1/7.jpg');"></div>
					</div>

				</div>
			</div>

			<div class="slider-arrow-left">
				<i class="icon-angle-left"></i><span>Prev</span>
			</div>
			<div class="slider-arrow-right">
				<span>Next</span> <i class="icon-angle-right"></i>
			</div>
			<div class="slide-number font-secondary">
				<div class="slide-number-current"></div>
				<span></span>
				<div class="slide-number-total op-05"></div>
			</div>
		</div>

	</section>

	<!-- Document Wrapper
	============================================= -->
	<div id="wrapper" class="clearfix">

		<!-- Content
		============================================= -->
		<section id="content">
			<div class="content-wrap">

				<div class="container">

					<h2 class="text-left border-bottom p-2">Category</h2>
					<div
						class="block-expand-categories flex-column flex-lg-row d-flex justify-content-center">
						<div class="expand-category bg-light"
							style="background: linear-gradient(to bottom, transparent, rgba(0, 0, 0, .3) 75%, rgba(0, 0, 0, 0.9) 100%), url('images/artwork/category/8.jpg') no-repeat center center; background-size: cover;">
							<h4>
								<a href="#" class="text-light">수묵화</a>
							</h4>
						</div>

						<div class="expand-category bg-light"
							style="background: linear-gradient(to bottom, transparent, rgba(0, 0, 0, .3) 75%, rgba(0, 0, 0, 0.9) 100%), url('images/artwork/category/9.jpg') no-repeat center center; background-size: cover;">
							<h4>
								<a href="#" class="text-light">채색화</a>
							</h4>
						</div>

						<div class="expand-category bg-light"
							style="background: linear-gradient(to bottom, transparent, rgba(0, 0, 0, .3) 75%, rgba(0, 0, 0, 0.9) 100%), url('images/artwork/category/10.jpg') no-repeat center center; background-size: cover;">
							<h4>
								<a href="#" class="text-light">풍경화</a>
							</h4>
						</div>

						<div class="expand-category bg-light"
							style="background: linear-gradient(to bottom, transparent, rgba(0, 0, 0, .3) 75%, rgba(0, 0, 0, 0.9) 100%), url('images/artwork/category/11.jpg') no-repeat center center; background-size: cover;">
							<h4>
								<a href="#" class="text-light">인물화</a>
							</h4>
						</div>

						<div class="expand-category bg-light"
							style="background: linear-gradient(to bottom, transparent, rgba(0, 0, 0, .3) 75%, rgba(0, 0, 0, 0.9) 100%), url('images/artwork/category/12.jpg') no-repeat center center; background-size: cover;">
							<h4>
								<a href="#" class="text-light">추상화</a>
							</h4>
						</div>

						<div class="expand-category bg-light"
							style="background: linear-gradient(to bottom, transparent, rgba(0, 0, 0, .3) 75%, rgba(0, 0, 0, 0.9) 100%), url('images/artwork/category/13.jpg') no-repeat center center; background-size: cover;">
							<h4>
								<a href="#" class="text-light">정물화</a>
							</h4>
						</div>

						<div class="expand-category bg-light"
							style="background: linear-gradient(to bottom, transparent, rgba(0, 0, 0, .3) 75%, rgba(0, 0, 0, 0.9) 100%), url('images/artwork/category/14.jpg') no-repeat center center; background-size: cover;">
							<h4>
								<a href="#" class="text-light">팝아트</a>
							</h4>
						</div>
					</div>
				</div>
			</div>
		</section>
		<!-- #content end -->


	</div>
	<!-- #wrapper end -->


	<!-- Content
============================================= -->
	<section id="content">

		<div class="content-wrap">
			<div class="container">
				<h2 class="text-left border-bottom p-2">ART WORK</h2>
				<div class="grid-filter-wrap">

					<!-- Portfolio Filter
                    ============================================= -->

					<div style="margin: 0 auto;">
						<ul class="grid-filter" data-container="#portfolio">
							<li class="activeFilter"><a href="#" data-filter="*">전체</a></li>
							<li><a href="#" data-filter=".pf-icons">추천순</a></li>
							<li><a href="#" data-filter=".pf-uielements">최신순</a></li>
						</ul>
						<!-- .grid-filter end -->
					</div>

					<div class="grid-shuffle rounded" data-container="#portfolio">
						<i class="icon-random"></i>
					</div>

				</div>

				<!-- Portfolio Items
                ============================================= -->
				<div
					class="masonry-thumbs grid-container grid-1 grid-md-2 grid-lg-3 block-gallery-9 masonry-gap-lg">
					<div class="grid-item">
						<div class="grid-inner"
							style="background: linear-gradient(to bottom, transparent, rgba(0, 0, 0, .3) 75%, rgba(0, 0, 0, 0.9) 100%), url('../images/blocks/preview/card-2/3.jpg') no-repeat center center/cover; height: 400px">
							<div class="bg-overlay position-relative">
								<div
									class="bg-overlay-content flex-column justify-content-end align-items-start px-5 py-4 dark">
									<div class="entry-meta mb-3">
										<ul>
											<li><a href="#"><img class="rounded-circle"
													style="width: 50px; height: 50px;"
													src="../images/author/1.jpg" alt="Image"></a></li>
											<li><a>Nick Name</a></li>
										</ul>
										<ul class="mt-3">
											<li><a href="#"
												class="social-icon inline-block si-small si-borderless mb-0 si-facebook">
													<i class="icon-like"></i> <i class="icon-like"></i>
											</a></li>
											<li><a href="blog-single-thumbs.html#comments"><i
													class="icon-comments"></i> 15</a></li>
											<li>1달 전</li>
										</ul>
									</div>
									<div class="entry-title title-sm">
										<h3>
											<a href="blog-single-thumbs.html">Seamlessly deploy
												exceptional infrastructures rather.</a>
										</h3>
									</div>
									<div class="mt-3"></div>
								</div>
							</div>
						</div>
					</div>
					<div class="grid-item">
						<div class="grid-inner"
							style="background: linear-gradient(to bottom, transparent, rgba(0, 0, 0, .5) 65%, rgba(0, 0, 0, 0.9) 100%), url('../images/blocks/preview/card-2/2.jpg') no-repeat center center/cover; height: 500px">
							<div class="bg-overlay position-relative">
								<div
									class="bg-overlay-content flex-column justify-content-end align-items-start px-5 py-4 dark">
									<div class="entry-meta mb-3">
										<ul>
											<li><a href="#"><img class="rounded-circle"
													style="width: 50px; height: 50px;"
													src="../images/author/1.jpg" alt="Image"></a></li>
											<li><a>Nick Name</a></li>
										</ul>
										<ul class="mt-3">
											<li><a href="#"
												class="social-icon inline-block si-small si-borderless mb-0 si-facebook">
													<i class="icon-like"></i> <i class="icon-like"></i>
											</a></li>
											<li><a href="blog-single-thumbs.html#comments"><i
													class="icon-comments"></i> 15</a></li>
											<li>1시간 전</li>
										</ul>
									</div>
									<div class="entry-title title-sm">
										<h3>
											<a href="blog-single-thumbs.html">Credibly leverage
												other's sticky services.</a>
										</h3>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="grid-item">
						<div class="grid-inner"
							style="background: linear-gradient(to bottom, transparent, rgba(0, 0, 0, .5) 65%, rgba(0, 0, 0, 0.9) 100%), url('/images/artwork/4.jpg') no-repeat center center/cover; height: 370px">
							<div class="bg-overlay position-relative">
								<div
									class="bg-overlay-content flex-column justify-content-end align-items-start px-5 py-4 dark">
									<div class="entry-meta mb-3">
										<ul>
											<li>
												<a href="#"><img class="rounded-circle" style="width: 50px; height: 50px;" src="../images/author/1.jpg" alt="Image"></a>
											</li>
											<li>
											</li>
											<li><a>Nick Name</a></li>
										</ul>
										<ul class="mt-3">
											<li><a href="#"
												class="social-icon inline-block si-small si-borderless mb-0 si-facebook">
													<i class="icon-like"></i> <i class="icon-like"></i>
											</a></li>
											<li><a href="blog-single-thumbs.html#comments"><i
													class="icon-comments"></i> 15</a></li>
											<li>2시간 전</li>
										</ul>
									</div>
									<div class="entry-title title-sm">
										<h3>
											<a href="blog-single-thumbs.html">Collaboratively
												implement clicks-and-mortar methods of.</a>
										</h3>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="grid-item">
						<div class="grid-inner"
							style="background: linear-gradient(to bottom, transparent, rgba(0, 0, 0, .5) 65%, rgba(0, 0, 0, 0.9) 100%), url('/images/artwork/3.jpg') no-repeat center center/cover; height: 570px">
							<div class="bg-overlay position-relative">
								<div
									class="bg-overlay-content flex-column justify-content-end align-items-start px-5 py-4 dark">
									<div class="entry-meta mb-3">
										<ul>
											<li><a href="#"><img class="rounded-circle"
													style="width: 50px; height: 50px;"
													src="../images/author/1.jpg" alt="Image"></a></li>
											<li><a>Nick Name</a></li>
										</ul>
										<ul class="mt-3">
											<li><a href="#"
												class="social-icon inline-block si-small si-borderless mb-0 si-facebook">
													<i class="icon-like"></i> <i class="icon-like"></i>
											</a></li>
											<li><a href="blog-single-thumbs.html#comments"><i
													class="icon-comments"></i> 15</a></li>
											<li>2일 전</li>
										</ul>
									</div>
									<div class="entry-title title-sm">
										<h3>
											<a href="blog-single-thumbs.html">Uniquely synergize 24/7
												manufactured products.</a>
										</h3>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="grid-item">
						<div class="grid-inner"
							style="background: linear-gradient(to bottom, transparent, rgba(0, 0, 0, .5) 65%, rgba(0, 0, 0, 0.9) 100%), url('/images/artwork/2.jpg') no-repeat center center/cover; height: 510px">
							<div class="bg-overlay position-relative">
								<div
									class="bg-overlay-content flex-column justify-content-end align-items-start px-5 py-4 dark">
									<div class="entry-meta mb-3">
										<ul>
											<li><a href="#"><img class="rounded-circle"
													style="width: 50px; height: 50px;"
													src="../images/author/1.jpg" alt="Image"></a></li>
											<li><a>Nick Name</a></li>
										</ul>
										<ul class="mt-3">
											<li><a href="#"
												class="social-icon inline-block si-small si-borderless mb-0 si-facebook">
													<i class="icon-like"></i> <i class="icon-like"></i>
											</a></li>
											<li><a href="blog-single-thumbs.html#comments"><i
													class="icon-comments"></i> 15</a></li>
											<li>1일 전</li>
										</ul>
									</div>
									<div class="entry-title title-sm">
										<h3>
											<a href="#">Phosfluorescently utilize optimal alignments
												vis-a-vis.</a>
										</h3>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="grid-item">
						<div class="grid-inner"
							style="background: linear-gradient(to bottom, transparent, rgba(0, 0, 0, .5) 65%, rgba(0, 0, 0, 0.9) 100%), url('/images/artwork/1.jpg') no-repeat center center/cover; height: 380px">
							<div class="bg-overlay position-relative">
								<div
									class="bg-overlay-content flex-column justify-content-end align-items-start px-5 py-4 dark">
									<div class="entry-meta mb-3">
										<ul>
											<li><a href="#"><img class="rounded-circle"
													style="width: 50px; height: 50px;"
													src="../images/author/1.jpg" alt="Image"></a></li>
											<li><a>Nick Name</a></li>
										</ul>
										<ul class="mt-3">
											<li><a href="#"
												class="social-icon inline-block si-small si-borderless mb-0 si-facebook">
													<i class="icon-like"></i> <i class="icon-like"></i>
											</a></li>
											<li><a href="blog-single-thumbs.html#comments"><i
													class="icon-comments"></i> 15</a></li>
											<li>2주 전</li>
										</ul>
									</div>
									<div class="entry-title title-sm">
										<h3>
											<a href="blog-single-thumbs.html">Efficiently develop
												cost effective resources.</a>
										</h3>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		</div>
		<div class="container center" style="margin-top: 100px;">
			<button class="button button-rounded" style="width: 300px;">더
				보기</button>
		</div>
		</div>
		<!-- #portfolio end -->

		</div>
		</div>
	</section>
	<!-- #content end -->
	</div>
	<!-- Footer
============================================= -->
	<footer id="footer" class="dark">
		<jsp:include page="../include/footer.jsp"></jsp:include>
	</footer>

	</div>

	<!-- #wrapper end-->

	<!-- Go To Top
============================================= -->
	<div id="gotoTop" class="icon-angle-up"></div>

	<!-- JavaScripts
============================================= -->
	<script src="../js/jquery.js"></script>
	<script src="../js/plugins.min.js"></script>

	<script src="../js/jquery.hotspot.js"></script>
	<!-- Footer Scripts
============================================= -->
	<script src="../js/functions.js"></script>

	<!--  
============================================== -->
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