<%--
  Created by IntelliJ IDEA.
  User: Komorebi
  Date: 2022/4/18
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>主页</title>
    <!-- Bootstrap -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="js/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="js/bootstrap.min.js"></script>
    <style>
        *{
            margin: 0;
            padding: 0;
        }
        .body{
            width:910px;
            height:auto;
            margin-left:auto; /*左右自动可以居中*/
            margin-right:auto;
        }
        .header{
            background-color: #619AC3;
            float: left;
            height: 100px;
            width: 910px;
            text-align: center;
        }
        .content{
            background-color: #619AC3;
            float: left;
            height: auto;
            width: 910px;
            margin-top: 20px;
            padding-bottom:20px;

        }
        .mid{
            background-color: #7952B3;
            box-sizing: border-box;
            padding-top: 8px;
            float: left;
            height: 50px;
            width: 910px;
            margin-top: 20px;
            margin-bottom: 10px;
            text-align: right;
        }
        .hl{
            margin-right: 20px;
            color: black;
            text-decoration: none;
            font-min-size: xx-large;
        }
        .left{
            background-color: #2775B6;
            float: left;
            height: 420px;
            width: 210px;
            margin-top: 10px;
            margin-left: 10px;
            display:inline; /*先把这个去掉看下，边距的问题，在IE6下双边据。加上这个就正常了*/
            margin-right:10px;
            text-align: center;
        }
        .right_1{
            text-align: center;
            background-color: #2775B6;
            float: right;
            height: 360px;
            width: 600px;
            margin-top:10px;
            margin-right: 20px;
            text-align: center;
        }
        .right_2{
            float: right;
            height: 60px;
            width: 600px;
            margin-right: 20px;
        }
        .data{
            width: 550px;
            margin: auto;
            text-align: center;
            font-size: 22px;
            /*固定表格宽度*/
            table-layout: fixed;
            word-break: break-all;
            word-wrap: break-word;
        }
        .award-name{
            /*超出部分显示省略号*/
            -o-text-overflow: ellipsis;
            text-overflow: ellipsis;
            overflow: hidden;
            white-space: nowrap;
        }
        .footer{
            /*background-color: #000;*/
            float: left;
            height: 50px;
            width: 910px;
            margin-top: 20px;
            text-align: right;
        }
    </style>
</head>
<body>
<div class="body">
    <div class="header">
        <h1 style="font-weight: bold">图书信息</h1>
    </div>
        <div style="height: 100px;width: 910px;"></div>
        <div class="content">
            <div class="mid">
                <a href="LogoutServlet" class="hl" title="注销账户">注销</a>
            </div>

            <div class="left">
                <h2 align="center" style="font-weight: bold">用户</h2>
                <h3 align="center">${sessionScope.username}</h3>
                <br/><br/><br/><br/>
                <a href="addbook.jsp" style="color: #000000;font-size: 20px">添加图书</a>
            </div>

            <div class="right_1">
                <h2 style="font-weight: bold">属性</h2>
                <table class="data" border="0">
                    <!--<caption>属性</caption>-->
                    <tr style="font-weight: 600;font-size: 25px" >
                        <td height="50">图书编号</td><td width="220">书名</td><td>作者</td><td width="80">价格</td>
                    </tr>
                    <c:forEach var="book" items="${sessionScope.pb.list}">
                    <tr>
                        <td class="award-name">${book.bookID}</td>
                        <td class="award-name">${book.bookName}</td>
                        <td class="award-name">${book.author}</td>
                        <td class="award-name">${book.price}</td>
                    </tr>
                    </c:forEach>
                </table>

            </div>
            <div class="right_2">
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <c:if test="${pb.currentPage == 1}">
                            <li class="disabled">
                            <a href="${pageContext.request.contextPath}/FindUserByPageServlet?currentPage=${pb.currentPage}&rows=8" aria-label="Previous">
                        </c:if>
                        <c:if test="${pb.currentPage != 1}">
                            <li>
                            <a href="${pageContext.request.contextPath}/FindUserByPageServlet?currentPage=${pb.currentPage-1}&rows=8" aria-label="Previous">
                        </c:if>
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>

                        <c:forEach begin="1" end="${pb.totalPage}" var="i">
                        <c:if test="${pb.currentPage == i}">
                            <li class="active">
                        </c:if>
                        <c:if test="${pb.currentPage != i}">
                            <li>
                        </c:if>
                                <a href="${pageContext.request.contextPath}/FindUserByPageServlet?currentPage=${i}&rows=8">${i}</a>
                            </li>
                        </c:forEach>

                        <c:if test="${pb.currentPage == pb.totalPage}">
                            <li class="disabled">
                            <a href="${pageContext.request.contextPath}/FindUserByPageServlet?currentPage=${pb.currentPage}&rows=8" aria-label="Next">
                        </c:if>
                        <c:if test="${pb.currentPage != pb.totalPage}">
                            <li>
                            <a href="${pageContext.request.contextPath}/FindUserByPageServlet?currentPage=${pb.currentPage+1}&rows=8" aria-label="Next">
                        </c:if>
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                            </li>
                        <span style="font-size: 20px;margin-left: 5px">
                            共${pb.totalCount}条记录，共${pb.totalPage}页
                        </span>
                    </ul>
                </nav>
            </div>
        </div>
        <div class="footer">
            <span style="font-family:Arial;">©2022 Komorebi. All rights reserved</span>
        </div>

</div>
</body>
</html>
