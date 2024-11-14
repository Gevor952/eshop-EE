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
    <link rel="stylesheet" href="style/style.css">

</head>
<body>
<nav class="manu"></nav>
<div class="main_div">

    <div class="boot">
        <h1>Category</h1>
        <a href="/index.jsp" class="a_boot" id="a_b_2"><p>home</p></a>
        <a href="/addCategory" class="a_boot" ><p>add category</p></a>

    </div>

    <table>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>action</th>
        </tr>

        <% List<Category> categorys = (List<Category>) request.getAttribute("categories");%>
        <% for (Category category : categorys) { %>
        <tr>
            <td><%= category.getId()%></td>
            <td> <%= category.getName()%></td>
            <td><a href="/deleteCategory?id=<%= category.getId()%>" class="a_boot"><p>delete</p></a> <a href="/editCategory?id=<%= category.getId()%>" class="a_boot"><p>edit</p></a></td>
        </tr>
        <%}%>
    </table>

</div>
</body>
</html>
