<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<body>

<div class="container">
    <div align = "right">
        <button type="button" class="btn btn-warning"  id="AddNewCustomer">Add customer</button>
    </div>

    <table class="table table-hover">
        <thead>
        <tr>
            <th>Email</th>
            <th>Full name</th>
            <th>Number Of Orders</th>
            <th></th>
        </tr>
        </thead>
        <tbody>


        <c:forEach var="item" items="${ list }" >
            <tr>
                <td>${item.email}</td>
                <td>${item.fullName}</td>
                <td>${item.numberOfOrders}</td>
                <%--<td>${item.fullName}</td>
                <td>${item.numberOfOrders}</td>
                <td><a href = "customer.html">Edit</a></td>--%>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>


</body>
</html>
