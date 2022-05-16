<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Admin Dashboard</title>

    <script src="https://kit.fontawesome.com/535198922e.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/views/Css/Admin.css">
    <script src="<%=request.getContextPath()%>/views/Js/Admin.js"></script>

    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">
    
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>

    <!-- Popper JS -->
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="<%=request.getContextPath()%>/Homepage">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fas fa-laugh-wink"></i>
                </div>
                <div class="sidebar-brand-text mx-3"> Administrator Tools </div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">

            <!-- Nav Item - Dashboard -->
            <li class="nav-item ">
                <a class="nav-link" href="<%=request.getContextPath()%>/Admin/VideosManagement">
                    <i class="fas fa-photo-video"></i>
                    <span>Manage video</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading">
                Manage user account
            </div>

            <!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"
                    aria-expanded="true" aria-controls="collapseTwo">
                    <i class="fas fa-fw fa-cog"></i>
                    <span>Manage Users</span>
                </a>
                <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">My Users</h6>
                        <a class="collapse-item active" href="<%=request.getContextPath()%>/UserManagementServlet">Edit Users</a>
                    </div>
                </div>
            </li>



            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading">
                Reports and Statistics
            </div>

            <!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages"
                    aria-expanded="true" aria-controls="collapsePages">
                    <i class="fas fa-fw fa-folder"></i>
                    <span>Pages</span>
                </a>
                <div id="collapsePages" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Favorites</h6>
                        <a class="collapse-item" href="<%=request.getContextPath()%>/ReportManagementServlet"> Statistics</a>
                    </div>
                </div>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider d-none d-md-block">

            <!-- Sidebar Toggler (Sidebar) -->
            <div class="text-center d-none d-md-inline">
                <button class="rounded-circle border-0" id="sidebarToggle"></button>
            </div>
        </ul>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                    <!-- Sidebar Toggle (Topbar) -->
                    <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                        <i class="fa fa-bars"></i>
                    </button>

                    <!-- Topbar Search -->
                    <form
                        class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                        <div class="input-group">
                            <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..."
                                aria-label="Search" aria-describedby="basic-addon2">
                            <div class="input-group-append">
                                <button class="btn btn-primary" type="button">
                                    <i class="fas fa-search fa-sm"></i>
                                </button>
                            </div>
                        </div>
                    </form>

                    <!-- Topbar Navbar -->
                    <ul class="navbar-nav ml-auto">

                        <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                        <li class="nav-item dropdown no-arrow d-sm-none">
                            <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-search fa-fw"></i>
                            </a>
                            <!-- Dropdown - Messages -->
                            <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
                                aria-labelledby="searchDropdown">
                                <form class="form-inline mr-auto w-100 navbar-search">
                                    <div class="input-group">
                                        <input type="text" class="form-control bg-light border-0 small"
                                            placeholder="Search for..." aria-label="Search"
                                            aria-describedby="basic-addon2">
                                        <div class="input-group-append">
                                            <button class="btn btn-primary" type="button">
                                                <i class="fas fa-search fa-sm"></i>
                                            </button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </li>

                        <div class="topbar-divider d-none d-sm-block"></div>

                        <!-- Nav Item - User Information -->
                        <li class="nav-item dropdown ">
                            <a class="nav-link dropdown-toggle" href="<%=request.getContextPath()%>/EditProfileServlet" id="userDropdown" role="button"
                               data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small">${sessionScope.username}</span>
                                <img class="img-profile rounded-circle" src="<%=request.getContextPath()%>/views/Picture/undraw_profile.svg">
                            </a>
                            <!-- Dropdown - User Information -->
                            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                 aria-labelledby="userDropdown">
                                <a class="dropdown-item" href="<%=request.getContextPath()%>/EditProfileServlet">
                                    <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Profile
                                </a>
                                <a class="dropdown-item" href="<%=request.getContextPath()%>/ChangePasswordServlet">
                                    <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Change Password
                                </a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="<%=request.getContextPath()%>/LogoffServlet" data-toggle="modal" data-target="#logoutModal">
                                    <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Logout
                                </a>
                            </div>
                        </li>

                    </ul>

                </nav>
                <!-- End of Topbar -->
                <!-- Main content -->
                <div class="row">
                    
                    <div class="container my-12 mx-auto px-4 md:px-12">
                        <div
                                class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                            <h6 class="m-0 font-weight-bold text-primary"><i class="fas fa-video"></i> Admin Report</h6>
                        </div>
                        <div class="col mt-4">
                            <ul class="nav nav-tabs" id="myTab" role="tablist">
                                <li class="nav-item" role="presentation"><a
                                        class="nav-link active" id="VideoEditing-tab" data-toggle="tab"
                                        href="#VideoEditing" role="tab" aria-controls="VideoEditing"
                                        aria-selected="true">Favorites</a></li>
                                <li class="nav-item" role="presentation"><a class="nav-link"
                                                                            id="VideoList-tab" data-toggle="tab" href="#VideoList" role="tab"
                                                                            aria-controls="VideoList" aria-selected="false">Favorite Users</a></li>
                                <li class="nav-item" role="presentation"><a class="nav-link"
                                                                            id="shareFriends-tab" data-toggle="tab" href="#shareFriends"
                                                                            role="tab" aria-controls="shareFriends" aria-selected="false">Share
                                    Friends</a></li>

                            </ul>
                            <div class="tab-content" id="myTabContent">
                                <div class="tab-pane fade show active" id="VideoEditing"
                                     role="tabpanel" aria-labelledby="VideoEditing-tab">
                                    <table class="table table-bordered mt-3">
                                        <tr>
                                            <th>Video Title</th>
                                            <th>Favorites Count</th>
                                            <th>Lasted Date</th>
                                            <th>Oldest Date</th>
                                        </tr>
                                        <c:forEach var="item" items= "${favList}">
                                            <tr>
                                                <td>${item.videoTitle}</td>
                                                <td>${item.favoriteCount}</td>
                                                <td>${item.newestDate}</td>
                                                <td>${item.oldestDate}</td>
                                            </tr>
                                        </c:forEach>
                                    </table>
                                </div>
                                <div class="tab-pane fade" id="VideoList" role="tabpanel"
                                     aria-labelledby="VideoList-tab">
                                    <form action="" method="get">
                                        <div class="row mt-3">
                                            <div class="col">
                                                <div class="form-inline">
                                                    <div class="form-group">
                                                        <label>Video Title
                                                            <select name="videoUserId" id="videoUserId"
                                                                    class="from-control ml-3">
                                                                <c:forEach var="item" items="${vidList }">
                                                                    <option value="${item.videoId }"
                                                                        ${item.videoId == videoUserId?'selected':'' }>${item.title }</option>
                                                                </c:forEach>
                                                            </select>
                                                        </label>
                                                        <button class="btn btn-success ml-2">Search</button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col mt-3">
                                                <table class="table table-bordered">
                                                    <thead>
                                                        <th>Username</th>
                                                        <th>Fullname</th>
                                                        <th>Email</th>
                                                        <th>Favorite Date</th>
                                                    </thead>
                                                    <c:forEach var="item" items="${favUsers }">
                                                        <tr>
                                                            <td>${item.username }</td>
                                                            <td>${item.fullname }</td>
                                                            <td>${item.email }</td>
                                                            <td>${item.likeDate }</td>
                                                        </tr>
                                                    </c:forEach>
                                                </table>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                                <div class="tab-pane fade" id="shareFriends" role="tabpanel"
                                     aria-labelledby="shareFriends-tab">
                                    <form action="" method="get">
                                        <div class="row mt-3">
                                            <div class="col">
                                                <div class="form-inline">
                                                    <div class="form-group ">
                                                        <label>Video Title
                                                            <select name="" id="" class="from-control ml-2">
                                                                <c:forEach var="item" items="${vidList }">
                                                                    <option value="${item.videoId }" ${item.videoId == videoUserId?'selected':'' }>${item.title }</option>
                                                                </c:forEach>
                                                            </select>
                                                        </label>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col mt-3">
                                                <table class="table table-bordered">
                                                    <thead>
                                                        <th>Sender Name</th>
                                                        <th>Sender Email</th>
                                                        <th>Receiver Email</th>
                                                        <th>Sent Date</th>
                                                    </thead>
                                                    <tbody>
                                                        <c:forEach var="item" items="${shareList}">
                                                        <tr>
                                                            <td>${item.user.fullName}</td>
                                                            <td>${item.user.email}</td>
                                                            <td>${item.emails}</td>
                                                            <td>${item.sharedDate}</td>
                                                        </tr>
                                                        </c:forEach>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="my-2"></div>
                <!-- End content -->

                <!-- Footer -->
                <footer class="sticky-footer bg-white">
                    <div class="container my-auto">
                        <div class="copyright text-center my-auto">
                            <span>Copyright &copy; Your Website 2021</span>
                        </div>
                    </div>
                </footer>
                <!-- End of Footer -->

            </div>
            <!-- End of Content Wrapper -->

        </div>
        <!-- End of Page Wrapper -->

        <!-- Scroll to Top Button-->
        <a class="scroll-to-top rounded" href="#page-top">
            <i class="fas fa-angle-up"></i>
        </a>

        <!-- Logout Modal-->
        <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
            aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                        <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">×</span>
                        </button>
                    </div>
                    <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                    <div class="modal-footer">
                        <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                        <a class="btn btn-primary" href="<%=request.getContextPath()%>/LogoffServlet">Logout</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>

</html>