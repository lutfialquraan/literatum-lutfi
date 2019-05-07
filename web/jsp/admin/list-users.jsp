<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<head>
    <title>All Users</title>

    <link rel="stylesheet" href="css/style.css">
</head>

<body>

<div id="wrapper">
    <div id="header">
        <h2>All Users</h2>
    </div>
</div>

<div id="container">

    <div id="content">

        <input type="button" value="Add job Application" onclick="window.location.href='application.jsp'; return false;"  class="add-student-button" >
        <input type="button" value="Add vacancy" onclick="window.location.href='vanacy.jsp'; return false;"  class="add-student-button" >


        <table>

            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>User Name</th>
                <th>Email</th>
                <th>Role</th>
            </tr>

            <c:forEach var="user" items="${requestScope.users}">
            <tr>

                <td> ${user.firstName} </td>
                <td> ${user.lastName} </td>
                <td> ${user.userName} </td>
                <td> ${user.email} </td>
                <td> ${user.role} </td>

                </c:forEach>
        </table>
    </div>
</div>
</body>
</html>