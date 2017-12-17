<!DOCTYPE html>
<html lang="en">
<head>
    <title>Customer Orders Demo</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script>
        String.prototype.replaceAll = function(search, replacement) {
            var target = this;
            return target.split(search).join(replacement);
        };
        function showAlert() {
            var str = "?responseMessage="
            var url = window.location.href
            if(url.indexOf(str)>-1 && url.length > url.indexOf(str)+str.length){
                var messageStr= url.substring(url.indexOf(str)+str.length);
                messageStr = messageStr.replaceAll("+"," ");
                messageStr = messageStr.replaceAll("%0D","\r");
                alert(messageStr);
            }
        }
    </script>
    <script>

        window.onload = showAlert();
    </script>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


</head>
<body>

<div class="container">
    showAlert();
    <div align = "right">
        <a href = "/customers/0" /a>
        <button type="button" class="btn btn-warning"  customerId="AddNewCustomer">Add customer</button>
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
                <td>${item.numberOfOrders}</td>--%>
                <td><a href = /customers/${item.customerId}>Edit</a></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>


</body>
</html>
