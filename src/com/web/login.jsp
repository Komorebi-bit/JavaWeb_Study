<%--
  Created by IntelliJ IDEA.
  User: Komorebi
  Date: 2022/4/4
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登录</title>
    <style>
        .mid{
            margin: auto;
            margin-top: 40px;
            border-radius: 10px;
            background-color: #F6F8FA;
            border: 1px solid #D0D7DE;
            width: 350px;
            height: 390px;
            padding-top: 16px;
            /*固定盒子大小*/
            box-sizing: border-box;
        }
        .btn_left{
            background-color: #2DA44E;
            color: #FFFFFF;
            margin-top: 16px;
            margin-left: 56px;
            margin-right: 15px;
            border-radius: 5px;
            width: 100px;
            height: 35px;
            border: solid 0px;
            font-size: 16px;
        }
        .btn_right{
            background-color: #2DA44E;
            color: #FFFFFF;
            margin-top: 16px;
            margin-left: 15px;
            margin-right: 56px;
            border-radius: 5px;
            width: 100px;
            height: 35px;
            border: solid 0px;
            font-size: 16px;
        }
        .in{
            margin-top: -10px;
            margin-left: 25px;
            margin-bottom: 20px;
            width: 300px;
            height: 32px;
            border-radius: 5px;
            border: 1px solid #D0D7DE;
            /*#D0D7DE*/
        }
        .lb{
            margin-left: 25px;
            margin-bottom: 0px;
            font-size: 20px;
            /*color: #FFD026;*/
        }
        #warn {
            margin-top: 20px;
            margin-left: 32px;
            padding-top: 13px;
            width: 280px;
            height: 40px;
            border-radius: 6px;
            border: solid 1px #FFC1C0;
            text-align: center;
            font-size: 14px;
            background-color: #FFEBE9;
            /*  #FFEBE9
              #F6F8FA*/
        }
        .off{
            float: right;
            margin-right: 20px;
            color: #AC1F18;
            text-decoration: none;
            font-min-size: xx-large;
        }
        .in:focus{
            outline:none;
            border: 2px solid #2983BB;
        }
        /*背景透明*/
        /*background:transparent;*/
        /*border:1px solid #ffffff*/
        .bottom{
            /*background-color: #F6F8FA;*/
            margin: auto;
            margin-top: 20px;
            border-radius: 10px;
            border: 1px solid #D0D7DE;
            width: 350px;
            height: 50px;
            box-sizing: border-box;
            padding-top: 12px;
            text-align: center;
        }
        .bottom > a{
            text-decoration: none;
            color: #000;
        }
    </style>
    <script>
        // window.onload=function () {
        //     document.getElementById("login").onclick=function(){
        //         var user = document.getElementsById("username").value;
        //         var pwd = document.getElementsById("password").value;
        //         if(user === null || user ===""){
        //             document.getElementById("div1").innerHTML = "<div id='warn'>用户名不能为空</div>";
        //         }else if (pwd === null || pwd ===""){
        //             document.getElementById("div1").innerHTML = "<div id='warn'>密码不能为空</div>";
        //         }else{
        //             document.getElementById("login").submit();
        //         }
        //     }
        // }
        function loginSubmit(){
            var user=document.getElementById("username").value;
            var pass=document.getElementById("password").value;
            if(user === null || user === ""){
                //alert("请填写用户名");
                document.getElementById("div1").innerHTML = "<div id='warn'>用户名不能为空" +
                    "<a class='off' href='#' onclick='javascript:turnoff(\"warn\")'>×</a></div>";
            } else if(pass === null || pass === ""){
                //alert("请填写密码");
                document.getElementById("div1").innerHTML = "<div id='warn'>密码不能为空" +
                    "<a class='off' href='#' onclick='javascript:turnoff(\"warn\")'>×</a></div>";
            }else{
                document.getElementById("login").submit();
            }
        }
        function turnoff(obj){
            document.getElementById(obj).style.display="none";
        }
    </script>
</head>
<body>
<h1 style="text-align: center;letter-spacing: 20px;margin-top: 20px">登录</h1>
<div class="mid">
<form action="login" method="post" id="login">

    <p class="lb"><label for="username">用户名</label></p>
    <p>
        <input type="text" name="username" class="in" id="username"/>
    </p>

    <p class="lb"><label for="password">密码</label></p>
    <p>
        <input type="password" name="password" class="in" id="password"/>
    </p>
    <p>
        <input type="button" name="login" value="登录" class="btn_left" onclick="loginSubmit()" />
        <input type="reset" value="重置" class="btn_right"/>
    </p>
</form>
    <div id="div1">
        <% if(request.getSession().getAttribute("msg") != null) {
        out.print("<div id='warn'>用户名或密码错误");
        out.print("<a class='off' href='#' onclick='javascript:turnoff(\"warn\")'>×</a></div>");
        request.getSession().removeAttribute("msg");}
        %>
    </div>

</div>
<div class="bottom" >
    <a href="register.jsp">没有账号？去注册一个</a>
</div>
</body>
</html>
