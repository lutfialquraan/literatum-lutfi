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

<jsp:include page="admin-users-nav-bar.jsp"/>

<table class="table">
    <thead class="thead-light">
    <tr>
        <th scope="col">First-Name</th>
        <th scope="col">Last-Name</th>
        <th scope="col">User-Name</th>
        <th scope="col">Email</th>
        <th scope="col">Role</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${requestScope.users}">
    <tr>
        <td> ${user.firstName} </td>
        <td> ${user.lastName} </td>
        <td> ${user.userName} </td>
        <td> ${user.email} </td>
        <td> ${user.role} </td>
    </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
