<%--
  Created by IntelliJ IDEA.
  User: lquran
  Date: 4/25/19
  Time: 11:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>ProcessFiles</title>
<body>

<jsp:include page="backstage-nav-bar.jsp"/>

<h1>File is Submitted</h1>
<form action="/process" method="post">
    <button type="submit">Process</button>
</form>
</body>
</html>
