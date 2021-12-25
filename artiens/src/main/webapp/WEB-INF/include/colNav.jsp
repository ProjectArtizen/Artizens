<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 서브메뉴============================================= -->
<section id="content">
			<div class="content-wrap py-0">
<!-- Section Light -->
<div class="d-lg-flex flex-column justify-content-lg-center min-vh-20 min-vh-lg-10 ">

	<!-- Primary Navigation icon in mobile
        ============================================= -->
	<div id="primary-menu-trigger">
		<svg class="svg-trigger" viewBox="0 0 100 100">
			<path
				d="m 30,33 h 40 c 3.722839,0 7.5,3.126468 7.5,8.578427 0,5.451959 -2.727029,8.421573 -7.5,8.421573 h -20"></path>
			<path d="m 30,50 h 40"></path>
			<path
				d="m 70,67 h -40 c 0,0 -7.5,-0.802118 -7.5,-8.365747 0,-7.563629 7.5,-8.634253 7.5,-8.634253 h 20"></path></svg>
	</div>

	<!-- Primary Navigation
        ============================================= -->
	<nav class="primary-menu with-arrows block-nav-menu">

		<ul class="menu-container justify-content-center">
			<!-- justify-content-center class for center menu-->

			<li class="menu-item"><a class="menu-link"
				href="../collaboration/${result.id}"><div>콜라보레이션 소개</div></a></li>

			<c:if test="${result.pastDateBoolean eq true}">
				<li class="menu-item"><a class="menu-link"
					href="../collaboration/art/winner"><div>당선작품</div></a></li>
			</c:if>

			<li class="menu-item"><a class="menu-link"
				href="../collaboration/art"><div>참여작품</div></a></li>

			<li class="menu-item col-sm-6 col-12"></li>

			<c:choose>
				<c:when test="${result.pastDateBoolean eq false}">
					<div>
						<a href="#block-modal-request" data-lightbox="inline" data-target="#block-modal-request">
							<button
								class="button m-3 button-rounded button-black d-none d-xl-flex my-4 ms-3"
								id="modalbtn">접수하기</button>
							<div class="header-misc-icon">
								<a type="button" onclick="onClickmodals()" class="d-flex d-xl-none"><i class="icon-pencil"></i></a>
							</div> 
							<script type="text/javascript">
								function onClickmodals() {
									document.getElementById('modalbtn').click();
								}
							</script>
						</a>
					</div>
				</c:when>
				<c:when test="${result.pastDateBoolean eq true}">
					<button class="button m-3 button-rounded button-red d-none d-xl-flex my-4 ms-3" id="modalbtn" disabled="disabled" style="cursor:default">마감된 콜라보레이션</button>
				</c:when>
			</c:choose>
		</ul>
	</nav>
	<!-- #primary-menu end -->

</div>

<!-- Modal -->
<div class="modal1 mfp-hide" id="block-modal-request">
	<div class="modal-dialog modal-dialog-centered modal-lg">
		<div class="modal-content bg-white p-4 p-md-5 rounded">
			<div class="d-flex justify-content-between mb-2">
				<h3 class="mb-0 text-uppercase ls1">작품 접수</h3>
				<a href="#" onClick="$.magnificPopup.close();return false;"
					class="text-muted h4 mb-0 h-text-danger"><i
					class="icon-line-circle-cross"></i></a>
			</div>
			<div class="line double-line mt-2 mb-4"></div>

			<div class="form-widget">

				<div class="form-result"></div>

				<form class="mb-0" id="template-contactform" action="./art/register" method="post" enctype="multipart/form-data">
					<input type="hidden" name="collaborationId" value="${result.id}">
					<div class="form-process">
						<div class="css3-spinner">
							<div class="css3-spinner-scaler"></div>
						</div>
					</div>

					<div class="row">
						<div class="col-md-6 form-group w-100">
							<label class="nott ls0 fw-medium" for="template-contactform-name">Title <small>*</small></label>
							<input stype="text" id="template-contactform-name" name="title" value="" class="form-control required" />
						</div>

						<div class="w-100"></div>

						<div class="col-md-6 form-group w-100">
							<label class="nott ls0 fw-medium" for="template-contactform-upload">Upload <small class="text-muted">(Maximum file size allowed is 2048 KB.)</small></label>
							<div class="form-file">
								<input type="file" name="file" class="form-control" id="template-contactform-upload">
							</div>
						</div>

						<div class="w-100"></div>

						<div class="col-12 form-group">
							<label class="nott ls0 fw-medium" for="template-contactform-message">Content <small>*</small></label>
							<textarea style="height: 700px;" class="required form-control" id="template-contactform-message" name="content" rows="5" cols="30"></textarea>
						</div>

						<div class="col-12 form-group d-none">
							<input type="text" id="template-contactform-botcheck" name="template-contactform-botcheck" value="" class="form-control" />
						</div>

						<div style="color: red;">
							해당 콜라보레이션에 접수한 작품은 개인 블로그에는 올라가지 않으며, 해당 콜라보레이션의 참여 작품에서 확인할
							수 있습니다.<br> 이미지 교체 방지를 위해, 업로드 후 이미지는 수정할 수 없습니다.
						</div>

						<div class="col-12 d-flex justify-content-end">
							<button class="button ls0 nott px-5 py-3 rounded-pill bg-primary ms-2" type="submit" id="template-contactform-submit"
												name="template-contactform-submit" value="submit">Upload</button>
							
						</div>
					</div>

					<input type="hidden" name="prefix" value="template-contactform-">

				</form>
			</div>

		</div>
	</div>
</div>
</div>
</section>
<!-- modal -->