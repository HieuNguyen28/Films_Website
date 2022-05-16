<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Watch Video</title>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/views/Css/Video.css">
  <script src="<%=request.getContextPath()%>/views/Js/Video.js"></script>
  <script src="https://kit.fontawesome.com/535198922e.js" crossorigin="anonymous"></script>
  <!-- Latest compiled and minified CSS -->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">

  <!-- jQuery library -->
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>

  <!-- Popper JS -->
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

  <!-- Latest compiled JavaScript -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

</head>

<body>
  <div class="container-fluid">
    <div class="row">
      <div class="navigation-wrap bg-light start-header start-style">
        <div class="container-fluid">
          <div class="row" id="row-header">
            <div class="col-12">
              <nav class="navbar navbar-expand-md navbar-light">

                <a class="navbar-brand" href="<%=request.getContextPath()%>/Homepage" >
                  <img src="https://ap.poly.edu.vn/images/logo.png" alt="">
                </a>
                <button class="navbar-toggler" type="button" data-toggle="collapse"
                  data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                  aria-label="Toggle navigation">
                  <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                  <ul class="navbar-nav ml-auto py-4 py-md-0">
                    <li class="nav-item pl-4 pl-md-0 ml-0 ml-md-4">
                      <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button"
                        aria-haspopup="true" aria-expanded="false">My Account</a>
                      <div class="dropdown-menu">
                        <a class="dropdown-item" href="<%=request.getContextPath()%>/LogoffServlet">Log Out</a>
                        <a class="dropdown-item" href="<%=request.getContextPath()%>/ChangePasswordServlet">Change Password</a>
                        <a class="dropdown-item" href="<%=request.getContextPath()%>/EditProfileServlet">Edit Profile</a>
                        <c:if test="${sessionScope.userSession.admin == true}">
                          <a class="dropdown-item" href="<%=request.getContextPath()%>//Admin/VideosManagement">Management</a>
                        </c:if>
                      </div>
                    </li>
                    <li class="nav-item pl-4 pl-md-0 ml-0 ml-md-4">
                      <a class="nav-link" href="<%=request.getContextPath()%>/FavoriteServlet">My favorites</a>
                    </li>
                  </ul>
                </div>

              </nav>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div id="blog" class="blog">
      <div class="container-fluid">
        <div class="row">
          <div class="col-lg-4 offset-lg-4  wow fadeInDown" data-wow-duration="1s" data-wow-delay="0.3s">
            <div class="section-heading">
              <h1 class="display-4">Watch anywhere. Cancel anytime!</h1>
              <div class="line-dec"></div>
            </div>
          </div>
          <div class="col-lg-8 show-up wow fadeInUp" data-wow-duration="1s" data-wow-delay="0.3s">
            <div class="blog-post">
              <div class="thumb" style="display:flex; justify-content:center; align-items:center; padding: 20px;">
                ${video.link}
              </div>
              <div class="down-content">
                <span class="category">Trending</span>
                <span class="date">03 August 2021</span>
                <a href="#">
                  <h4>${video.title}</h4>
                </a>
                <span class="author"><img src="https://lh3.googleusercontent.com/ogw/ADea4I4ckmyM7UWMv42vQY1KDVt8wx-alH-JpsIxXTjL=s32-c-mo" 
                  alt="">By: Hiếu Nguyễn
                </span>
                <div class="border-first-button">
                  <a href="<%=request.getContextPath()%>/LikeVideo?videoId=${video.videoId}"><i class="fas fa-heart"></i></a>
                  <a href="<%=request.getContextPath()%>/ShareVideo?videoId=${video.videoId}"><i class="fas fa-share"></i></a>
                </div>
                <p>${video.description}
                </p>
              </div>
            </div>
          </div>
          <div class="col-lg-4 wow fadeInUp" data-wow-duration="1s" data-wow-delay="0.3s">
            <div class="blog-posts">
              <div class="row">
                <c:forEach items="${videos}" var="item" begin ="0" end="2">
                <div class="col-lg-12">
                  <div class="post-item">
                    <div class="thumb" >
                      <a href="<%=request.getContextPath()%>/VideoDetailServlet?videoId=${item.videoId}">
                        <img src="<%=request.getContextPath()%>/views/Picture/${item.poster}" alt="">
                      </a>
                    </div>
                    <div class="right-content">
                      <span class="category">Suggestion</span>
                      <span class="date">24 September 2021</span>
                      <a href="<%=request.getContextPath()%>/VideoDetailServlet?videoId=${item.videoId}">
                        <h6>${item.title}</h6>
                      </a>
                      <p>${item.description}</p>
                    </div>
                  </div>
                </div>
                </c:forEach>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="my-3 py-3">
    </div>
    <!-- Site footer -->
    <footer class="site-footer">
      <div class="container">
        <div class="row">
          <div class="col-sm-12 col-md-6">
            <h6>About</h6>
            <p class="text-justify">This is project of my group 1. Welcome to my website.</p>
          </div>

          <div class="col-xs-6 col-md-3">
            <h6>Made by</h6>
            <ul class="footer-links">
              <li><a href="https://www.facebook.com/timt.pu">Nguyễn Hiếu</a></li>
              <li><a href="">Zi Dan</a></li>
              <li><a href="">Nhựt Hào</a></li>
            </ul>
          </div>

          <div class="col-xs-6 col-md-3">
            <h6>Quick Links</h6>
            <ul class="footer-links">
              <li><a href="#">About Us</a></li>
              <li><a href="#">Contact Us</a></li>
              <li><a href="#">Contribute</a></li>
              <li><a href="#">Privacy Policy</a></li>
              <li><a href="#">Sitemap</a></li>
            </ul>
          </div>
        </div>
        <hr>
      </div>
      <div class="container">
        <div class="row">
          <div class="col-md-8 col-sm-6 col-xs-12">
            <p class="copyright-text">Copyright &copy; 2022 All Rights Reserved by
              <a href="#">FPT Polytechnic</a>.
            </p>
          </div>

          <div class="col-md-4 col-sm-6 col-xs-12">
            <ul class="social-icons">
              <li><a class="facebook" href="#"><i class="fa fa-facebook"></i></a></li>
              <li><a class="twitter" href="#"><i class="fa fa-twitter"></i></a></li>
              <li><a class="dribbble" href="#"><i class="fa fa-dribbble"></i></a></li>
              <li><a class="linkedin" href="#"><i class="fa fa-linkedin"></i></a></li>
            </ul>
          </div>
        </div>
      </div>
    </footer>
  </div>
</body>

</html>