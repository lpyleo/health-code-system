<%@ page import="com.dao.UsersDao" %>
<%@ page import="com.dao.UsersDaoImpl" %>
<%@ page import="com.dao.DaoException" %>
<%@ page import="com.model.users.Students" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html class="no-js" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>每日一报</title>
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
    <script language="JavaScript" type="text/javascript">
        function custCheck() {
            var name = document.getElementById("name");
            var idcard = document.getElementById("idnumber");
            var stuid = document.getElementById("no");
            var phone = document.getElementById("phone");
            var no1 = document.getElementById("no1");
            var yes1 = document.getElementById("yes1");
            var no2 = document.getElementById("no2");
            var yes2 = document.getElementById("yes2");
            var no3 = document.getElementById("no3");
            var yes3 = document.getElementById("yes3");
            var no4 = document.getElementById("no4");
            var yes4 = document.getElementById("yes4");
            var no5 = document.getElementById("no5");
            var yes5 = document.getElementById("yes5");
            var good = document.getElementById("good");
            var fever = document.getElementById("fever");
            var weakness = document.getElementById("weakness");
            var rincon = document.getElementById("rincon");
            var runny_nose = document.getElementById("runny_nose");
            var pharyngeal = document.getElementById("pharyngeal");
            var hose = document.getElementById("hose");
            var diarrhea = document.getElementById("diarrhea");
            var agree = document.getElementById("agree");
            if (name.value=="" || idcard.value=="" || stuid.value=="" || phone.value=="") {
                alert("有必填项未填!");
                return false;
            }
            else if (!no1.checked && !yes1.checked) {
                alert("有必选项未选!");
                return false;
            }
            else if (!no2.checked && !yes2.checked) {
                alert("有必选项未选!");
                return false;
            }
            else if (!no3.checked && !yes3.checked) {
                alert("有必选项未选!");
                return false;
            }
            else if (!no4.checked && !yes4.checked) {
                alert("有必选项未选!");
                return false;
            }
            else if (!no5.checked && !yes5.checked) {
                alert("有必选项未选!");
                return false;
            }
            else if (!good.checked && !fever.checked && !weakness.checked && !rincon.checked && !runny_nose.checked
                && !pharyngeal.checked && !hose.checked && !diarrhea.checked) {
                alert("有必选项未选!");
                return false;
            }
            else if (!agree.checked) {
                alert("有必选项未选!");
                return false;
            }
        }
    </script>
</head>

<body class="darklayout">
<%
    Students students=(Students) request.getSession().getAttribute("students");
    if(students==null){
        response.sendRedirect("index.jsp");
    }else {
        UsersDao dao = new UsersDaoImpl();
        try {
            students = dao.findStudentsByNo(students.getSno());
        } catch (DaoException e) {
            e.printStackTrace();
        }
        session.setAttribute("students", students);
    }
