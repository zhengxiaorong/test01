<%@ page import="java.lang.ref.SoftReference" %><%--
  Created by IntelliJ IDEA.
  User: 张倩瑶
  Date: 2020/10/16
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <%
        String result = (String)request.getAttribute("info");
    %>
    <font style="color: red;font-size: 45px">
        <%=result%>
    </font>
</center>
</body>
</html>
