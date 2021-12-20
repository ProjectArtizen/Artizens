<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Header
============================================= -->
  <div id="header-wrap">
    <div class="container">
      <div class="header-row">

          <!-- Logo
          ============================================= -->
          <div id="logo">
            <a href="art" class="standard-logo" data-dark-logo="/images/logo_new/logo_D.png" style="height: 50px;">
              <img src="/images/logo_new/logo_D.png" alt="Artizen Logo">
            </a>
          </div><!-- #logo end -->

          <div class="header-misc">
            <!-- Top Search
        ============================================= -->
            <div id="top-search" class="header-misc-icon">
              <a href="#" id="top-search-trigger">
                <i class="icon-line-search"></i>
                <i class="icon-line-cross"></i>
              </a>
            </div><!-- #top-search end -->

            <!-- 유저 로그아웃 정보-->
            <div id="top-login-in" class="header-misc-icon d-none d-sm-block">
              <a href="/artizen/login">
                <i class="icon-line-log-in">
					
                </i>
              </a>
            </div>
          </div>

          <div id="primary-menu-trigger">
            <svg class="svg-trigger" viewBox="0 0 100 100">
              <path d="m 30,33 h 40 c 3.722839,0 7.5,3.126468 7.5,8.578427 0,5.451959 -2.727029,8.421573 -7.5,8.421573 h -20"></path>
              <path d="m 30,50 h 40"></path>
              <path d="m 70,67 h -40 c 0,0 -7.5,-0.802118 -7.5,-8.365747 0,-7.563629 7.5,-8.634253 7.5,-8.634253 h 20"></path>
            </svg>
          </div>

          <!-- Primary Navigation
          ============================================= -->
          <nav class="primary-menu">

            <ul class="menu-container">
              <li class="menu-item">
                <a class="menu-link" style="font-size: larger;" href="work.jsp">
                  <div>홈</div>
                </a>
              </li>
              <li class="menu-item">
                <a class="menu-link" style="font-size: larger;" href="artWorkMain">
                  <div>작 품</div>
                </a>
                <ul class="sub-menu-container bg-light" >
                  <li class="menu-item ">
                    <a class="menu-link" href="artWorkInkPainting">
                      <div>수묵화</div>
                    </a>
                  </li>
                  <li class="menu-item ">
                    <a class="menu-link" href="artWorkColoring">
                      <div>채색화</div>
                    </a>
                  </li>
                  <li class="menu-item ">
                    <a class="menu-link" href="artWorkLandscape">
                      <div>풍경화</div>
                    </a>
                  </li>
                  <li class="menu-item ">
                    <a class="menu-link" href="artWorkFigure">
                      <div>인물화</div>
                    </a>
                  </li>
                  <li class="menu-item">
                    <a class="menu-link" href="artWorkAbstract">
                      <div>추상화</div>
                    </a>
                  </li>
                  <li class="menu-item">
                    <a class="menu-link" href="artWorkStill">
                      <div>정물화</div>
                    </a>
                  </li>
                  <li class="menu-item">
                    <a class="menu-link" href="artWorkPop">
                      <div>팝아트</div>
                    </a>
                  </li>
                </ul>
              </li>
              <li class="menu-item">
                <a class="menu-link" style="font-size: larger;" href="/artizen/colMain">
                  <div>콜라보레이션</div>
                </a>
              </li>
              <li class="menu-item">
                <a class="menu-link" style="font-size: larger;" href="work.jsp">
                  <div>후원하기</div>
                </a>
                <ul class="sub-menu-container bg-light">
                  <li class="menu-item">
                    <a class="menu-link" href="#">
                      <div>후원이란</div>
                    </a>
                  </li>
                  <li class="menu-item">
                    <a class="menu-link" href="#">
                      <div>크리에이터</div>
                    </a>
                  </li>
                  <li class="menu-item">
                    <a class="menu-link" href="#">
                      <div>리워드</div>
                    </a>
                  </li>
                </ul>
              </li>
             </ul>
          </nav><!-- #primary-menu end -->

        <form class="top-search-form" action="" method="get">
          <input type="text" name="q" class="form-control" value="" placeholder="Type &amp; Hit Enter.." autocomplete="off">
        </form>

      </div>
    </div>
  </div>
<script>
	jQuery(document).ready( function(){
	
		var element = $(".custom-file");
	
		element.find('input[type="file"]').change(function(e){
			var fileName = e.target.files[0].name;
			element.find('.custom-file-label').html(fileName);
		});
	
		$('#template-contactform').click( 'formSubmitSuccess', function(){
			setTimeout(function(){
					$('#block-modal-request').magnificPopup('close');
					}, 500);
		});
	
	});
	function fn_Upload() {
		window.open("/artizen/upload","fileUpload","width=1250,height=700");
	}
</script>
<!-- #header end -->
