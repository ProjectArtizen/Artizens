<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html dir="ltr" lang="en-US">
<head>

<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="author" content="SemiColonWeb" />

<!-- Stylesheets
	============================================= -->
<link
	href="https://fonts.googleapis.com/css?family=Lato:300,400,400i,700|Poppins:300,400,500,600,700|PT+Serif:400,400i&display=swap"
	rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="../../css/bootstrap.css" type="text/css" />
<link rel="stylesheet" href="../../style.css" type="text/css" />
<link rel="stylesheet" href="../../css/dark.css" type="text/css" />
<link rel="stylesheet" href="../../css/font-icons.css" type="text/css" />
<link rel="stylesheet" href="../../css/animate.css" type="text/css" />
<link rel="stylesheet" href="../../css/magnific-popup.css" type="text/css" />
<link rel="stylesheet" href="../../css/components/datepicker.css"
	type="text/css" />
<link rel="stylesheet" href="../../css/components/timepicker.css"
	type="text/css" />
<link rel="stylesheet" href="../../css/components/daterangepicker.css"
	type="text/css" />
<link rel="stylesheet" href="../../css/custom.css" type="text/css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1" />

<!-- Document Title
	============================================= -->
<title>콜라보레이션</title>
<script type="text/javascript">
	function commentAlert(){
		alert("댓글 작성은 구현 중입니다.")
		location.href = '/artizen/collaboration/${result.id}'
	}
</script>
</head>

