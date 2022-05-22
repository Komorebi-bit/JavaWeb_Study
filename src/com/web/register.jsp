<%--
  Created by IntelliJ IDEA.
  User: Komorebi
  Date: 2022/5/13
  Time: 12:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <style>
        .mid{
            margin: auto;
            margin-top: 20px;
            border-radius: 10px;
            background-color: #F6F8FA;
            border: 1px solid #D0D7DE;
            width: 490px;
            height: 450px;
            padding-top: 5px;
            /*固定盒子大小*/
            box-sizing: border-box;

        }
        .input{
            margin-top: -10px;
            margin-left: 25px;
            /*margin-bottom: 10px;*/
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
        .gender,.like,.addr{
        }
        #y,#m,#d{
            /*margin-left: 89px;*/
            width: 110px;
            height: 25px;
            border-radius: 5px;
            border: 1px solid #D0D7DE;
            /*#D0D7DE*/

        }
        #status{
            width: 200px;
            height: 25px;
            border-radius: 5px;
            border: 1px solid #D0D7DE;

        }
        .btn_left{
            background-color: #2DA44E;
            color: #FFFFFF;
            margin-top: 16px;
            margin-left: 116px;
            margin-right: 25px;
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
            margin-left: 25px;
            margin-right: 116px;
            border-radius: 5px;
            width: 100px;
            height: 35px;
            border: solid 0px;
            font-size: 16px;
        }
        #men{
            margin-left: 10px;
            border: 1px solid;
        }
        .lb_r{
            margin-right: 45px;
        }
        .lb_i{
            margin-right: 20px;
        }
        .lb_ii{
            margin-right: -20px;
        }
        .brt{
            margin-right: 5px;
        }
    </style>
</head>
<body>
<h1 style="text-align: center;letter-spacing: 20px;margin-top: 20px">注册</h1>
<div class="mid">
<form action="" method="post">

            <p class="lb">用户名：
                <input class="input" type="text" name="user" value=""/>
            </p>


            <p class="lb"><font class="lb_r">性别：</font>
                <input type="radio" name="sex" id="man" value="1"/>
                <lable for="man">男</lable>
                <input type="radio" name="sex" id="woman" value="2"/>
                <lable for="woman">女</lable>
            </p>

            <p class="lb"><font class="lb_r">爱好：</font>
                <input id="a1" type="checkbox" name="love" value="a"/>
                <label for="a1">酸</label>

                <input id="b1" type="checkbox" name="love" value="b"/>
                <label for="b1">甜</label>

                <input id="c1" type="checkbox" name="love" value="c"/>
                <label for="c1">辣</label>
            </p>

            <p class="lb"><font class="lb_r">地址：</font>
                <select name="status" id="status">
                    <option value="sd">山东</option>
                    <option value="bj">北京</option>
                    <option value="sh">上海</option>
                    <option value="hn">湖南</option>
                    <option value="sx">陕西</option>
                </select>
            </p>

            <p class="lb"><font class="brt">出生日期：</font>

                <select name="y" id="y">
                    <option value="" disabled selected hidden>--请选择年份--</option>
                    <option value="">2000</option>
                    <option value="">2001</option>
                    <option value="">2002</option>
                    <option value="">2003</option>
                    <option value="">2004</option>
                </select>


                <select name="m" id="m">
                    <option value="" disabled selected hidden>--请选择月份--</option>
                    <option value="">1</option>
                    <option value="">2</option>
                    <option value="">3</option>
                    <option value="">4</option>
                    <option value="">5</option>
                    <option value="">6</option>
                    <option value="">7</option>
                    <option value="">8</option>
                    <option value="">9</option>
                    <option value="">10</option>
                    <option value="">11</option>
                    <option value="">12</option>
                </select>


                <select name="d" id="d">
                    <option value="" disabled selected hidden>--请选择日期--</option>
                    <option value="">1</option>
                    <option value="">2</option>
                    <option value="">3</option>
                    <option value="">4</option>
                    <option value="">5</option>
                    <option value="">6</option>
                    <option value="">7</option>
                    <option value="">8</option>
                    <option value="">9</option>
                    <option value="">10</option>
                    <option value="">11</option>
                    <option value="">12</option>
                    <option value="">13</option>
                    <option value="">14</option>
                    <option value="">15</option>
                    <option value="">16</option>
                    <option value="">17</option>
                    <option value="">18</option>
                    <option value="">19</option>
                    <option value="">20</option>
                    <option value="">21</option>
                    <option value="">22</option>
                    <option value="">23</option>
                    <option value="">24</option>
                    <option value="">25</option>
                    <option value="">26</option>
                    <option value="">27</option>
                    <option value="">28</option>
                    <option value="">29</option>
                    <option value="">30</option>
                    <option value="">31</option>
                </select>
            </p>

            <p class="lb"><font class="lb_i">密码：</font>
                <input class="input" type="password" name="pw" value=""/>
            </p>

            <p class="lb"><font class="lb_ii">确认密码：</font>
                <input class="input" type="password" name="pw" value=""/>
            </p>

            <p>
                <input class="btn_left" type="submit" name="register" value="注册"/>
                <input class="btn_right" type="reset" value="重置"/>
            </p>
</form>
</div>
</body>
</html>
