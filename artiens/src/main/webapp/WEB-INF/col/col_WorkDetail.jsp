<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html dir="ltr" lang="en-ko">
<head>
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

<!-- Page Title -->
<title>::: ARTIZEN | 작품 상세페이지 :::</title>

    <style>
        <%-- <%@include file="../include/work.css"%> --%>
    </style>
</head>
<body>
<!-- HEADER
============================================= -->
<header id="header" class="full-header transparent-header semi-transparent dark">
    <%@include file="../include/header.jsp" %>
</header>

<section id="content">
    <div class="content-wrap">
        <div class="container clearfix">

            <div class="single-post mb-0">

                <!-- Single Post
                ============================================= -->
                <div class="entry clearfix">

                    <!-- Entry Title
                    ============================================= -->
                    <div>
                        <p class="center" style="font-size: 30px;">iPhone 목업파일 만들어 봤습니다.</p>
                        <hr>
                        <div class="entry-meta">
                            <ul>
                                <li><i class="icon-calendar3"></i> 2021.10.27</li>
                                <li><a href="#"><i class="icon-user"></i> 사용자이름</a></li>
                            </ul>
                        </div>
                    </div><!-- .entry-title end -->

                    <!-- ARTWORK SLIDER
                    ========================================-->
                    <section id="slider" class="slider-element revslider-wrap">

                        <div class="rev_slider_wrapper fullwidthbanner-container">
                            <div style="padding: 10%; margin: 0 auto;">

                                <div id="oc-slider" class="owl-carousel carousel-widget" data-items="1" data-loop="true"
                                     data-nav="true" data-autoplay="5000" data-animate-in="fadeIn"
                                     data-animate-out="fadeOut" data-speed="800">

                                    <a href="../demos/agency/images/slider/1.jpg" data-lightbox="gallery-item">
                                        <img class="img-fluid " src="../demos/agency/images/slider/1.jpg" alt="Slider">
                                    </a>
                                    <a href="../demos/agency/images/slider/2.jpg" data-lightbox="gallery-item">
                                        <img class="img-fluid " src="../demos/agency/images/slider/2.jpg" alt="Slider">
                                    </a>
                                    <a href="../demos/agency/images/slider/3.jpg" data-lightbox="gallery-item">
                                        <img class="img-fluid " src="../demos/agency/images/slider/3.jpg" alt="Slider">
                                    </a>
                                    <a href="#"><img src="../demos/agency/images/slider/2.jpg" alt="Slider"></a>
                                    <a href="#"><img src="../demos/agency/images/slider/3.jpg" alt="Slider"></a>

                                </div>

                            </div>


                    </section>
                    <!-- ARTWORK SLIDER END
                    =============================================-->
                    <div class="entry-content mt-0">
                        <!-- Tag Cloud
                        ============================================= -->
                        <div class="tagcloud clearfix bottommargin">
                            <a href="#" class="border rounded-4 p-2">#거침 없는</a>
                            <a href="#" class="border rounded-4 p-2">#화려한</a>
                            <a href="#" class="border rounded-4 p-2">#풍경</a>
                            <a href="#" class="border rounded-4 p-2">#아름다운</a>
                            <a href="#" class="border rounded-4 p-2">#잔잔한</a>
                            <a href="#" class="border rounded-4 p-2">#트렌디한</a>
                            <a href="#" class="border rounded-4 p-2">#추상적인</a>
                            <a href="#" class="border rounded-4 p-2">#감각적인</a>
                        </div><!--Wrapper End-->

                        <!-- Post Author Info Start
                        ============================================= -->
                        <div class="card mt-4">
                            <div class="card-header"><strong>작가의 말 <a href="#">ARTIST</a></strong></div>
                            <div class="card-body">
                                <div class="author-image">
                                    <img src="../images/author/1.jpg" alt="Image" class="rounded-circle">
                                </div>
                                Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dolores, eveniet, eligendi et
                                nobis neque minus mollitia sit repudiandae ad repellendus recusandae blanditiis
                                praesentium vitae ab sint earum voluptate velit beatae alias fugit accusantium
                                laboriosam nisi reiciendis deleniti tenetur molestiae maxime id quaerat consequatur
                                fugiat aliquam laborum nam aliquid. Consectetur, perferendis?
                            </div>
                        </div>
                        <!-- Post Author Info Ended-->

                        <!-- Comments
                    ============================================= -->
                        <div id="comments" class="clearfix">

                            <h3 id="comments-title"><span>3</span> Comments</h3>

                            <!-- Comments List
                            ============================================= -->
                            <ol class="commentlist clearfix">

                                <li class="comment even thread-even depth-1" id="li-comment-1">

                                    <div id="comment-1" class="comment-wrap clearfix">

                                        <div class="comment-meta">

                                            <div class="comment-author vcard">

												<span class="comment-avatar clearfix">
												<img alt='Image'
                                                     src='https://0.gravatar.com/avatar/ad516503a11cd5ca435acc9bb6523536?s=60'
                                                     class='avatar avatar-60 photo avatar-default' height='60'
                                                     width='60'/></span>

                                            </div>

                                        </div>

                                        <div class="comment-content clearfix">

                                            <div class="comment-author">John Doe<span><a href="#"
                                                                                         title="Permalink to this comment">April 24, 2012 at 10:46 am</a></span>
                                            </div>

                                            <p>Donec sed odio dui. Nulla vitae elit libero, a pharetra augue. Nullam id
                                                dolor id nibh ultricies vehicula ut id elit. Integer posuere erat a ante
                                                venenatis dapibus posuere velit aliquet.</p>

                                            <a class='comment-reply-link' href='#'><i class="icon-reply"></i></a>

                                        </div>

                                        <div class="clear"></div>

                                    </div>


                                    <ul class='children'>

                                        <li class="comment byuser comment-author-_smcl_admin odd alt depth-2"
                                            id="li-comment-3">

                                            <div id="comment-3" class="comment-wrap clearfix">

                                                <div class="comment-meta">

                                                    <div class="comment-author vcard">

														<span class="comment-avatar clearfix">
														<img alt='Image'
                                                             src='https://1.gravatar.com/avatar/30110f1f3a4238c619bcceb10f4c4484?s=40&amp;d=http%3A%2F%2F1.gravatar.com%2Favatar%2Fad516503a11cd5ca435acc9bb6523536%3Fs%3D40&amp;r=G'
                                                             class='avatar avatar-40 photo' height='40'
                                                             width='40'/></span>

                                                    </div>

                                                </div>

                                                <div class="comment-content clearfix">

                                                    <div class="comment-author"><a href='#' rel='external nofollow'
                                                                                   class='url'>SemiColon</a><span><a
                                                            href="#" title="Permalink to this comment">April 25, 2012 at 1:03 am</a></span>
                                                    </div>

                                                    <p>Nullam id dolor id nibh ultricies vehicula ut id elit.</p>

                                                    <a class='comment-reply-link' href='#'><i
                                                            class="icon-reply"></i></a>

                                                </div>

                                                <div class="clear"></div>

                                            </div>

                                        </li>

                                    </ul>

                                </li>

                                <li class="comment byuser comment-author-_smcl_admin even thread-odd thread-alt depth-1"
                                    id="li-comment-2">

                                    <div id="comment-2" class="comment-wrap clearfix">

                                        <div class="comment-meta">

                                            <div class="comment-author vcard">

												<span class="comment-avatar clearfix">
												<img alt='Image'
                                                     src='https://1.gravatar.com/avatar/30110f1f3a4238c619bcceb10f4c4484?s=60&amp;d=http%3A%2F%2F1.gravatar.com%2Favatar%2Fad516503a11cd5ca435acc9bb6523536%3Fs%3D60&amp;r=G'
                                                     class='avatar avatar-60 photo' height='60' width='60'/></span>

                                            </div>

                                        </div>

                                        <div class="comment-content clearfix">

                                            <div class="comment-author"><a
                                                    href='https://themeforest.net/user/semicolonweb'
                                                    rel='external nofollow' class='url'>SemiColon</a><span><a href="#"
                                                                                                              title="Permalink to this comment">April 25, 2012 at 1:03 am</a></span>
                                            </div>

                                            <p>Integer posuere erat a ante venenatis dapibus posuere velit aliquet.</p>

                                            <a class='comment-reply-link' href='#'><i class="icon-reply"></i></a>

                                        </div>

                                        <div class="clear"></div>

                                    </div>

                                </li>

                            </ol><!-- .commentlist end -->
                        </div><!-- .entry end -->

                        <!-- Comment Form Start
                        ===========================-->
                        <form action="">

                            <div class="border">
                                <div class="border-collapse border-bottom p-3" style="height: 150px;">
                                    <textarea class="textarea w-100" style="border: 0; height: 100%;"
                                              placeholder="댓글을 작성해 주세요."></textarea>
                                </div>
                                <div class="grid" style="text-align: right;">
                                    <a href="#" style="margin: 0; border: 0;" class="social-icon si-facebook">
                                        <i class="icon-like"></i>
                                        <i class="icon-like"></i>
                                    </a>
                                    <button type="button" style="margin: 0;" class="button">등 록</button>
                                </div>
                            </div>

                        </form>

                    </div>
                </div>
            </div>
        </div>
</section>
</div>
</div><!-- #wrapper end-->
<footer id="footer" class="dark">
    <%@include file="../include/footer.jsp" %>
</footer>

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

</body>
</html>