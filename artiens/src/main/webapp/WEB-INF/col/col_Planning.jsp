<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>::: 콜라보레이션 기획 | 업로드 :::</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
  <link rel="stylesheet" href="/css/components/datepicker.css"type="text/css" />
 
</head>
<style>
	::placeholder {
		font-size: 15px; color:white; font-style:italic;
	}
	#logo {filter: brightness(0%)}
</style>
<script>
/* <!-- ajax를 통한 전송완료 확인하는 함수 -->
$( function() {
  $("#submit").click(function(){
	  
	  var formdata = $("#frm").serialize();
	  $.ajax({
		  type : "POST",
		  url  : "colPlanningSave",
		  data : formdata,
		  
		  //text형태로 전달받기
		  datatype : "text",
		  success  : function(data) {  // 성공시 OK 전달하기
			  if( data == "ok") {
				  alert("저장완료");
				  location="colMain";
			  } else {
				  alert("저장실패");
				  console.log(data);
			  }
		  },
		  error	   : function() {
			  alert("오류발생");
		  }
	  });
  });
  
}); */
</script>
<body>
<!-- Document Wrapper
  ============================================= -->
	<div id="wrapper" class="clearfix">
	
	<form name="frm" id="frm" action="/artizen/collaboration/planning" method="POST" enctype="multipart/form-data">
		<%-- <input type="hidden" value="${userid }" name="userProfileId"> --%>
		<table class="table text-center caption-top container-sm">
			<caption class="text-center fs-3 fw-bold" ><img id="logo" src="/images/logo_new/logo_D.png" alt="Artizen Logo"></caption>
			<colgroup>
				<col width="10%"/>
				<col width="*"/>
			</colgroup>
			<tr style="height:60px;">
				<th>제목<small>*</small></th>
				<td><input type="text" name="title" id="title" class="form-control" placeholder="제목을 입력해 주세요"></td>
			</tr>
			<tr>
				<th>기간<small>*</small></th>
				<td><input type="text" name="deadLineDate" id="deadLineDate" class="form-control text-start component-datepicker default" placeholder="YYYY-MM-DD"></td>
			</tr>
			<tr>	
				<th>파일첨부<small>*</small></th>
				<td><input type="file" name="file" class="form-control" multiple></td>
			</tr>
			<tr>
				<th>기획내용<small>*</small></th>
				<td><textarea name="content" id="content" class="form-control" style="height:200px;" placeholder="최대 10000자까지 등록 가능합니다."></textarea></td>
			</tr>
			<tr class="border-borderless">
				<td colspan="2">
					<button type="submit" name="submit" id="submit" class="btn btn-primary m-3">콜라보레이션 등록</button>
					<button type="button" onclick="window.close();" class="btn btn-primary ms-3">취소</button>
				</td>
			</tr>
		</table>
		<div class="text-center">
		</div>
	</form>
</div>

<!-- Date & Time Picker JS -->
	<script src="/js/components/moment.js"></script>
	<script src="/js/components/timepicker.js"></script>
	<script src="/js/components/datepicker.js"></script>

<script>
	
	$(function(){
		$('#submit').click(function(){
			if( confirm("이미지를 등록하시겠습니까?") == true ) {
				document.frm.method = "post"; 
				theForm.action = "/artizen/upload";
				document.frm.submit();
			}
		})
	})
	
	$(function() {
				
				$('.component-datepicker.default').datepicker({					
					autoclose: true,
					startDate: "today",
					format: "yyyy-mm-dd"
				});

			});
	
</script>
</body>
</html>