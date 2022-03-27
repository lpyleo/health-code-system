<%@ page import="com.model.users.Teachers" %>
<%@ page import="com.dao.UsersDao" %>
<%@ page import="com.dao.UsersDaoImpl" %>
<%@ page import="com.model.users.Colleges" %>
<%@ page import="com.model.users.Majors" %>
<%@ page import="com.model.users.Classes" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html class="no-js" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>专业模糊查询结果</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- favicon
		============================================ -->
    <link rel="shortcut icon" type="image/x-icon" href="static/img/favicon.ico">
    <!-- Google Fonts
		============================================ -->
    <link href="static/css/googleapisfonts.css" rel="stylesheet">
    <!-- Bootstrap CSS
		============================================ -->
    <link rel="stylesheet" href="static/css/bootstrap.min.css">
    <!-- Bootstrap CSS
		============================================ -->
    <link rel="stylesheet" href="static/css/font-awesome.min.css">
    <!-- adminpro icon CSS
		============================================ -->
    <link rel="stylesheet" href="static/css/adminpro-custon-icon.css">
    <!-- meanmenu icon CSS
		============================================ -->
    <link rel="stylesheet" href="static/css/meanmenu.min.css">
    <!-- mCustomScrollbar CSS
		============================================ -->
    <link rel="stylesheet" href="static/css/jquery.mCustomScrollbar.min.css">
    <!-- animate CSS
		============================================ -->
    <link rel="stylesheet" href="static/css/animate.css">
    <!-- normalize CSS
		============================================ -->
    <link rel="stylesheet" href="static/css/data-table/bootstrap-table.css">
    <link rel="stylesheet" href="static/css/data-table/bootstrap-editable.css">
    <!-- normalize CSS
		============================================ -->
    <link rel="stylesheet" href="static/css/normalize.css">
    <!-- charts CSS
		============================================ -->
    <link rel="stylesheet" href="static/css/c3.min.css">
    <!-- form CSS
		============================================ -->
    <link rel="stylesheet" href="static/css/form.css">
    <!-- style CSS
		============================================ -->
    <link rel="stylesheet" href="static/css/style.css">
    <!-- responsive CSS
		============================================ -->
    <link rel="stylesheet" href="static/css/responsive.css">
    <!-- modernizr JS
		============================================ -->
    <script src="static/js/vendor/modernizr-2.8.3.min.js"></script>
</head>

