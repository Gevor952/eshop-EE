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
    <link rel="stylesheet" href="style/style.css">

</head>
<body>
<nav class="manu"></nav>

<div class="main_div">

    <div class="boot">
        <h1>Product</h1>
        <a href="index.jsp" class="a_boot" id="a_b_3"><p>home</p></a>
        <a href="/addProduct" class="a_boot"><p>add</p></a>
    </div>

    <table>
        <% List<Product> products = (List<Product>) request.getAttribute("products");%>

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

</div>
</body>
</html>
