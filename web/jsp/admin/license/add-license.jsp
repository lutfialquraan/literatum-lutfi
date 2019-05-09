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
    <title>Add-User</title>
</head>
<body>

<jsp:include page="admin-license-nav-bar.jsp"/>

<form action="/admin/addLicense" method="post">

    <div class="container">
    <div class="form-row">
            <label for="inputEmail4">Email</label>
            <input type="email" class="form-control" id="inputEmail4" placeholder="Email" name="email">
    </div>
    <div class="form-group">
        <label for="inputAddress">License</label>
        <input type="number" class="form-control" id="inputAddress" placeholder="Ex.30" name="date">
    </div>
    <button type="submit" class="btn btn-primary">Add License</button>
    </div>
</form>
</body>
</html>
