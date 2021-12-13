<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<meta name="author" content="SemiColonWeb" />

	<!-- Stylesheets
	============================================= -->
	<script type="text/javascript" nonce="a4f84d226a5b4b17b010d07a1b5" src="//local.adguard.org?ts=1635669619739&amp;type=content-script&amp;dmn=themes.semicolonweb.com&amp;app=msedge.exe&amp;css=3&amp;js=1&amp;rel=1&amp;rji=1&amp;sbe=0"></script>
	<script type="text/javascript" nonce="a4f84d226a5b4b17b010d07a1b5" src="//local.adguard.org?ts=1635669619739&amp;name=AdGuard%20Extra&amp;name=AdGuard%20Popup%20Blocker&amp;type=user-script"></script><link href="https://fonts.googleapis.com/css?family=Lato:300,400,400i,700|Poppins:300,400,500,600,700|PT+Serif:400,400i&display=swap" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href="/css/bootstrap.css" type="text/css" />
	<link rel="stylesheet" href="/style.css" type="text/css" />
	<link rel="stylesheet" href="/css/dark.css" type="text/css" />
	<link rel="stylesheet" href="/css/font-icons.css" type="text/css" />
	<link rel="stylesheet" href="/css/animate.css" type="text/css" />
	<link rel="stylesheet" href="/css/magnific-popup.css" type="text/css" />
    
    <!-- Date & TimePicker CSS	============================================= -->
    <script type="text/javascript" nonce="a4f84d226a5b4b17b010d07a1b5" src="//local.adguard.org?ts=1635759618260&amp;type=content-script&amp;dmn=themes.semicolonweb.com&amp;app=msedge.exe&amp;css=3&amp;js=1&amp;rel=1&amp;rji=1&amp;sbe=0"></script>
    <script type="text/javascript" nonce="a4f84d226a5b4b17b010d07a1b5" src="//local.adguard.org?ts=1635759618260&amp;name=AdGuard%20Extra&amp;name=AdGuard%20Popup%20Blocker&amp;type=user-script"></script><link href="https://fonts.googleapis.com/css?family=Lato:300,400,400i,700|Poppins:300,400,500,600,700|PT+Serif:400,400i&display=swap" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href="/css/components/datepicker.css" type="text/css" />
	<link rel="stylesheet" href="/css/components/timepicker.css" type="text/css" />
	<link rel="stylesheet" href="/css/components/daterangepicker.css" type="text/css" />

	<link rel="stylesheet" href="/css/custom.css" type="text/css" />
	<meta name="viewport" content="width=device-width, initial-scale=1" />

	<!-- Document Title
	============================================= -->
	<title>콜라보레이션 | 기획 수정하기</title>

	<style>

		.mfp-close { display: none !important; }

	</style>

</head>
<body class="stretched ">

	<!-- Document Wrapper
	============================================= -->
	<div id="wrapper" class="clearfix">

		<!-- Content
		============================================= -->
		<section id="content">
			<div class="content-wrap py-0">

				<div class="d-flex align-items-center justify-content-center min-vh-100">
					<a href="#block-modal-request" data-lightbox="inline" class="button button-xlarge rounded-pill bg-primary nott ls0 px-6 py-3">콜라보레이션 기획 수정하기</a>
				</div>

				<div class="modal-on-load" data-target="#block-modal-request"></div>

				<!-- Modal -->
				<div class="modal1 mfp-hide container clearfix" id="block-modal-request">
					<div class="modal-dialog modal-dialog-centered modal-lg">
						<div class="modal-content bg-white p-4 p-md-5 rounded">
							<div class="d-flex justify-content-between mb-2">
								<h3 class="mb-0 text-uppercase ls1">콜라보레이션 기획 수정하기</h3>
								<a href="#" onClick="$.magnificPopup.close();return false;" class="text-muted h4 mb-0 h-text-danger"><i class="icon-line-circle-cross"></i></a>
							</div>
							<div class="line double-line mt-2 mb-4"></div>

							<div class="form-widget">

								<div class="form-result"></div>

								<form class="mb-0" id="template-contactform" name="template-contactform" action="include/form.php" method="post">

									<div class="form-process">
										<div class="css3-spinner">
											<div class="css3-spinner-scaler"></div>
										</div>
									</div>

									<div class="row">
										<div class="col-md-6 form-group w-100">
											<label class="nott ls0 fw-medium" for="template-contactform-name">Title <small>*</small></label>
											<input stype="text" id="template-contactform-name" name="template-contactform-name" value="" class="form-control required" />
										</div>

										<div class="w-100"></div>

										<div class="col-md-6 form-group">
											<label class="nott ls0 fw-medium" for="template-contactform-upload">Upload <small class="text-muted">(Maximum file size allowed is 2048 KB.)</small></label>
											<div class="form-file">
												<input type="file" class="form-control" id="template-contactform-upload">
											</div>
										</div>
                                        
										<div class="col-md-6 form-group bottommargin-sm row">
											<label class="nott ls0 fw-medium" for="template-contactform-subject">기간</label>
											<div class="input-group text-start" data-target-input="nearest" data-target=".datetimepicker">
												<input type="text" class="form-control datetimepicker-input datetimepicker" data-target=".datetimepicker" placeholder="MM/DD/YYYY 00:00 AM/PM"/>
												<div class="input-group-text" data-target=".datetimepicker" data-toggle="datetimepicker"><i class="icon-calendar"></i></div>
											</div>
										</div>

										<div class="w-100"></div>

										<div class="col-12 form-group">
											<label class="nott ls0 fw-medium" for="template-contactform-message">Content <small>*</small></label>
											<textarea style="height: 700px;" class="required form-control" id="template-contactform-message" name="template-contactform-message" rows="5" cols="30"></textarea>
										</div>

										<div class="col-12 form-group d-none">
											<input type="text" id="template-contactform-botcheck" name="template-contactform-botcheck" value="" class="form-control" />
										</div>

										<div class="col-12 d-flex justify-content-end">
											<button class="button ls0 nott px-5 py-3 rounded-pill bg-primary ms-2" type="submit" id="template-contactform-submit" name="template-contactform-submit" value="submit">수정완료</button>
										</div>
									</div>

									<input type="hidden" name="prefix" value="template-contactform-">

								</form>
							</div>

						</div>
					</div>
				</div>
				<!-- modal end -->

			</div>
		</section><!-- #content end -->


	</div><!-- #wrapper end -->

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
		jQuery(document).ready( function(){

			var element = $(".custom-file");

			element.find('input[type="file"]').change(function(e){
				var fileName = e.target.files[0].name;
				element.find('.custom-file-label').html(fileName);
			});

			$('#template-contactform').on( 'formSubmitSuccess', function(){
				setTimeout(function(){
 					$('#block-modal-request').magnificPopup('close');
  				}, 500);
			});

		});
	</script>

</body>
</html>