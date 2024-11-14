<%@ page import="org.example.eshopee.model.Category" %><%--
  Created by IntelliJ IDEA.
  User: NITRO
  Date: 13.11.2024
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%Category category = (Category) request.getAttribute("category");%>
<h1>edit category</h1>

<form action="/editCategory" method="post">
    <input type="hidden" name="id" value="<%=category.getId()%>">
    Name: <input type="text" name="name" value="<%=category.getName()%>">
    <br>
    <input type="submit" value="update">
</form>
</body>
</html>
