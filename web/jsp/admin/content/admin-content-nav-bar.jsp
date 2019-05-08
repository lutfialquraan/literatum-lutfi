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
                <a class="nav-link" href="/admin/showContents">Show Content<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/admin/addContent">Add Content</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/admin/deleteContent">Delete Content</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/admin/updateContent">Update Content</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/admin/findContent">Find Content</a>
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