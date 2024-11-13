<%@ page import="org.example.eshopee.model.Category" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: NITRO
  Date: 13.11.2024
  Time: 0:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Category</h1>  <a href="/addCategory">add</a>
<table border="1">
    <tr>
        <th>id</th>
        <th>name</th>
    </tr>

    <% List<Category> categorys = (List<Category>) request.getAttribute("categories");%>
    <% for (Category category : categorys) { %>
    <tr>
        <td><%= category.getId()%></td>
        <td> <%= category.getName()%></td>
    </tr>
    <%}%>
</table>

</body>
</html>
