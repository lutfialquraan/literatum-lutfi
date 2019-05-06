<%--
  Created by IntelliJ IDEA.
  User: LUTFI
  Date: 5/5/2019
  Time: 2:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>logged-in</title>
</head>
<body>

<h1> Welcome <% if (session.getAttribute("name")== null){
    response.sendRedirect("jsp/log-in.jsp");
}%> </h1>

<form method="post" action="/logout">
    <button type="submit">LogIn</button>
</form>
</body>
</html>
