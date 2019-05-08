<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Show-Users</title>
</head>
<body>

<jsp:include page="admin-content-nav-bar.jsp"/>

<table class="table">
    <thead class="thead-light">
    <tr>
        <th scope="col">doi</th>
        <th scope="col">subject</th>
        <th scope="col">Author</th>
        <th scope="col">Title</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="meta" items="${requestScope.metas}">
        <tr>
            <td> ${meta.theDoi} </td>
            <td> ${meta.subject} </td>
            <td> ${meta.title} </td>
            <td> ${meta.author} </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
