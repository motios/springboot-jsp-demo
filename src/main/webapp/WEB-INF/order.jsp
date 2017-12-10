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

    <div class="form-group" align="right">
        <button type="button" class="btn btn-success"  customerId="saveOrder">Save</button>
        <button type="button" class="btn btn-danger"  customerId="cancelOrder">Cancel</button>
    </div>

    <div class="form-group">
        <label for="orderDate">Date:</label>
        <input type="text" class="form-control" customerId="orderDate" value="${order.date}">
    </div>
    <div class="form-group">
        <label for="orderDescription">Description:</label>
        <input type="text" class="form-control" customerId="orderDescription" value="${order.description}">
    </div>
    <div class="form-group">
        <label for="orderPrice">Price:</label>
        <input type="text" class="form-control" customerId="orderPrice" value="${order.price}">
    </div>
    <div class="form-group">
        <label for="orderQty">Qty:</label>
        <input type="text" class="form-control" customerId="orderQty"  value="${order.qty}">
    </div>
</div>
</body>
</html>
