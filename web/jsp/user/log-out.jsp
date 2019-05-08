<%--
  Created by IntelliJ IDEA.
  User: LUTFI
  Date: 5/5/2019
  Time: 2:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>log-out</title>
</head>
<body>
<% session.invalidate();
request.getRequestDispatcher("http://localhost:8080/log-in.jsp").forward(request,response);%>
</body>
</html>
