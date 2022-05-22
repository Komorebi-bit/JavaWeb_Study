<%--
  Created by IntelliJ IDEA.
  User: Komorebi
  Date: 2022/5/16
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书新增页面</title>
    <style>
        .mid{
            margin: auto;
            margin-top: 40px;
            background-color: #F6F8FA;
            border: 1px solid #D0D7DE;
            width: 800px;
            height: 300px;
        }
        .btn_left{
            background-color: #2DA44E;
            color: #FFFFFF;
            margin-top: 40px;
            margin-left: 247px;
            margin-right: 50px;
            border-radius: 5px;
            width: 100px;
            height: 35px;
            border: solid 0px;
            font-size: 16px;
        }
        .btn_right{
            background-color: #2DA44E;
            color: #FFFFFF;
            margin-top: 40px;
            margin-left: 50px;
            margin-right: 247px;
            border-radius: 5px;
            width: 100px;
            height: 35px;
            border: solid 0px;
            font-size: 16px;
        }
        .in{
            margin-top: 40px;
            margin-bottom: 20px;
            width: 150px;
            height: 27px;
            border-radius: 5px;
            border: 1px solid #D0D7DE;
            /*#D0D7DE*/
        }
        .lb{
            margin-left: 25px;
            margin-top: 20px;
            font-size: 20px;
            /*color: #FFD026;*/
        }
    </style>
</head>
<body>
<div class="mid">
    <h1 style="text-align: center;">图书添加</h1>
    <form action="AddBookServlet" method="post">
        <label class="lb" for="bookname">图书名：</label>
        <input class="in" type="text" name="bookname" id="bookname"/>
        <label class="lb" for="author">作者：</label>
        <input class="in" type="text" name="author" id="author"/>
        <label class="lb" for="price">价格：</label>
        <input class="in" type="text" name="price" id="price"/>
        <br/>
        <input class="btn_left" type="submit" value="添加"/>
        <input class="btn_right" type="reset" value="重置"/>
    </form>
</div>
</body>
</html>
