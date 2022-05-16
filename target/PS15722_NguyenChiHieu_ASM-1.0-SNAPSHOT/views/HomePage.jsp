<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/views/Css/Index.css">
    <script src="<%=request.getContextPath()%>/views/Js/Index.js"></script>
    <script src="https://kit.fontawesome.com/535198922e.js" crossorigin="anonymous"></script>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.tailwindcss.com"></script>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>

    <!-- Popper JS -->
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    <title>Trang chủ</title>
</head>

<body>
    <div class="container-fluid">
        <div class="row">
            <div class="navigation-wrap bg-light start-header start-style">
                <div class="container-fluid">
                    <div class="row" id="row-header">
                        <div class="col-12">
                            <nav class="navbar navbar-expand-md navbar-light">

                                <a class="navbar-brand" href="" target="_blank"><img
                                        src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAATEAAAClCAMAAAADOzq7AAAAvVBMVEX////m5ubl5eXk5OTz8/P09PTx8fHj4+P29vbw8PD39/fu7u7lChXr6+v6+vrkAADvenzlAA3m7e3y1NXysbLrbW7629v99PTyqKjlxMToOj3oj5Hm7u7suLjvo6Tw5ubwmZv2y8zmiInoX2PnQEPtdnjmLjLlHSHx+vrqwMDpVFbnQELwz8/rqKruhYf03t7lIibytbXnSUvm2trlFhzph4jpt7joWVvrT1Hq+/vtgIHkvr777O3u1tflZGeQW0AdAAAOa0lEQVR4nO1da3vbqBrUxTfZkWUp90Rx7OY4lXuSOr1kTzfb7v//WYeXFyGBQXc5SQvPfpiobZgdwTBCCCwLimuTokA+gHmGHNt2KJoCmnHkAZoAGgEaAhoAGgAaAhoBmgDyAE0BzQDNAfkZIpW5GaJUbAUCUo6O/FxHXkXZU1AeKChPkLJlFDOKvQ3FHAn1oZgrI4VOThPFcuS7VMzh1Tu8elknZfUur94tU8zl1btcsT2dRISKceQ4OcWUlLlilSlXVMxNFXNJGdP6xgQ5HNkcYX0KNCVoPOMIOQCisg0AYc2AsGZAKBZHPhCYi8jmpDLkCEQz5Coo2zrKFGkpDzllSn7IKU/ylO2WfkDRRGznlVq3omuKFobalXbNnv3XE8kbxfpQrMQPWihWYmaSTjUU0/tvRrmdYjanlCGsSoewUkBYKUdDQFipiLBSEaFigHjLUiIFvTaUZyJlikYK8jhiKShbJQ6qtX/uoG4tB/Vcbv8K0/cVpp8hV2P/tUcsJD8R7T+jrB+xUCaTYE3mP4hi7RNsDcUaJ9gyxWom2BqKuYJitu+zmwPI16EpoBlHzDcFxByUIOagBDEHJYg5qICY/RPEWlYRsgGJlK1CynORsoq8irJEPk+5bebPHFS2f6WDiqavzfwq++8h81casVyZfGkeMwnWZP4OFMtmA+o7KCrmlinm7jloxcyvQK5AudaINVXZf+GciyeSJ5R9KHMoOjQDMBWRB2giohGgIaABoIGIhoBGgCaAPBFNAc04KidVFUnkJcpeA8r0tnTnoG4NB22f+TPKnYxYrpz5lZQt3s5NgjWZv2fFOp21dvPVuw1nrVWm392stTRiSZRVIxajbB3A9Bva/6wLq9dSbjxikbvmpF5KkMORzRHzzX00BcQclCCPI7xXbopGBKUOShBz0BT5gOYKhM2LI4ejcYY0lG0d5TmnPBUps76RJ5+OWDJ5k2BN5u9bMQe6JVZFkK1ArHoBMQdN0QSQx5HcK6EKVmmKZoCwVwKaKxDqpECugJyKlH2R8lSkrOiV7lCk7DHKM1L8+ZQUH6CA5hR5gCY6NAI0FNEA0AB+cYaGgEYimgDydGgKiNIDTnNOdO4LaNYJeU60hDzP/Pyu9eCgrsZBmf2rTJ+95t23f2gO3PT1lLUjVkZZHrFEynzEcvcoo2ImwZrM37diY42DsupL7T9r2NpemWvi3PRnOtNnmX/f9B11r2w/Yg2Le2WOsgVmOQXHm3HkAZiUoxGgIXVLEQ10aAhoJKIJIK8cKYi2oSyR11LeI59LF1lDq5/53eoO6jbN/ELzyhCn7DQdsQr7hrdn/ybBmsx/uMwvNOz6Dlq5V9bO/GMJuYW9sjDzi+Tr90qg7EGZQNGhkYiGIhoAGjRDQ0AjEU1EVE6vIeWG5IdUPK2DOlUctPG9Ks38pc1L3zfKKTcesVAxk2BN5j9c5lf1So2D1uuVulBWnPnlXlmc+WuMWHKvLMn8+V45hDKCokADEQ36RUMd0tGrQLl78iXpYszvUOagLs/8rRyUpwuV/Rc2r+J0UTxi1e4b+yOWSbAm879u5h9rTL9Nr0TFhF6ZmX7HvVKm3EWvHJhSr1iHuld10oU+81dNF7q+YTK/hrzJ/G9Psaq9skWuKemVYhTrsFfqKDfvla+WnasF/zpx/zDPKs3Shf75rEG60Mwoys2r6oxix8/DJvObzP/amV/1Kkv/9q2/J3G3Veav9Patca+sM3Pe6Xx56WR/syn+Yspt3k8wypb2XrllDlrvnYyyoWlMX7WKoOMZRfkdWOUZRZNgTeZ/3czf7/qFGivuNKav6JU1V9w1yfyvtkamxgKfaRcLfEYdrUlSZn63iYM6Ve6V4zRYRSDbv6sIROWUG65780Ty/SRYOwGUcD9IoihCFwAUJRxZIoo58rNrcYpsfi2fYNNrhF4Uc/KUqAX/4H1k/tvTDSnLCKv/vFksFqc+VL87XUCBP6XglFw7k64tNp+JYjcb8dozIbolP2xOt4Ji0XJD/trpDrS7hr+/uYmQKP0Ni03fmb+Dr2xII74NoIQ2NvF7+tMtVP8QSIVcu5GvBfekdSyla0/k2iNFN8KKu+iUXjwj16IVhR9jJP9Ef/oQK8i3XCMOntbtuvj5eXBESrAlcOAnVyH8cE4c1Lukf5CVIPG9G+naUXiV+MmFeDW8J1RO4FqwHOWX8lun9OKxl1W7JnDqbfGHcy15eSm/blH/3ncIFrZujYPWXjlMWzejvqH3KmaKjchv21fMiRSKxWNrTzHSDVGx6ygzfYJQsQdKFDF09Xn8NUQKdVYOl3zr0mPmR8WOgjn4QcIVs6sqlrgKxRxJMZZg84qdBWm11jHCs3eS+VPFvqgVy9kTVYyWo+xP7rli2V/8XkUx64lWdZE2t/Brr5nfzey/7Vc2TLHwB3ymznrlnIQyVCx4ebi8vDw+I+WSxPpvFNGWFix25Nrlpc16ZfDh8vKM/r3LS2L1qWLjPGVBsRXV6T/cF25qjFhjdY7c/zBIu3tDi29hb1mXCm79wdxCxWbD+ZyMlQBX8N0w9Vf6qS64anyMFpTMaGXz0ZL+/GjRb7rwmvdIr51YeaIJKnaGlH+iUA8JSvc06ODb45H8IS/kMYe3c/l7a+3H4vodQgjiil1H5F6hYixdoGKWvEOIjYrdxewhPELFLvKfiEeo2A2MSZxyzBRjlPGnRfKd1rmKHJl8yQ4hbr5rujyPiR+L95Fgg9SvvULFnCqK2fuK5RNsTjFCeU1r/n6Cbe323czzp4qR/jE8rGLWPVQWYuXPcT+Kdb+blpMp9pxoFRN200oVi9jGKjnFOL1MsdxuWrxXMsrXWSoJdk6LvWBc/V4w3W2KMGRemo6V5GZ/H/HMD76JY+UqBge18ns2YH4Kni22ZwMbKy9ifKSmVNhYuYry9NLMn17jN4vIn1Qcu+ru3pB2ww53CDnPaN/YsZzHgmt/5sMwmd8hBBX7YKXbQqFin7fbNZRvtBuW5zHXjj+FadXbqCLlwjym2CGEV995gqV5Id5T7Ojo6SMp30mfy2atc4rZXDGeYB+jqopFf6WjzpX3jub5z3Nmcqt4SgppCZaliqW/5KSyYrYfMt9/jPqd5+90P8K8Ysu/eeZ3xedKUIzvoZVTjNq6pJgN16TMj/YvKEauRc/0X4aB32D/R1SsZP9HcNWu97yk9hv++F9In5TksTJTLOLbdPqo2L8x25ITx8pMMXqNj5Wk0aSU+VjJie6wP19bDfYYVW3Tub/HqCaPtdkVEBX7im1ivqcY6ZDkv4ArlstjkZDHuI9JirnqPIaUsQ6IMJV3BayRx/rM/OF/bzEhfJUUC+8/0fLj0S5LsJuTk0dSLs5ExQoSrGXd4V15eldre1Cxq79hpA8/fVIm2CSOo9LMf4JvN/DdRzXFdukz7bo3xTrL/GMx84dXMU4WfjxSKSaemuF0lfmtRarYXfenZnD7t5Q73rfY5/4ce6V1nqZJmi7I72CZH972ZFvzUySmCzvN/FG6NzNcS8dKvKsOEmVjpc/I5zL/TiI/Fcl7InnVuQLS1vwMoWKaPFYp82vyGEzsnQY5xXjmB8WyDlmU+S+i/GqLCnksWmU1LuOKlN9KggXF1hUUK0iw9RXznnizDu8HCvJvXbF5GB5UMRudk6X+hz4Va3lqxliR+YmPWdYLn/eZkwDNFUsd1CvO/ESx/A66TLE4XUqwn/nZO7fnFxxHFJT5iDXeH7GqnZoxprPWHe4SmksXsW1vuWL76eLbbr1OG5o6wapmrcO7zycXf/3zsP7505JnrX32+m3HXu/edpVgG89aKx1Un8eIYvF9mFfsGB+fPt9dZasIas7BHoX8jdxKzmPxAh82YqyWPFR0cF7dIRMsUYw9F0tPSUGQ6thAsSywXMiKYbQIbqKIvYaL31nmj1MlxDaW/59updhSUiz+TOt9irl2D6+U+RVTPmPJQQX755mf/IuEdUvF3EWqmD9mmT8UMj8UReYXFRtHucw/C/EyGVjiDb38Eo0VI5b+cL9qJ+VxYWqPldqas7HSStiritxYeZRzo2TMx8ogvL+6ttKxcr15eXlZbO38WPkorZCiI2lurGTv3Oi/2Ka4+E43Gitp6SmPkepZR0zzGF8j9okocrGK0zw2S5IElxhma63jKNpbYR3vdr9g7n+5ell8geelO/rrqGJo9y+UqI9LML68qwRL29gg/oESUcV+LZbr9dmtn6oz4gk2twSWK6ZbnY70ogj99+d6e7P6ZsMDBi07SjS6ZhxeTbFaozRVLLii1UfLry/PJw/HtHpcIEsecB1XyvxtTpW1QTyLivfPI3uatH/RATn4aelSUXvFOn37BoV2j4EbxbhU+BCnysI6YjbGR6t/wSsXSsVqvH07zKmyt6tjEsiTEgctOmGqk1NlrWi3vZ4pyLccK3vIY05SdK8O930l+XvvZHX6b/5FaqlilZ7EGylmTpWllQKSZn/NqbKW7KDmVFmOOvSD3+z7SqOYOVW2BuW6CRYpmVNlzamyasrmVNn+/ddk/m4U034z0uztmzlVtp9V3r45VdacKmsSrMn8b3bW2pwq29b0zamy3Xw9bE6V/aMSrFHMnCqroOyLlM2psu13zzGnyhZTlkes0j3uTObnlE3mP4hiut31WPVd7K5nTpVtvYNjtU0nzamyjjlV9s9LsEYxc6ps9f1gzamydSibU2X3kDlVVkIm878zxQ5wio45Vbb/w6XMqbL7zUuf+QubV3G6KB6xavcNc8KUyfxvLfOPNabfpleiYkKvNKfK/s7FOtS9MqfK/uEJ1ihmTpUtpdy8V75adq4W/OvEfXOqrK6hVU0XnTwPm8xvMv9rZ35zqqw5Vba79xPmVFmhb5hTZU3mf2uKvcr6hRor7jSmr+iV5lRZc6qs02AVgWz/riIQlVNuuO5t71TZ/wNaJz+FpVdOCgAAAABJRU5ErkJggg==" alt=""></a>

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
                <div style="padding: 20px;" class="jumbotron jumbotron-fluid">
                    <div class="container">
                        <h1 class="display-4">Welcome and enjoy your time!</h1>
                        <p class="lead" style="color: black">This website made by Team 1 and guided by the instructor
                            Mrs.Huong </p>
                    </div>
                </div>
            </div>

        </div>
        <div class="my-5 py-3">
            <h1 class="display-4">Unlimited movies, TV shows, and more.</h1>
            <p class="lead">Watch anywhere. Cancel anytime! </p>
        </div>
        <div class="row">
            <div class="container my-12 mx-auto px-4 md:px-12">
                <div class="flex flex-wrap -mx-1 lg:-mx-4">
                    <c:forEach items="${videos}" var="video">
                    <!-- Column -->
                    <div style="background:white;" class="my-1 px-1  w-full md:w-1/2 lg:my-4 lg:px-4 lg:w-1/3">

                        <!-- Article -->
                        <article class="overflow-hidden rounded-lg shadow-lg">

                            <a href="<%=request.getContextPath()%>/VideoDetailServlet?videoId=${video.videoId}">
                                <img alt="Placeholder" class="rounded-lg w-full" style="height: 300px; object-fit: contain"
                                    src="<%=request.getContextPath()%>/views/Picture/${video.poster}">
                            </a>

                            <header class="flex items-center justify-between leading-tight p-2 md:p-4">
                                <h1 class="text-lg">
                                    <a class="no-underline hover:underline text-black" href="<%=request.getContextPath()%>/VideoDetailServlet?videoId=${video.videoId}">
                                        ${video.title}
                                    </a>
                                </h1>
                                <p class="text-grey-darker text-sm">
                                    ${video.description}
                                </p>
                            </header>

                            <footer class="flex items-center justify-between leading-none p-2 md:p-4">
                                <a class="flex items-center no-underline hover:underline text-black" href="<%=request.getContextPath()%>/VideoDetailServlet?videoId=${video.videoId}">
                                    <img alt="Placeholder" class="block rounded-full"
                                        src="https://picsum.photos/32/32/?random">
                                    <p class="ml-2 text-sm">
                                        Author Name
                                    </p>
                                </a>
                                <a class="no-underline text-grey-darker hover:text-red-dark" href="<%=request.getContextPath()%>/ShareVideo?videoId=${video.videoId}">
                                    <span class="hidden">Share</span>
                                    <i class="fas fa-share"></i>
                                </a>
                                <a class="no-underline text-grey-darker hover:text-red-dark" href="<%=request.getContextPath()%>/LikeVideo?videoId=${video.videoId}">
                                    <span class="hidden">Like</span>
                                    <i class="fa fa-heart"></i>
                                </a>
                            </footer>

                        </article>
                        <!-- END Article -->

                    </div>
                    <!-- END Column -->
                    </c:forEach>
                    <!-- Column -->

                </div>
            </div>
        </div>
        <div class="my-1 py-1">
        </div>
        <div class="container-fluid">
            <nav aria-label="Page navigation example">
                <ul class="pagination justify-content-center">
                    <li class="page-item disabled">
                        <a class="page-link" href="#" tabindex="-1">Previous</a>
                    </li>
                    <li class="page-item"><a class="page-link" href="#">1</a></li>
                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                    <li class="page-item">
                        <a class="page-link" href="#">Next</a>
                    </li>
                </ul>
            </nav>
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