<%@ page import="java.util.List" %>
<%@ page import="org.example.eshopee.model.Product" %><%--
  Created by IntelliJ IDEA.
  User: NITRO
  Date: 13.11.2024
  Time: 13:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Product</h1>
<a href="/addProduct">add</a>
<% List<Product> products = (List<Product>) request.getAttribute("products");%>

<table border="1">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>description</th>
        <th>prise</th>
        <th>quantity</th>
        <th>category</th>
    </tr>


    <%for (Product product : products){ %>
        <tr>
            <td> <%= product.getId()%></td>
            <td> <%= product.getName()%></td>
            <td> <%= product.getDescription()%></td>
            <td> <%= product.getPrice()%></td>
            <td> <%= product.getQuantity()%></td>
            <td> <%= product.getCategory().getName()%></td>

        </tr>


    <%}%>


</table>

</body>
</html>
