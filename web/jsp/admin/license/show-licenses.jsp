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

<jsp:include page="admin-license-nav-bar.jsp"/>

<table class="table">
    <thead class="thead-light">
    <tr>
        <th scope="col">id</th>
        <th scope="col">email</th>
        <th scope="col">License Expiry</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="theLicense" items="${requestScope.license}">
        <tr>
            <td> ${theLicense.id} </td>
            <td> ${theLicense.email} </td>
            <td> ${theLicense.date} </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
