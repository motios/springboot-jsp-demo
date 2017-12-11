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
<form:form  action="/orders/${order.orderId}" method="post" modelAttribute="order" >
    <%--<form:form  action="action=${pageContext.servletContext.contextPath}/orders/${order.orderId}" method="post" modelAttribute="customer" >--%>
    <div class="form-group" align="right">
        <button type="submit" class="btn btn-success"  id="saveOrder">Save</button>
        <button type="button" class="btn btn-danger"  id="cancelOrder">Cancel</button>
    </div>
    <div class="form-group">
        <label for="orderDate">Date:</label>
        <form:input type="text" class="form-control" id="orderDate" value="${order.date}" path="date"/>
    </div>
    <div class="form-group">
        <label for="orderProductDescription">Description:</label>
        <form:input type="text" class="form-control" id="orderProductDescription" value="${order.productDescription}" path="productDescription"/>
    </div>
    <div class="form-group">
        <label for="orderPrice">Price:</label>
        <form:input path="price" type="text" class="form-control" id="orderPrice" value="${order.price}" />
    </div>
    <div class="form-group">
        <label for="orderQuantity">Quantity:</label>
        <form:input type="text" class="form-control" id="orderQuantity"  value="${order.quantity}" path="quantity" />
    </div>
</form:form>
</div>
</body>
</html>
