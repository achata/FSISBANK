
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">


<!-- Mirrored from www.urbanui.com/silica/template/demo/vertical-fixed/pages/tables/basic-table.html by HTTrack Website Copier/3.x [XR&CO'2014], Sun, 19 May 2019 18:20:04 GMT -->
<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Silica Admin</title>
  <!-- plugins:css -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/vendors/iconfonts/mdi/font/css/materialdesignicons.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/vendors/css/vendor.bundle.base.css">
  <!-- endinject -->
  <!-- inject:css -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/vertical-layout-light/styles.css">
  <!-- endinject -->
  <link rel="shortcut icon" href="${pageContext.request.contextPath}/assets/images/favicon.png" />
</head>

<body class="sidebar-fixed">
  <div class="container-scroller">
    <!-- partial:${pageContext.request.contextPath}/assets/${pageContext.request.contextPath}/assets${pageContext.request.contextPath}/assets/partials/_navbar.html -->
    <nav class="navbar col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
      <div class="navbar-brand-wrapper d-flex justify-content-center">
        <div class="navbar-brand-inner-wrapper d-flex justify-content-between align-items-center w-100">
          <a class="navbar-brand brand-logo" href="index.html"><img src="http://www.urbanui.com/silica/template/images/logo.svg" alt="logo"/></a>
          <a class="navbar-brand brand-logo-mini" href="index.html"><img src="http://www.urbanui.com/silica/template/images/logo-mini.svg" alt="logo"></a>
          <button class="navbar-toggler navbar-toggler align-self-center" type="button" data-toggle="minimize">
            <span class="mdi mdi-menu"></span>
          </button>
        </div>
      </div>
      <div class="navbar-menu-wrapper d-flex align-items-center justify-content-end">
        <ul class="navbar-nav mr-lg-2">
          <li class="nav-item d-none d-lg-block">
            <h4 class="mb-0">Principal</h4>
          </li>
        </ul>
        <ul class="navbar-nav navbar-nav-right">
          <li class="nav-item nav-search position-relative" id="navbarSearch">
            <a class="nav-link d-flex justify-content-center align-items-center" id="navbarSearchButton" href="#">
              <i class="mdi mdi-magnify mx-0"></i>
            </a>
            <input type="text" class="form-control" placeholder="Search..." id="navbarSearchInput">                  
          </li>

          <li class="nav-item nav-profile dropdown mr-0 mr-sm-3">
            <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown" id="profileDropdown">
                <img src="images/faces/face28.jpg" alt="profile"/>
              <span class="nav-profile-name mr-2">Craig Estrada</span>              
            </a>
            <div class="dropdown-menu dropdown-menu-right navbar-dropdown" aria-labelledby="profileDropdown">
              <a class="dropdown-item">
                <i class="mdi mdi-logout text-primary"></i>
                Salir
              </a>
            </div>
          </li>
        </ul>
        <button class="navbar-toggler navbar-toggler-right d-lg-none align-self-center" type="button" data-toggle="offcanvas">
          <span class="mdi mdi-menu"></span>
        </button>
      </div>
    </nav>

    <!-- partial -->
    <div class="container-fluid page-body-wrapper">
      <!-- partial:${pageContext.request.contextPath}/assets/${pageContext.request.contextPath}/assets${pageContext.request.contextPath}/assets/partials/_sidebar.html -->
       <jsp:include page="/assets/partials/_sidebar.jsp"></jsp:include>
      <!-- partial -->
      <div class="main-panel">
        <div class="content-wrapper">