<body class="darklayout">
<%
    Teachers t=(Teachers)request.getSession().getAttribute("teachers");
    if(t==null){
        response.sendRedirect("index.jsp");
    }else {
        session.setAttribute("teachers",t);
        UsersDao dao=new UsersDaoImpl();
        ArrayList<Colleges> col=new ArrayList<Colleges>(dao.findAllColleges());
        ArrayList<Majors> maj=new ArrayList<Majors>(dao.findAllMajors());
        ArrayList<Classes> cla=new ArrayList<Classes>(dao.findAllClasses());
        session.setAttribute("col",col);
        session.setAttribute("maj",maj);
        session.setAttribute("cla",cla);
%>
<!-- Header top area start-->
<div class="wrapper-pro">
    <div class="left-sidebar-pro">
        <nav id="sidebar">
            <div class="sidebar-header">
                <a href="#"><img src="static/img/message/1.jpg" alt="" />
                </a>
                <h3>${teachers.tname}</h3>
                <p>${teachers.trole}</p>
                <strong>AP+</strong>
            </div>
            <div class="left-custom-menu-adp-wrap">
                <ul class="nav navbar-nav left-sidebar-menu-pro">
                    <li class="nav-item">
                        <a href="#" data-toggle="dropdown" role="button" aria-expanded="false" class="nav-link dropdown-toggle"><i class="fa big-icon fa-home"></i> <span class="mini-dn">主页</span> <span class="indicator-right-menu mini-dn"><i class="fa indicator-mn fa-angle-left"></i></span></a>
                        <div role="menu" class="dropdown-menu left-menu-dropdown animated flipInX">
                            <a href="SaMain" class="dropdown-item">我的主页</a>
                        </div>
                    </li>
                    <%
                        if(t.getTrole().equals("系统管理员")){
                    %>
                    <li class="nav-item"><a href="#" data-toggle="dropdown" role="button" aria-expanded="false" class="nav-link dropdown-toggle"><i class="fa big-icon fa-envelope"></i> <span class="mini-dn">管理</span> <span class="indicator-right-menu mini-dn"><i class="fa indicator-mn fa-angle-left"></i></span></a>
                        <div role="menu" class="dropdown-menu left-menu-dropdown animated flipInX">
                            <a href="ShowAllColleges" class="dropdown-item">学院管理</a>
                            <a href="ShowAllMajors" class="dropdown-item">专业管理</a>
                            <a href="ShowAllClasses" class="dropdown-item">班级管理</a>
                            <a href="ShowAllStudents" class="dropdown-item">学生管理</a>
                            <a href="ShowAllTeachers" class="dropdown-item">教师管理</a>
                        </div>
                    </li>
                    <%
                    }else {
                    %>
                    <li class="nav-item"><a href="#" data-toggle="dropdown" role="button" aria-expanded="false" class="nav-link dropdown-toggle"><i class="fa big-icon fa-envelope"></i> <span class="mini-dn">查看</span> <span class="indicator-right-menu mini-dn"><i class="fa indicator-mn fa-angle-left"></i></span></a>
                        <div role="menu" class="dropdown-menu left-menu-dropdown animated flipInX">
                            <a href="ShowAllColleges" class="dropdown-item">学院信息查看</a>
                            <a href="ShowAllMajors" class="dropdown-item">专业信息查看</a>
                            <a href="ShowAllClasses" class="dropdown-item">班级信息查看</a>
                            <a href="ShowAllStudents" class="dropdown-item">学生信息查看</a>
                            <a href="ShowAllTeachers" class="dropdown-item">教师信息查看</a>
                        </div>
                    </li>
                    <%
                        }
                    %>
                    <li class="nav-item"><a href="#" data-toggle="dropdown" role="button" aria-expanded="false" class="nav-link dropdown-toggle"><i class="fa big-icon fa-flask"></i> <span class="mini-dn">统计</span> <span class="indicator-right-menu mini-dn"><i class="fa indicator-mn fa-angle-left"></i></span></a>
                        <div role="menu" class="dropdown-menu left-menu-dropdown animated flipInX">
                            <a href="StuAllReportsSituation" class="dropdown-item">学生每日一报情况</a>
                            <a href="TeaAllReportsSituation" class="dropdown-item">教师每日一报情况</a>
                            <a href="StuAllHealthCodes" class="dropdown-item">学生健康码统计</a>
                            <a href="TeaAllHealthCodes" class="dropdown-item">教师健康码统计</a>
                        </div>
                    </li>
                </ul>
            </div>
        </nav>
    </div>
    <!-- Header top area start-->
    <div class="content-inner-all">
        <div class="header-top-area">
            <div class="fixed-header-top">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-1 col-md-6 col-sm-6 col-xs-12">
                            <button type="button" id="sidebarCollapse" class="btn bar-button-pro header-drl-controller-btn btn-info navbar-btn">
                                <i class="fa fa-bars"></i>
                            </button>
                            <div class="admin-logo logo-wrap-pro">
                                <a href="#"><img src="static/img/logo/log.png" alt="" />
                                </a>
                            </div>
                        </div>
                        <div class="col-lg-5 col-md-5 col-sm-6 col-xs-12" style="position:absolute;right: 200px;">
                            <div class="header-right-info">
                                <ul class="nav navbar-nav mai-top-nav header-right-menu">
                                    <li class="nav-item">
                                        <a href="#" data-toggle="dropdown" role="button" aria-expanded="false" class="nav-link dropdown-toggle">
                                            <span class="adminpro-icon adminpro-user-rounded header-riht-inf"></span>
                                            <span class="admin-name">${teachers.tname}</span>
                                            <span class="author-project-icon adminpro-icon adminpro-down-arrow"></span>
                                        </a>
                                        <ul role="menu" class="dropdown-header-top author-log dropdown-menu animated flipInX">
                                            <li><a href="index.jsp"><span class="adminpro-icon adminpro-locked author-log-ic"></span>退出登录</a>
                                            </li>
                                        </ul>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Header top area end-->
        <!-- Breadcome start-->
        <div class="breadcome-area mg-b-30 small-dn">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="breadcome-list shadow-reset">
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="breadcome-heading">
                                        <h2>欢迎使用寰宇师生健康码管理系统</h2>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Breadcome End-->
        <!-- Mobile Menu start -->
        <div class="mobile-menu-area">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <div class="mobile-menu">
                            <nav id="dropdown">
                                <ul class="mobile-menu-nav">
                                    <li><a data-toggle="collapse" data-target="#Charts" href="#">主页 <span class="admin-project-icon adminpro-icon adminpro-down-arrow"></span></a>
                                        <ul class="collapse dropdown-header-top">
                                            <li><a href="SaMain">我的主页</a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li><a data-toggle="collapse" data-target="#demo" href="#">统计 <span class="admin-project-icon adminpro-icon adminpro-down-arrow"></span></a>
                                        <ul id="demo" class="collapse dropdown-header-top">
                                            <li><a href="ShowAllColleges">学院管理</a>
                                            </li>
                                            <li><a href="ShowAllMajors">专业管理</a>
                                            </li>
                                            <li><a href="ShowAllClasses">班级管理</a>
                                            </li>
                                            <li><a href="ShowAllStudents">学生管理</a>
                                            </li>
                                            <li><a href="ShowAllTeachers">教师管理</a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li><a data-toggle="collapse" data-target="#others" href="#">查询 <span class="admin-project-icon adminpro-icon adminpro-down-arrow"></span></a>
                                        <ul id="others" class="collapse dropdown-header-top">
                                            <li><a href="StuAllReportsSituation">学生每日一报情况</a>
                                            </li>
                                            <li><a href="TeaAllReportsSituation">教师每日一报情况</a>
                                            </li>
                                            <li><a href="StuAllHealthCodes">学生健康码统计</a>
                                            </li>
                                            <li><a href="TeaAllHealthCodes">教师健康码统计</a>
                                            </li>
                                        </ul>
                                    </li>
                                </ul>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Mobile Menu end -->
        <!-- Breadcome start-->
        <div class="breadcome-area mg-b-30 des-none">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <div class="breadcome-list map-mg-t-40-gl shadow-reset">
                            <div class="row">
                                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                                    <div class="breadcome-heading">
                                        <h2>Thanks for Visits</h2>
                                    </div>
                                </div>
                                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                                    <ul class="breadcome-menu">
                                        <li><a href="#">Home</a> <span class="bread-slash">/</span>
                                        </li>
                                        <li><span class="bread-blod">Dashboard</span>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Breadcome End-->
        <!-- stockprice, feed area end-->
        <div class="admin-dashone-data-table-area mg-b-15">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="sparkline8-list shadow-reset">
                            <div class="sparkline8-hd">
                                <div class="main-sparkline8-hd">
                                    <%
                                        if(t.getTrole().equals("系统管理员")){
                                    %>
                                    <h1>专业管理</h1>
                                    <%
                                    }else {
                                    %>
                                    <h1>专业信息查看</h1>
                                    <%
                                        }
                                    %>
                                    <div class="sparkline8-outline-icon">
                                        <span class="sparkline8-collapse-link"><i class="fa fa-chevron-up"></i></span>
                                        <span><i class="fa fa-wrench"></i></span>
                                        <span class="sparkline8-collapse-close"><i class="fa fa-times"></i></span>
                                    </div>
                                </div>
                            </div>
                            <div class="sparkline8-graph">
                                <div class="datatable-dashv1-list custom-datatable-overright">
                                    <div>
                                        <form action="FuzzyQueryMajor?tno=${teachers.tno}" method="post" style="position:relative;float:left;">
                                            <span style="color: #fff">请输入专业名、编号、系主任名字或学院名（支持模糊查询）：</span>
                                            <input type="text" name="name" size="15">
                                            <input type="submit" class="btn btn-primary btn-sm" style="border-radius: 5px;width: 80px;" value="确定">
                                        </form>
                                    </div>
                                    <br>
                                    <br>
                                    <br>
                                    <%
                                        String role=t.getTrole();
                                        if(role.equals("系统管理员")){
                                    %>
                                    <div>
                                        <form action="ImportExcelMajors?tno=${teachers.tno}" method="post" enctype="multipart/form-data" style="position: relative;">
                                            <span style="color: #fff;position: relative;float:left;">Excel导入：</span>
                                            <input id="excelFile" name="excelFile" class="file-loading" type="file" multiple accept=".xls,.xlsx" style="background: white;display: inline;position: relative;left: -350px;">
                                            <input type="submit" class="btn btn-primary btn-sm" style="border-radius: 5px;width: 80px;position: relative;left: -350px;" value="确定">
                                        </form>
                                    </div>
                                    <br>
                                    <%
                                        }
                                    %>
                                    <div id="toolbar">
                                        <select class="form-control">
                                            <option value="">Export Basic</option>
                                            <option value="all">Export All</option>
                                            <option value="selected">Export Selected</option>
                                        </select>
                                    </div>
                                    <%
                                        if(role.equals("系统管理员")){
                                    %>
                                    <span style="position:relative;right: -110px">
                                            <a href="addMajor.jsp?tno=${teachers.tno}" title="Add major"><i style="position:relative;height: 32px;left: 215px;top: 33px;right: -2.5px;background: #303030;border: 5px solid #303030;color:#fff;padding-top: 3px;" class="fa fa-user-plus fa-lg"></i></a>
                                    </span>
                                    <%
                                        }
                                    %>
                                    <table id="table" data-toggle="table" data-pagination="true" data-show-columns="true" data-show-pagination-switch="true" data-show-refresh="true" data-key-events="true" data-show-toggle="true" data-resizable="true" data-cookie="true" data-cookie-id-table="saveId" data-show-export="true" data-click-to-select="true" data-toolbar="#toolbar">
                                        <thead>
                                        <tr>
                                            <th data-field="state" data-checkbox="true"></th>
                                            <th data-field="majorname" data-editable="true">专业名</th>
                                            <th data-field="id" data-editable="true">专业编号</th>
                                            <th data-field="company" data-editable="true">系主任</th>
                                            <th data-field="name" data-editable="true">学院</th>
                                            <%
                                                if(role.equals("系统管理员")){
                                            %>
                                            <th data-field="action">操作</th>
                                            <%
                                                }
                                            %>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="majors" items="${sessionScope.majors}" varStatus="status">
                                            <tr>
                                                <td></td>
                                                <td>${majors.name}</td>
                                                <td>${majors.no}</td>
                                                <td>${majors.dean}</td>
                                                <td>${majors.college}</td>
                                                <%
                                                    if(role.equals("系统管理员")){
                                                %>
                                                <td>
                                                    <div class="btn-group project-list-action">
                                                        <a href="MajorChange?majorsno=${majors.no}&teacherno=${teachers.tno}"><button class="btn btn-white btn-action btn-xs"><i class="fa fa-folder"></i> 修改</button></a>
                                                        <a href="DeleteMajor?majorsno=${majors.no}&teacherno=${teachers.tno}"><button class="btn btn-white btn-xs"><i class="fa fa-pencil"></i> 删除</button></a>
                                                    </div>
                                                </td>
                                                <%
                                                    }
                                                %>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Footer Start-->
<div class="footer-copyright-area">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <div class="footer-copy-right">
                    <p>Copyright &#169; 2021 Colorlib All rights reserved. 寰宇师生健康码管理系统.</p>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Footer End-->
<!-- jquery
    ============================================ -->
<script src="static/js/vendor/jquery-1.11.3.min.js"></script>
<!-- bootstrap JS
    ============================================ -->
<script src="static/js/bootstrap.min.js"></script>
<!-- meanmenu JS
    ============================================ -->
<script src="static/js/jquery.meanmenu.js"></script>
<!-- mCustomScrollbar JS
    ============================================ -->
<script src="static/js/jquery.mCustomScrollbar.concat.min.js"></script>
<!-- sticky JS
    ============================================ -->
<script src="static/js/jquery.sticky.js"></script>
<!-- scrollUp JS
    ============================================ -->
<script src="static/js/jquery.scrollUp.min.js"></script>
<!-- counterup JS
    ============================================ -->
<script src="static/js/counterup/jquery.counterup.min.js"></script>
<script src="static/js/counterup/waypoints.min.js"></script>
<!-- peity JS
    ============================================ -->
<script src="static/js/peity/jquery.peity.min.js"></script>
<script src="static/js/peity/peity-active.js"></script>
<!-- sparkline JS
    ============================================ -->
<script src="static/js/sparkline/jquery.sparkline.min.js"></script>
<script src="static/js/sparkline/sparkline-active.js"></script>
<!-- data table JS
    ============================================ -->
<script src="static/js/data-table/bootstrap-table.js"></script>
<script src="static/js/data-table/tableExport.js"></script>
<script src="static/js/data-table/data-table-active.js"></script>
<script src="static/js/data-table/bootstrap-table-editable.js"></script>
<script src="static/js/data-table/bootstrap-editable.js"></script>
<script src="static/js/data-table/bootstrap-table-resizable.js"></script>
<script src="static/js/data-table/colResizable-1.5.source.js"></script>
<script src="static/js/data-table/bootstrap-table-export.js"></script>
<!-- main JS
    ============================================ -->
<script src="static/js/main.js"></script>
</body>

</html>
<%
    }
%>