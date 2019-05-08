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
    <title>BackstageHome</title>
</head>
<body>
<jsp:include page="backstage-nav-bar.jsp"/>


<table class="table">
    <thead class="thead-light">
    <tr>
        <th scope="col">File id</th>
        <th scope="col">File path</th>
        <th scope="col">Statue</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="file" items="${requestScope.files}">
        <tr>
            <td> ${file.fileId} </td>
            <td> ${file.filePath} </td>
            <td> ${file.status} </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