%>
<!-- Header top area start-->
<div class="wrapper-pro">
    <div class="left-sidebar-pro">
        <nav id="sidebar">
            <div class="sidebar-header">
                <a href="#"><img src="static/img/message/1.jpg" alt="" />
                </a>
                <h3>${students.sname}</h3>
                <p>学生</p>
                <strong>AP+</strong>
            </div>
            <div class="left-custom-menu-adp-wrap">
                <ul class="nav navbar-nav left-sidebar-menu-pro">
                    <li class="nav-item">
                        <a href="#" data-toggle="dropdown" role="button" aria-expanded="false" class="nav-link dropdown-toggle"><i class="fa big-icon fa-home"></i> <span class="mini-dn">主页</span> <span class="indicator-right-menu mini-dn"><i class="fa indicator-mn fa-angle-left"></i></span></a>
                        <div role="menu" class="dropdown-menu left-menu-dropdown animated flipInX">
                            <a href="StuMain" class="dropdown-item">我的主页</a>
                        </div>
                    </li>
                    <li class="nav-item"><a href="#" data-toggle="dropdown" role="button" aria-expanded="false" class="nav-link dropdown-toggle"><i class="fa big-icon fa-envelope"></i> <span class="mini-dn">健康码申领</span> <span class="indicator-right-menu mini-dn"><i class="fa indicator-mn fa-angle-left"></i></span></a>
                        <div role="menu" class="dropdown-menu left-menu-dropdown animated flipInX">
                            <a href="stuDailyReport.jsp" class="dropdown-item">每日一报</a>
                            <a href="StuHealthCodeCollection" class="dropdown-item">健康码领取</a>
                        </div>
                    </li>
                    <li class="nav-item"><a href="#" data-toggle="dropdown" role="button" aria-expanded="false" class="nav-link dropdown-toggle"><i class="fa big-icon fa-flask"></i> <span class="mini-dn">查询</span> <span class="indicator-right-menu mini-dn"><i class="fa indicator-mn fa-angle-left"></i></span></a>
                        <div role="menu" class="dropdown-menu left-menu-dropdown animated flipInX">
                            <a href="StuReportsSituation" class="dropdown-item">每日一报情况查询</a>
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
                                            <span class="admin-name">${students.sname}</span>
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
                                            <li><a href="StuMain">我的主页</a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li><a data-toggle="collapse" data-target="#demo" href="#">健康码申领 <span class="admin-project-icon adminpro-icon adminpro-down-arrow"></span></a>
                                        <ul id="demo" class="collapse dropdown-header-top">
                                            <li><a href="stuDailyReport.jsp">每日一报</a>
                                            </li>
                                            <li><a href="StuHealthCodeCollection">健康码领取</a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li><a data-toggle="collapse" data-target="#others" href="#">查询 <span class="admin-project-icon adminpro-icon adminpro-down-arrow"></span></a>
                                        <ul id="others" class="collapse dropdown-header-top">
                                            <li><a href="StuReportsSituation">每日一报情况查询</a>
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
        <!-- change Start-->
        <div class="login-form-area mg-t-30 mg-b-40">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-4"></div>
                    <form id="adminpro-form" class="adminpro-form" action="StudentHealthCode" method="post" onsubmit="return custCheck()">
                        <div class="col-lg-5">
                            <div class="login-bg">
                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="login-title" style="text-align: center">
                                            <h1>每日一报</h1>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="login-input-head">
                                            <p>姓名</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="login-input-area">
                                            <input type="text" name="name" id="name" value="${students.sname}" readonly>
                                            <i class="fa fa-lock login-user" aria-hidden="true"></i>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="login-input-head">
                                            <p>身份证号</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="login-input-area">
                                            <input type="text" name="idnumber" id="idnumber" value="${students.sidnumber}" readonly>
                                            <i class="fa fa-lock login-user"></i>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="login-input-head">
                                            <p>学号</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="login-input-area">
                                            <input type="text" name="no" id="no" value="${students.sno}" readonly>
                                            <i class="fa fa-lock login-user"></i>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="login-input-head">
                                            <p>手机号</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="login-input-area">
                                            <input type="text" name="phone" id="phone">
                                            <i class="fa fa-lock login-user"></i>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="login-input-head">
                                            <p>本人近期（14天内）是否去过重点疫区？</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="login-input-head">
                                            <span style="position: absolute;top: -10px;border: 1px solid #0099ff;border-radius: 5px;width: 28px;font-size: xx-small;color: #0099ff">单选</span>
                                        </div>
                                    </div>
                                </div>
                                <br>
                                <div class="row">
                                    <div class="col-lg-6">
                                        <div class="login-input-head">
                                            <input type="radio" name="select1" id="no1" value="否"><font color="white">&nbsp;否</font><br>
                                        </div>
                                    </div>
                                    <div class="col-lg-6">
                                        <div class="login-input-head">
                                            <input type="radio" name="select1" id="yes1" value="是"><font color="white">&nbsp;是</font><br>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="login-input-head">
                                            <p>本人近期（14天内）是否去过国外？</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="login-input-head">
                                            <span style="position: absolute;top: -10px;border: 1px solid #0099ff;border-radius: 5px;width: 28px;font-size: xx-small;color: #0099ff">单选</span>
                                        </div>
                                    </div>
                                </div>
                                <br>
                                <div class="row">
                                    <div class="col-lg-6">
                                        <div class="login-input-head">
                                            <input type="radio" name="select2" id="no2" value="否"><font color="white">&nbsp;否</font><br>
                                        </div>
                                    </div>
                                    <div class="col-lg-6">
                                        <div class="login-input-head">
                                            <input type="radio" name="select2" id="yes2" value="是"><font color="white">&nbsp;是</font><br>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="login-input-head">
                                            <p>本人近期（14天内）是否接触过新冠确诊病人或疑似病人？</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="login-input-head">
                                            <span style="position: absolute;top: -10px;border: 1px solid #0099ff;border-radius: 5px;width: 28px;font-size: xx-small;color: #0099ff">单选</span>
                                        </div>
                                    </div>
                                </div>
                                <br>
                                <div class="row">
                                    <div class="col-lg-6">
                                        <div class="login-input-head">
                                            <input type="radio" name="select3" id="no3" value="否"><font color="white">&nbsp;否</font><br>
                                        </div>
                                    </div>
                                    <div class="col-lg-6">
                                        <div class="login-input-head">
                                            <input type="radio" name="select3" id="yes3" value="是"><font color="white">&nbsp;是</font><br>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="login-input-head">
                                            <p>本人是否被卫生部门确认为新冠肺炎确诊病例或疑似病例？</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="login-input-head">
                                            <span style="position: absolute;top: -10px;border: 1px solid #0099ff;border-radius: 5px;width: 28px;font-size: xx-small;color: #0099ff">单选</span>
                                        </div>
                                    </div>
                                </div>
                                <br>
                                <div class="row">
                                    <div class="col-lg-6">
                                        <div class="login-input-head">
                                            <input type="radio" name="select4" id="no4" value="否"><font color="white">&nbsp;否</font><br>
                                        </div>
                                    </div>
                                    <div class="col-lg-6">
                                        <div class="login-input-head">
                                            <input type="radio" name="select4" id="yes4" value="是"><font color="white">&nbsp;是</font><br>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="login-input-head">
                                            <p>是否接种疫苗？</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="login-input-head">
                                            <span style="position: absolute;top: -10px;border: 1px solid #0099ff;border-radius: 5px;width: 28px;font-size: xx-small;color: #0099ff">单选</span>
                                        </div>
                                    </div>
                                </div>
                                <br>
                                <div class="row">
                                    <div class="col-lg-6">
                                        <div class="login-input-head">
                                            <input type="radio" name="select5" id="no5" value="否"><font color="white">&nbsp;否</font><br>
                                        </div>
                                    </div>
                                    <div class="col-lg-6">
                                        <div class="login-input-head">
                                            <input type="radio" name="select5" id="yes5" value="是"><font color="white">&nbsp;是</font><br>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="login-input-head">
                                            <p>当前健康状况（若有以下状况，请在方框内勾选）</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="login-input-head">
                                            <span style="position: absolute;top: -10px;border: 1px solid #0099ff;border-radius: 5px;width: 28px;font-size: xx-small;color: #0099ff">多选</span>
                                        </div>
                                    </div>
                                </div>
                                <br>
                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="login-input-head">
                                            <input type="checkbox" value="good" id="good" name="choose">&nbsp;<font color="white">无异常</font>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="login-input-head">
                                            <input type="checkbox" value="fever" id="fever" name="choose">&nbsp;<font color="white">发烧（≥37.3℃）</font>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="login-input-head">
                                            <input type="checkbox" value="weakness" id="weakness" name="choose">&nbsp;<font color="white">乏力</font>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="login-input-head">
                                            <input type="checkbox" value="hose" id="hose" name="choose">&nbsp;<font color="white">干咳</font>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="login-input-head">
                                            <input type="checkbox" value="rincon" id="rincon" name="choose">&nbsp;<font color="white">鼻塞</font>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="login-input-head">
                                            <input type="checkbox" value="runny_nose" id="runny_nose" name="choose">&nbsp;<font color="white">流涕</font>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="login-input-head">
                                            <input type="checkbox" value="pharyngeal" id="pharyngeal" name="choose">&nbsp;<font color="white">咽痛</font>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="login-input-head">
                                            <input type="checkbox" value="diarrhea" id="diarrhea" name="choose">&nbsp;<font color="white">腹泻</font>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="login-input-head">
                                            <p>本人郑重承诺：</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="login-input-head">
                                            <input type="checkbox" value="" id="agree">&nbsp;&nbsp;<font color="white">填写信息真实，愿意承担相应的法律责任。</font>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="login-button-pro" style="position:relative;left: 60px;">
                                            <button type="submit" class="login-button login-button-lg" style="width: 150px;">确定</button>
                                            <button type="reset" class="login-button login-button-lg" style="width: 150px;">重置</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                    <div class="col-lg-4"></div>
                </div>
            </div>
        </div>
        <!-- change End-->
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

