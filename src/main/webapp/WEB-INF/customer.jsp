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
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
</head>
<body>

<div class="container">
    <%--<form action="${pageContext.servletContext.contextPath}/customers/${customer.customerId}" method="post">--%>
        <form:form  action="/customers/${customer.customerId}" method="post" modelAttribute="customer" >
        <div class="form-group" align="right">
            <button type="submit" class="btn btn-success" id="saveCustomer">Save</button>
            <button type="button" class="btn btn-danger" onclick="history.back()" id="cancel">Cancel</button>

        </div>

        <div class="form-group">
            <label for="customerName">First name:</label>
            <form:input type="text" class="form-control" id="customerName" value="${customer.firstName}" path="firstName"/>
        </div>
        <div class="form-group">
            <label for="customerSecondName">Second name:</label>
            <form:input path="lastName" type="text" class="form-control" id="customerSecondName" value="${customer.lastName}" />
        </div>
        <div class="form-group">
            <label for="customerEmail">Email:</label>
            <form:input path="email" type="text" class="form-control" id="customerEmail" value="${customer.email}" />
        </div>
        <div class="form-group">
            <label for="customerAge">Age:</label>
            <form:input path="age" type="text" class="form-control" id="customerAge"  value="${customer.age}"/>
            <form:input path="customerId" type="hidden" class="form-control" id="customerId"  />

        </div>
        </form:form>
    <div align = "right">
        <%--<a href = /orders/0/customer/${customer.customerId}>Add Order</a>--%>
           <%-- <button type="button" class="btn btn-warning"  id="AddNewOrder">Add Order</button>--%>
        <a href = /customers /a>
        <button type="button" class="btn btn-warning"  id="AddNewOrder">Home</button>
        <a href = /orders/0/customer/${customer.customerId} /a>
            <button type="button" class="btn btn-success"  id="AddNewOrder">Add Order</button>
    </div>


    <table class="table table-hover">
        <thead>
        <tr>
            <th>Date</th>
            <th>Product Description</th>
            <th>Total Order</th>
            <th></th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${orders}" var="order">
            <tr>
                <td>${order.orderDate}</td>
                <td>${order.productDescription}</td>
                <td>${order.totalPrice}</td>
                <td><a href = "/orders/${order.orderId}">Edit</a></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>


</body>
</html>
