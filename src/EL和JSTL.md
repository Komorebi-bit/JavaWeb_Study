# EL和JSTL

## EL隐含对象

1. JSP
   - pageContext  引用当前jsp页面的pageContext内置对象

2. 作用域
   - pageScope  相当于pageContext.getAttribute()
   - requestScope  相当于request.getAttribute()
   - sessionScope  相当于session.getAttribute()
   - applicationScope  相当于application.getAttribute()

3. 请求参数
   - param  相当于request.getParameter()
   - paramValues  相当于request.getParameterValues()

4. HTTP请求头
   - header  相当于request.getHeader()
   - headerValues  相当于request.getHeaderValues()

5. Cookie
   - cookie  获得请求中的Cookie值

6. 初始化参数
   - initParam  获得上下文的初始参数值

## JSTL核心标签库

1. 通用标签
   - <c:out value="value">
     - "value"表示要输出的数据
   - <c:set var="name" value="value" scope="">
     - var 指定变量名称
     - value指定变量的值
     - scope 指定变量的范围，page(默认),request,session,application
   - <c:remove var="name" scope="">
     - var指定要删除的变量的名称
     - scope指定变量所在的范围
   - <c:catch var="name">       </c:catch >
     - 捕获其内部代码抛出的异常
     - var用于标识这个异常的名字
2. 条件标签
   - <c:if test="condition" var="name" scope="">//condition为true时执行的代码</c:if >
     - test 指定条件，通常使用EL进行条件运算
     - var 保存test属性运算结果
     - scope 指定var属性对应变量的保存范围
   - <c:choose ><c:when test="condition">//......</c:when >...<c:otherwise >// ......</c:otherwise ></c:choose >
3. 迭代标签
   - <c:forEach var="name" items="collection" varStatus="statusname"  begin="begin" end="end" step="step">//.....</c:forEach >
     - var 指定用于存放集合中当前遍历元素的变量名称
     - items 指定要遍历的集合，可以是数组，list，map
     - varStatus 指定存放当前遍历状态的变量名称，varStatus常用属性有current（当前迭代的项），index（当前迭代从0开始的索引）和count（当前迭代从1开始的迭代计数）。
     - begin指定遍历的起始索引
     - end 结束索引
     - step 指定迭代的步长
   - <c:forTokens items="string" delims="delimiters" var="name" varStatus="statusname" >//......</c:Tokens >
     - items 指定要遍历的字符串
     - delims 指定分隔符，可以指定一个或多个分隔符
     - var指定存放当前遍历元素的变量名称
     - varStatus 指定存放当前遍历状态的变量名称，varStatus常用属性有current（当前迭代的项），index（当前迭代从0开始的索引）和count（当前迭代从1开始的迭代计数）。
4. URL标签
   - <c:import url="url" var="name" scope="" charEncoding=""/>
     - var指定存放此包含文件的变量名称
     - scope指定保存变量的范围
   - <c:redirect >
   - <c:url >

## L18N标签库

- <fmt: setLocale value="setting" variant="variant" scope=""/>

  - 用于重写客户端指定的区域设置

  - value 指定语言和国家代码，例如zh_CN
  - variant 指定浏览器变量

- <fmt: bundle basename="basename">.....</fmt:bundle >

  - 加载本地化资源包
  - basename 指定资源包的名称 该名称不包括.properties后缀名

- <fmt: setBundle basename="basename" var="name" scope="">.....</fmt:setBundle >

  - 加载一个资源包，并将它储存在变量中
  - var 指定变量名称
  - scope 指定变量的范围

- <fmt: message key="messageKey"/>

  - 输出资源包中键映射的值

- <fmt: formatNumber value="value" var="name" pattern="patterrn" scope="" type="number|currency|percent" groupingUsed="true|false"/>

  - 格式化数字
  - value 指定需要格式化的数字
  - var 指定变量名称
  - pattern 指定格式化样式
  - scope 指定变量范围
  - type 指定值的类型 可以是number数字，currency货币，percent百分比
  - groupingUsed 指明是否将数字进行间隔，例如123，000.00

- <fmt: formatDate value="value" var="name" patttern="pattern" scope="" type="time|date|both"/>

  - 格式化日期
  - value 指定需要格式化的时间和日期，该值必须指定
  - var 指定变量名称
  - scope 指定变量范围
  - type 指定类型time时间，date日期，both时间和日期
  - pattern 指定格式化日期时间的样式，例如yyyy-MM-dd hh:mm:ss 