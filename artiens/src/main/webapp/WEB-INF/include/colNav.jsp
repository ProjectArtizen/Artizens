<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<div style="width: 1600px; margin-left: -125px;">
	<!-- 서브메뉴============================================= -->
	
		<ul class="menu-container" style="margin-Left: 150px;">
			<li class="menu-item"><a class="menu-link"
				href="../artizen/colDetail"><div
						style="font-size: 20px; font-weight: normal;">콜라보레이션 소개</div></a></li>
			<li class="menu-item"><a class="menu-link"
				href="../artizen/colArtList"><div
						style="font-size: 20px; font-weight: normal;">참여작품</div></a></li>
			<div style="margin-left: 750px;">
				<a href="#block-modal-request" data-lightbox="inline" data-target="#block-modal-request">
					<button class="button m-3">접수하기</button>
				</a>			
			</div>
		</ul>
		
		
		
		<!-- Modal -->
				<div class="modal1 mfp-hide container clearfix" id="block-modal-request">
					<div class="modal-dialog modal-dialog-centered modal-lg">
						<div class="modal-content bg-white p-4 p-md-5 rounded">
							<div class="d-flex justify-content-between mb-2">
								<h3 class="mb-0 text-uppercase ls1">작품 접수</h3>
								<a href="#" onClick="$.magnificPopup.close();return false;" class="text-muted h4 mb-0 h-text-danger"><i class="icon-line-circle-cross"></i></a>
							</div>
							<div class="line double-line mt-2 mb-4"></div>

							<div class="form-widget">

								<div class="form-result"></div>

								<form class="mb-0" id="template-contactform" name="template-contactform" action="" method="post">

									<div class="form-process">
										<div class="css3-spinner">
											<div class="css3-spinner-scaler"></div>
										</div>
									</div>

									<div class="row">
										<div class="col-md-6 form-group w-100">
											<label class="nott ls0 fw-medium" for="template-contactform-name">Title <small>*</small></label>
											<input type="text" id="template-contactform-name" name="template-contactform-name" value="" class="form-control required" />
										</div>

										<div class="w-100"></div>

										<div class="col-md-6 form-group w-100">
											<label class="nott ls0 fw-medium" for="template-contactform-upload">Upload <small class="text-muted">(Maximum file size allowed is 2048 KB.)</small></label>
											<div class="form-file">
												<input type="file" class="form-control" id="template-contactform-upload">
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

										<div style="color: red;">
											해당 콜라보레이션에 접수한 작품은 개인 블로그에는 올라가지 않으며, 해당 콜라보레이션의 참여 작품에서 확인할 수 있습니다.<br>
											이미지 교체 방지를 위해, 업로드 후 이미지는 수정할 수 없습니다. 
										</div>

										<div class="col-12 d-flex justify-content-end">
											<button class="button ls0 nott px-5 py-3 rounded-pill bg-primary ms-2" type="submit" id="template-contactform-submit" name="template-contactform-submit" value="submit">Upload</button>
										</div>
									</div>

									<input type="hidden" name="prefix" value="template-contactform-">

								</form>
							</div>

						</div>
					</div>
				</div>


	<!-- 서브메뉴 끝 -->
</div>
