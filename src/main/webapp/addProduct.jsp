<%@ page import="java.util.List" %>
<%@ page import="org.example.eshopee.model.Category" %><%--
  Created by IntelliJ IDEA.
  User: NITRO
  Date: 13.11.2024
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% List<Category> categories = (List<Category>)request.getAttribute("categories");%>
<h1>Add Product</h1>
<br>
<form action="/addProduct" method="post">
    Name: <input type="text" name="name"><br>
    Description: <input type="text" name="description"><br>
    Price: <input type="text" name="price"><br>
    Quantity: <input type="text" name="quantity"><br>
    Category: <select name="category">
    <%for (Category category : categories){%>

    <option value="<%=category.getId()%>"><%=category.getName()%></option>

    <%}%>
</select>
    <input type="submit" value="add">

</form>
</body>
</html>
