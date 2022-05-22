# JSP基础结构

## JSP指令

​		<%@ 指令名 属性="值" 属性="值"%>

### 指令

   1. page

      ​	属性包括 language, extends, import, session, buffer, autoFlash, info, errorPage, isErrorPage, contentType, pageEncoding, isELIgnored. 

   2. include

      ​	用于在当前JSP中包含其他文件（jsp,html,文本文件）

      ​	<%@ include file="被包含文件的url" %>

   3. taglib

      ​	用于指定jsp页面所使用的标签库

      <%@ taglib uri="标签库URL" prefix="标签前缀" %>

## JSP声明

* <%! 声明的内容 %>

## JSP表达式

  * <%=表达式 %>

## JSP脚本

 -  <% java代码 %>

##  JSP动态标签

- <jsp: 动作名> </jsp: 动作名>

## JSP注释

- <%--  --%>

# JavaBean

### 特点：

- 可重用
- 升级方便
- 不依赖于平台

### 要求:

- 是一个公有类，含有公有的无参构造方法
- 属性私有
- 属性具有共有的get和set方法

# JSP标准动作

1. <jsp:useBean id="" class="" scope="" />

   - 查找或实例化一个JavaBean

   - id实例的变量名

   - class指定JavaBean的类名

   - scope指定JavaBean的作用范围 page request session application


2. <jsp:setProperty name="" property="" value=""/>

   - 设置JavaBean中的属性值

   - value和param="" 不能共存
   - param指定请求中的参数名（该参数可以来自表单，URL传参数等）


3. <jsp:getProperty name="" property=""/>
   -  访问一个JavaBean的属性并将其输出


```java
<% UserBean user = new UserBean();%>
<jsp:useBean id="user2" class="bean.UserBean" scope="page"/>
<% user.setName("李四");
   user.setPwd("123456");%>
<jsp:setProperty name="user2" property="name" value="张三"/>
<jsp:setProperty name="user2" property="pwd" value="10010"/>//value和param="参数名"不能同时存在
用户名：<%=user.getName()%>
密码：<%=user.getPwd()%>
<hr/>
用户名：<jsp:getProperty name="user2" property="name"/>
密码：<jsp:getProperty name="user2" property="pwd"/>
```

4. <jsp:include page="被包含文件的URL"/>
   - 或者：<jsp:include page=""><jsp:param name="" value=""/></jsp:include >		
   
   - jsp页面动态包含其他页面
   
5. <jsp:forward page="URL地址"/>
   - 或者 <jsp:forward page=""><jsp:param name="" value=""></jsp:forward >
   - 请求转发

6. <jsp:param name="" value=""/>
   - 用于为其他动作标签提供附加参数信息

#  JSP 9个内置对象

1. request
2. response
3. session
4. application
   - 作用于整个应用程序 (servletContext)
5. out
   - 当页面同时存在out.print()和response.getWriter.print(),先输出response.getWriter.prin的内容
6. pageContext
   - 用于存储当前jsp页面的相关信息
   - 可以访问当前jsp页面所有的内置对象
   - 也可以存取数据，作用范围为当前jsp页面
7. config
   - String getInitParameter(String name)//返回指定名称的初始参数值
   - Enumeration getInitParameterNames()//返回所有初始参数的名称集合
   - ServletContext getServletContext()
   - String getServletName()
8. page
   - jsp页面的当前实例，相当于this
9. exception
