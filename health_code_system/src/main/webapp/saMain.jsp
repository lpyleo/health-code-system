<%@ page import="com.model.users.Teachers" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html class="no-js" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>系统管理员主页</title>
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
    <!-- style CSS
		============================================ -->
    <link rel="stylesheet" href="static/css/style.css">
    <!-- responsive CSS
		============================================ -->
    <link rel="stylesheet" href="static/css/responsive.css">
    <!-- modernizr JS
		============================================ -->
    <script src="static/js/vendor/modernizr-2.8.3.min.js"></script>
    <script src="static/js/echarts.min.js"></script>
</head>

<body class="darklayout">
<%
    Teachers teachers=(Teachers) request.getSession().getAttribute("teachers");
    if(teachers==null){
        response.sendRedirect("index.jsp");
    }else{
    session.setAttribute("teachers",teachers);
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
                        if(teachers.getTrole().equals("系统管理员")){
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
                                    <li><a data-toggle="collapse" data-target="#demo" href="#">管理 <span class="admin-project-icon adminpro-icon adminpro-down-arrow"></span></a>
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
                                    <li><a data-toggle="collapse" data-target="#others" href="#">统计 <span class="admin-project-icon adminpro-icon adminpro-down-arrow"></span></a>
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
                                    <h1>教师打卡完成率</h1>
                                    <div class="sparkline8-outline-icon">
                                        <span class="sparkline8-collapse-link"><i class="fa fa-chevron-up"></i></span>
                                        <span><i class="fa fa-wrench"></i></span>
                                        <span class="sparkline8-collapse-close"><i class="fa fa-times"></i></span>
                                    </div>
                                </div>
                            </div>
                            <div class="sparkline8-graph">
                                <div class="datatable-dashv1-list custom-datatable-overright">
                                    <div class="form-group data-custon-pick data-custom-mg" id="data_5">
                                        <label>请选择查询时间：</label>
                                        <form action="SaMain" method="post">
                                            <div class="input-daterange input-group" id="datepicker1">
                                                <input type="text" class="form-control" id="start1" name="start1" style="width: 200px;" readonly>
                                                <button type="submit" class="btn btn-primary" style="border-radius: 5px;width: 80px;">查询</button>
                                            </div>
                                        </form>
                                    </div>
                                    <br>
                                    <br>
                                    <br>
                                    <div id="main1" style="height: 400px;"></div>
                                    <script type="text/javascript">
                                        var chartDom=document.getElementById("main1");
                                        var myChart=echarts.init(chartDom);
                                        var option;
                                        var tdaka="<%=session.getAttribute("tdaka")%>";
                                        var tnodaka="<%=session.getAttribute("tnodaka")%>";
                                        option = {
                                            title: {
                                                text: '教师打卡完成率',
                                                left: 'center',
                                                textStyle: {
                                                    color: '#ffffff'
                                                }
                                            },
                                            tooltip: {
                                                trigger: 'item',
                                                formatter: '{a} <br/>{b} : {c} ({d}%)'
                                            },
                                            legend: {
                                                orient: 'vertical',
                                                left: 200,
                                                data: ['已打卡', '未打卡'],
                                                textStyle: {
                                                    color: '#ffffff'
                                                }
                                            },
                                            series: [
                                                {
                                                    name: '教师打卡完成率',
                                                    type: 'pie',
                                                    center: ['50%', '50%'],
                                                    selectedMode: 'multiple',
                                                    data: [
                                                        {value: tdaka, name: '已打卡'},
                                                        {value: tnodaka, name: '未打卡'},
                                                    ],
                                                    emphasis: {
                                                        itemStyle: {
                                                            shadowBlur: 10,
                                                            shadowOffsetX: 0,
                                                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                                                        }
                                                    }
                                                }
                                            ]
                                        };
                                        option && myChart.setOption(option);
                                    </script>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- stockprice, feed area end-->
        <div class="admin-dashone-data-table-area mg-b-15">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="sparkline8-list shadow-reset">
                            <div class="sparkline8-hd">
                                <div class="main-sparkline8-hd">
                                    <h1>教师打卡情况</h1>
                                    <div class="sparkline8-outline-icon">
                                        <span class="sparkline8-collapse-link"><i class="fa fa-chevron-up"></i></span>
                                        <span><i class="fa fa-wrench"></i></span>
                                        <span class="sparkline8-collapse-close"><i class="fa fa-times"></i></span>
                                    </div>
                                </div>
                            </div>
                            <div class="sparkline8-graph">
                                <div class="datatable-dashv1-list custom-datatable-overright">
                                    <div id="main2" style="height: 400px;width: 500px;position: relative;left: 300px;"></div>
                                    <script type="text/javascript">
                                        var chartDom=document.getElementById("main2");
                                        var myChart=echarts.init(chartDom);
                                        var option;
                                        var tgold="<%=session.getAttribute("tgold")%>";
                                        var tgreen="<%=session.getAttribute("tgreen")%>";
                                        var tyellow="<%=session.getAttribute("tyellow")%>";
                                        var tred="<%=session.getAttribute("tred")%>";
                                        option = {
                                            title: {
                                                text: '教师打卡情况',
                                                left: 'center',
                                                textStyle: {
                                                    color: '#ffffff'
                                                }
                                            },
                                            tooltip: {
                                                trigger: 'axis',
                                                axisPointer: {            // 坐标轴指示器，坐标轴触发有效
                                                    type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                                                }
                                            },
                                            grid: {
                                                left: '3%',
                                                right: '4%',
                                                bottom: '3%',
                                                containLabel: true
                                            },
                                            xAxis: [
                                                {
                                                    type: 'category',
                                                    data: ['gold', 'green', 'yellow', 'red'],
                                                    axisTick: {
                                                        alignWithLabel: true
                                                    },
                                                    axisLine:{
                                                        lineStyle:{
                                                            color:'#ffffff',
                                                            width:1
                                                        }
                                                    }
                                                }
                                            ],
                                            yAxis: [
                                                {
                                                    type: 'value',
                                                    axisLine:{
                                                        lineStyle:{
                                                            color:'#ffffff',
                                                            width:1
                                                        }
                                                    }
                                                }
                                            ],
                                            series: [
                                                {
                                                    name: '教师打卡情况',
                                                    type: 'bar',
                                                    barWidth: '60%',
                                                    data: [tgold, tgreen, tyellow, tred]
                                                }
                                            ]
                                        };
                                        option && myChart.setOption(option);
                                    </script>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- stockprice, feed area end-->
        <div class="admin-dashone-data-table-area mg-b-15">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="sparkline8-list shadow-reset">
                            <div class="sparkline8-hd">
                                <div class="main-sparkline8-hd">
                                    <h1>学生打卡完成率</h1>
                                    <div class="sparkline8-outline-icon">
                                        <span class="sparkline8-collapse-link"><i class="fa fa-chevron-up"></i></span>
                                        <span><i class="fa fa-wrench"></i></span>
                                        <span class="sparkline8-collapse-close"><i class="fa fa-times"></i></span>
                                    </div>
                                </div>
                            </div>
                            <div class="sparkline8-graph">
                                <div class="datatable-dashv1-list custom-datatable-overright">
                                    <div id="main3" style="height: 400px;"></div>
                                    <script type="text/javascript">
                                        var chartDom=document.getElementById("main3");
                                        var myChart=echarts.init(chartDom);
                                        var option;
                                        var sdaka="<%=session.getAttribute("sdaka")%>";
                                        var snodaka="<%=session.getAttribute("snodaka")%>";
                                        option = {
                                            title: {
                                                text: '学生打卡完成率',
                                                left: 'center',
                                                textStyle: {
                                                    color: '#ffffff'
                                                }
                                            },
                                            tooltip: {
                                                trigger: 'item',
                                                formatter: '{a} <br/>{b} : {c} ({d}%)'
                                            },
                                            legend: {
                                                orient: 'vertical',
                                                left: 200,
                                                data: ['已打卡', '未打卡'],
                                                textStyle: {
                                                    color: '#ffffff'
                                                }
                                            },
                                            series: [
                                                {
                                                    name: '学生打卡完成率',
                                                    type: 'pie',
                                                    center: ['50%', '50%'],
                                                    selectedMode: 'multiple',
                                                    data: [
                                                        {value: sdaka, name: '已打卡'},
                                                        {value: snodaka, name: '未打卡'},
                                                    ],
                                                    emphasis: {
                                                        itemStyle: {
                                                            shadowBlur: 10,
                                                            shadowOffsetX: 0,
                                                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                                                        }
                                                    }
                                                }
                                            ]
                                        };
                                        option && myChart.setOption(option);
                                    </script>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- stockprice, feed area end-->
        <div class="admin-dashone-data-table-area mg-b-15">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="sparkline8-list shadow-reset">
                            <div class="sparkline8-hd">
                                <div class="main-sparkline8-hd">
                                    <h1>学生打卡情况</h1>
                                    <div class="sparkline8-outline-icon">
                                        <span class="sparkline8-collapse-link"><i class="fa fa-chevron-up"></i></span>
                                        <span><i class="fa fa-wrench"></i></span>
                                        <span class="sparkline8-collapse-close"><i class="fa fa-times"></i></span>
                                    </div>
                                </div>
                            </div>
                            <div class="sparkline8-graph">
                                <div class="datatable-dashv1-list custom-datatable-overright">
                                    <div id="main4" style="height: 400px;width: 500px;position: relative;left: 300px;"></div>
                                    <script type="text/javascript">
                                        var chartDom=document.getElementById("main4");
                                        var myChart=echarts.init(chartDom);
                                        var option;
                                        var sgold="<%=session.getAttribute("sgold")%>";
                                        var sgreen="<%=session.getAttribute("sgreen")%>";
                                        var syellow="<%=session.getAttribute("syellow")%>";
                                        var sred="<%=session.getAttribute("sred")%>";
                                        option = {
                                            title: {
                                                text: '学生打卡情况',
                                                left: 'center',
                                                textStyle: {
                                                    color: '#ffffff'
                                                }
                                            },
                                            tooltip: {
                                                trigger: 'axis',
                                                axisPointer: {            // 坐标轴指示器，坐标轴触发有效
                                                    type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                                                }
                                            },
                                            grid: {
                                                left: '3%',
                                                right: '4%',
                                                bottom: '3%',
                                                containLabel: true
                                            },
                                            xAxis: [
                                                {
                                                    type: 'category',
                                                    data: ['gold', 'green', 'yellow', 'red'],
                                                    axisTick: {
                                                        alignWithLabel: true
                                                    },
                                                    axisLine:{
                                                        lineStyle:{
                                                            color:'#ffffff',
                                                            width:1
                                                        }
                                                    }
                                                }
                                            ],
                                            yAxis: [
                                                {
                                                    type: 'value',
                                                    axisLine:{
                                                        lineStyle:{
                                                            color:'#ffffff',
                                                            width:1
                                                        }
                                                    }
                                                }
                                            ],
                                            series: [
                                                {
                                                    name: '学生打卡情况',
                                                    type: 'bar',
                                                    barWidth: '60%',
                                                    data: [sgold, sgreen, syellow, sred]
                                                }
                                            ]
                                        };
                                        option && myChart.setOption(option);
                                    </script>
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
<!-- datapicker JS
       ============================================ -->
<script src="static/js/datapicker/bootstrap-datepicker.js"></script>
<script src="static/js/datapicker/datepicker-active.js"></script>
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