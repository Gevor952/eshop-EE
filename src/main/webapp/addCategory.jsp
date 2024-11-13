<%--
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
  <h1>add category</h1>

  <form action="/addCategory" method="post">
    Name: <input type="text" name="name">
    <br>
    <input type="submit" value="add">
  </form>
  </body>
</html>
