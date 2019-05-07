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

<jsp:include page="admin-users-nav-bar.jsp"/>

<form action="/admin/users/addUser" method="post">
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="inputEmail4">Email</label>
            <input type="email" class="form-control" id="inputEmail4" placeholder="Email" name="email">
        </div>
        <div class="form-group col-md-6">
            <label for="inputPassword4">Password</label>
            <input type="password" class="form-control" id="inputPassword4" placeholder="Password" name="password">
        </div>
    </div>
    <div class="form-group">
        <label for="inputAddress">First Name</label>
        <input type="text" class="form-control" id="inputAddress" placeholder="ex.Lutfi" name="first_name">
    </div>
    <div class="form-group">
        <label for="inputAddress2">Last Name</label>
        <input type="text" class="form-control" id="inputAddress2" placeholder="Ex.Al-Quran" name="last_name">
    </div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="inputCity">User Name</label>
            <input type="text" class="form-control" id="inputCity" name="user_name">
        </div>
        <div class="form-group col-md-4">
            <label for="inputState">Role</label>
            <select id="inputState" class="form-control" name="type">
                <option selected>User</option>
                <option>Admin</option>
                <option>SuperAdmin</option>
            </select>
        </div>
    </div>
    <button type="submit" class="btn btn-primary">Add User</button>
</form>


</body>
</html>