<body class="stretched">

	<!-- Document Wrapper
	============================================= -->
	<div id="wrapper" class="clearfix">

		<!-- Header
		============================================= -->
		<header id="header"
			class="full-header transparent-header semi-transparent dark">

			<%@ include file="../include/header.jsp"%>

		</header>
		<!-- #header end -->

		<!-- 타이틀============================================= -->
		<section id="page-title" class="page-title-center"
			style="background-color: white; border: none; padding-bottom: 0px;">
			<div class="container clearfix" style="background-color: white;">
				<%-- <c:if test="">
				<span class="fw-bold"
					  style="font-size:1.8em;
					  		 width:7em;
					  		 background-color:gray; 
					  		 color:white; 
					  		 margin-bottom:1em;">당선작 발표
				</span>
			</c:if>	 --%>
				<h1>콜라보레이션 타이틀</h1>
				<span style="margin-top: 20px;">
					<div class="d-flex align-items-center" style="justify-content: center;">
						<a href="#"><img src="${result.creatorImgName}"
							alt="Author" class="rounded-circle" width="35" height="35"></a>
						<div class="entry-meta mt-0">
							<div class="entry-meta"
								style="margin-bottom: 10px; padding-left: 10px;">
								<ul>
									<li><a href="/blog/${result.creatorId}">${result.creatorNickname}</a></li>
									<li><i class="icon-calendar3"></i>${result.registerDate}</li>
								</ul>
							</div>
						</div>
					</div>
				</span>


				<div style="width: 1600px;">
					<!-- 서브메뉴
							============================================= -->
					<nav class="primary-menu"
						style="margin-top: 100px; border-top: 2px solid #f3f3f3; border-bottom: 2px solid #f3f3f3">

						<%@ include file="../include/colNav.jsp"%>

					</nav>
					<!-- 서브메뉴 끝 -->
				</div>
			</div>

		</section>
		<!-- 타이틀 끝 -->


		<!-- 상세내용
		============================================= -->
		<section id="content">
			<div class="content-wrap">
				<div class="container clearfix" style="width: 1000px;">

					<div class="single-post mb-0">

						<!-- Single Post
						============================================= -->
						<div class="entry clearfix">



							<!-- 이미지
							============================================= -->

							<div class="entry-image bottommargin">
								<img src="${result.contentImgName}" alt="Blog Single">
							</div>
							<!-- 아미지 끝 -->

							<!-- 내용
							============================================= -->
							<div class="entry-content mt-0">

								<blockquote>
									<p>${result.content}</p>
								</blockquote>
								<!-- 내용 끝 -->

								<div class="clear"></div>

							</div>
						</div>
						<!-- .entry end -->
						<!-->

						<!-- 댓글
						============================================= -->
						<div id="comments" class="clearfix" style="border: none;">

							<!-- 댓글작성
							============================================= -->
							<div id="respond">

								<h3>
									<span>댓글작성</span>
								</h3>

								<form class="row" action="" method="get" id="commentform" onsubmit="return commentAlert()">

									<div class="w-100"></div>
									<div><input type="hidden" name="" value=""></div>
									
									<div class="col-12 form-group">
										<textarea name="" cols="58" rows="7" tabindex="4" class="sm-form-control" placeholder="댓글을 입력하세요."></textarea>
									</div>

									<div class="col-12 form-group" style="text-align: right;">
										<button type="submit" id="submit-button" tabindex="5" value="" class="button button-3d m-0">작성하기</button>
									</div>
								</form>

							</div>
							<!-- 댓글작성 끝-->


							<!-- 댓글목록
							============================================= -->
							<div class="line"></div>

							<h3 id="comments-title">
								<span>${result.commentCount}</span> 개의 댓글
							</h3>
							
							<!-- <ol class="commentlist clearfix" style="border: none;">

								<li class="comment even thread-even depth-1" id="li-comment-1">

									<div id="comment-1" class="comment-wrap clearfix">

										<div class="comment-meta">

											<div class="comment-author vcard">

												<span class="comment-avatar clearfix"> <img
													alt='Image'
													src='https://0.gravatar.com/avatar/ad516503a11cd5ca435acc9bb6523536?s=60'
													class='avatar avatar-60 photo avatar-default' height='60'
													width='60' /></span>

											</div>

										</div>

										<div class="comment-content clearfix">

											<div class="comment-author">
												John Doe<span><a href="#"
													title="Permalink to this comment">April 24, 2012 at
														10:46 am</a></span>
											</div>

											<p>Donec sed odio dui. Nulla vitae elit libero, a
												pharetra augue. Nullam id dolor id nibh ultricies vehicula
												ut id elit. Integer posuere erat a ante venenatis dapibus
												posuere velit aliquet.</p>

											<a class='comment-reply-link' href='#'><i
												class="icon-reply"></i></a>

										</div>

										<div class="clear"></div>

									</div>


									<ul class='children'>

										<li
											class="comment byuser comment-author-_smcl_admin odd alt depth-2"
											id="li-comment-3">

											<div id="comment-3" class="comment-wrap clearfix">

												<div class="comment-meta">

													<div class="comment-author vcard">

														<span class="comment-avatar clearfix"> <img
															alt='Image'
															src='https://1.gravatar.com/avatar/30110f1f3a4238c619bcceb10f4c4484?s=40&amp;d=http%3A%2F%2F1.gravatar.com%2Favatar%2Fad516503a11cd5ca435acc9bb6523536%3Fs%3D40&amp;r=G'
															class='avatar avatar-40 photo' height='40' width='40' /></span>

													</div>

												</div>

												<div class="comment-content clearfix">

													<div class="comment-author">
														<a href='#' rel='external nofollow' class='url'>SemiColon</a><span><a
															href="#" title="Permalink to this comment">April 25,
																2012 at 1:03 am</a></span>
													</div>

													<p>Nullam id dolor id nibh ultricies vehicula ut id
														elit.</p>

													<a class='comment-reply-link' href='#'><i
														class="icon-reply"></i></a>

												</div>

												<div class="clear"></div>

											</div>

										</li>

									</ul>

								</li>

								<li
									class="comment byuser comment-author-_smcl_admin even thread-odd thread-alt depth-1"
									id="li-comment-2">

									<div id="comment-2" class="comment-wrap clearfix">

										<div class="comment-meta">

											<div class="comment-author vcard">

												<span class="comment-avatar clearfix"> <img
													alt='Image'
													src='https://1.gravatar.com/avatar/30110f1f3a4238c619bcceb10f4c4484?s=60&amp;d=http%3A%2F%2F1.gravatar.com%2Favatar%2Fad516503a11cd5ca435acc9bb6523536%3Fs%3D60&amp;r=G'
													class='avatar avatar-60 photo' height='60' width='60' /></span>

											</div>

										</div>

										<div class="comment-content clearfix">

											<div class="comment-author">
												<a href='https://themeforest.net/user/semicolonweb'
													rel='external nofollow' class='url'>SemiColon</a><span><a
													href="#" title="Permalink to this comment">April 25,
														2012 at 1:03 am</a></span>
											</div>

											<p>Integer posuere erat a ante venenatis dapibus posuere
												velit aliquet.</p>

											<a class='comment-reply-link' href='#'><i
												class="icon-reply"></i></a>

										</div>

										<div class="clear"></div>

									</div>

								</li>

							</ol>
							댓글목록 끝 -->

							<div class="clear"></div>

						</div>
						<!-- 댓글 끝 -->

					</div>

				</div>
			</div>
		</section>
		<!-- 상세내용 끝 -->

		<!-- Footer
		============================================= -->
		<footer id="footer" class="dark">
			<%@ include file="../include/footer.jsp"%>
		</footer>
		<!-- #footer end -->

		<!-- Go To Top
	============================================= -->
		<div id="gotoTop" class="icon-angle-up"></div>
		<!-- JavaScripts
	============================================= -->
		<script src="/js/jquery.js"></script>
		<script src="/js/plugins.min.js"></script>

		<!-- Date & Time Picker JS -->
		<script src="/js/components/moment.js"></script>
		<script src="/js/components/timepicker.js"></script>
		<script src="/js/components/datepicker.js"></script>

		<!-- Include Date Range Picker -->
		<script src="/js/components/daterangepicker.js"></script>

		<!-- Footer Scripts
	============================================= -->
		<script src="/js/functions.js"></script>

		<script>
			jQuery(document).ready(function() {

				var element = $(".custom-file");

				element.find('input[type="file"]').change(function(e) {
					var fileName = e.target.files[0].name;
					element.find('.custom-file-label').html(fileName);
				});

				$('#block-modal-request').on('show.bs.modal', function(e) {
					e.preventDefault();
				})

				$('#template-contactform').on('formSubmitSuccess', function() {
					setTimeout(function() {
						$('#block-modal-request').magnificPopup('close');
					}, 500);
				});

			});
		</script>
	</div>
	<!-- #wrapper end-->

</body>
</html>