<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/views/Css/Login.css">
    <script src="<%=request.getContextPath()%>/views/Js/Login.js"></script>
    <script src="https://kit.fontawesome.com/535198922e.js" crossorigin="anonymous"></script>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>

    <!-- Popper JS -->
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    <title>Document</title>
</head>

<body>
    <div class="navigation-wrap bg-light start-header start-style">
        <div class="container-fluid">
            <div class="row" id="row-header">
                <div class="col-12">
                    <nav class="navbar navbar-expand-md navbar-light">

                        <a class="navbar-brand" href="#" ><img
                                src="https://ap.poly.edu.vn/images/logo.png" alt=""></a>

                        <button class="navbar-toggler" type="button" data-toggle="collapse"
                            data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                            aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                    </nav>
                </div>
            </div>
        </div>
    </div>
    <div class="my-1 py-1">
    </div>
    <div class="section full-height">
        <div class="absolute-center">
            <div class="login-wrap">
                <div class="login-html">
                    <input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1"
                        class="tab">Sign
                        In</label>
                    <input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">Sign
                        Up</label>
                    <div class="login-form">
                        <form action="<%=request.getContextPath()%>/LoginServlet" method="POST">
                        <div class="sign-in-htm">
                            <div class="group">
                                <label for="user_login" class="label">User Name</label>
                                <input name="username" id="user_login" type="text" class="input" value="${sessionScope.username}">
                            </div>
                            <div class="group">
                                <label for="password" class="label">Password</label>
                                <input name="password" id="password" type="password" class="input" data-type="password">
                            </div>
                            <div class="group">
                                <input name="remember" id="check" type="checkbox" class="check">
                                <label for="check" style="color:white"><span class="icon"></span> Remember me? </label>
                            </div>
                            <div class="group">
                                <input type="submit" class="button" value="Sign In">
                                <p style="color: indianred">${error}</p>
                            </div>
                            <div class="hr"></div>
                            <div class="foot-lnk">
                                <a href="<%=request.getContextPath()%>/ForgotPasswordServlet">Forgot Password?</a>
                            </div>
                        </div>
                        </form>
                        <form action="<%=request.getContextPath()%>/Registration" method="POST">
                        <div class="sign-up-htm">
                            <div class="group">
                                <label for="user" class="label">User Name</label>
                                <input name="userName" id="user" type="text" class="input">
                            </div>
                            <div class="group">
                                <label for="pass_registration" class="label">Password</label>
                                <input name="password" id="pass_registration" type="password" class="input" data-type="password">
                            </div>
                            <div class="group">
                                <label for="pass_registration_1" class="label">Email</label>
                                <input name="email" id="pass_registration_1" type="email" class="input" >
                            </div>
                            <div class="group">
                                <label for="name_registration" class="label">Full Name</label>
                                <input name="fullName" id="name_registration" type="text" class="input">
                                <input name="admin" id="role" type="checkbox" class="input" hidden checked value="false">
                            </div>
                            <div class="group">
                                <input type="submit" class="button" value="Sign Up">
                                <p style="color: indianred">${error}</p>
                            </div>
                        </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
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
                        <li><a href="">Nguyễn Hiếu</a></li>
                        <li><a href="">Zi Dan</a></li>
                        <li><a href="">Nhựt Hào</a></li>
                    </ul>
                </div>

                <div class="col-xs-6 col-md-3">
                    <h6>Quick Links</h6>
                    <ul class="footer-links">
                        <li><a href="http://scanfcode.com/about/">About Us</a></li>
                        <li><a href="http://scanfcode.com/contact/">Contact Us</a></li>
                        <li><a href="http://scanfcode.com/contribute-at-scanfcode/">Contribute</a></li>
                        <li><a href="http://scanfcode.com/privacy-policy/">Privacy Policy</a></li>
                        <li><a href="http://scanfcode.com/sitemap/">Sitemap</a></li>
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
</body>

</html>