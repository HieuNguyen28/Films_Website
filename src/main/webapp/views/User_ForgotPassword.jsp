<!-- <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> -->
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
    <title>Quên mật khẩu</title>
</head>

<body>
    <div class="navigation-wrap bg-light start-header start-style">
        <div class="container-fluid">
            <div class="row" id="row-header">
                <div class="col-12">
                    <nav class="navbar navbar-expand-md navbar-light">

                        <a class="navbar-brand" href="#"><img src="https://ap.poly.edu.vn/images/logo.png" alt=""></a>

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
                        class="tab">Forgot Password</label>
                    <input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab"></label>
                    <div class="login-form">
                        <form action="<%=request.getContextPath()%>/ForgotPasswordServlet" method="POST">
                        <div class="sign-in-htm">
                            <div class="group">
                                <label for="user_login" class="label">User Name</label>
                                <input name="username" id="user_login" type="text" class="input" required >
                            </div>
                            <div class="group">
                                <label for="password" class="label">Your Email</label>
                                <input name="email" id="password" type="email" class="input" data-type="email" required>
                            </div>
                            <div class="group">
                                <input type="submit" class="button" value="Retrieve">
                                <p style="color: indianred">${error}</p>
                                <p style="color:white">${message}</p>
                            </div>
                            <div class="hr"></div>
                            <div class="group">
                                <button type="button" class="btn btn-primary btn-rounded">
                                    <a style="color:white;text-decoration:none" href="<%=request.getContextPath()%>/LoginServlet">Sign In</a>
                                </button>
                                <button type="button"  class="btn btn-success btn-rounded">
                                    <a  style="color:white;text-decoration:none" href="<%=request.getContextPath()%>/Registration">Sign Up</a>
                                </button>
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
</body>

</html>