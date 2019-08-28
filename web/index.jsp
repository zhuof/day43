<%--
  Created by IntelliJ IDEA.
  User: JLB
  Date: 2019/8/27
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%
    String msg= (String) request.getAttribute("msg");

  %>
  <h3>提示信息：<%=msg%></h3><br>
  <form name="form1" action="login" method="post">

    用户名：<input type="text" id="username" name="username">
    <div id="usernamemsg"></div><br>
    密码：<input type="password" id="password" name="password">
    <div id="passwordmsg"></div><br>
    <input type="submit" value="登录" >
  </form>
  </body>
</html>
