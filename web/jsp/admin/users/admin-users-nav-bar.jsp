<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="#">Atypon
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="users/showUsers">Show Users<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="users/addUser">Add User</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="users/deleteUser">Delete User</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="users/updateUser">Update User</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="users/findUser">Find User</a>
            </li>

        </ul>
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a  class="nav-link active">Welcome, ${name}</a>
            </li>
            <li class="nav-item">
                <a href="/admin/logout" style="margin-left: 10px;" class="btn  btn-outline-danger">Log out</a>
            </li>
        </ul>
    </div>
</nav>