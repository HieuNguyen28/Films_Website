<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/views/Css/User_Profile.css">
    <script src="<%=request.getContextPath()%>/views/Js/User_Profile.js"></script>
    <script src="https://kit.fontawesome.com/535198922e.js" crossorigin="anonymous"></script>

    <!-- <script src="https://cdn.tailwindcss.com"></script> -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>

    <title>Đổi mật khẩu</title>
</head>

<body>
    <div class="container-fluid">
        <div class="row">
            <div class="navigation-wrap bg-light start-header start-style">
                <div class="container-fluid">
                    <div class="row" id="row-header">
                        <div class="col-12">
                            <nav class="navbar navbar-expand-md navbar-light">

                                <a class="navbar-brand" href="<%=request.getContextPath()%>/Homepage" ><img
                                        src="https://ap.poly.edu.vn/images/logo.png" alt=""></a>

                                <button class="navbar-toggler" type="button" data-toggle="collapse"
                                    data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                                    aria-expanded="false" aria-label="Toggle navigation">
                                    <span class="navbar-toggler-icon"></span>
                                </button>
                                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                                    <ul class="navbar-nav ml-auto py-4 py-md-0">
                                        <li class="nav-item pl-4 pl-md-0 ml-0 ml-md-4">
                                            <a class="nav-link" href="<%=request.getContextPath()%>/EditProfileServlet" id="userDropdown" role="button"
                                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                <span class="mr-2 d-none d-lg-inline text-gray-600 small">${sessionScope.username}</span>
                                                <img class="img-profile rounded-circle" style="width: 40px;" src="<%=request.getContextPath()%>/views/Picture/undraw_profile.svg">
                                            </a>
                                        </li>
                                        <li class="nav-item pl-4 pl-md-0 ml-0 ml-md-4">
                                            <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#"
                                                role="button" aria-haspopup="true" aria-expanded="false">My Account</a>
                                            <div class="dropdown-menu">
                                                <a class="dropdown-item"
                                                    href="<%=request.getContextPath()%>/LogoffServlet">Log Out</a>
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
        <div class="container-fluid">
            <div class="header">
                <!--Content before waves-->
                <div class="inner-header flex">
                    <!--Just the logo.. Don't mind this-->
                    <svg version="1.1" class="logo" baseProfile="tiny" id="Layer_1" xmlns="http://www.w3.org/2000/svg"
                        xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 500 500"
                        xml:space="preserve">
                        <path fill="#FFFFFF" stroke="#000000" stroke-width="10" stroke-miterlimit="10" d="M57,283" />
                        <g>
                            <path fill="#fff"
                                d="M250.4,0.8C112.7,0.8,1,112.4,1,250.2c0,137.7,111.7,249.4,249.4,249.4c137.7,0,249.4-111.7,249.4-249.4
                C499.8,112.4,388.1,0.8,250.4,0.8z M383.8,326.3c-62,0-101.4-14.1-117.6-46.3c-17.1-34.1-2.3-75.4,13.2-104.1
                c-22.4,3-38.4,9.2-47.8,18.3c-11.2,10.9-13.6,26.7-16.3,45c-3.1,20.8-6.6,44.4-25.3,62.4c-19.8,19.1-51.6,26.9-100.2,24.6l1.8-39.7		c35.9,1.6,59.7-2.9,70.8-13.6c8.9-8.6,11.1-22.9,13.5-39.6c6.3-42,14.8-99.4,141.4-99.4h41L333,166c-12.6,16-45.4,68.2-31.2,96.2	c9.2,18.3,41.5,25.6,91.2,24.2l1.1,39.8C390.5,326.2,387.1,326.3,383.8,326.3z" />
                        </g>
                    </svg>
                    <h1 id="title">My Movies</h1>
                </div>

                <!--Waves Container-->
                <div>
                    <svg class="waves" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"
                        viewBox="0 24 150 28" preserveAspectRatio="none" shape-rendering="auto">
                        <defs>
                            <path id="gentle-wave"
                                d="M-160 44c30 0 58-18 88-18s 58 18 88 18 58-18 88-18 58 18 88 18 v44h-352z" />
                        </defs>
                        <g class="parallax">
                            <use xlink:href="#gentle-wave" x="48" y="0" fill="rgba(255,255,255,0.7" />
                            <use xlink:href="#gentle-wave" x="48" y="3" fill="rgba(255,255,255,0.5)" />
                            <use xlink:href="#gentle-wave" x="48" y="5" fill="rgba(255,255,255,0.3)" />
                            <use xlink:href="#gentle-wave" x="48" y="7" fill="#fff" />
                        </g>
                    </svg>
                </div>
                <!--Waves end-->
                <div class="jumbotron jumbotron-fluid">
                    <div class="container">
                        <h3 class="display-4">Change Password</h3>
                    </div>
                </div>
            </div>

        </div>
        <div class="row">
            <div class="container my-12 mx-auto px-4 md:px-12">
                <form class="row g-3" method="post" action="<%=request.getContextPath()%>/ChangePasswordServlet">
                    <div class="col-md-4">
                        <div class="form-outline">
                            <input name="username" value="${sessionScope.username}" type="text"  class="form-control" hidden
                                   required />
                            <input name="currentPassword" placeholder="Enter your current password" type="password" class="form-control" id="validationDefault02"
                                required />
                            <label for="validationDefault02"  class="form-label font-italic">Current password</label>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-outline">
                            <input  name="password" placeholder="Enter your new password"type="password" class="form-control" id="validationDefault03" required />
                            <label for="validationDefault03" class="form-label font-italic">New password</label>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-outline">
                            <input  name="confirmPassword" placeholder="Enter your new password"type="password" class="form-control" id="validationDefault04" required />
                            <label for="validationDefault04" class="form-label font-italic">Confirm your password</label>
                        </div>
                    </div>
                    <div class="col-12">
                        <button class="btn btn-primary" type="submit">Submit</button>
                    </div>
                </form>
            </div>
        </div>
        <div class="my-1 py-1">
            <p>${message}</p>
            <p style="color: firebrick">${error}</p>
        </div>

        <div class="my-1 py-1">
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