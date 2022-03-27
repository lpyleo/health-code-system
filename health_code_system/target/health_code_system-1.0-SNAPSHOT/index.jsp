<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>寰宇师生健康码管理系统</title>
    <link rel="stylesheet" href="static/lib/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="static/lib/particles/css/style.css">
    <script src="static/lib/jQuery/jquery.min.js"></script>
    <script src="static/lib/bootstrap/js/bootstrap.min.js"></script>
    <style>
        .container{
            position: relative;
            width: 350px;
            font-size: 12px;
            line-height: 50px;
            border: 1px solid #dbdbdb;
            border-radius: 10px;
            top: 50px;
            background-color: #dbdbdb;
            opacity: 0.7;
        }
        body{
            background-color: white;
            background-image: url("static/images/background.png");
            background-size: cover;
        }
        #particles-js {
            position: fixed;
            top: 0;
            left: 0;
        }
        button{
            width: 300px;
        }
    </style>
</head>
<body>
<div id="particles-js"></div>
<div class="container">
    <div align="center">
        <img src="static/images/logo.png" alt="寰宇">
        <h2 style="font-size: 20px;">寰宇师生健康码管理系统</h2>
    </div>
    <br>
    <div class="form-group"  align="center">
        <a href="systemAdministrator.jsp"><button type="button" class="btn btn-primary" id="btn1">系统管理员登录</button></a>
    </div>
    <div class="form-group"  align="center">
        <a href="schoolAdministrator.jsp"><button type="button" class="btn btn-primary" id="btn2">校级管理员登录</button></a>
    </div>
    <div class="form-group"  align="center">
        <a href="collegeAdministrator.jsp"><button type="button" class="btn btn-primary" id="btn3">院级管理员登录</button></a>
    </div>
    <div class="form-group"  align="center">
        <a href="studentsTeachers.jsp"><button type="button" class="btn btn-primary" id="btn4">教师/学生登录</button></a>
    </div>
</div>
<script src="static/lib/particles/particles.min.js"></script>
<script src="static/lib/particles/js/app.js"></script>
</body>
</html>