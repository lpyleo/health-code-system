<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
  <meta http-equiv="refresh" content="5;url=index.jsp">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>登录失败</title>
  <link rel="stylesheet" href="static/lib/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="static/lib/particles/css/style.css">
  <script src="static/lib/jQuery/jquery.min.js"></script>
  <script src="static/lib/bootstrap/js/bootstrap.min.js"></script>
  <style>
    p{
      text-align: center;
      font-size: 20px;
    }
    .container{
      position: relative;
      width: 350px;
      font-size: 12px;
      line-height: 50px;
      border: 1px solid #dbdbdb;
      border-radius: 10px;
      top: 200px;
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
    #btn{
      position: relative;
      width: 300px;
      left: 10px;
    }
  </style>
  <script type="text/javascript">
    window.onload=function () {
      var t=setInterval(fun1,1000);
    }
    //倒计时显示
    var s=5;
    function fun1(){
      s--;
      document.getElementById("btn").value="返回（"+s+"）";
    }
  </script>
</head>
<body>
<div id="particles-js"></div>
<div class="container">
  <div align="center">
    <img src="static/images/logo.png" alt="寰宇">
  </div>
  <p>信息输入错误，登录失败！</p>
  <a href="index.jsp"><input type="button" class="btn btn-primary" id="btn" value="返回（5）"></a>
</div>
<script src="static/lib/particles/particles.min.js"></script>
<script src="static/lib/particles/js/app.js"></script>
</body>
</html>

