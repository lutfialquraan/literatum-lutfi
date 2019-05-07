<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lquran
  Date: 5/7/19
  Time: 10:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Home</title>
</head>
<body>

<jsp:include page="logged-in-nav-bar.jsp"/>
<div class="container">
<c:forEach var="meta" items="${meta}">
    <div class="row">
        <div class="col-12">
            <form action="/getArticle" method="post">
                <input type="hidden" name="doi" value="${meta.theDoi}">
                <button class="btn btn-warning" style="width: 100%">${meta.title}</button>
            </form>
        </div>
    </div>
</c:forEach>
</div>

</body>
</html>
